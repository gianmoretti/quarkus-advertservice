package com.jobrapido;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/advert")
public class AdvertResource {

    @Inject 
    AdvertService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "hello";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{company}")
    public List<Advert> advert(@PathParam String company) {
        return service.getAdverts(company);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/all")
    public List<Advert> allAdverts() {
        return service.getAllAdverts();
    }

    @PUT
    @Path("/create")
    public void createAdvert(
        @QueryParam String title,
        @QueryParam String url,
        @QueryParam String website,
        @QueryParam String company
        ) {
        service.createAdvert(title, url, website, company);
    }

}