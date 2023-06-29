package Controller;

import DAO.ClientsDAO;
import Model.Client;
import Service.Validation;
import View.ViewLogin;
import View.ViewSignUp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SignUpViewController implements ActionListener {

    private ClientsDAO clientsDAO = new ClientsDAO();
    private ViewSignUp viewSignUp = new ViewSignUp();

    /**
     *
     * @param modelClients
     * @param viewSignUp
     */
    public SignUpViewController(ClientsDAO modelClients, ViewSignUp viewSignUp) {
        this.clientsDAO = modelClients;
        this.viewSignUp = viewSignUp;
        this.viewSignUp.ButtonReturn.addActionListener(this);
        this.viewSignUp.ButtonSignUp.addActionListener(this);
        this.viewSignUp.textFieldCurp.addActionListener(this);
        this.viewSignUp.textFieldName.addActionListener(this);
        this.viewSignUp.textFieldPass.addActionListener(this);
        this.viewSignUp.textFieldUser.addActionListener(this);

    }

    /**
     *
     * @throws IOException
     */
    public void addUserAccount() throws IOException {
        Validation validator = new Validation();
        String clientCurp = this.viewSignUp.textFieldCurp.getText();
        if (validator.validateCurp(clientCurp)){
            String clientName = this.viewSignUp.textFieldName.getText();
            String clientUserName = this.viewSignUp.textFieldUser.getText();
            String clientPassWord = this.viewSignUp.textFieldPass.getText();

            Client newUserClient = new Client(clientName, clientCurp, clientUserName, clientPassWord);
            clientsDAO.addClient(newUserClient);

            JOptionPane.showMessageDialog(null, "Cuenta creada con éxito");
            returnViewLogin();
        }
        
    }

    public void returnViewLogin() {
        ViewLogin viewLogin = new ViewLogin();

        viewLogin.setVisible(true);
        this.viewSignUp.setVisible(false);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.viewSignUp.ButtonSignUp) {
            try {
                addUserAccount();
              
            } catch (IOException ex) {
                Logger.getLogger(SignUpViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == this.viewSignUp.ButtonReturn) {
            returnViewLogin();
        }
    }

}
