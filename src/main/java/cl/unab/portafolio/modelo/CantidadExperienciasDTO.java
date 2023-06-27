/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.portafolio.modelo;

/**
 * Clase que representa un objeto CantidadExperienciasDTO.
 * Contiene el id del portafolio y la cantidad de experiencias.
 * 
 * @author Loreto Galvez
 */
public class CantidadExperienciasDTO {

    private int id_portafolio;
    private int cantidad_experiencias;

    /**
     * Constructor por defecto de la clase CantidadExperienciasDTO.
     */
    public CantidadExperienciasDTO() {
    }
    
    /**
     * Obtiene el id del portafolio.
     * @return El id del portafolio.
     */
    public int getId_portafolio() {
        return id_portafolio;
    }

    /**
     * Establece el id del portafolio.
     * @param id_portafolio El id del portafolio a establecer.
     */
    public void setId_portafolio(int id_portafolio) {
        this.id_portafolio = id_portafolio;
    }

    /**
     * Obtiene la cantidad de experiencias.
     * @return La cantidad de experiencias.
     */
    public int getCantidad_experiencias() {
        return cantidad_experiencias;
    }

    /**
     * Establece la cantidad de experiencias.
     * @param cantidad_experiencias La cantidad de experiencias a establecer.
     */
    public void setCantidad_experiencias(int cantidad_experiencias) {
        this.cantidad_experiencias = cantidad_experiencias;
    }   
}