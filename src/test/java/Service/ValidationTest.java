/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Service;

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
public class ValidationTest {
    public static Validation validation;
    public ValidationTest() {
    }

  
    /**
     * Test of validateCURP method, of class Validation.
     */
    @Test
    public void testValidateCURP() {
         String CurpTest = "asdfghjklqwertyuio";
         boolean expectedValue = true;
         boolean result;
         
         result = validation.validateCURP(CurpTest);
         assertEquals(expectedValue, result );
        
        
    }
    
}
