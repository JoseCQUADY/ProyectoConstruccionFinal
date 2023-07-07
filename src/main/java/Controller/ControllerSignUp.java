package Controller;

import Model.Bank;
import Model.Client;
import Service.Validation;
import View.ViewLogin;
import View.ViewSignUp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerSignUp implements ActionListener {

    private ViewSignUp viewSignUp = new ViewSignUp();
    private Bank nationalBank;

    /**
     * Constructor de la clase SignUpViewController
     * Inicializa los botones y campos de texto de la vista
     * Para poder usarlos y llamarlos desde el controlador
     * 
     * @param nationalBank
     * @param viewSignUp
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public ControllerSignUp(Bank nationalBank,ViewSignUp viewSignUp) throws IOException, FileNotFoundException, ClassNotFoundException { 
        this.viewSignUp = viewSignUp;
        this.nationalBank = nationalBank;
        this.viewSignUp.ButtonReturn.addActionListener(this);
        this.viewSignUp.ButtonSignUp.addActionListener(this);
        this.viewSignUp.textFieldCurp.addActionListener(this);
        this.viewSignUp.textFieldName.addActionListener(this);
        this.viewSignUp.textFieldPass.addActionListener(this);
        this.viewSignUp.textFieldUser.addActionListener(this);
    }

    /**
     * Método registrar/añadir un cllente en la base de datos
     * Obteniendo los datos ingresados (curp, nombre, usuario y constraseña) por el cliente en la vista Sign Up
     * Y mandandolos a la clase clientsDAO para guardarlos en la base de datos
     * 
     * @throws IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    private void addUserAccount() throws IOException, FileNotFoundException, ClassNotFoundException {
        Validation validatorData = new Validation();
        String clientCurp = this.viewSignUp.textFieldCurp.getText();
        String clientName = this.viewSignUp.textFieldName.getText();
        String clientPassword = this.viewSignUp.textFieldPass.getText();
        String clientUserName = this.viewSignUp.textFieldUser.getText();
        boolean existsClientData = clientCurp.equals("") && clientName.equals("") && clientPassword.equals("") && clientUserName.equals("");
        if (!existsClientData){
            boolean validClientData = validatorData.validateCurp(clientCurp) && validatorData.validateName(clientName) && validatorData.validatePass(clientPassword);
            if (validClientData){
                if (!nationalBank.existsClient(clientCurp)){                    
                    Client newUserClient = new Client(clientName, clientCurp, clientUserName, clientPassword);
                    nationalBank.setClient(newUserClient);

                    JOptionPane.showMessageDialog(null, "Cliente registrado con éxito");
                    openViewLogin();
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese curp o usuario ");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Campos de texto vacios");
        } 
    }

    /**
     * Método para abrir la vista Sign Up 
     * Cierra la vista Login
     * 
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    private void openViewLogin() throws IOException, FileNotFoundException, ClassNotFoundException {
        ViewLogin viewLogin = new ViewLogin();
        ControllerLogin viewController = new ControllerLogin(viewLogin);
        this.viewSignUp.setVisible(false);
        viewLogin.setVisible(true);
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
        if (e.getSource() == this.viewSignUp.ButtonSignUp) {
            try {              
                addUserAccount();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewSignUp.ButtonReturn) {
            try {
                openViewLogin();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ControllerSignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
