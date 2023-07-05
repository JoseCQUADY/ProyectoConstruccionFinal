package Controller;

import Model.Account;
import Model.Bank;
import Model.CheckingAccount;
import Model.Client;
import Model.SavingAccount;
import Serializable.SerializeAccounts;
import View.ViewDeposit;

import View.ViewMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerDeposit implements ActionListener {

    private ViewDeposit viewDeposit = new ViewDeposit();
    private Client clientUser;
    private Bank nationalBank;

    /**
     * Constructor de la clase ControllerDeposit Inicializa los botones y campos
     * de texto de la vista Deposit Para poder usarlos y llamarlos desde el
     * controlador
     *
     * @param viewDeposit
     */
    public ControllerDeposit(Bank nationalBank, Client clientUser, ViewDeposit viewDeposit) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.viewDeposit = viewDeposit;
        this.clientUser = clientUser;
        this.nationalBank = nationalBank;
        this.viewDeposit.ButtonReturn.addActionListener(this);
        this.viewDeposit.ButtonDeposit.addActionListener(this);
        this.viewDeposit.ComboBoxAccount.addActionListener(this);
        this.viewDeposit.textFieldBalance.addActionListener(this);
        loadClientAccounts();
    }

    /**
     * Método para abrir la vista Menu Cierra la vista Deposit
     */
    public void loadClientAccounts() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.viewDeposit.ComboBoxAccount.removeAllItems(); // Eliminar todos los elementos existentes en el combobox

        ArrayList<Account> clientListAccounts = clientUser.getAccountType();

        for (int i = 0; i < clientListAccounts.size(); i++) {
            if (clientListAccounts.get(i).getIdClient().equals(this.clientUser.getClientCurp())) {
                if (clientListAccounts.get(i) instanceof CheckingAccount) {
                    this.viewDeposit.ComboBoxAccount.addItem("Checking Account " + clientListAccounts.get(i).getIdAccount() + " Balance: " + clientListAccounts.get(i).getBalanceAccount());
                } else if (clientListAccounts.get(i) instanceof SavingAccount) {
                    this.viewDeposit.ComboBoxAccount.addItem("Saving Account " + clientListAccounts.get(i).getIdAccount() + " Balance: " + clientListAccounts.get(i).getBalanceAccount());
                }
            }
        }
    }

    public void depositAccount() throws IOException, FileNotFoundException, ClassNotFoundException {
        String selectedAccountStr = (String) viewDeposit.ComboBoxAccount.getSelectedItem();
        String[] accountInfo = selectedAccountStr.split(" ");
        int accountId = Integer.parseInt(accountInfo[2]); // Obtener el ID de la cuenta seleccionada

        double depositAmount = Double.parseDouble(this.viewDeposit.textFieldBalance.getText()); // Obtener el monto del depósito

        ArrayList<Account> clientListAccounts = clientUser.getAccountType();

        Account selectedAccount = null;

        for (Account account : clientListAccounts) {
            if (account.getIdAccount() == accountId) {
                selectedAccount = account;
                break;
            }
        }

        if (selectedAccount != null) {
            selectedAccount.accountDeposit(depositAmount);
            SerializeAccounts.modifyAccounts(selectedAccount);
            JOptionPane.showMessageDialog(null, "Deposit successful");
        } else {
            JOptionPane.showMessageDialog(null, "Account not found");
        }

        loadClientAccounts();
    }

    public void openViewMenu() {
        ViewMenu viewMenu = new ViewMenu();
        ControllerMenu menuController = new ControllerMenu(nationalBank, clientUser, viewMenu);
        viewMenu.setVisible(true);
        this.viewDeposit.setVisible(false);
    }

    /**
     * Método de la clase implementada ActionListener que detecta y maneja
     * eventos (clic en botones) Utilizado para el funcionamiento y uso de los
     * botones de la vista Menu Mediante condicionales
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.viewDeposit.ButtonDeposit) {
            try {
                depositAccount();
            } catch (IOException ex) {
                Logger.getLogger(ControllerDeposit.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControllerDeposit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewDeposit.ButtonReturn) {
            this.viewDeposit.setVisible(false);
            openViewMenu();
        }

    }

}
