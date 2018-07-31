package com.springcloud.school.service;

import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @author huangzurong
 */
public interface BaseService<T, ID> {
    Optional<T> findById(ID id);
    Page<T> list(Integer page, Integer size);
    T save(T t);
    T update(T t);
    void delete(T t);
}
