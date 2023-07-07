import Service.Validation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ValidationTest {
    public static Validation validation = new Validation();
    public ValidationTest() {
    }
  
    /**
     * Test of validateCurp method, of class Validation.
     * Prueba cuando el CURP tiene la longitud esperada
     */
    @Test
    public void testValidateCurp() {
        String testCurp = "ABCD123456EFGHJKL9";
        assertTrue(validation.validateCurp(testCurp));
        System.out.println("test CURP");
        
        testCurp = "ABCD123456";
        assertFalse(validation.validateCurp(testCurp));
        System.out.println("test CURP");
    }
    
    /**
     * Test of validatePass method, of class Validation.
     * Prueba cuando la contraseña tiene la longitud esperada
     */
    @Test
    public void testValidatePass() {
        String testPass = "ABCD1234";
        assertTrue(validation.validatePass(testPass));
        System.out.println("test password");
        
        testPass = "AB12";
        assertFalse(validation.validatePass(testPass));
        System.out.println("test password");
    }
    
    /**
     * Test of validateBalance method, of class Validation.
     * Prueba cuando el monto es solo númerico
     */
    @Test
    public void testValidateBalance() {
        double testBalance = 1234;
        assertTrue(validation.validateBalance(testBalance));
        System.out.println("test balance");
    }
    
    /**
     * Test of validateName method, of class Validation.
     * Prueba cuando el nombre del cliente no es númerico
     */
    @Test
    public void testValidateName() {
        String testName = "ABCD";
        assertTrue(validation.validateName(testName));
        System.out.println("test name");
        
        testName = "1234";
        assertFalse(validation.validateName(testName));
        System.out.println("test name");
        
        testName = "AB12";
        assertFalse(validation.validateName(testName));
        System.out.println("test name");
    }
    
    @Test
    public void testIsBalanceEqualsZero(){
        double testBalance = 0.0;
        assertTrue(validation.isBalanceEqualsZero(testBalance));
        System.out.println("test balance equals zero");
        
        testBalance = 1000.0;
        assertFalse(validation.isBalanceEqualsZero(testBalance));
        System.out.println("test balance equals zero");
    }
}
