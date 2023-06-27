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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Loreto Galvez
 */     
public class ExperienciaAdmin extends HttpServlet {


    /**
     * Procesa peticiones para ambos metodos HTTP <code>GET</code> and <code>POST</code>.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Declaracion de variables generales
        HttpSession session = request.getSession(true);
        ExperienciaServicio experienciaServicio = new ExperienciaServicioImpl();
        PortafolioServicio portafolioServicio = new PortafolioServicioImpl();

        //Recibo los parametros generales
        String accion = request.getParameter("accion") != null ? request.getParameter("accion") : "";
        int idPortafolio = request.getParameter("id")!=null ? Integer.parseInt(request.getParameter("id")): 0;
        int idExperiencia = request.getParameter("idExp")!=null ? Integer.parseInt(request.getParameter("idExp")): 0;
        
        //Logica principal del controlador (incluye try catch para el control de errores)
        try {
            //Inicializacion de variables
            String jsp = "listarExperiencia.jsp";
            
            //Opciones de menu experiencia
            if ("edit".equalsIgnoreCase(accion)) { //Llamada a editar experiencia, mostrara un jsp 
                Experiencia expVO = experienciaServicio.obtenerExperiencia(idExperiencia);
                Portafolio portafolioVO = portafolioServicio.obtenerPortafolio(idPortafolio);

                session.setAttribute("experienciaVO", expVO);
                session.setAttribute("portafolioVO", portafolioVO);

                jsp ="editarExperiencia.jsp";
                
            } else if ("editSub".equalsIgnoreCase(accion)) { //Va a guardar los valores que estaban editados
                String titulo = request.getParameter("titulo") != null ? String.valueOf(request.getParameter("titulo")) : "";
                String texto = request.getParameter("texto") != null ? String.valueOf(request.getParameter("texto")) : "";
                String pagina = request.getParameter("pagina") != null ? String.valueOf(request.getParameter("pagina")) : "";

                experienciaServicio.actualizarExperiencia(idExperiencia, idPortafolio, titulo, texto, pagina);
                System.out.println("Experiencia actualizada");
                
            } else if ("del".equalsIgnoreCase(accion)) { //Va a eliminar desde la base datos
                experienciaServicio.eliminarExperiencia(idExperiencia);
                System.out.println("Experiencia eliminada");
            
            } else if ("ins".equalsIgnoreCase(accion)) { //Muestra un jsp vacio para ingresar la experiencia
                Portafolio portafolioVO2 = portafolioServicio.obtenerPortafolio(idPortafolio);
                session.setAttribute("portafolioVO", portafolioVO2);

                jsp = "ingresarExperiencia.jsp";
            
            } else if ("insSub".equalsIgnoreCase(accion)) { // Procesa el formulario de ingreso para guardar en la BD
                String titulo2 = request.getParameter("titulo") != null ? String.valueOf(request.getParameter("titulo")) : "";
                String texto2 = request.getParameter("texto") != null ? String.valueOf(request.getParameter("texto")) : "";
                String pagina2 = request.getParameter("pagina") != null ? String.valueOf(request.getParameter("pagina")) : "";

                experienciaServicio.insertarExperiencia(idPortafolio, titulo2, texto2, pagina2);
                System.out.println("Experiencia insertada");
            }            
           
            
            
            //Listar las experiencias cuando corresponda
            if (jsp.equals("listarExperiencia.jsp")) { 
                List<Experiencia> lista = experienciaServicio.obtenerExperienciasPortafolio(idPortafolio);
                session.setAttribute("portafolio", portafolioServicio.obtenerPortafolio(idPortafolio));
                session.setAttribute("listaExperienciasPortafolio", lista);
            }

            //Redireccionamiento (ir a la pagina que corresponde)
            System.out.println("EN SERVLET a jsp " + jsp);
            response.sendRedirect("admin/experiencia/"+jsp);
        } 
        catch(Exception ex){ // Manejo de la excepción
            ex.printStackTrace();
            System.out.println("Ocurrió una excepción: " + ex.getMessage());
        }
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
