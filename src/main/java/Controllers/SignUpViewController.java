package Controllers;

import DAO.ClientsDAO;
import Model.Client;
import View.ViewLogin;
import View.ViewSignUp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SignUpViewController implements ActionListener {

    private ClientsDAO modelClients = new ClientsDAO();
    private ViewSignUp viewSignUp = new ViewSignUp();

    public SignUpViewController(ClientsDAO modelClients, ViewSignUp viewSignUp) {
        this.modelClients = modelClients;
        this.viewSignUp = viewSignUp;
        this.viewSignUp.ButtonReturn.addActionListener(this);
        this.viewSignUp.ButtonSignUp.addActionListener(this);
        this.viewSignUp.textFieldCurp.addActionListener(this);
        this.viewSignUp.textFieldName.addActionListener(this);
        this.viewSignUp.textFieldPass.addActionListener(this);
        this.viewSignUp.textFieldUser.addActionListener(this);

    }

    public void addUserAccount() throws IOException {

        String clientName = this.viewSignUp.textFieldName.getText();
        String clientCurp = this.viewSignUp.textFieldCurp.getText();
        String clientUserName = this.viewSignUp.textFieldUser.getText();
        String clientPassWord = this.viewSignUp.textFieldPass.getText();

        Client newUserClient = new Client(clientName, clientCurp, clientUserName, clientPassWord);
        modelClients.addClient(newUserClient);
    }

    public void returnLastView() {
        ViewLogin viewLogin = new ViewLogin();
        LoginViewController loginController = new LoginViewController(viewLogin);

        viewLogin.setVisible(true);
        this.viewSignUp.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.viewSignUp.ButtonSignUp) {
            try {
                addUserAccount();
                 JOptionPane.showMessageDialog(null, "Cuenta creada con éxito");
            } catch (IOException ex) {
                Logger.getLogger(SignUpViewController.class.getName()).log(Level.SEVERE, null, ex);
               
            }
        } else if (e.getSource() == this.viewSignUp.ButtonReturn) {
            returnLastView();
        }
    }

}
