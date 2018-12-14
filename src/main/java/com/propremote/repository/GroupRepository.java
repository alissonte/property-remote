package com.propremote.repository;

import com.propremote.model.GroupProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupProperty, Long> {
}
