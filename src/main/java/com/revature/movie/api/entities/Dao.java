package com.revature.movie.api.entities;

public interface Dao<E> {
    void insert(E e);

    void update();

    void delete();
}