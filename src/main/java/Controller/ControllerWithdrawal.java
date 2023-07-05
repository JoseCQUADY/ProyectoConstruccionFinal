package Controller;

import Model.Bank;
import Model.Client;
import View.ViewMenu;
import View.ViewWithdrawal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerWithdrawal implements ActionListener {

    private ViewWithdrawal viewWithdrawal = new ViewWithdrawal();
    private Client clientUser;
    private Bank nationalBank;
    /**
     * Constructor de la clase ControllerWithdrawal
     * Inicializa los botones y campos de texto de la vista Withdrawal
     * Para poder usarlos y llamarlos desde el controlador
     * 
     * @param viewWithdrawal
     */
    public ControllerWithdrawal(Bank nationalBank,Client clientUser,ViewWithdrawal viewWithdrawal) {
        this.viewWithdrawal = viewWithdrawal;
        this.clientUser = clientUser;
        this.nationalBank = nationalBank;
        this.viewWithdrawal.ButtonReturn.addActionListener(this);
        this.viewWithdrawal.ButtonWithdraw.addActionListener(this);
        this.viewWithdrawal.ComboBoxAccount.addActionListener(this);
        this.viewWithdrawal.textFieldBalance.addActionListener(this);
    }

    /**
     * Método para abrir la vista Menu 
     * Cierra la vista Withdrawal
     */
    public void openViewMenu() {
        ViewMenu viewMenu = new ViewMenu();
        ControllerMenu menuController = new ControllerMenu(nationalBank,clientUser,viewMenu);
        viewMenu.setVisible(true);
        this.viewWithdrawal.setVisible(false);
    }
    
    /**
     * Método de la clase implementada ActionListener que detecta y maneja eventos (clic en botones)
     * Utilizado para el funcionamiento y uso de los botones de la vista Menu 
     * Mediante condicionales
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.viewWithdrawal.ButtonWithdraw) {
            
        }
        if (e.getSource() == this.viewWithdrawal.ButtonReturn) {
            this.viewWithdrawal.setVisible(false);
            openViewMenu();
        }
        

    }
    
}
