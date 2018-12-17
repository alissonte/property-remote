package com.propremote.controller;

import com.propremote.exception.NoSuchGroupException;
import com.propremote.model.GroupProperty;
import com.propremote.model.Property;
import com.propremote.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class GroupController {

    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/group", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addGroup(@RequestBody GroupProperty groupProperty) {
        groupService.save(groupProperty);
        return new ResponseEntity<>("Group has been created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/group/{id:[\\d]+}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getGroup(@PathVariable Long id) {

        //FIXME: Exceptions should be handled by Spring
        try {
            GroupProperty groupProperty = groupService.findOne(id);
            return new ResponseEntity(groupProperty, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("No group found for ID " + id + ".", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/group", method = RequestMethod.PUT)
    public ResponseEntity updateGroup(@RequestBody GroupProperty groupProperty) {
        try {
            groupService.save(groupProperty);
            return new ResponseEntity("Property has been updated successfully!", HttpStatus.OK);
        } catch (NoSuchGroupException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/group/{id:[\\d]+}", method = RequestMethod.DELETE)
    public ResponseEntity removeGroup(@PathVariable Long id) {

        //FIXME: Exceptions should be handled by Spring
        try {
            groupService.delete(id);
            return new ResponseEntity("Property has been deleted successfully!", HttpStatus.OK);
        } catch (NoSuchGroupException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/group/all", method=RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<GroupProperty> findAll() {
        return groupService.findAll();
    }

    @RequestMapping(value = "/group/{id:[\\d]+}/addProperties", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addPropertiesToGroup(@PathVariable Long id, @RequestBody List<Property> propertiesIDs) {
        try {
            groupService.includeProperties(id, propertiesIDs);
            return new ResponseEntity("Properties have been included successfully.", HttpStatus.OK);
        } catch (NoSuchGroupException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
    }
}
