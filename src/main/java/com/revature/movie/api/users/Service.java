package com.revature.movie.api.users;

/**
 * Service
 */
public interface Service<E> {
    void insert(E e);

    void update();

    void delete();
}