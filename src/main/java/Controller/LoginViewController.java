package Controller;

import DAO.ClientsDAO;
import Model.Client;
import Service.DeserializeClients;
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

    /**
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
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void loginUserClient() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Client> clientList = DeserializeClients.deserializeClients();
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getClientUser().equals(this.viewLogin.textFieldUser.getText()) && clientList.get(i).getClientPassWord().equals(this.viewLogin.textFieldPass.getText())) {
                JOptionPane.showMessageDialog(null, "Bienvenido Usuario");
                openViewMenu();
                break;
            }
        }
    }

    public void initializeSignUpView() {
        ViewSignUp viewSignUp = new ViewSignUp();

        viewSignUp.setVisible(true);
        this.viewLogin.setVisible(false);
    }
    
    public void openViewMenu() {
        ViewMenu viewMenu = new ViewMenu();

        viewMenu.setVisible(true);
        this.viewLogin.setVisible(false);
    }

    /**
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
        } else if (e.getSource() == this.viewLogin.ButtonAddClient) {

            initializeSignUpView();
        }

    }

    /* private int generateID() {
    Random random = new Random();
    int min = 100_000_000; // Mínimo valor de 8 dígitos
    int max = 999_999_999; // Máximo valor de 9 dígitos
    return random.nextInt(max - min + 1) + min;
    }*/
}
