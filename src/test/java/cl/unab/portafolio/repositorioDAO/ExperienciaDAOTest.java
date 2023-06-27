/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cl.unab.portafolio.repositorioDAO;

import cl.unab.portafolio.modelo.Experiencia;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco Alvarez
 */
public class ExperienciaDAOTest {
    
    public ExperienciaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertarExperiencia method, of class ExperienciaDAO.
     */
    @Test
    public void testInsertarExperiencia() {
        System.out.println("insertarExperiencia");
        Experiencia experiencia = null;
        ExperienciaDAO instance = new ExperienciaDAO();
        instance.insertarExperiencia(experiencia);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarExperiencia method, of class ExperienciaDAO.
     */
    @Test
    public void testActualizarExperiencia() {
        System.out.println("actualizarExperiencia");
        Experiencia experiencia = null;
        ExperienciaDAO instance = new ExperienciaDAO();
        instance.actualizarExperiencia(experiencia);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerExperiencia method, of class ExperienciaDAO.
     */
    @Test
    public void testObtenerExperiencia() {
        System.out.println("obtenerExperiencia");
        int idExperiencia = 0;
        ExperienciaDAO instance = new ExperienciaDAO();
        Experiencia expResult = null;
        Experiencia result = instance.obtenerExperiencia(idExperiencia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarExperiencia method, of class ExperienciaDAO.
     */
    @Test
    public void testEliminarExperiencia() {
        System.out.println("eliminarExperiencia");
        int idExperiencia = 0;
        ExperienciaDAO instance = new ExperienciaDAO();
        instance.eliminarExperiencia(idExperiencia);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
