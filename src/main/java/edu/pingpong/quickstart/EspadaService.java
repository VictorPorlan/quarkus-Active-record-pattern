package edu.pingpong.quickstart;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EspadaService {

    public EspadaService() {
    }

    public Optional<Espada> getEspadaNombre(String nombre){
        return Espada.find("nombre",nombre).firstResultOptional();
    }

    public Optional<Espada> getEspadaLongitud(double longitud){
        return Espada.find("longitud",longitud).firstResultOptional();
    }

    public Response postEspada(Espada espada){
        espada.persist();
        return Response.created(URI.create("/espadas/" + espada.id)).build();
    }

    public List<Espada> getListaEspadas() {
        return Espada.findAll().list();
    }

    public void deleteEspadas(String nombre){
        Espada espada = Espada.find("nombre", nombre).firstResult();
        espada.delete();
    }
}
