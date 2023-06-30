/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankuady;

import Controller.LoginViewController;
import View.ViewLogin;

public class BankUADY {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {  
        ViewLogin loginView = new ViewLogin();
        LoginViewController controller = new LoginViewController(loginView);
        loginView.show();
    }
}

