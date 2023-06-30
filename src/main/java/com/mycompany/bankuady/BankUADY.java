package com.mycompany.bankuady;

import Controller.LoginViewController;
import View.ViewLogin;

/*
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
     */
    public static void main(String[] args) {  
        ViewLogin loginView = new ViewLogin();
        LoginViewController viewController = new LoginViewController(loginView);
        loginView.show();
    }
}

