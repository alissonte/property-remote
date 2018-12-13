package com.propremote.controller;

import com.propremote.model.Property;
import com.propremote.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @RequestMapping(value = "/property", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addProperty(@RequestBody Property property) {
        propertyService.addProperty(property);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/property/{id:[\\d]+}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getProperty(@PathVariable Long id) {
        Property prop = propertyService.getProperty(id);
        return new ResponseEntity(prop, HttpStatus.OK);
    }

    @RequestMapping(value = "/property/{id:[\\d]+}", method = RequestMethod.PUT)
    public ResponseEntity updateShow(@PathVariable Long id) {
        return new ResponseEntity("Success!", HttpStatus.OK);
        //TODO: implement property update
    }

    @RequestMapping(value = "/property/{id:[\\d]+}", method = RequestMethod.DELETE)
    public ResponseEntity removeShow(@PathVariable Long id) {
        return new ResponseEntity("Success!", HttpStatus.OK);
        //TODO: implement property removal
    }
}
