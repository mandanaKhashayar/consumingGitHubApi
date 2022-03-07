package com.mandana.firstspringbootproject.servicesImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class ServiceImpl<T, E> {
    JpaRepository<T, E> repository;

    public ServiceImpl(JpaRepository<T, E> repository) {
        this.repository = repository;
    }

    protected void save(T t) {
        repository.save(t);
    }

    protected List<T> findAll() {
        return repository.findAll();
    }

}
