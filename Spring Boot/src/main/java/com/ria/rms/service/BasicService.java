package com.ria.rms.service;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface BasicService<T> {

    T save(T object);

    T update(T object);

    T findById(String id);

    boolean deleteById(String id);

    List<T> findAll();

    Page findAll(Map<String, Object> queryParams);

}
