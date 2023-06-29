/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Model.Client;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class ClientsDAOTest {
    
    public ClientsDAOTest() {
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
     * Test of addClient method, of class ClientsDAO.
     */
    @Test
    public void testAddClient() throws Exception {
        System.out.println("addClient");
        Client client = null;
        ClientsDAO instance = new ClientsDAO();
        instance.addClient(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existsClient method, of class ClientsDAO.
     */
    @Test
    public void testExistsClient() throws Exception {
        System.out.println("existsClient");
        String clientUserName = "";
        String clientPassword = "";
        ClientsDAO instance = new ClientsDAO();
        boolean expResult = false;
        boolean result = instance.existsClient(clientUserName, clientPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
