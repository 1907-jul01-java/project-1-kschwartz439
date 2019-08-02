package com.revature.movie.api.requests;

/**
 * Service
 */
public interface Service<E> {
    void insert(E e);

    void update();

    void delete();
}