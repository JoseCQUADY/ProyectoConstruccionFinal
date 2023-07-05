package Controller;

import Model.Bank;
import Model.Client;
import View.ViewAccounts;
import View.ViewDeposit;
import View.ViewMenu;
import View.ViewWithdrawal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerMenu implements ActionListener {

    private ViewMenu viewMenu = new ViewMenu();
    private Bank nationalBank;
    private Client clientUser;
 
  
    public ControllerMenu(Bank nationalBank, Client clientUser, ViewMenu viewMenu) {
        this.viewMenu = viewMenu;
        this.clientUser = clientUser;
        this.nationalBank = nationalBank;
        this.viewMenu.ButtonClose.addActionListener(this);
        this.viewMenu.ButtonAccounts.addActionListener(this);
        this.viewMenu.ButtonDeposit.addActionListener(this);
        this.viewMenu.ButtonWithdrawal.addActionListener(this);
    }

    

    /**
     * Método para abrir la vista Cuentas
     * Cierra la vista Menu
     */
    public void openViewAccounts() throws IOException, FileNotFoundException, ClassNotFoundException {
        ViewAccounts viewAccounts = new ViewAccounts();
        ControllerAccounts accountsController = new ControllerAccounts(clientUser,nationalBank,viewAccounts);
        viewAccounts.show();
        this.viewMenu.dispose();
    }
    
    /**
     * Método para abrir la vista Deposito 
     * Cierra la vista Menu
     */
    public void openViewDeposit() throws IOException, FileNotFoundException, ClassNotFoundException {
        ViewDeposit viewDeposit = new ViewDeposit();
        ControllerDeposit depositController = new ControllerDeposit(nationalBank,clientUser,viewDeposit);
        viewDeposit.setVisible(true);
        this.viewMenu.setVisible(false);
    }
    
    /**
     * Método para abrir la vista Retiro 
     * Cierra la vista Menu
     */
    public void openViewWithdrawal() {
        ViewWithdrawal viewWithdrawal = new ViewWithdrawal();
        ControllerWithdrawal withdrawalController = new ControllerWithdrawal(nationalBank,clientUser,viewWithdrawal);
        viewWithdrawal.setVisible(true);
        this.viewMenu.setVisible(false);
    }
    
    /**
     * Método de la clase implementada ActionListener que detecta y maneja eventos (clic en botones)
     * Utilizado para el funcionamiento y uso de los botones de la vista Sign Up 
     * Mediante condicionales
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.viewMenu.ButtonAccounts) {
            try {
                openViewAccounts();
            } catch (IOException ex) {
                Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewMenu.ButtonDeposit) {
          try {
              openViewDeposit();
          } catch (IOException ex) {
              Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        if (e.getSource() == this.viewMenu.ButtonWithdrawal) {
            openViewWithdrawal();
        }
        if (e.getSource() == this.viewMenu.ButtonClose) {
            this.viewMenu.setVisible(false);
            System.exit(0);
        }
        
        

    }
    
}
