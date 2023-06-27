/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankuady;

import Service.Algorithm;
import Service.Validation;
import Controller.Controller;
import DAO.AccountDAOImpl;
import DAO.ClientDAOImpl;
import DAO.AccountDAO;
import DAO.ClientDAO;
import View.ViewMenu;

public class BankUADY {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        ClientDAO clientDAO = new ClientDAOImpl();
        AccountDAO accountDAO = new AccountDAOImpl();
        Validation validator = new Validation();
        Controller controller = new Controller(clientDAO, accountDAO, validator, algorithm);
        ViewMenu viewMenu = new ViewMenu(controller);
        viewMenu.openWindow(viewMenu);
        //Interface view = new Interface(controller);
        //view.menu();   
    }
}

