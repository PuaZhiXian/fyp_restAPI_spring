package com.example.fyp_restapi_spring.api.dao;

import java.io.Serializable;
import java.util.List;

public interface ProjectDao<T, Id extends Serializable> {

    public void update(T entity);

    public T findById(int id);

    public void delete(int id);

    public List<T> findAll();

    public void add(T p);
}
