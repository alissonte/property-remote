package com.propremote.service;

import com.propremote.exception.NoSuchGroupException;
import com.propremote.model.GroupProperty;
import com.propremote.model.Property;

import java.util.List;

public interface GroupService extends GenericService<GroupProperty> {
    void includeProperties(Long groupId, List<Property> propertiesIDs);
}
