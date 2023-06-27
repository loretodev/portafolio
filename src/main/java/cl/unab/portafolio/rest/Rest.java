package cl.unab.portafolio.rest;

import cl.unab.portafolio.modelo.Portafolio;
import cl.unab.portafolio.servicio.PortafolioServicio;
import cl.unab.portafolio.servicio.PortafolioServicioImpl;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import javax.ws.rs.PathParam;

/**
 * Clase que representa un recurso REST para obtener un objeto Portafolio.
 */
@Path("/rest")
public class Rest {
    
    /**
     * Método GET para obtener un objeto Portafolio en formato JSON.
     * @param id El ID del Portafolio que se desea obtener.
     * @return El objeto Portafolio convertido a JSON.
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/get/{id}") // Parámetro en la ruta
    public String get(@PathParam("id") int id) {
        System.out.println("entra a get");
        PortafolioServicio portafolioServicio = new PortafolioServicioImpl();

        // Crear un objeto Java que deseas convertir a JSON
        Portafolio portafolio = (Portafolio) portafolioServicio.obtenerPortafolio(id);

        // Convertir el objeto Java a JSON utilizando Gson
        Gson gson = new Gson();
        String json = gson.toJson(portafolio);

        // Devolver el JSON resultante
        return json;
            //http://localhost:8080/portafolio/api/rest/get/rut (<-- asi se ejecuta, el rut que esta en la base de datos)
    }
}