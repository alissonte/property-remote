package com.propremote.controller;

import com.propremote.model.GroupProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @RequestMapping(value = "/property", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getProperty() {
        return new ResponseEntity("OK", HttpStatus.OK);
        //TODO: implement property search
    }

    @RequestMapping(value = "/property", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addProperty(@RequestBody GroupProperty groupProperty) {
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
        //TODO: implement property creation
    }

    @RequestMapping(value = "/property/{id:[\\d]+}", method = RequestMethod.DELETE)
    public ResponseEntity removeShow(@PathVariable String id) {
        return new ResponseEntity("Success!", HttpStatus.OK);
        //TODO: implement property removal
    }

    @RequestMapping(value = "/property/{id:[\\d]+}", method = RequestMethod.PUT)
    public ResponseEntity removeShow(@PathVariable GroupProperty groupProperty) {
        return new ResponseEntity("Success!", HttpStatus.OK);
        //TODO: implement property update
    }
}
