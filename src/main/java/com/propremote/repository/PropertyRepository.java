package com.propremote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propremote.model.Property;

import java.util.Collection;
import java.util.List;

public interface PropertyRepository extends GenericRepository<Property> {
    List<Property> findByIdIn(Collection<Long> ids);
}
