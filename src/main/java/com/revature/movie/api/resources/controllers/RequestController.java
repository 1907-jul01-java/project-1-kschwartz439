// package com.revature.movie.api.resources.controllers;

// import java.sql.Connection;
// import java.sql.SQLException;
// import java.util.List;

// import javax.ws.rs.GET;
// import javax.ws.rs.Path;
// import javax.ws.rs.Produces;
// import javax.ws.rs.core.MediaType;

// import com.revature.movie.api.ConnectionUtil;
// import com.revature.movie.api.entities.RequestDao;
// import com.revature.movie.api.requests.RequestService;
// import com.revature.movie.api.requests.Requests;

// @Path(value = "requests")
// public class RequestController{
    
// 	@GET
// 	@Produces(MediaType.APPLICATION_JSON)
// 	public List<Requests> getAllUsersJSON() {
// 		List<Requests> requests = null;

// 		try (Connection connection = new ConnectionUtil().getConnection()) {
// 			RequestDao dao = new RequestDao(connection);
// 			RequestService service = new RequestService(dao);
// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		}

// 		return requests;
// 	}
// }