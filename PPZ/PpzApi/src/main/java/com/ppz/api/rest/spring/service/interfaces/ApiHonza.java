package com.ppz.api.rest.spring.service.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.ppz.api.rest.entity.GetUsersResponse;

/**
 * The Interface ApiHonza.
 * 
 * @autor Honza
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@CrossOriginResourceSharing(allowAllOrigins = true)
public interface ApiHonza {

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@POST
	@Path("/getUsers/")
	public GetUsersResponse getUsers();

}
