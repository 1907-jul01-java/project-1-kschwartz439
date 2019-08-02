package com.revature.movie.api.requests;

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
import com.revature.movie.api.entities.RequestDao;

/**
 * MovieController
 * 
 */
@Path(value = "request")
public class RequestController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Requests> getAllMoviesJSON(String username) {
		List<Requests> requests = null;

		try (Connection connection = new ConnectionUtil().getConnection()) {
			RequestDao dao = new RequestDao(connection);
			RequestService service = new RequestService(dao);
			requests = service.getAll(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public void insertMovie(@FormParam("requestName") String requestName, @FormParam("requestType") String requestType, @FormParam("cost") double cost, @FormParam("requestDescription") String requestDescription, @FormParam("imageLocation") String imageLocation, @FormParam("username") String username, @FormParam("approved") String approved,
			@Context HttpServletResponse resp) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			RequestDao dao = new RequestDao(connection);
			RequestService service = new RequestService(dao);
			service.insert(new Requests(requestName, requestType, cost, requestDescription, /*imageLocation, */username, approved));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resp.sendRedirect("/movie-api");
	}
}