/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Service.Validation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ianag
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
        Validation validation = new Validation();
        
        // Prueba cuando el CURP tiene la longitud esperada
        String curpValido = "ABCD123456EFGHJKL9";
        assertTrue(validation.validateCurp(curpValido));
        System.out.println("test CURP");
    }
}
