package Controller;

import DAO.ClientsDAO;
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

public class SignUpViewController implements ActionListener {

    private ViewSignUp viewSignUp = new ViewSignUp();
    private ClientsDAO clientsDAO = new ClientsDAO();

    /**
     * Constructor de la clase SignUpViewController
     * Inicializa los botones y campos de texto de la vista Sign Up
     * Para poder usarlos y llamarlos desde el controlador
     * 
     * @param clientsDAO
     * @param viewSignUp
     */
    public SignUpViewController(ClientsDAO clientsDAO, ViewSignUp viewSignUp) { 
        this.viewSignUp = viewSignUp;
        this.clientsDAO = clientsDAO;
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
    public void addUserAccount() throws IOException, FileNotFoundException, ClassNotFoundException {
        Validation validator = new Validation();
        String clientCurp = this.viewSignUp.textFieldCurp.getText();
        if (validator.validateCurp(clientCurp)){
            String clientUserName = this.viewSignUp.textFieldUser.getText();
            if (!clientsDAO.existsClient(clientCurp, clientUserName)){
                String clientName = this.viewSignUp.textFieldName.getText();
            
                String clientPassWord = this.viewSignUp.textFieldPass.getText();

                Client newUserClient = new Client(clientName, clientCurp, clientUserName, clientPassWord);
                clientsDAO.addClient(newUserClient);

                JOptionPane.showMessageDialog(null, "Cliente registrado con éxito");
                openViewLogin();
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese curp o usuario ");
            }
            
        }
        
    }

    /**
     * Método para abrir la vista Sign Up 
     * Cierra la vista Login
     */
    public void openViewLogin() {
        ViewLogin viewLogin = new ViewLogin();
        LoginViewController viewController = new LoginViewController(viewLogin);
        viewLogin.setVisible(true);
        this.viewSignUp.setVisible(false);
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
        if (e.getSource() == this.viewSignUp.ButtonSignUp) {
            try {
                
                addUserAccount();
              
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewSignUp.ButtonReturn) {
            openViewLogin();
        }

    }

}
