package Controller;

import Model.Client;
import Model.Bank;
import View.ViewSignUp;
import View.ViewLogin;
import View.ViewMenu;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase controlador para la vista Login
 * Controla la vista implementando la clase ActionListener
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
*/
public class ControllerLogin implements ActionListener {
    private ViewLogin viewLogin = new ViewLogin();
    private Bank nationalBank;

    /**
     * Constructor de la clase
     * Inicializa los botones y campos de texto de la vista 
     * Para poder usarlos y llamarlos desde el controlador
     * 
     * @param viewLogin
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public ControllerLogin(ViewLogin viewLogin) throws IOException, FileNotFoundException, ClassNotFoundException{
        this.viewLogin = viewLogin;
        this.nationalBank = Bank.getInstance();
        this.viewLogin.ButtonAddClient.addActionListener(this);
        this.viewLogin.ButtonLogin.addActionListener(this);
        this.viewLogin.textFieldPass.addActionListener(this);
        this.viewLogin.textFieldUser.addActionListener(this);       
    }
    
    /**
     * Método para iniciar sesión con el usuario y contraseña de un cliente
     * Utilizando los datos ingresados por el cliente en la vista Login
     * Se valida si existe el cliente en la base de datos
     * 
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    private void loginUserClient() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Client> clientList = nationalBank.getClients();
        String enteredUser = this.viewLogin.textFieldUser.getText();
        String enteredPassword = this.viewLogin.textFieldPass.getText();

        Client loggedInClient = clientList.stream()
                .filter(client -> client.getClientUser().equals(enteredUser) && client.getClientPassWord().equals(enteredPassword))
                .findFirst()
                .orElse(null);

        if (loggedInClient != null) {
            JOptionPane.showMessageDialog(null, "Bienvenido Usuario");
            openViewMenu(loggedInClient);  
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales Inválidas");  
        }
    }

    /**
     * Método para abrir la vista Sign Up 
     * Cierra la vista Login
     * 
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    private void openViewSignUp() throws FileNotFoundException, ClassNotFoundException, IOException {
        ViewSignUp viewSignUp = new ViewSignUp();
        ControllerSignUp signUpController = new ControllerSignUp(nationalBank,viewSignUp);
        this.viewLogin.setVisible(false);
        viewSignUp.setVisible(true);       
    }
    
    /**
     * Método para abrir la vista Menu 
     * Cierra la vista Login
     * 
     * @param clientUser
     */
    private void openViewMenu(Client clientUser) {
        ViewMenu viewMenu = new ViewMenu();
        ControllerMenu menuController = new ControllerMenu(nationalBank,clientUser,viewMenu);
        this.viewLogin.setVisible(false);
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
        if (e.getSource() == this.viewLogin.ButtonLogin) {
            try {
                loginUserClient();   
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewLogin.ButtonAddClient) {
            try {
                openViewSignUp();
            } catch (ClassNotFoundException | IOException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

