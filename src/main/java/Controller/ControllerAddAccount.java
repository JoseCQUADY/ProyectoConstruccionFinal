package Controller;

import Model.Bank;
import Model.CheckingAccount;
import Model.Client;
import Model.SavingAccount;
import View.ViewAccounts;
import View.ViewAddAccount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerAddAccount implements ActionListener {

    private ViewAddAccount viewAddAccount = new ViewAddAccount();
    private Client clientUser;
    private Bank nationalBank;
    private LocalDate lastInterestAppliedDate;
    private final int INTERESTRATE = 2;

    /**
     * Constructor de la clase ControllerAddAccount Inicializa los botones y
     * campos de texto de la vista AddAccounts Para poder usarlos y llamarlos
     * desde el controlador
     *
     * @param viewAddAccount
     */
    public ControllerAddAccount(Bank nationalBank,Client clientUser,ViewAddAccount viewAddAccount) {
        this.viewAddAccount = viewAddAccount;
        this.clientUser = clientUser;
        this.nationalBank = nationalBank;
        this.lastInterestAppliedDate = LocalDate.now();
        this.viewAddAccount.ButtonReturn.addActionListener(this);
        this.viewAddAccount.ButtonAddAccount.addActionListener(this);
        this.viewAddAccount.ComboBoxAccountType.addActionListener(this);
        this.viewAddAccount.textFieldBalance.addActionListener(this);
    }

    /**
     * Método para abrir la vista Menu Cierra la vista AddAccount
     * @throws java.io.IOException
     */

    public void addAccount() throws IOException {
        String accountInitialBalance =  this.viewAddAccount.textFieldBalance.getText();
        
        if (this.viewAddAccount.ComboBoxAccountType.getSelectedIndex() == 0) {
            SavingAccount savingAccount = new SavingAccount(INTERESTRATE,lastInterestAppliedDate,Double.parseDouble(accountInitialBalance),clientUser.getClientCurp());
            clientUser.setAccountType(savingAccount);
        }else{
            CheckingAccount checkingAccount = new CheckingAccount(Double.parseDouble(accountInitialBalance),clientUser.getClientCurp()); 
            clientUser.setAccountType(checkingAccount);
        }
        
    }

    public void openViewAccounts() throws IOException, FileNotFoundException, ClassNotFoundException {
        ViewAccounts viewAccounts = new ViewAccounts();
        ControllerAccounts accountsController = new ControllerAccounts(clientUser,nationalBank,viewAccounts);
        viewAccounts.show();
        this.viewAddAccount.dispose();
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
                JOptionPane.showMessageDialog(null, "Cuenta agregada con éxito");
            } catch (IOException ex) {
                Logger.getLogger(ControllerAddAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewAddAccount.ButtonReturn) {
            
 
            try {
                openViewAccounts();
            } catch (IOException ex) {
                Logger.getLogger(ControllerAddAccount.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControllerAddAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }

    }

}
