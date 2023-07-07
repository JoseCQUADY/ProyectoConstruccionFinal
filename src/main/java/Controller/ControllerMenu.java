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

/**
 * Clase controlador para la vista Menu
 * Controla la vista implementando la clase ActionListener
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
*/
public class ControllerMenu implements ActionListener {   
    private Bank nationalBank;
    private Client clientUser;
    private ViewMenu viewMenu = new ViewMenu();
 
    /**
     * Constructor de la clase
     * Inicializa los botones y campos de texto de la vista 
     * Para poder usarlos y llamarlos desde el controlador
     * 
     * @param nationalBank
     * @param clientUser
     * @param viewMenu
     */
    public ControllerMenu(Bank nationalBank, Client clientUser, ViewMenu viewMenu) {
        this.nationalBank = nationalBank;
        this.clientUser = clientUser;
        this.viewMenu = viewMenu;
        this.viewMenu.ButtonClose.addActionListener(this);
        this.viewMenu.ButtonAccounts.addActionListener(this);
        this.viewMenu.ButtonDeposit.addActionListener(this);
        this.viewMenu.ButtonWithdrawal.addActionListener(this);
    }

    /**
     * Método para abrir la vista Cuentas
     * Cierra la vista Menu
     * 
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    private void openViewAccounts() throws IOException, FileNotFoundException, ClassNotFoundException {
        ViewAccounts viewAccounts = new ViewAccounts();
        ControllerAccounts accountsController = new ControllerAccounts(clientUser,nationalBank,viewAccounts);
        this.viewMenu.setVisible(false);
        viewAccounts.setLocationRelativeTo(null);
        viewAccounts.setVisible(true);
    }
    
    /**
     * Método para abrir la vista Deposito 
     * Cierra la vista Menu
     * 
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    private void openViewDeposit() throws IOException, FileNotFoundException, ClassNotFoundException {
        ViewDeposit viewDeposit = new ViewDeposit();
        ControllerDeposit depositController = new ControllerDeposit(nationalBank,clientUser,viewDeposit);
        this.viewMenu.setVisible(false);
        viewDeposit.setLocationRelativeTo(null);
        viewDeposit.setVisible(true);
    }
    
    /**
     * Método para abrir la vista Retiro 
     * Cierra la vista Menu
     */
    private void openViewWithdrawal() throws IOException, FileNotFoundException, ClassNotFoundException {
        ViewWithdrawal viewWithdrawal = new ViewWithdrawal();
        ControllerWithdrawal withdrawalController = new ControllerWithdrawal(nationalBank,clientUser,viewWithdrawal);
        this.viewMenu.setVisible(false);
        viewWithdrawal.setLocationRelativeTo(null);
        viewWithdrawal.setVisible(true);
    }
    
    /**
     * Método de la clase implementada ActionListener que detecta y maneja eventos (clic en botones) 
     * Utilizado para el funcionamiento y uso de los botones de la vista 
     * Mediante condicionales para comprobar el botón que se presiona
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.viewMenu.ButtonAccounts) {
            try {
                openViewAccounts();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewMenu.ButtonDeposit) {
          try {
              openViewDeposit();
          } catch (IOException | ClassNotFoundException ex) {
              Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        if (e.getSource() == this.viewMenu.ButtonWithdrawal) {
          try {
              openViewWithdrawal();
          } catch (IOException | ClassNotFoundException ex) {
              Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        if (e.getSource() == this.viewMenu.ButtonClose) {
            this.viewMenu.setVisible(false);
            System.exit(0);
        }
    }   
}
