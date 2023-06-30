package Controller;

import DAO.ClientsDAO;
import Model.Client;
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

public class LoginViewController implements ActionListener {

    private ViewLogin viewLogin = new ViewLogin();
    private final ClientsDAO clientsDAO = new ClientsDAO();

    /**
     * Constructor de la clase LoginViewController
     * Inicializa los botones y campos de texto de la vista Login
     * Para poder usarlos y llamarlos desde el controlador
     * 
     * @param viewLogin
     */
    public LoginViewController(ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
        this.viewLogin.ButtonAddClient.addActionListener(this);
        this.viewLogin.ButtonLogin.addActionListener(this);
        this.viewLogin.textFieldPass.addActionListener(this);
        this.viewLogin.textFieldUser.addActionListener(this);
        
    }

    /**
     * Método para inciar sesión
     * Obteniendo los datos ingresados (usuario y constraseña) por el cliente en la vista Login
     * Utiliza una lista con los clientes ingresados
     * Compara cada elemento (cliente) de la lista con los datos que hay en la base de datos 
     * Para saber ssi existe el cliente
     * 
     * 
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void loginUserClient() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Client> clientList = clientsDAO.getDeserializeClientList();
        String enteredUser = this.viewLogin.textFieldUser.getText();
        String enteredPassword = this.viewLogin.textFieldPass.getText();
        boolean isLoginSuccessful = clientList.stream()
                .anyMatch(client -> client.getClientUser().equals(enteredUser) && client.getClientPassWord().equals(enteredPassword));

        if (isLoginSuccessful) {
            JOptionPane.showMessageDialog(null, "Bienvenido Usuario");
            openViewMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales Inválidas");
        }
    }

    /**
     * Método para abrir la vista Sign Up 
     * Cierra la vista Login
     */
    public void openSignUpView() {
        ViewSignUp viewSignUp = new ViewSignUp();
        SignUpViewController viewController = new SignUpViewController(clientsDAO, viewSignUp);
        viewSignUp.setVisible(true);
        this.viewLogin.setVisible(false);
    }
    
    /**
     * Método para abrir la vista Menu 
     * Cierra la vista Login
     */
    public void openViewMenu() {
        ViewMenu viewMenu = new ViewMenu();
        
        viewMenu.setVisible(true);
        this.viewLogin.setVisible(false);
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
        if (e.getSource() == this.viewLogin.ButtonLogin) {
            try {
                loginUserClient();
                
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewLogin.ButtonAddClient) {

            openSignUpView();
        }
        

    }

    /* private int generateID() {
    Random random = new Random();
    int min = 100_000_000; // Mínimo valor de 8 dígitos
    int max = 999_999_999; // Máximo valor de 9 dígitos
    return random.nextInt(max - min + 1) + min;
    }*/
}

