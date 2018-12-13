package com.propremote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propremote.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long>{
}
