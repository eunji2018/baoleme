package com.eunji.repository;

import com.eunji.entity.Type;

import java.util.List;

public interface TypeRepository {

    public Type findById(long id);
    public List<Type> findAll();
}
