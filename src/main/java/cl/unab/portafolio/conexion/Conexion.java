/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.portafolio.conexion;

import java.sql.*;

public class Conexion {

    private static Conexion instancia = null;
    private static String url = "jdbc:mysql://localhost:3306/clase1";
    private static String user = "root";
    private static String pass = "";
    private static Connection con = null;
    private Statement stmt = null;

    /**
     * Constructor
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Conexion() throws SQLException, ClassNotFoundException {
        System.out.println("Conectando...");
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
        stmt = con.createStatement();
        System.out.println(con);
        System.out.println("Conectado");
    }

    /**
     * Obtiene la instancia del objeto Conexion
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static Conexion obtenerInstancia() throws SQLException, ClassNotFoundException {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    /**
     * Permite retornar la conexion
     * @return 
     * @author 
     */
    public Connection getConexion()
    {
        return con;
    }

    /**
     * Cierra objeto Connection
     * @return 
     */
    public int CerrarConexion() {
        try {
            con.close();
            return 0;
        } catch (Exception exc) {
            System.out.println("Error al cerrar la conexion: " + " : " + exc);
            return -1;
        }
    }

    /**
     * Cierra statement y conn
     */
    public void close() {
        try {
            if (con != null) {
                stmt.close();
                con.close();
                con = null;
            }
        } catch (SQLException sqe) {
            System.out.println("Unexpected exception : "
                    + sqe.toString() + ", sqlstate = " + sqe.getSQLState());
            sqe.printStackTrace();
        }
    }

    //Getters
    public Connection conexion() {
        return con;
    }

    public Statement sentencia() {
        return stmt;
    }

}
