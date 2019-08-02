package com.revature.movie.api.users;

import com.revature.movie.api.entities.Dao;

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
    public void update() {

    }

    @Override
    public void delete() {
		
    }

}