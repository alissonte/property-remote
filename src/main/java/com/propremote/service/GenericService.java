package com.propremote.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<TEntity> {
	List<TEntity> findAll();

	TEntity findOne(Long id);

	void save(TEntity entity);

	void delete(Long id);

	Page<TEntity> findAll(Pageable pageable);
}
