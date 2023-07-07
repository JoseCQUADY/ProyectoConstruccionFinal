package Service;

import javax.swing.JOptionPane;

/**
 * Clase con los métodos para hacer todas las validaciones necesarias para los datos ingresados por el usuario (cliente)
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
 */
public class Validation {

    /**
     * Método para validar que el curp ingresado tiene 18 caracteres
     * Devuelve un false si se cumple la condición, de lo contrario devuelve true
     * 
     * @param curp
     * @return boolean
     */
    public boolean validateCurp(String curp){
        int expectedLengthCurp = 18;
        
        if (curp.length() != expectedLengthCurp) {
            JOptionPane.showMessageDialog(null, "El CURP debe tener " + expectedLengthCurp + " caracteres.");
            return false;
        }      
        return true;
    }
    
    /**
     * Método para validar que el balance ingresada es positivo
     * 
     * @param balance
     * @return boolean
     */
    public boolean validatePositiveBalance(double balance){
        double expectedPositiveBalance = 0.0;
        
        if (balance < expectedPositiveBalance) {
            JOptionPane.showMessageDialog(null, "No puede ingresar números negativos");
            return false;
        }      
        return true;
    }
    
    /**
     * Método para validar que la contraseña ingresada tiene minimo 8 caracteres
     * Devuelve un false si se cumple la condición, de lo contrario devuelve true
     * 
     * @param pass
     * @return boolean
     */
    public boolean validatePass(String pass){
        int expectedLengthPass = 8;
        
        if (pass.length() < expectedLengthPass) {
            JOptionPane.showMessageDialog(null, "La contraseña de debe tener minimo " + expectedLengthPass + " caracteres.");
            return false;
        }      
        return true;
    }
    
    /**
     * Método para validar que el monto ingresado solo tiene números
     * Devuelve un true si se cumple la condición, de lo contrario devuelve false
     * 
     * @param balance
     * @return boolean
     */
    public boolean validateBalance(double balance){   
        try {
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo ingrese números. Error: " + e);
            return false;
        }   
    }
    
    /**
     * Método para validar que el nombre del cliente ingresada solo tiene letras
     * Devuelve un true si se cumple la condición, de lo contrario devuelve false
     * 
     * @param name
     * @return boolean
     */
    public boolean validateName(String name){
        boolean validName = true;
        for (char caracter : name.toCharArray()) {
            if (Character.isDigit(caracter)) {
                validName = false;
            }
        }
        if(!validName){
            JOptionPane.showMessageDialog(null, "Solo ingrese letras");
        }
        return validName;
    }
    
    /**
     * Método para validar que el saldo es igual a cero
     * Devuelve un false si se cumple la condición, de lo contrario devuelve true
     * 
     * @param balance
     * @return boolean
     */
    public boolean isBalanceEqualsZero(double balance){
        double expectedAmount = 0.0;
        
        if (balance == expectedAmount) {
            return true;     
        }      
        JOptionPane.showMessageDialog(null, "Para eliminar la cuenta el saldo debe ser de $" + expectedAmount);
        return false;
    }
}
