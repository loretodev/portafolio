/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cl.unab.portafolio.servicio;

import cl.unab.portafolio.modelo.Portafolio;
import java.util.List;

/**
 * Proporciona métodos para interactuar con los objetos de Portafolio.
 * @author Loreto Galvez
 */
public interface PortafolioServicio {

    /**
     * Obtiene el portafolio activo.
     * @return El objeto Portafolio que representa el portafolio activo.
     */
    public Portafolio obtenerPortafolioActivo();

    /**
     * Obtiene un portafolio por su ID.
     * @param portafolioId El ID del portafolio a obtener.
     * @return El objeto Portafolio correspondiente al ID especificado.
     */
    public Portafolio obtenerPortafolio(int portafolioId);

    /**
     * Obtiene todos los portafolios.
     * @return Una lista de objetos Portafolio que representa todos los
     * portafolios.
     */
    public List<Portafolio> obtenerPortafolioTodos();

    /**
     * Actualiza un portafolio existente.
     * @param id El ID del portafolio a actualizar.
     * @param nombre El nombre del portafolio.
     * @param apellido El apellido del portafolio.
     * @param profesion La profesión del portafolio.
     * @param acercaDeMi01 Información sobre el portafolio.
     * @param acercaDeMi02 Información adicional sobre el portafolio.
     * @param direccion La dirección del portafolio.
     * @param estado El estado del portafolio.
     * @return El resultado de la operación de actualización.
     */
    public int actualizarPortafolio(int id, String nombre, String apellido, String profesion, String acercaDeMi01, String acercaDeMi02, String direccion, String estado);

    /**
     * Elimina un portafolio existente.
     * @param idPortafolio El ID del portafolio a eliminar.
     * @return El resultado de la operación de eliminación.
     */
    public int eliminarPortafolio(int idPortafolio);

    /**
     * Inserta un nuevo portafolio.
     * 
     * @param nombre El nombre del portafolio.
     * @param apellido El apellido del portafolio.
     * @param profesion La profesión del portafolio.
     * @param acercaDeMi01 Información sobre el portafolio.
     * @param acercaDeMi02 Información adicional sobre el portafolio.
     * @param direccion La dirección del portafolio.
     * @param estado El estado del portafolio.
     * @return El resultado de la operación de inserción.
     */
    public int insertarPortafolio(String nombre, String apellido, String profesion, String acercaDeMi01, String acercaDeMi02, String direccion, String estado);

}
