package com.revature.movie.api.entities;

import java.util.List;

import com.revature.movie.api.requests.Requests;

public interface Dao<E> {
    void insert(E e);

    void update();

    void delete();

    List<Requests> getAll(String username);
}