package com.propremote.service;

import com.propremote.model.Property;
import com.propremote.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public void addProperty(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public Property getProperty(Long id) {
        return propertyRepository.findById(id).get();
    }

    @Override
    public void updateProperty(Property property) {

    }

    @Override
    public void removeProperty(Long id) {

    }
}