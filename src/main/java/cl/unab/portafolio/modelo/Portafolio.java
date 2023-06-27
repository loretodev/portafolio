/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.portafolio.modelo;

/**
 * Clase que representa un portafolio.
 * @author Loreto Galvez
 */
public class Portafolio {
    
    private int id;
    private String nombre;
    private String apellido;
    private String profesion;
    private String acercaDeMi01;
    private String acercaDeMi02;
    private String direccion;
    private String estado;
    
    private String nombreEstado;

    /**
     * Constructor por defecto de la clase Portafolio.
     */
    public Portafolio() {
    }

    /**
     * Obtiene el ID del portafolio.
     * @return El ID del portafolio.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del portafolio.
     * @param id El ID del portafolio.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del portafolio.
     * @return El nombre del portafolio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del portafolio.
     * @param nombre El nombre del portafolio.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del portafolio.
     * @return El apellido del portafolio.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del portafolio.
     * @param apellido El apellido del portafolio.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la profesión del portafolio.
     * @return La profesión del portafolio.
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * Establece la profesión del portafolio.
     * @param profesion La profesión del portafolio.
     */
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * Obtiene la descripción acerca de mí del portafolio.
     * @return La descripción acerca de mí del portafolio.
     */
    public String getAcercaDeMi01() {
        return acercaDeMi01;
    }

    /**
     * Establece la descripción acerca de mí del portafolio.
     * @param acercaDeMi01 La descripción acerca de mí del portafolio.
     */
    public void setAcercaDeMi01(String acercaDeMi01) {
        this.acercaDeMi01 = acercaDeMi01;
    }

    /**
     * Obtiene la segunda descripción acerca de mí del portafolio.
     * @return La segunda descripción acerca de mí del portafolio.
     */
    public String getAcercaDeMi02() {
        return acercaDeMi02;
    }

    /**
     * Establece la segunda descripción acerca de mí del portafolio.
     * @param acercaDeMi02 La segunda descripción acerca de mí del portafolio.
     */
    public void setAcercaDeMi02(String acercaDeMi02) {
        this.acercaDeMi02 = acercaDeMi02;
    }

    /**
     * Obtiene la dirección del portafolio.
     * @return La dirección del portafolio.
     */
    public String getDireccion() {
        return direccion;
    }



    /**
     * Establece la dirección del portafolio.
     * @param direccion La dirección del portafolio.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el estado del portafolio.
     * @return El estado del portafolio.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del portafolio.
     * @param estado El estado del portafolio.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el nombre del estado del portafolio.
     * @return El nombre del estado del portafolio.
     */
    public String getNombreEstado() {
        return nombreEstado;
    }

    /**
     * Establece el nombre del estado del portafolio.
     * @param nombreEstado El nombre del estado del portafolio.
     */
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }   
    
}


