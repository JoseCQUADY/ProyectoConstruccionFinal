package com.mycompany.bankuady;

import Controller.ControllerLogin;
import View.ViewLogin;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Clase App del programa es donde se encuentra el main
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
 */
public class BankUADY {

    /**
     * Método main del proyecto
     * Inicia y ejecuta el proyecto
     * Llama a la vista Login 
     * Instacia el controllador de la vista Login
     * 
     * @param args
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {  
        ViewLogin viewLogin = new ViewLogin();
        ControllerLogin loginController = new ControllerLogin(viewLogin);
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setVisible(true);
    }
}