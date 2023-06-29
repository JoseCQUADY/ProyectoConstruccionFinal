/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author gaeli
 */
public class Validation {
    public boolean validateCURP(String curp){
        int expectedLength = 18;
        
        if (curp.length() != expectedLength) {
            System.out.println("El CURP debe tener " + expectedLength + " caracteres.");
            return false;
        }      
        return true;
    }
}
