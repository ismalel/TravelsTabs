package com.encora.travelstab.service;

import com.encora.travelstab.http.ApiResponse;
import com.encora.travelstab.model.User;

import java.util.List;

public interface GenericService<T> {
    T create(T t);
    T read(Long id);
    List<T> readAll();
    T update(Long id, T t);
    ApiResponse delete(T t);
}
