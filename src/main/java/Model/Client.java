package Model;

import Serializable.DeserializeAccounts;
import Serializable.SerializeAccounts;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {
    private String clientName;
    private String clientCurp;
    private String clientUser;
    private String clientPassWord;
    private Account accountType;
    private static final long serialVersionUID = 1L;
    
   
    public Client(String clientName, String clientCurp, String clientUser, String clientPass) {
        this.clientName = clientName;
        this.clientCurp = clientCurp;
        this.clientUser = clientUser;
        this.clientPassWord = clientPass;
    }
    
    public Client(Account accountType){
        this.accountType = accountType;
    }

  
    public void setAccountType(Account accountType) throws IOException {
        SerializeAccounts.serializeAccounts(accountType);
    }

    public ArrayList<Account> getAccountType() throws IOException, FileNotFoundException, ClassNotFoundException {
        return DeserializeAccounts.deserializeAccounts();
    }
    
    

    /**
     * Método de acceso get para la variable clientName
     * 
     * @return clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Método de acceso set para la variable clientName
     * 
     * @param clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Método de acceso get para la variable clientCurp
     * @return clientCurp
     */
    public String getClientCurp() {
        return clientCurp;
    }

    /**
     * Método de acceso set para la variable clientCurp
     * 
     * @param clientCurp
     */
    public void setClientCurp(String clientCurp) {
        this.clientCurp = clientCurp;
    }

    /**
     * Método de acceso get para la variable clientPassWord
     * @return clientPassWord
     */
    public String getClientUser() {
        return clientUser;
    }

    /**
     * Método de acceso set para la variable clientUser
     * 
     * @param clientUser
     */
    public void setClientUser(String clientUser) {
        this.clientUser = clientUser;
    }

    /**
     * Método de acceso get para la variable clientPassWord
     * @return clientPassWord
     */
    public String getClientPassWord() {
        return clientPassWord;
    }

    /**
     * Método de acceso set para la variable clientPassWord
     * 
     * @param clientPass
     */
    public void setClientPassWord(String clientPass) {
        this.clientPassWord = clientPass;
    }
 
}
