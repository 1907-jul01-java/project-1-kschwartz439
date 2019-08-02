// package com.revature.movie.api.resources.controllers;

// import java.io.IOException;
// import java.sql.Connection;
// import java.sql.SQLException;
// import java.util.List;

// import javax.servlet.http.HttpServletResponse;
// import javax.ws.rs.Consumes;
// import javax.ws.rs.FormParam;
// import javax.ws.rs.POST;
// import javax.ws.rs.Path;
// import javax.ws.rs.Produces;
// import javax.ws.rs.core.Context;
// import javax.ws.rs.core.MediaType;

// import com.revature.movie.api.ConnectionUtil;
// import com.revature.movie.api.entities.UserDao;
// import com.revature.movie.api.users.User;
// import com.revature.movie.api.users.UserService;

// @Path(value = "users")
// public class UserController {

// 	// Login
// 	@POST
// 	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
// 	@Produces(MediaType.TEXT_HTML)
// 	public List<User> getAllUsersJSON() {
// 		List<User> users = null;

// 		try (Connection connection = new ConnectionUtil().getConnection()) {
// 			UserDao dao = new UserDao(connection);
// 			UserService service = new UserService(dao);
// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		}

// 		return users;
// 	}

// 	// Signup
// 	@POST
// 	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
// 	@Produces(MediaType.TEXT_HTML)
// 	public void insertUser(@FormParam("username") String username, @FormParam("password") String password,
// 			@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
// 			@Context HttpServletResponse resp) throws IOException {
// 		try (Connection connection = new ConnectionUtil().getConnection()) {
// 			UserDao dao = new UserDao(connection);
// 			UserService service = new UserService(dao);
// 			service.insert(new User(firstName, lastName, username, password));
// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		}

// 		resp.sendRedirect("/movie-api");
// 	}
// }