package com.sumerge.program;
import Entities.employee;

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
@Path("employee")
public class EmployeeController {
    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());
    @GET
    public Response getAllEmployees() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<employee> query =
                entityManager.createNamedQuery("employee.findAll", employee.class);
        List<employee> results = query.getResultList();

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
    @Path("name")
    public Response getEmployee(@QueryParam("name") String name
    ) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<employee> query =
                entityManager.createNamedQuery("employee.findByName",employee.class).setParameter("commonname", name);
        employee em = query.getSingleResult();
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

    @GET
    @Path("{id}")
    public Response getByCommonEmployee(@PathParam("id") String id
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

    @POST
    public Response addEmployee(employee  u)  {
        try {
            //u.setEmpid("14p6072");
            System.out.println("emp id :: " + u.getEmpid());
            System.out.println("emp id :: " + u.getFamillyname());
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
    public Response editEmployee(employee  u)  {
        try {

            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            employee em = entityManager.find(employee.class, u.getEmpid());
            em.setCommonname("ok");
            System.out.println("name b4 :: " + em.getGivenname());
            //em = u;
            System.out.println("name after :: " + em.getGivenname());
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
    public Response deleteEmployee(@PathParam("id") String id) {
        try {
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            employee em = entityManager.find(employee.class, id);
            System.out.println("name b4 :: " + em.getGivenname());
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
