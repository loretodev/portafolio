/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.portafolio.servicio;

import cl.unab.portafolio.modelo.CantidadExperienciasDTO;
import cl.unab.portafolio.modelo.Experiencia;
import cl.unab.portafolio.repositorioDAO.ExperienciaDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementación de la interfaz ExperienciaServicio que proporciona métodos
 * para manejar las experiencias en un portafolio.
 *
 * @author Loreto Galvez
 */
public class ExperienciaServicioImpl implements ExperienciaServicio {

    private ExperienciaDAO experienciaDao = new ExperienciaDAO();


    @Override
    public List<Experiencia> obtenerExperienciasPortafolio(int idPortafolio) {

        List<Experiencia> result = new ArrayList<Experiencia>();
        List<Experiencia> lista = experienciaDao.obtenerExperienciasPortafolio(idPortafolio);
        for (Experiencia experiencia : lista) {
            result.add(experiencia);
        }
        return result;
    }


    @Override
    public void actualizarExperiencia(int idExperiencia, int idPortafolio, String titulo, String texto, String pagina) {
        Experiencia experiencia = new Experiencia();

        experiencia.setIdExperiencia(idExperiencia);
        experiencia.setIdPortafolio(idPortafolio);
        experiencia.setTitulo(titulo);
        experiencia.setTexto(texto);
        experiencia.setPagina(pagina);

        experienciaDao.actualizarExperiencia(experiencia);
    }


    @Override
    public void eliminarExperiencia(int idExperiencia) {
        experienciaDao.eliminarExperiencia(idExperiencia);
    }


    @Override
    public void insertarExperiencia(int idPortafolio, String titulo, String texto, String pagina) {
        Experiencia experiencia = new Experiencia();

        experiencia.setIdPortafolio(idPortafolio);
        experiencia.setTitulo(titulo);
        experiencia.setTexto(texto);
        experiencia.setPagina(pagina);

        experienciaDao.insertarExperiencia(experiencia);
    }


    @Override
    public Experiencia obtenerExperiencia(int experienciaId) {
        Experiencia expe = experienciaDao.obtenerExperiencia(experienciaId);
        return expe;
    }


    @Override
    public Map obtenerExperienciaAgrupada() {
        Map mapa = new HashMap();
        List<CantidadExperienciasDTO> listaAgrupada = experienciaDao.obtenerExperienciaAgrupada();

        for (CantidadExperienciasDTO cantidadExperienciasDTO : listaAgrupada) {
            mapa.put(cantidadExperienciasDTO.getId_portafolio(), cantidadExperienciasDTO.getCantidad_experiencias());
        }
        return mapa;
    }

}
