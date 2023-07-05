package Controller;

import Model.Account;
import Model.Bank;
import Model.CheckingAccount;
import Model.Client;
import Model.SavingAccount;
import Service.ButtonDeleteColumn;
import Serializable.DeserializeAccounts;
import Serializable.SerializeAccounts;
import View.ViewAccounts;
import View.ViewAddAccount;
import View.ViewMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerAccounts implements ActionListener {

    private ViewAccounts viewAccounts;
    private Bank nationalBank;
    private Client clientUser;
    private ArrayList<Account> userAccounts;

    public ControllerAccounts(Client clientUser, Bank nationalBank, ViewAccounts viewAccounts) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.viewAccounts = viewAccounts;
        this.nationalBank = nationalBank;
        this.clientUser = clientUser;
        this.viewAccounts.ButtonReturn.addActionListener(this);
        this.viewAccounts.ButtonAddAccount.addActionListener(this);
        // Crear el modelo de la tabla
        loadUserAccounts(); // Cargar las cuentas del usuario por primera vez
    }

    public void loadUserAccounts() throws IOException, FileNotFoundException, ClassNotFoundException {
        userAccounts = DeserializeAccounts.deserializeAccounts();
        fillDataTable();
    }

    public void fillDataTable() {
        // Limpiar la tabla antes de llenarla con nuevos datos
        DefaultTableModel model = (DefaultTableModel) this.viewAccounts.jTable1.getModel();
        model.setRowCount(0);
        for (Account account : userAccounts) {

            Object[] rowData = new Object[2];
            if (account instanceof CheckingAccount) {
                rowData[0] = "Checking Account";
            } else if (account instanceof SavingAccount) {
                rowData[0] = "Saving Account";
            }
            rowData[1] = account.getBalanceAccount();
            fillDeleteButton(account);
            model.addRow(rowData);
        }
    }

    public void fillDeleteButton(Account userAccount) {

        // Configurar el botón de eliminar
        DefaultTableModel model = (DefaultTableModel) this.viewAccounts.jTable1.getModel();
        ButtonDeleteColumn buttonColumn = new ButtonDeleteColumn(viewAccounts.jTable1, 2);
        buttonColumn.setButtonText("Eliminar");
        buttonColumn.addButtonClickListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la cuenta?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    try {
                        SerializeAccounts.removeAccount(userAccount);
                        int modelRow = Integer.valueOf(e.getActionCommand());
                        model.removeRow(modelRow);
                    } catch (IOException ex) {
                        Logger.getLogger(ControllerAccounts.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ControllerAccounts.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                }

            }
        });
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
        if (e.getSource() == this.viewAccounts.ButtonAddAccount) {
            ViewAddAccount viewAdd = new ViewAddAccount();
            ControllerAddAccount controllerAddAccount = new ControllerAddAccount(nationalBank, clientUser, viewAdd);
            this.viewAccounts.setVisible(false);
            viewAdd.setVisible(true);
        }
        if (e.getSource() == this.viewAccounts.ButtonReturn) {
            ViewMenu viewMenu = new ViewMenu();
            ControllerMenu controlllerMenu = new ControllerMenu(nationalBank, clientUser, viewMenu);
            viewMenu.show();
            this.viewAccounts.dispose();

        }

    }

}
