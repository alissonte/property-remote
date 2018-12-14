package com.propremote.service;

import com.propremote.exception.NoSuchPropertyException;
import com.propremote.model.Property;
import com.propremote.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PropertyServiceImpl extends GenericServiceImpl<Property> implements PropertyService {
}