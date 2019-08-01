package com.revature.movie.api.domain;

import java.util.List;

import com.revature.movie.api.entities.Dao;

/**
 * MovieService
 */
public class UserService implements Service<User> {
    private Dao<User> dao;

    public UserService(Dao<User> dao) {
        this.dao = dao;
    }

    @Override
    public void insert(User user) {
        this.dao.insert(user);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
		
    }

}