package Controller;

import Model.Account;
import Model.Bank;
import Model.CheckingAccount;
import Model.Client;
import Model.SavingAccount;
import View.ViewMenu;
import View.ViewWithdrawal;
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
 * Clase controlador para la vista Withdrawal
 * Controla la vista implementando la clase ActionListener
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
*/
public class ControllerWithdrawal implements ActionListener {  
    private Bank nationalBank;
    private Client clientUser;
    private ViewWithdrawal viewWithdrawal = new ViewWithdrawal();
    

    /**
     * Constructor de la clase
     * Inicializa los botones y campos de texto de la vista 
     * Para poder usarlos y llamarlos desde el controlador
     * 
     * @param nationalBank
     * @param clientUser
     * @param viewWithdrawal
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public ControllerWithdrawal(Bank nationalBank, Client clientUser, ViewWithdrawal viewWithdrawal) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.nationalBank = nationalBank;
        this.clientUser = clientUser;
        this.viewWithdrawal = viewWithdrawal;
        this.viewWithdrawal.ButtonReturn.addActionListener(this);
        this.viewWithdrawal.ButtonWithdraw.addActionListener(this);
        this.viewWithdrawal.ComboBoxAccount.addActionListener(this);
        this.viewWithdrawal.textFieldBalance.addActionListener(this);
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
        this.viewWithdrawal.ComboBoxAccount.removeAllItems();
        ArrayList<Account> clientListAccounts = clientUser.getAccounts();

        for (Account account: clientListAccounts) {
            if (account.getIdClient().equals(this.clientUser.getClientCurp())) {
                if (account instanceof CheckingAccount) {
                    this.viewWithdrawal.ComboBoxAccount.addItem("Cuenta Cheques " + account.getIdAccount() + " Saldo: " + account.getBalanceAccount());
                } else if (account instanceof SavingAccount) {                  
                    this.viewWithdrawal.ComboBoxAccount.addItem("Cuenta Ahorro " + account.getIdAccount() + " Saldo: " + account.getBalanceAccount());
                }
            }
        }
    }

    /**
     * Método para realizar un retiro en una cuenta especifica
     * 
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void withdrawAccount() throws IOException, FileNotFoundException, ClassNotFoundException {
        try {
            Validation validatorData = new Validation();
            double withdrawAmount = Double.parseDouble(this.viewWithdrawal.textFieldBalance.getText());
            boolean validAmountWithdraw = validatorData.validateBalance(withdrawAmount) && validatorData.validatePositiveBalance(withdrawAmount) ; 
            if (validAmountWithdraw){
                ArrayList<Account> clientListAccounts = clientUser.getAccounts();
                String selectedAccountStr = (String) viewWithdrawal.ComboBoxAccount.getSelectedItem();
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
                    selectedAccount.accountWithdraw(withdrawAmount);
                    clientUser.modifyAccount(selectedAccount);
                } else {
                    JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
                }
            }

            loadClientAccountsComboBox();
        }catch(NumberFormatException | NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    /**
     * Método para abrir la vista Menu 
     * Cierra la vista Withdrawal
     */
    private void openViewMenu() {
        ViewMenu viewMenu = new ViewMenu();
        ControllerMenu menuController = new ControllerMenu(nationalBank, clientUser, viewMenu);
        this.viewWithdrawal.setVisible(false);
        viewMenu.setLocationRelativeTo(null);
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
        if (e.getSource() == this.viewWithdrawal.ButtonWithdraw) {
            try {
                withdrawAccount();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ControllerWithdrawal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewWithdrawal.ButtonReturn) {
            this.viewWithdrawal.setVisible(false);
            openViewMenu();
        }
    }
}
