package org.nicolly.resource;

import java.util.List;

import org.nicolly.model.entity.Airbnb;
import org.nicolly.service.AirbnbService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/listings")
public class AirbnbResource {

    @Inject
    AirbnbService airbnbService;

    @GET
    public List<Airbnb> listar() {
        return airbnbService.listar();
    }
}
