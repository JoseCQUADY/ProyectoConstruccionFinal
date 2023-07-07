package Controller;

import Model.Account;
import Model.Bank;
import Model.Client;
import Model.CheckingAccount;
import Model.SavingAccount;
import Service.ButtonDeleteColumn;
import Service.Validation;
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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableCell;

/**
 * Clase controlador para la vista Accounts
 * Controla la vista implementando la clase ActionListener
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
*/
public class ControllerAccounts implements ActionListener {
    private Bank nationalBank;
    private Client clientUser;
    private ViewAccounts viewAccounts;
    private ArrayList<Account> userAccounts;

    /**
     * Constructor de la clase
     * Inicializa los atributos privados usando los parametros que recibe
     * 
     * @param clientUser
     * @param nationalBank
     * @param viewAccounts
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public ControllerAccounts(Client clientUser, Bank nationalBank, ViewAccounts viewAccounts) throws IOException, FileNotFoundException, ClassNotFoundException {      
        this.nationalBank = nationalBank;
        this.clientUser = clientUser;
        this.viewAccounts = viewAccounts;
        this.viewAccounts.ButtonReturn.addActionListener(this);
        this.viewAccounts.ButtonAddAccount.addActionListener(this);
        fillDataTable();
    }

    /**
     * Método para mostrar las cuentas de un cliente especifico
     * 
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    private void fillDataTable() throws IOException, FileNotFoundException, ClassNotFoundException {
        userAccounts = clientUser.getAccounts();
        DefaultTableModel model = (DefaultTableModel) this.viewAccounts.jTable1.getModel();
        model.setRowCount(0);
        for (Account account : userAccounts) {
            Object[] rowData = new Object[4];
            rowData[0]=account.getIdAccount();
            if (account instanceof CheckingAccount) {
                rowData[1] = "Cuenta Cheques";
            } else if (account instanceof SavingAccount) {
                rowData[1] = "Cuenta Ahorro";
            } else{
                rowData[1] = "Error";
            }
            rowData[2] = account.getBalanceAccount();
            rowData[3] = "X";
            fillDeleteButton();
            model.addRow(rowData);
        }
    }

    /**
     * Método para llamar al botón creado (botón eliminar) 
     * Para mostrarlo en la tercer columna de la tabla
     */
    private void fillDeleteButton() {
        DefaultTableModel model = (DefaultTableModel) this.viewAccounts.jTable1.getModel();
        ButtonDeleteColumn buttonColumn = new ButtonDeleteColumn(viewAccounts.jTable1, 3);
        buttonColumn.setButtonText("X");
        buttonColumn.setButtonClickListener(new ActionListener() {
            Validation validatorData = new Validation();
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int modelRow = Integer.valueOf(e.getActionCommand());
                int cont=0;
                for (Account userAccount : userAccounts) {
                    if(cont==modelRow){
                        if (validatorData.isBalanceEqualsZero(userAccount.getBalanceAccount())){
                            int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la cuenta?", "Confirmación", JOptionPane.YES_NO_OPTION);

                            if (result == JOptionPane.YES_OPTION) {
                                try {
                                    clientUser.removeAccount(userAccount);
                                    fillDataTable();
                                } catch (IOException | ClassNotFoundException ex) {
                                    Logger.getLogger(ControllerAccounts.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                    cont++;
                }
            }
        });
    }
    
    /**
     * Método para abrir la vista Menu 
     * Cierra la vista Accountss
     */
    private void openViewMenu() {
        ViewMenu viewMenu = new ViewMenu();
        ControllerMenu menuController = new ControllerMenu(nationalBank, clientUser, viewMenu);
        this.viewAccounts.setVisible(false);
        viewMenu.setLocationRelativeTo(null);
        viewMenu.setVisible(true);
    }
    
    /**
     * Método para abrir la vista AddAccount 
     * Cierra la vista Accounts
     */
    private void openViewAddAccount() {
        ViewAddAccount viewAdd = new ViewAddAccount();
        ControllerAddAccount controllerAddAccount = new ControllerAddAccount(nationalBank, clientUser, viewAdd);
        this.viewAccounts.setVisible(false);
        viewAdd.setLocationRelativeTo(null);
        viewAdd.setVisible(true);
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
        if (e.getSource() == this.viewAccounts.ButtonAddAccount) {
            openViewAddAccount();
        }
        if (e.getSource() == this.viewAccounts.ButtonReturn) {
            openViewMenu();
        }
    }
}
