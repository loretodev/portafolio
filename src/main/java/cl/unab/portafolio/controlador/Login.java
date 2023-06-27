/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cl.unab.portafolio.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author loreto galvez
 */
public class Login extends HttpServlet {

    private static final String USUARIO = "admin";
    private static final String PASS = "1234";

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
        
        System.out.println("cl.unab.portafolio.controlador.Login.doGet()");
        
	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
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
        
        System.out.println("cl.unab.portafolio.controlador.Login.doPost()");
        
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("password");

        HttpSession session = request.getSession();	

        if (USUARIO.equals(usuario) && PASS.equals(pass)) {
                //mensaje = "VALIDO";
                session.setAttribute("USUARIO", usuario);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/Menu");
        dispatcher.forward(request, response);			

        } else {
                //mensaje = "NO VALIDO";
                session.removeAttribute("USUARIO");
                doGet(request, response);
        }
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
