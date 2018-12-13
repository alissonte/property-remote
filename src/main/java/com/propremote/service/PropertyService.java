package com.propremote.service;

import com.propremote.model.Property;

public interface PropertyService {

    public void addProperty(Property property);
    public Property getProperty(Long id);
    public void updateProperty(Property property);
    public void removeProperty(Long id);
}
