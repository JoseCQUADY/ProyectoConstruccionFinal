package Service;

import javax.swing.JOptionPane;

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
    public boolean validateBalance(String balance){
        if (balance.matches("[0-9]+")){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Solo ingrese números");
        }
        return false;   
    }
    
    /**
     * Método para validar que el nombre del cliente ingresada solo tiene letras
     * Devuelve un true si se cumple la condición, de lo contrario devuelve false
     * 
     * @param name
     * @return boolean
     */
    public boolean validateName(String name){
        boolean validator = true;
        for (char caracter : name.toCharArray()) {
            if (Character.isDigit(caracter)) {
                validator = false;
            }
        }
        if(!validator){
            JOptionPane.showMessageDialog(null, "Solo ingrese letras");
        }
        return validator;

    }
    
    /**
     * Método para validar que el saldo es igual a cero
     * Devuelve un false si se cumple la condición, de lo contrario devuelve true
     * 
     * @param balance
     * @return boolean
     */
    public boolean isBalanceEqualsZero(Double balance){      
        int expectedAmount = 0;
        
        if (balance != expectedAmount) {
            JOptionPane.showMessageDialog(null, "Para eliminar la cuenta el saldo debe ser de $" + expectedAmount);
            return false;
        }      
        return true;
    }
}
