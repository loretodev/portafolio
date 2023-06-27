/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.portafolio.repositorioDAO;

/**
 *
 * @author Loreto Galvez
 */
import cl.unab.portafolio.conexion.Conexion;
import cl.unab.portafolio.log.CrearLog;
import cl.unab.portafolio.modelo.Portafolio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PortafolioDAO {
    
    /**
     * Inserta un nuevo portafolio en la base de datos.
     * @param portafolio El objeto Portafolio a insertar.
     * @return El número de filas afectadas en la base de datos.
     */
    public int insertarPortafolio(Portafolio portafolio) {
        int result = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            if (portafolio!=null) {
                Conexion db = new Conexion();
                conn = db.conexion();

                String query = "INSERT INTO Portafolio (nombre, apellido, profesion, acerca_de_mi_01, acerca_de_mi_02, direccion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(query);
                ps.setString(1, portafolio.getNombre());
                ps.setString(2, portafolio.getApellido());
                ps.setString(3, portafolio.getProfesion());
                ps.setString(4, portafolio.getAcercaDeMi01());
                ps.setString(5, portafolio.getAcercaDeMi02());
                ps.setString(6, portafolio.getDireccion());
                ps.setString(7, portafolio.getEstado());

                ps.executeUpdate();                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - insertarPortafolio: " + e.getMessage());
            
        } finally {
            try {
                if (ps!=null) {
                    ps.close();
                }
 
                if (conn!=null) {
                    conn.close();
                } 
                
            } catch (Exception e) { }

        }
        
        return result;
    }

    /**
     * Actualiza un portafolio existente en la base de datos.
     * @param portafolio El objeto Portafolio con los datos actualizados.
     * @return El número de filas afectadas en la base de datos.
     */
    public int actualizarPortafolio(Portafolio portafolio) {
        int result = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            if (portafolio!=null) {
                Conexion db = new Conexion();
                conn = db.conexion();

                String query = "UPDATE Portafolio SET nombre=?, apellido=?, profesion=?, acerca_de_mi_01=?, acerca_de_mi_02=?, direccion=?, estado=? WHERE id_portafolio=?";
                ps = conn.prepareStatement(query);
                ps.setString(1, portafolio.getNombre());
                ps.setString(2, portafolio.getApellido());
                ps.setString(3, portafolio.getProfesion());
                ps.setString(4, portafolio.getAcercaDeMi01());
                ps.setString(5, portafolio.getAcercaDeMi02());
                ps.setString(6, portafolio.getDireccion());
                ps.setString(7, portafolio.getEstado());
                ps.setInt(8, portafolio.getId());

                ps.executeUpdate();
                result = 1;                
            }
            
        } catch (Exception e) {
            e.printStackTrace();            
            CrearLog.errorLog("Error select Log - actualizarPortafolio: " + e.getMessage());
            
        } finally {
            try {
                if (ps!=null) {
                    ps.close();
                }
 
                if (conn!=null) {
                    conn.close();
                } 
                
            } catch (Exception e) { }

        }
        return result;
    }

    /**
     * Obtiene un portafolio de la base de datos por su ID.
     * @param idPortafolio El ID del portafolio a obtener.
     * @return El objeto Portafolio correspondiente al ID, o null si no se encontró.
     */
    public Portafolio obtenerPortafolio(int idPortafolio) {
        Connection conn = null;
        PreparedStatement ps = null;
        Portafolio portafolio = null;
        
        try {
            Conexion db = new Conexion();
            conn = db.conexion();
            
            String query = "SELECT id_portafolio, nombre, apellido, profesion, acerca_de_mi_01, acerca_de_mi_02, direccion, estado FROM Portafolio WHERE id_portafolio=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idPortafolio);

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                portafolio = new Portafolio();
                portafolio.setId(resultSet.getInt("id_portafolio"));
                portafolio.setNombre(resultSet.getString("nombre"));
                portafolio.setApellido(resultSet.getString("apellido"));
                portafolio.setProfesion(resultSet.getString("profesion"));
                portafolio.setAcercaDeMi01(resultSet.getString("acerca_de_mi_01"));
                portafolio.setAcercaDeMi02(resultSet.getString("acerca_de_mi_02"));
                portafolio.setDireccion(resultSet.getString("direccion"));
                portafolio.setEstado(resultSet.getString("estado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - obtenerPortafolio: " + e.getMessage());
            
        } finally {
            try {
                if (ps!=null) {
                    ps.close();
                }
 
                if (conn!=null) {
                    conn.close();
                } 
                
            } catch (Exception e) { }

        }
        return portafolio;
    }
    
    /**
     * Obtiene todos los portafolios de la base de datos.
     * @return Una lista de objetos Portafolio.
     */
    public List<Portafolio> obtenerPortafolioTodos() {
        List<Portafolio> lista = new ArrayList<Portafolio>();
        
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Conexion db = new Conexion();
            conn = db.conexion();
            
            String query = "SELECT por.id_portafolio, por.nombre, por.apellido, " 
                    + "por.profesion, por.acerca_de_mi_01, por.acerca_de_mi_02, por.direccion, por.estado, est.nombreEstado  " 
                    + "FROM Portafolio por JOIN Estado est ON (por.estado = est.codigo) " 
                    + "ORDER BY nombre, apellido";
            ps = conn.prepareStatement(query);
            

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Portafolio portafolio = new Portafolio();
                portafolio.setId(resultSet.getInt("id_portafolio"));
                portafolio.setNombre(resultSet.getString("nombre"));
                portafolio.setApellido(resultSet.getString("apellido"));
                portafolio.setProfesion(resultSet.getString("profesion"));
                portafolio.setAcercaDeMi01(resultSet.getString("acerca_de_mi_01"));
                portafolio.setAcercaDeMi02(resultSet.getString("acerca_de_mi_02"));
                portafolio.setDireccion(resultSet.getString("direccion"));
                portafolio.setEstado(resultSet.getString("estado"));
                portafolio.setNombreEstado(resultSet.getString("nombreEstado"));
                
                lista.add(portafolio);
            }
        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - obtenerPortafolioTodos: " + e.getMessage());
            
        } finally {
            try {
                if (ps!=null) {
                    ps.close();
                }
 
                if (conn!=null) {
                    conn.close();
                } 
                
            } catch (Exception e) { }

        }
        return lista;
    }

    /**
     * Elimina un portafolio de la base de datos por su ID.
     * @param idPortafolio El ID del portafolio a eliminar.
     */
    public void eliminarPortafolio(int idPortafolio) {
        int result = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Conexion db = new Conexion();
            conn = db.conexion();
            
            String query = "DELETE FROM Portafolio WHERE id_portafolio=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idPortafolio);

            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - eliminarPortafolio: " + e.getMessage());
            
        } finally {
            try {
                if (ps!=null) {
                    ps.close();
                }
 
                if (conn!=null) {
                    conn.close();
                } 
                
            } catch (Exception e) { }

        }

    }
    
    /**
     * Obtiene el portafolio activo de la base de datos.
     * @return El objeto Portafolio activo, o null si no se encontró.
     */
    public Portafolio obtenerPortafolioActivo() {
        Connection conn = null;
        PreparedStatement ps = null;
        Portafolio portafolio = null;
        
        try {
            Conexion db = new Conexion();
            conn = db.conexion();
            
            String query = "SELECT id_portafolio, nombre, apellido, profesion, acerca_de_mi_01, acerca_de_mi_02, direccion, estado FROM Portafolio WHERE estado = 'A'";
            ps = conn.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                portafolio = new Portafolio();
                portafolio.setId(resultSet.getInt("id_portafolio"));
                portafolio.setNombre(resultSet.getString("nombre"));
                portafolio.setApellido(resultSet.getString("apellido"));
                portafolio.setProfesion(resultSet.getString("profesion"));
                portafolio.setAcercaDeMi01(resultSet.getString("acerca_de_mi_01"));
                portafolio.setAcercaDeMi02(resultSet.getString("acerca_de_mi_02"));
                portafolio.setDireccion(resultSet.getString("direccion"));
                portafolio.setEstado(resultSet.getString("estado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - obtenerPortafolioActivo: " + e.getMessage());
            
        } finally {
            try {
                if (ps!=null) {
                    ps.close();
                }
 
                if (conn!=null) {
                    conn.close();
                } 
                
            } catch (Exception e) { }

        }
        return portafolio;
    }    
    

}

