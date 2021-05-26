package edu.pingpong.quickstart;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/espadas")
public class EspadaResource {
    @Inject
    EspadaService service;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postEspadas(Espada espada){
        return service.postEspada(espada);
    }

    @Path("/{nombre}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Espada> getEspadaNombre(@PathParam("nombre")String nombre){
        return this.service.getEspadaNombre(nombre);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Espada> getListaEspadas(){
        return service.getListaEspadas();
    }

    @Path("/longitud/{longitud}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Espada> getEspadaLongitud(@PathParam("longitud")String longitud){
        return this.service.getEspadaLongitud(longitud);
    }
    @Path("/{nombre}")
    @DELETE
    @Transactional
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Espada> delete(@PathParam("nombre")String nombre){
        service.deleteEspadas(nombre);
        return this.getListaEspadas();
    }
}