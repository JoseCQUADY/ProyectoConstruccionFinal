/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bank;
import Model.Client;
import View.ViewAccountOptions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author You
 */
public class ControllerViewAccountOptions implements ActionListener{
    private ViewAccountOptions viewAccountOptions;
    private Bank nationalBank;
    private Client clientUser;
    
    public ControllerViewAccountOptions( Bank nationalBank,Client clientUser,ViewAccountOptions viewAccountOptions){
        this.viewAccountOptions = viewAccountOptions;
        this.nationalBank = nationalBank;
        this.clientUser = clientUser;
        this.viewAccountOptions.ButtonClose.addActionListener(this);
        this.viewAccountOptions.jButton1.addActionListener(this);
        this.viewAccountOptions.jButton2.addActionListener(this);
    }

    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.viewAccountOptions.jButton1){
            
        }
    }
    
}
