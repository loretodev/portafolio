/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.portafolio.repositorioDAO;

import cl.unab.portafolio.conexion.Conexion;
import cl.unab.portafolio.log.CrearLog;
import cl.unab.portafolio.modelo.CantidadExperienciasDTO;
import cl.unab.portafolio.modelo.Experiencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para la manipulación de la entidad Experiencia.
 *
 * @author Loreto Galvez
 */
public class ExperienciaDAO {

    /**
     * Inserta una experiencia en la base de datos.
     *
     * @param experiencia La experiencia a insertar.
     */
    public void insertarExperiencia(Experiencia experiencia) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            if (experiencia != null) {
                Conexion db = new Conexion();
                conn = db.conexion();

                String query = "INSERT INTO Experiencia (id_portafolio, titulo, texto, pagina) VALUES (?, ?, ?, ?)";
                ps = conn.prepareStatement(query);
                ps.setInt(1, experiencia.getIdPortafolio());
                ps.setString(2, experiencia.getTitulo());
                ps.setString(3, experiencia.getTexto());
                ps.setString(4, experiencia.getPagina());

                ps.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - insertarExperiencia: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
            }

        }
    }

    /**
     * Actualiza una experiencia en la base de datos.
     *
     *
     * @param experiencia La experiencia a actualizar.
     */
    public void actualizarExperiencia(Experiencia experiencia) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            if (experiencia != null) {
                Conexion db = new Conexion();
                conn = db.conexion();

                String query = "UPDATE Experiencia SET id_portafolio=?, titulo=?, texto=?, pagina=? WHERE id_experiencia=?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, experiencia.getIdPortafolio());
                ps.setString(2, experiencia.getTitulo());
                ps.setString(3, experiencia.getTexto());
                ps.setString(4, experiencia.getPagina());
                ps.setInt(5, experiencia.getIdExperiencia());

                ps.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - actualizarExperiencia: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
            }

        }
    }

    /**
     * Obtiene una experiencia de la base de datos por su ID.
     *
     * @param idExperiencia El ID de la experiencia.
     * @return La experiencia encontrada, o null si no se encontró ninguna.
     */
    public Experiencia obtenerExperiencia(int idExperiencia) {
        Connection conn = null;
        PreparedStatement ps = null;

        Experiencia experiencia = null;
        try {

            Conexion db = new Conexion();
            conn = db.conexion();

            String query = "SELECT id_experiencia, id_portafolio, titulo, texto, pagina FROM Experiencia WHERE id_experiencia=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idExperiencia);

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                experiencia = new Experiencia();
                experiencia.setIdExperiencia(resultSet.getInt("id_experiencia"));
                experiencia.setIdPortafolio(resultSet.getInt("id_portafolio"));
                experiencia.setTitulo(resultSet.getString("titulo"));
                experiencia.setTexto(resultSet.getString("texto"));
                experiencia.setPagina(resultSet.getString("pagina"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - obtenerExperiencia: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
            }

        }
        return experiencia;
    }

    /**
     * Elimina una experiencia de la base de datos por su ID.
     *
     * @param idExperiencia El ID de la experiencia a eliminar.
     */
    public void eliminarExperiencia(int idExperiencia) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Conexion db = new Conexion();
            conn = db.conexion();

            String query = "DELETE FROM Experiencia WHERE id_experiencia=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idExperiencia);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - eliminarExperiencia: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
            }

        }
    }

    /**
     * Obtiene una lista de experiencias asociadas a un portafolio.
     *
     * @param idPortafolio El ID del portafolio.
     * @return Una lista de experiencias asociadas al portafolio, o null si no
     * se encontró ninguna.
     */
    public List<Experiencia> obtenerExperienciasPortafolio(int idPortafolio) {
        List<Experiencia> lista = null;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Conexion db = new Conexion();
            conn = db.conexion();

            String query = "SELECT ex.* FROM experiencia ex JOIN portafolio por ON (ex.id_portafolio = por.id_portafolio) WHERE ex.id_portafolio = ? ORDER BY titulo";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idPortafolio);
            ResultSet resultSet = ps.executeQuery();

            lista = new ArrayList<Experiencia>();
            while (resultSet.next()) {
                Experiencia experiencia = new Experiencia();
                experiencia.setIdExperiencia(resultSet.getInt("id_experiencia"));
                experiencia.setIdPortafolio(resultSet.getInt("id_portafolio"));
                experiencia.setTitulo(resultSet.getString("titulo"));
                experiencia.setTexto(resultSet.getString("texto"));
                experiencia.setPagina(resultSet.getString("pagina"));

                lista.add(experiencia);
            }

        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - obtenerExperienciasPortafolio: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
            }

        }
        return lista;
    }

    /**
     * Obtiene una lista de objetos CantidadExperienciasDTO que representa la
     * cantidad de experiencias agrupadas por portafolio.
     * @return Una lista de objetos CantidadExperienciasDTO, o null si no se
     * encontró ninguna.
     */
    public List<CantidadExperienciasDTO> obtenerExperienciaAgrupada() {
        Connection conn = null;
        PreparedStatement ps = null;
        List<CantidadExperienciasDTO> result = null;

        CantidadExperienciasDTO cantidadExperienciasDTO = null;
        try {
            Conexion db = new Conexion();
            conn = db.conexion();

            String query = "SELECT id_portafolio, COUNT(*) AS cantidad_experiencias FROM experiencia GROUP BY id_portafolio";
            ps = conn.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();
            result = new ArrayList<CantidadExperienciasDTO>();

            while (resultSet.next()) {
                cantidadExperienciasDTO = new CantidadExperienciasDTO();
                cantidadExperienciasDTO.setId_portafolio(resultSet.getInt("id_portafolio"));
                cantidadExperienciasDTO.setCantidad_experiencias(resultSet.getInt("cantidad_experiencias"));
                result.add(cantidadExperienciasDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
            CrearLog.errorLog("Error select Log - obtenerExperienciaAgrupada: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
            }

        }
        return result;
    }

}
