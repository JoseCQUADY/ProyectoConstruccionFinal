package Controller;
import Model.*;
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

public class ControllerLogin implements ActionListener {

    private ViewLogin viewLogin = new ViewLogin();
    private Bank nationalBank;

    public ControllerLogin(ViewLogin viewLogin) throws IOException, FileNotFoundException, ClassNotFoundException{
        this.viewLogin = viewLogin;
        this.nationalBank = Bank.getInstance();
        this.viewLogin.ButtonAddClient.addActionListener(this);
        this.viewLogin.ButtonLogin.addActionListener(this);
        this.viewLogin.textFieldPass.addActionListener(this);
        this.viewLogin.textFieldUser.addActionListener(this);
        
    }
    
     public void loginUserClient() throws IOException, FileNotFoundException, ClassNotFoundException {
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
     * @throws java.io.FileNotFoundException
     */
    public void openViewSignUp() throws FileNotFoundException, ClassNotFoundException, IOException {
        ViewSignUp viewSignUp = new ViewSignUp();
        ControllerSignUp signUpController = new ControllerSignUp(nationalBank,viewSignUp);
        viewSignUp.setVisible(true);
        this.viewLogin.setVisible(false);
    }
    
    /**
     * Método para abrir la vista Menu 
     * Cierra la vista Login
     */
    public void openViewMenu(Client clientUser) {
        ViewMenu viewMenu = new ViewMenu();
        ControllerMenu menuController = new ControllerMenu(nationalBank,clientUser,viewMenu);
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
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.viewLogin.ButtonAddClient) {
            try {
                openViewSignUp();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        

    }

    /* private int generateID() {
    Random random = new Random();
    int min = 100_000_000; // Mínimo valor de 8 dígitos
    int max = 999_999_999; // Máximo valor de 9 dígitos
    return random.nextInt(max - min + 1) + min;
    }*/
}

