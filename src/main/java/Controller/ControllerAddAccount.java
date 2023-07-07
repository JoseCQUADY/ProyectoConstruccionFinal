package Controller;

import Model.Bank;
import Model.CheckingAccount;
import Model.Client;
import Model.SavingAccount;
import Service.Validation;
import View.ViewAccounts;
import View.ViewAddAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 * Clase controlador para la vista AddAccount
 * Controla la vista implementando la clase ActionListener
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
*/
public class ControllerAddAccount implements ActionListener {
    private Bank nationalBank;
    private Client clientUser;
    private ViewAddAccount viewAddAccount = new ViewAddAccount();
    private LocalDate lastInterestAppliedDate;
    private final int INTERESTRATE = 2;

    /**
     * Constructor de la clase 
     * Inicializa los botones y campos de texto de la vista 
     * Para poder usarlos y llamarlos desde el controlador
     *
     * @param nationalBank
     * @param clientUser
     * @param viewAddAccount
     */
    public ControllerAddAccount(Bank nationalBank,Client clientUser,ViewAddAccount viewAddAccount) {
        this.nationalBank = nationalBank;
        this.clientUser = clientUser;
        this.viewAddAccount = viewAddAccount;
        this.lastInterestAppliedDate = LocalDate.now();
        this.viewAddAccount.ButtonReturn.addActionListener(this);
        this.viewAddAccount.ButtonAddAccount.addActionListener(this);
        this.viewAddAccount.ComboBoxAccountType1.addActionListener(this);
        this.viewAddAccount.textFieldBalance1.addActionListener(this);
    }

    /**
     * Método para crear y agregar una nueva cuenta a la base de datos
     * 
     * @throws java.io.IOException
     */
    private void addAccount() throws IOException {
        Validation validatorData = new Validation();
        double accountInitialBalance =  Double.parseDouble(this.viewAddAccount.textFieldBalance1.getText());
        boolean validAmountData = validatorData.validateBalance(accountInitialBalance) && validatorData.validatePositiveBalance(accountInitialBalance);
        if (validAmountData){
            if (this.viewAddAccount.ComboBoxAccountType1.getSelectedIndex() == 0) {
            SavingAccount savingAccount = new SavingAccount(INTERESTRATE,lastInterestAppliedDate,accountInitialBalance,clientUser.getClientCurp());
            clientUser.setAccount(savingAccount);
            }else{
                CheckingAccount creditAccount = new CheckingAccount(accountInitialBalance,clientUser.getClientCurp()); 
                clientUser.setAccount(creditAccount);
            } 
            JOptionPane.showMessageDialog(null, "Cuenta agregada con éxito");
        }
    }

    /**
     * Método para abrir la vista Accounts
     * Cierra la vista AddAccount
     * 
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void openViewAccounts() throws IOException, FileNotFoundException, ClassNotFoundException {
        ViewAccounts viewAccounts = new ViewAccounts();
        ControllerAccounts accountsController = new ControllerAccounts(clientUser,nationalBank,viewAccounts);
        this.viewAddAccount.setVisible(false);
        viewAccounts.setLocationRelativeTo(null);
        viewAccounts.setVisible(true);
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
        if (e.getSource() == this.viewAddAccount.ButtonAddAccount) {
            try {
                addAccount();
            } catch (IOException ex) {
                Logger.getLogger(ControllerAddAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewAddAccount.ButtonReturn) {
            try {
                openViewAccounts();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ControllerAddAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
