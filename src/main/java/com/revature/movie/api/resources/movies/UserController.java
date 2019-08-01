package com.revature.movie.api.resources.movies;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.revature.movie.api.ConnectionUtil;
import com.revature.movie.api.domain.UserService;
import com.revature.movie.api.domain.User;
import com.revature.movie.api.entities.UserDao;

@Path(value = "movies")
public class UserController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllMoviesJSON() {
		List<User> movies = null;

		try (Connection connection = new ConnectionUtil().getConnection()) {
			UserDao dao = new UserDao(connection);
			UserService service = new UserService(dao);
			movies = service.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movies;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public void insertMovie(@FormParam("userId") int userId, @FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
			@Context HttpServletResponse resp) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			UserDao dao = new UserDao(connection);
			UserService service = new UserService(dao);
			service.insert(new User(0, firstName, lastName));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resp.sendRedirect("/movie-api");
	}
}