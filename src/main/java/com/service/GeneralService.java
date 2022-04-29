package com.service;

import java.util.Optional;

public interface GeneralService<T> {
    void save(T t);
    void save(Long id,T t);
    void delete(Long id);
    Optional<T> findById(Long id);
    Iterable<T> findAll();
}
