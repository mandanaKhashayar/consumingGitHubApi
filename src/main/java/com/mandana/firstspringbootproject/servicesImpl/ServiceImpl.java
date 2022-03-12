package com.mandana.firstspringbootproject.servicesImpl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Setter
@Getter
public class ServiceImpl<T, E> {
    JpaRepository<T, E> repository;


    public ServiceImpl(JpaRepository<T, E> repository) {
        this.repository = repository;
    }

    protected T save(T t) {
      return  repository.save(t);
    }


    protected List<T> findAll() {
        return repository.findAll();
    }



}
