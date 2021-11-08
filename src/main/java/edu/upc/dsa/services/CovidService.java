package edu.upc.dsa.services;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.CovidManagerImpl;
import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Seguimiento;
import edu.upc.dsa.models.Vacuna;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Api(value = "Covid", description = "Endpoint to Text Service")
@Path("/users")
public class CovidService {
    private Covid19Manager manager;

    public CovidService(){
        this.manager = CovidManagerImpl.getInstance();
    }

    @PUT
    @ApiOperation(value = "poner vacuna", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })

    @Path("/AddVacuna/{idUser}{marcaVacuna}{fecha}")
    public Response addVacuna(@PathParam("idUser") String idUser, @PathParam("marcaVacuna") String marcaVacuna, @PathParam("fecha") String fecha) {

        Persona p = manager.getUserById(idUser);
        Vacuna vacuna = manager.getVacunaById(marcaVacuna);
        manager.addVacuna(idUser,marcaVacuna, fecha);
        if (p == null || marcaVacuna == null || fecha == null) return Response.status(404).build();
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "Donam les vacunes ordenades", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Vacuna.class, responseContainer="List"),
    })
    @Path("/getVacunesOrdenades")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacunesOrdenades() {

        List<Vacuna> vacunas = this.manager.listarVacunas();

        GenericEntity<List<Vacuna>> entity = new GenericEntity<List<Vacuna>>(vacunas) {};
        return Response.status(201).entity(entity).build()  ;
    }


    @GET
    @ApiOperation(value = "Donam totes les marques de vacunes", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Vacuna.class, responseContainer="List"),
    })
    @Path("/getVacunesMarca")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacunesMarca() {

        List<Vacuna> vacunas = this.manager.listarVacunasMarca();

        GenericEntity<List<Vacuna>> entity = new GenericEntity<List<Vacuna>>(vacunas) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @PUT
    @ApiOperation(value = "Afegeix un seguiment a un usuari", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Usuari not found")
    })
    @Path("/updateSeguiment")
    public Response updateSeguiment(@PathParam("idUser") String idUser, @PathParam("data") String data, @PathParam("descripcio") String descripcio) {

        Seguimiento s = this.manager.addSeguimiento(idUser, data, descripcio);
        if(s==null){
            return Response.status(404).build();
        }
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "Donam el seguiment d'una persona", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Seguimiento.class, responseContainer="List"),
    })
    @Path("/getSeguimentPersona")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSeguimentPersona(String idUser) {

        List<Seguimiento> seguimiento = this.manager.listarSeguimientos(idUser);

        GenericEntity<List<Seguimiento>> entity = new GenericEntity<List<Seguimiento>>(seguimiento) {};
        return Response.status(201).entity(entity).build();
    }

}
