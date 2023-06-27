package cl.unab.portafolio.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Clase de configuración de la aplicación que extiende de
 * javax.ws.rs.core.Application.
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    /**
     * Obtiene el conjunto de clases que son recursos REST de la aplicación.
     *
     * @return El conjunto de clases que son recursos REST.
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Agrega las clases de recursos REST al conjunto de recursos.
     * @param resources El conjunto de clases de recursos REST.
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cl.unab.portafolio.rest.Rest.class);
    }
}
