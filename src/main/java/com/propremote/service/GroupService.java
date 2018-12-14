package com.propremote.service;

import com.propremote.model.GroupProperty;

public interface GroupService {
    
    void addGroupProperty(GroupProperty groupProperty);
    GroupProperty getGroupProperty(Long id);
    void updateGroupProperty(GroupProperty groupProperty);
    void removeGroupProperty(Long id);
}
