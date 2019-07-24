package com.sumerge.program;

import Entities.employee;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.logging.Logger;
import static java.util.logging.Level.SEVERE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("users")

public class UserResources {

    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());

    @EJB
    static private UserRepo repo = new UserRepo();

    @Context
    HttpServletRequest request;

    @GET
    public Response getAllUsers() {
        try {
            return Response.ok().
                    entity(repo.getUserList()).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    @Path("name")
    public Response getUserbyName(@QueryParam("name") String name) {
        try {
            return Response.ok().
                    entity(repo.getUserbyName(name)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    @Path("address")
    public Response getUserbyAddress(@QueryParam("address") String address) {
        try {
            return Response.ok().
                    entity(repo.getUserbyAddress(address)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    @Path("email")
    public Response getUserbyEmail(@QueryParam("email") String email) {
        try {
            return Response.ok().
                    entity(repo.getUserbyemail(email)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }


    @GET
    @Path("{id}")
    public Response getStudent(@PathParam("id") int id
                               ) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        employee em = entityManager.find(employee.class, "E10001");
        System.out.println("emp id :: " + em.getEmpid());
        System.out.println("emp id :: " + em.getFamillyname());
        System.out.println("ALIVE");

        entityManager.getTransaction().commit();
        entityManager.close();
        try {

            return Response.ok().
                    entity(em).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        try {
            repo.deleteUser(id);
            return Response.ok().
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @PUT
    public Response editStudent(User  u)  {
        try {
            if (u.getId() == -1)
                throw new IllegalArgumentException("Can't edit student since it does not exist in the database");

            repo.Update(u,u.getId());
            return Response.ok().
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }




}
