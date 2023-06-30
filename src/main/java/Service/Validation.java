package Service;

import javax.swing.JOptionPane;

public class Validation {

    /**
     * Método para validar el curp ingresado tiene 18 digitos
     * Devuelve un true o false dependiendo si se cumple la condición
     * 
     * @param curp
     * @return boolean
     */
    public boolean validateCurp(String curp){
        int expectedLength = 18;
        
        if (curp.length() != expectedLength) {
            JOptionPane.showMessageDialog(null, "El CURP debe tener " + expectedLength + " caracteres.");
            return false;
        }      
        return true;
    }
}
