/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cl.unab.portafolio.repositorioDAO;

import cl.unab.portafolio.modelo.Portafolio;
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
public class PortafolioDAOTest {
    
    public PortafolioDAOTest() {
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
     * Test of insertarPortafolio method, of class PortafolioDAO.
     */
    @Test
    public void testInsertarPortafolio() {
        System.out.println("insertarPortafolio");
        Portafolio portafolio = null;
        PortafolioDAO instance = new PortafolioDAO();
        int expResult = 0;
        int result = instance.insertarPortafolio(portafolio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarPortafolio method, of class PortafolioDAO.
     */
    @Test
    public void testActualizarPortafolio() {
        System.out.println("actualizarPortafolio");
        Portafolio portafolio = null;
        PortafolioDAO instance = new PortafolioDAO();
        int expResult = 0;
        int result = instance.actualizarPortafolio(portafolio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPortafolio method, of class PortafolioDAO.
     */
    @Test
    public void testObtenerPortafolio() {
        System.out.println("obtenerPortafolio");
        int idPortafolio = 0;
        PortafolioDAO instance = new PortafolioDAO();
        Portafolio expResult = null;
        Portafolio result = instance.obtenerPortafolio(idPortafolio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarPortafolio method, of class PortafolioDAO.
     */
    @Test
    public void testEliminarPortafolio() {
        System.out.println("eliminarPortafolio");
        int idPortafolio = 0;
        PortafolioDAO instance = new PortafolioDAO();
        instance.eliminarPortafolio(idPortafolio);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
