package at.htl.vehicle.rest;

import at.htl.vehicle.model.Vehicle;
import at.htl.vehicle.persistence.VehicleRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.net.URI;

@Path("vehicle")
public class VehicleEndpoint {

    @Inject
    VehicleRepository vehicleRepository;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("all")
    public Response findAll() {
        return Response.ok(vehicleRepository.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("id/{id}")
    public Response findById(@PathParam("id") long id) {
        return Response.ok(vehicleRepository.find(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Vehicle toSave) {
        Vehicle saved = vehicleRepository.save(toSave);
        if (toSave.equals(saved)) {
            return Response.notModified().build();
        } else {
            return Response.created(URI.create(saved.getId().toString())).build();
        }
    }

    @DELETE
    @Path("id/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (vehicleRepository.delete(id)) {
            return Response.accepted().build();
        } else {
            return Response.notModified().build();
        }
    }
}
