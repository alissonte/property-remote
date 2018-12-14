package com.propremote.service;

import com.propremote.exception.NoSuchGroupException;
import com.propremote.model.GroupProperty;
import com.propremote.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public void addGroupProperty(GroupProperty groupProperty) {
        groupRepository.save(groupProperty);
    }

    @Override
    public GroupProperty getGroupProperty(Long id) {
        if(id == null) {
            throw new RuntimeException("ID cannot be null");
        }

        try {
            return groupRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NoSuchGroupException("No group found for ID " + id + ".");
        }
    }

    @Override
    public void updateGroupProperty(GroupProperty editedGroupProperty) {
        if(editedGroupProperty.getId() == null) {
            throw new RuntimeException("ID cannot be null");
        }

        GroupProperty groupProperty = getGroupProperty(editedGroupProperty.getId());
        groupProperty.setName( editedGroupProperty.getName() );

        groupRepository.save(groupProperty);
    }

    @Override
    public void removeGroupProperty(Long id) {

        if(id == null) {
            throw new RuntimeException("ID cannot be null");
        }

        //if no exception is thrown, we know that the specific group exists
        getGroupProperty(id);

        groupRepository.deleteById(id);
    }
}
