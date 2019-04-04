package com.dropwizard.platform.app.resources;

import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dropwizard.platform.app.db.User;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class controller {
	
	protected SessionFactory sessionFactory;
	
	public void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try {
		    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			System.out.println("catch error");
			StandardServiceRegistryBuilder.destroy(registry);
		    ex.printStackTrace();
		}
	}
	
	public void exit() {
		sessionFactory.close();
	}
	
	protected void create(String name) {
		User user = new User();
		user.setName(name);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	protected void read() {
		Session session = sessionFactory.openSession();
		
		session.close();
	}
	
	@POST
	public Response getUser() {
		controller c = new controller();
		c.setup();
		c.create("ujang");
		c.exit();
		return Response.ok("passing").build();
	}
	
}
