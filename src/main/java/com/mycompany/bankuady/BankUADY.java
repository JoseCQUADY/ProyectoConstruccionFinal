/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankuady;

import Controllers.LoginViewController;
import View.ViewLogin;

public class BankUADY {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {  
        ViewLogin loginView = new ViewLogin();
        loginView.setLocationRelativeTo(null);
        LoginViewController controller = new LoginViewController(loginView);
        loginView.show();
    }
}

