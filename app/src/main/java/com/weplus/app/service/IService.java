package com.weplus.app.service;

import java.util.List;

public interface IService<T, ID> {
    T save(T entity);
    T findById(ID id);
    List<T> findAll();
    T update(ID id, T entity);
    void delete(ID id);
}
