package com.propremote.service;

import com.propremote.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericServiceImpl<TEntity extends Serializable> implements GenericService<TEntity> {

	@Autowired
	protected GenericRepository<TEntity> repository;

	protected Class<TEntity> entityClass;

	@SuppressWarnings("unchecked")
	public GenericServiceImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<TEntity>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public List<TEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public TEntity findOne(Long id) {
        return repository.findById(id).get();
	}

	@Override
	public void save(TEntity entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Long id) { repository.deleteById(id); }

	@Override
	public Page<TEntity> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
