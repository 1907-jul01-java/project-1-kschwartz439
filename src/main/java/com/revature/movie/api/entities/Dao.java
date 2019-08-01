package com.revature.movie.api.entities;

import java.util.List;

/**
 * Dao
 */
public interface Dao<E> {
    void insert(E e);

    List<E> getAll();

    void update();

    void delete();
}