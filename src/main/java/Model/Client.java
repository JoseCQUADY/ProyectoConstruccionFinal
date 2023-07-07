package Model;

import Serializable.DeserializeAccounts;
import Serializable.SerializeAccounts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase modelo para el objeto Client
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
 */
public class Client implements Serializable {
    private String clientName;
    private String clientCurp;
    private String clientUser;
    private String clientPassWord;
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor de la clase
     * Inicializa los atributos privados usando los parametros que recibe
     * 
     * @param clientName
     * @param clientCurp
     * @param clientUser
     * @param clientPass
     */
    public Client(String clientName, String clientCurp, String clientUser, String clientPass) {
        this.clientName = clientName;
        this.clientCurp = clientCurp;
        this.clientUser = clientUser;
        this.clientPassWord = clientPass;
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
    
    /**
     * Método de acceso set para agregar una cuenta a la base de datos
     * 
     * @param accountType
     * @throws IOException
     */
    public void setAccount(Account accountType) throws IOException {
        SerializeAccounts.serializeAccounts(accountType);
    }

    /**
     * Método de acceso get para obtener una lista de las cuentas existentes
     * 
     * @return lista de cuentas
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public ArrayList<Account> getAccounts() throws IOException, FileNotFoundException, ClassNotFoundException {
        return DeserializeAccounts.deserializeAccounts();
    }
    
    /**
     * Método que llama al método modifyAccount de la clase SerializableAccounts
     * Para modificar un atributo de la cuenta 
     * 
     * @param account
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void modifyAccount(Account account) throws IOException, ClassNotFoundException {
        SerializeAccounts.modifyAccount(account);
    }
    
    /**
     * Método que llama al método removeAccounts de la clase SerializableAccounts
     * Para eliminar un atributo de la cuenta 
     * 
     * @param account
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void removeAccount(Account account) throws IOException, ClassNotFoundException {
        SerializeAccounts.removeAccount(account);
    }
}
