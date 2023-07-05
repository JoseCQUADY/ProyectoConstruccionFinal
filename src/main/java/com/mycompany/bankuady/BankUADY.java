package com.mycompany.bankuady;

import Controller.ControllerLogin;
import Controller.ControllerMenu;
import View.ViewLogin;
import View.ViewMenu;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {  
        
        ViewLogin loginView = new ViewLogin();
        ControllerLogin loginController = new ControllerLogin(loginView);
        loginView.show();
        
        /*ViewMenu viewMenu = new ViewMenu();
        ControllerMenu menuController = new ControllerMenu(viewMenu);
        viewMenu.show();*/
    }
}

