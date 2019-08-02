package com.revature.movie.api.requests;

import com.revature.movie.api.entities.Dao;

public class RequestService implements Service<Requests> {
    private Dao<Requests> dao;

    public RequestService(Dao<Requests> dao) {
        this.dao = dao;
    }

    @Override
    public void insert(Requests request) {
        this.dao.insert(request);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
		
    }

}