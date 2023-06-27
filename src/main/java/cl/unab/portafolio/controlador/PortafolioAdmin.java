package cl.unab.portafolio.controlador;

import cl.unab.portafolio.modelo.Experiencia;
import cl.unab.portafolio.modelo.Portafolio;
import cl.unab.portafolio.servicio.ExperienciaServicio;
import cl.unab.portafolio.servicio.ExperienciaServicioImpl;
import cl.unab.portafolio.servicio.PortafolioServicio;
import cl.unab.portafolio.servicio.PortafolioServicioImpl;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Loreto Galvez
 */
public class PortafolioAdmin extends HttpServlet {

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

        //Declaracion de variables generales
        HttpSession session = request.getSession(true);
        PortafolioServicio portafolioServicio = new PortafolioServicioImpl();
        ExperienciaServicio experienciaServicio = new ExperienciaServicioImpl();
        
        //Recibo los parametros generales
        String accion = request.getParameter("accion") != null ? request.getParameter("accion") : "";
        int idPortafolio = request.getParameter("id")!=null ? Integer.parseInt(request.getParameter("id")): 0;
        
        //Logica principal del controlador (incluye try catch para el control de errores)
        try {
            //Inicializacion de variables
            String jsp = "listarPortafolio.jsp";
            session.setAttribute("MENSAJE",null);
            
            //Opciones de menu portafolio
            if ("edit".equalsIgnoreCase(accion)) { //Llamada a editar portafolio, mostrara un jsp 
                Portafolio portafolioVO = portafolioServicio.obtenerPortafolio(idPortafolio);
                session.setAttribute("portafolioVO", portafolioVO);
                jsp ="editarPortafolio.jsp";

            } else if ("editSub".equalsIgnoreCase(accion)) { //Va a guardar los valores que estaban editados
                //Recibo parametros
                String nombre = request.getParameter("nombre") != null ? String.valueOf(request.getParameter("nombre")) : "";
                String apellido = request.getParameter("apellido") != null ? String.valueOf(request.getParameter("apellido")) : "";
                String profesion = request.getParameter("profesion") != null ? String.valueOf(request.getParameter("profesion")) : "";
                String acercaDeMi01 = request.getParameter("acercaDeMi01") != null ? String.valueOf(request.getParameter("acercaDeMi01")) : "";
                String acercaDeMi02 = request.getParameter("acercaDeMi02") != null ? String.valueOf(request.getParameter("acercaDeMi02")) : "";
                String direccion = request.getParameter("direccion") != null ? String.valueOf(request.getParameter("direccion")) : "";
                String estado = request.getParameter("estado") != null ? String.valueOf(request.getParameter("estado")) : "";

                int result = portafolioServicio.actualizarPortafolio(idPortafolio, nombre, apellido, profesion, acercaDeMi01, acercaDeMi02, direccion, estado);
                System.out.println("Portafolio actualizado: " + result);
                
            } else if ("del".equalsIgnoreCase(accion)) { //Va a eliminar desde la base datos
                List<Experiencia> listaExp = experienciaServicio.obtenerExperienciasPortafolio(idPortafolio);
                if (listaExp!=null && listaExp.size()>0) {
                    System.out.println("NO SE PUEDE ELIMINAR PORQUE TIENE EXPERIENCIAS");
                    session.setAttribute("MENSAJE", "NO SE PUEDE ELIMINAR PORQUE TIENE EXPERIENCIAS");
                } else {
                    int result3 = portafolioServicio.eliminarPortafolio(idPortafolio);
                    System.out.println("Portafolio eliminado: " + result3);
                }

            } else if ("ins".equalsIgnoreCase(accion)) { //Muestra un jsp vacio para ingresar el portafolio
                jsp ="ingresarPortafolio.jsp";

            } else if ("insSub".equalsIgnoreCase(accion)) { // Procesa el formulario de ingreso para guardar en la BD
                //Recibo parametros
                String nombre2 = request.getParameter("nombre") != null ? String.valueOf(request.getParameter("nombre")) : "";
                String apellido2 = request.getParameter("apellido") != null ? String.valueOf(request.getParameter("apellido")) : "";
                String profesion2 = request.getParameter("profesion") != null ? String.valueOf(request.getParameter("profesion")) : "";
                String acercaDeMi012 = request.getParameter("acercaDeMi01") != null ? String.valueOf(request.getParameter("acercaDeMi01")) : "";
                String acercaDeMi022 = request.getParameter("acercaDeMi02") != null ? String.valueOf(request.getParameter("acercaDeMi02")) : "";
                String direccion2 = request.getParameter("direccion") != null ? String.valueOf(request.getParameter("direccion")) : "";
                String estado2 = request.getParameter("estado") != null ? String.valueOf(request.getParameter("estado")) : "";

                int result2 = portafolioServicio.insertarPortafolio(nombre2, apellido2, profesion2, acercaDeMi012, acercaDeMi022, direccion2, estado2);
                System.out.println("Portafolio insertado: " + result2);
            }            
            
            
            //Listar los portafolios cuando corresponda
            if (jsp.equals("listarPortafolio.jsp")) { 
                List<Portafolio> listaDePortafolios = portafolioServicio.obtenerPortafolioTodos();
                Map cantidadExperienciasPortafolio = experienciaServicio.obtenerExperienciaAgrupada();
                
                //Guardo la lista de portafolios en session
                session.setAttribute("listaPortafolios", listaDePortafolios); 
                
                //Guardo en session la lista agrupada de experiencias de portafolios
                session.setAttribute("cantidadExperienciasPortafolio", cantidadExperienciasPortafolio); 
            }

            //Redireccionamiento (ir a la pagina que corresponde)
            System.out.println("EN SERVLET a jsp " + jsp);
            response.sendRedirect("admin/portafolio/" + jsp);
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
