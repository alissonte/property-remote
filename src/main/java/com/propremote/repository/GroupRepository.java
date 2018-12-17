package com.propremote.repository;

import com.propremote.model.GroupProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GroupRepository extends GenericRepository<GroupProperty> {

    @Override
    @Query(value = "select g from GroupProperty g left join g.properties where g.id = ?1")
    Optional<GroupProperty> findById(Long id);
}