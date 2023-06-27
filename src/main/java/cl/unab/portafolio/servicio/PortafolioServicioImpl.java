/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.portafolio.servicio;

import cl.unab.portafolio.modelo.Portafolio;
import cl.unab.portafolio.repositorioDAO.PortafolioDAO;
import java.util.List;

/**
 * Esta clase es una implementación de la interfaz PortafolioServicio que
 * proporciona métodos para interactuar con los objetos de Portafolio.
 * @author Loreto Galvez
 */
public class PortafolioServicioImpl implements PortafolioServicio {

    private final PortafolioDAO portafolioDAO = new PortafolioDAO();

    @Override
    public Portafolio obtenerPortafolioActivo() {
        Portafolio portafolioVO = portafolioDAO.obtenerPortafolioActivo();
        return portafolioVO;
    }

    @Override
    public Portafolio obtenerPortafolio(int portafolioId) {
        Portafolio portafolioVO = portafolioDAO.obtenerPortafolio(portafolioId);
        return portafolioVO;
    }

    @Override
    public List<Portafolio> obtenerPortafolioTodos() {
        List<Portafolio> lista = portafolioDAO.obtenerPortafolioTodos();
        return lista;
    }

    @Override
    public int actualizarPortafolio(int id, String nombre, String apellido, String profesion, String acercaDeMi01, String acercaDeMi02, String direccion, String estado) {
        Portafolio portafolio = new Portafolio();

        portafolio.setNombre(nombre);
        portafolio.setApellido(apellido);
        portafolio.setProfesion(profesion);
        portafolio.setAcercaDeMi01(acercaDeMi01);
        portafolio.setAcercaDeMi02(acercaDeMi02);
        portafolio.setDireccion(direccion);
        portafolio.setEstado(estado);
        portafolio.setId(id);

        int result = portafolioDAO.actualizarPortafolio(portafolio);
        return result;
    }

    @Override
    public int eliminarPortafolio(int idPortafolio) {
        try {
            portafolioDAO.eliminarPortafolio(idPortafolio);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int insertarPortafolio(String nombre, String apellido, String profesion, String acercaDeMi01, String acercaDeMi02, String direccion, String estado) {
        Portafolio portafolio = new Portafolio();

        portafolio.setNombre(nombre);
        portafolio.setApellido(apellido);
        portafolio.setProfesion(profesion);
        portafolio.setAcercaDeMi01(acercaDeMi01);
        portafolio.setAcercaDeMi02(acercaDeMi02);
        portafolio.setDireccion(direccion);
        portafolio.setEstado(estado);

        int result = portafolioDAO.insertarPortafolio(portafolio);
        return result;
    }

}
