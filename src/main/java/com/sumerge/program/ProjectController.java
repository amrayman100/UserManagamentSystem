package com.sumerge.program;

import Entities.department;
import Entities.employee;
import Entities.Project;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
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
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Level.SEVERE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("project")
public class ProjectController {
    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());
    @GET
    public Response getAllProject() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Project> query =
                entityManager.createNamedQuery("project.findAll", Project.class);
        List<Project> results = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        try {
            return Response.ok().
                    entity(results).
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
    public Response getProject(@PathParam("id") String id
    ) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Project em = entityManager.find(Project.class, id);


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

    @POST
    public Response adddepartment(Project  u)  {
        try {
            //u.setEmpid("14p6072");

            System.out.println("ALIVE");
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(u);
            entityManager.getTransaction().commit();
            entityManager.close();
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
    public Response editProject(Project  u)  {
        try {

            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            Project em = entityManager.find(Project.class, u.getProjid());
            em.setProjname("ok");

            //em = u;

            //entityManager.merge(em);
            // entityManager.refresh(em);
            entityManager.getTransaction().commit();
            entityManager.close();


            return Response.ok().
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
    public Response deleteProject(@PathParam("id") String id) {
        try {
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            Project em = entityManager.find(Project.class, id);

            entityManager.remove(em);
            entityManager.getTransaction().commit();
            entityManager.close();
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

