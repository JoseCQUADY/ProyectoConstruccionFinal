package Controller;

import Model.Account;
import Model.Bank;
import Model.CheckingAccount;
import Model.Client;
import Model.SavingAccount;
import View.ViewDeposit;
import View.ViewMenu;
import Service.Validation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase controlador para la vista Deposit
 * Controla la vista implementando la clase ActionListener
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
*/
public class ControllerDeposit implements ActionListener {
    private Bank nationalBank;
    private Client clientUser;
    private ViewDeposit viewDeposit = new ViewDeposit();

    /**
     * Constructor de la clase 
     * Inicializa los botones y campos de texto de la vista 
     * Para poder usarlos y llamarlos desde el controlador
     *
     * @param nationalBank
     * @param clientUser
     * @param viewDeposit
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public ControllerDeposit(Bank nationalBank, Client clientUser, ViewDeposit viewDeposit) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.nationalBank = nationalBank;
        this.clientUser = clientUser;
        this.viewDeposit = viewDeposit;
        this.viewDeposit.ButtonReturn.addActionListener(this);
        this.viewDeposit.ButtonDeposit.addActionListener(this);
        this.viewDeposit.ComboBoxAccount.addActionListener(this);
        this.viewDeposit.textFieldBalance.addActionListener(this);
        loadClientAccountsComboBox();
    }

    /**
     * Método para cargar y mostrar las cuentas de un cliente especifico en la ComboBox de la vista
     * 
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    private void loadClientAccountsComboBox() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.viewDeposit.ComboBoxAccount.removeAllItems();
        ArrayList<Account> clientListAccounts = clientUser.getAccounts();

        for (Account account: clientListAccounts) {
            if (account.getIdClient().equals(this.clientUser.getClientCurp())) {
                if (account instanceof CheckingAccount) {
                    this.viewDeposit.ComboBoxAccount.addItem("Cuenta Cheques " + account.getIdAccount() + " Saldo: " + account.getBalanceAccount());
                } else if (account instanceof SavingAccount) {
                    this.viewDeposit.ComboBoxAccount.addItem("Cuenta Ahorro " + account.getIdAccount() + " Saldo: " + account.getBalanceAccount());                 
                }
            }
        }
    }
    
    /**
     * Método para realizar un deposito en una cuenta especifica
     * 
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void depositAccount() throws IOException, FileNotFoundException, ClassNotFoundException {
        Validation validatorData = new Validation();    
        double depositAmount = Double.parseDouble(this.viewDeposit.textFieldBalance.getText());
        if (validatorData.validateBalance(depositAmount)){
            ArrayList<Account> clientListAccounts = clientUser.getAccounts();
            String selectedAccountStr = (String) viewDeposit.ComboBoxAccount.getSelectedItem();    
            String[] accountInfo = selectedAccountStr.split(" ");
            int accountId = Integer.parseInt(accountInfo[2]);
            Account selectedAccount = null;

            for (Account account : clientListAccounts) {
                if (account.getIdAccount() == accountId) {
                    selectedAccount = account;
                    break;
                }
            }


            if (selectedAccount != null) {
                selectedAccount.accountDeposit(depositAmount);           
                clientUser.modifyAccount(selectedAccount);
                JOptionPane.showMessageDialog(null, "Deposito realizado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
            }
            
        }
        

        loadClientAccountsComboBox();
    }

    /**
     * Método para abrir la vista Menu 
     * Cierra la vista Deposit
     */
    private void openViewMenu() {
        ViewMenu viewMenu = new ViewMenu();
        ControllerMenu menuController = new ControllerMenu(nationalBank, clientUser, viewMenu);
        this.viewDeposit.setVisible(false);
        viewMenu.setVisible(true);
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
        if (e.getSource() == this.viewDeposit.ButtonDeposit) {
            try {
                depositAccount();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ControllerDeposit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewDeposit.ButtonReturn) {
            this.viewDeposit.setVisible(false);
            openViewMenu();
        }

    }

}