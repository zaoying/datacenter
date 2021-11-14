package com.springcloud.school.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author huangzurong
 */
public class BaseServiceImpl<T,ID> implements BaseService<T,ID> {

    @Autowired
    private JpaRepository<T,ID> jpaRepository;

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Page<T> list(Integer page, Integer size) {
        return jpaRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public T save(T t) {
        return jpaRepository.save(t);
    }

    @Override
    public T update(T t) {
        return jpaRepository.save(t);
    }

    @Override
    public void delete(T t) {
        jpaRepository.delete(t);
    }
}
