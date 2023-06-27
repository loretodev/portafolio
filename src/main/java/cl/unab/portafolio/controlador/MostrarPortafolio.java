/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cl.unab.portafolio.controlador;

import cl.unab.portafolio.modelo.Experiencia;
import cl.unab.portafolio.modelo.Portafolio;
import cl.unab.portafolio.servicio.ExperienciaServicio;
import cl.unab.portafolio.servicio.ExperienciaServicioImpl;
import cl.unab.portafolio.servicio.PortafolioServicio;
import cl.unab.portafolio.servicio.PortafolioServicioImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Loreto Galvez
 */
public class MostrarPortafolio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PortafolioServicio portafolioServicio = new PortafolioServicioImpl();        
        ExperienciaServicio experienciaServicio = new ExperienciaServicioImpl();
        
        System.out.println("ANTES DE MOSTRAR PORTAFOLIO EN BOOTCAMP CLIENTE");
        Portafolio portafolio = (Portafolio) portafolioServicio.obtenerPortafolioActivo();
        
        if (portafolio!=null) { //Si encuentra portafolio activo, busco las experiencias
            List<Experiencia> listaExperiencias = experienciaServicio.obtenerExperienciasPortafolio(portafolio.getId());
            request.getSession().setAttribute("LISTA_EXPERIENCIAS", listaExperiencias);
        }
   
        request.getSession().setAttribute("PORTAFOLIO_CLIENTE", portafolio);
        response.sendRedirect("index.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
