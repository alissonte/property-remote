package com.propremote.service;

import com.propremote.exception.NoSuchGroupException;
import com.propremote.exception.NoSuchPropertyException;
import com.propremote.model.GroupProperty;
import com.propremote.model.Property;
import com.propremote.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl extends GenericServiceImpl<GroupProperty> implements GroupService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public void includeProperties(Long groupId, List<Property> propertiesIDs) {

        if(groupId == null) {
            throw new RuntimeException("ID cannot be null!");
        }

        GroupProperty groupProperty = findOne(groupId);

        List<Long> reducedIDs = propertiesIDs.stream()
                                             .map(property -> property.getId())
                                             .collect(Collectors.toList());

        List<Property> properties = propertyRepository.findByIdIn(reducedIDs);

        if(groupProperty == null) {
            throw new NoSuchGroupException("No group found for ID " + groupId + ".");
        }

        if(properties == null || properties.isEmpty()) {
            throw new NoSuchPropertyException("No properties found.");
        }

        properties.forEach( prop -> {
            prop.setGroupProperty(groupProperty);
            propertyRepository.save(prop);
        });
    }
}
