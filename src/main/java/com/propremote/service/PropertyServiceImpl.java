package com.propremote.service;

import com.propremote.exception.NoSuchPropertyException;
import com.propremote.model.Property;
import com.propremote.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

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

        if(id == null) {
            throw new RuntimeException("ID cannot be null");
        }

        try {
            return propertyRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NoSuchPropertyException("No property found for ID " + id + ".");
        }
    }

    @Override
    public void updateProperty(Property editedProperty) {
        if(editedProperty.getId() == null) {
            throw new RuntimeException("ID cannot be null");
        }

        Property property = getProperty(editedProperty.getId());

        property.setKey( editedProperty.getKey() );
        property.setValue( editedProperty.getValue() );

        propertyRepository.save(property);
    }

    @Override
    public void removeProperty(Long id) {

        if(id == null) {
            throw new RuntimeException("ID cannot be null");
        }

        //if no exception is thrown, we know that the specific property exists
        getProperty(id);

        propertyRepository.deleteById(id);
    }
}