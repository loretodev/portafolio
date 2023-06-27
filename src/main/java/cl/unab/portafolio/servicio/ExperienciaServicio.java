/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cl.unab.portafolio.servicio;

import cl.unab.portafolio.modelo.Experiencia;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Loreto
 */
public interface ExperienciaServicio {

    /**
     * Obtiene la lista de experiencias de un portafolio.
     *
     * @param idPortafolio ID del portafolio del que se desea obtener las
     * experiencias.
     * @return Lista de experiencias del portafolio.
     */
    public List<Experiencia> obtenerExperienciasPortafolio(int idPortafolio);

    /**
     * Actualiza la información de una experiencia existente.
     *
     * @param idExperiencia ID de la experiencia que se desea actualizar.
     * @param idPortafolio ID del portafolio al que pertenece la experiencia.
     * @param titulo Título de la experiencia.
     * @param texto Texto descriptivo de la experiencia.
     * @param pagina Página asociada a la experiencia.
     */
    public void actualizarExperiencia(int idExperiencia, int idPortafolio, String titulo, String texto, String pagina);

    /**
     * Elimina una experiencia existente.
     *
     * @param idExperiencia ID de la experiencia que se desea eliminar.
     */
    public void eliminarExperiencia(int idExperiencia);

    /**
     * Inserta una nueva experiencia en un portafolio.
     *
     * @param idPortafolio ID del portafolio al que se desea agregar la
     * experiencia.
     * @param titulo Título de la experiencia.
     * @param texto Texto descriptivo de la experiencia.
     * @param pagina Página asociada a la experiencia.
     */
    public void insertarExperiencia(int idPortafolio, String titulo, String texto, String pagina);

    /**
     * Obtiene una experiencia por su ID.
     *
     * @param experienciaId ID de la experiencia que se desea obtener.
     * @return Experiencia correspondiente al ID proporcionado, o null si no se
     * encuentra.
     */
    public Experiencia obtenerExperiencia(int experienciaId);

    /**
     * Obtiene un mapa con la cantidad de experiencias agrupadas por portafolio.
     *
     * @return Mapa con la cantidad de experiencias agrupadas por portafolio.
     */
    public Map obtenerExperienciaAgrupada();
}
