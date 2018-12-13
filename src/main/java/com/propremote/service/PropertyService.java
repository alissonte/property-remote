package com.propremote.service;

import com.propremote.model.Property;

public interface PropertyService {

    void addProperty(Property property);
    Property getProperty(Long id);
    void updateProperty(Property property);
    void removeProperty(Long id);
}
