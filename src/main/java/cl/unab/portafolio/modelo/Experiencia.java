/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.portafolio.modelo;

import java.io.Serializable;

/**
 * Clase que representa la tabla Experiencia.
 * Contiene información sobre una experiencia relacionada a un portafolio.
 * Implementa la interfaz Serializable.
 * 
 * @author Loreto Galvez
 */
public class Experiencia implements Serializable {
    private int idExperiencia;
    private int idPortafolio;
    private String titulo;
    private String texto;
    private String pagina;

    /**
     * Constructor por defecto de la clase Experiencia.
     */
    public Experiencia() {
    }

    /**
     * Obtiene el id de la experiencia.
     * @return El id de la experiencia.
     */
    public int getIdExperiencia() {
        return idExperiencia;
    }

    /**
     * Establece el id de la experiencia.
     * @param idExperiencia El id de la experiencia a establecer.
     */
    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    /**
     * Obtiene el id del portafolio asociado a la experiencia.
     * @return El id del portafolio asociado a la experiencia.
     */
    public int getIdPortafolio() {
        return idPortafolio;
    }

    /**
     * Establece el id del portafolio asociado a la experiencia.
     * @param idPortafolio El id del portafolio a establecer.
     */
    public void setIdPortafolio(int idPortafolio) {
        this.idPortafolio = idPortafolio;
    }

    /**
     * Obtiene el título de la experiencia.
     * @return El título de la experiencia.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la experiencia.
     * @param titulo El título de la experiencia a establecer.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el texto de la experiencia.
     * @return El texto de la experiencia.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Establece el texto de la experiencia.
     * @param texto El texto de la experiencia a establecer.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Obtiene la página de la experiencia.
     * @return La página de la experiencia.
     */
    public String getPagina() {
        return pagina;
    }

    /**
     * Establece la página de la experiencia.
     * @param pagina La página de la experiencia a establecer.
     */
    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
}