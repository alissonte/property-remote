package com.propremote.controller;

import com.propremote.exception.NoSuchPropertyException;
import com.propremote.model.Property;
import com.propremote.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @RequestMapping(value = "/property", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addProperty(@RequestBody Property property) {
        propertyService.save(property);
        return new ResponseEntity<>("Property has been created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/property/{id:[\\d]+}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getProperty(@PathVariable Long id) {

        //FIXME: Exceptions should be handled by Spring
        try {
            Property property = propertyService.findOne(id);
            return new ResponseEntity(property, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("No property found for ID " + id + ".", HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/property", method = RequestMethod.PUT)
    public ResponseEntity updateProperty(@RequestBody Property property) {
        try {
            propertyService.save(property);
            return new ResponseEntity("Property has been updated successfully!", HttpStatus.OK);
        } catch (NoSuchPropertyException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/property/{id:[\\d]+}", method = RequestMethod.DELETE)
    public ResponseEntity removeProperty(@PathVariable Long id) {

        //FIXME: Exceptions should be handled by Spring
        try {
            propertyService.delete(id);
            return new ResponseEntity("Property has been deleted successfully!", HttpStatus.OK);
        } catch (NoSuchPropertyException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/property/all", method=RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Property> findAll() {
        return propertyService.findAll();
    }
}
