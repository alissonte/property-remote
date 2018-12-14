package com.propremote.service;

import com.propremote.exception.NoSuchGroupException;
import com.propremote.model.GroupProperty;
import com.propremote.repository.GroupRepository;
import org.dom4j.tree.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GroupServiceImpl extends GenericServiceImpl<GroupProperty> implements GroupService {
}
