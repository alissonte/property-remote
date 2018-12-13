package com.propremote.controller;

import com.propremote.model.GroupProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @RequestMapping(value = "/property", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public GroupProperty getProperty() {
        return new GroupProperty();
        //TODO: implement property search
    }

    @RequestMapping(value = "/property", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addProperty(@RequestBody GroupProperty groupProperty) {
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
        //TODO: implement property creation
    }
}
