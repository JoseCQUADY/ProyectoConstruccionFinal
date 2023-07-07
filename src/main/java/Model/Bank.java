package Model;

import Serializable.DeserializeClients;
import Serializable.SerializeClients;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase modelo para el objeto Bank
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
 */
public class Bank {
    private static ArrayList<Client> clientList;
    private static Bank nationalBank;
    
    /**
     * Constructor de la clase
     * Inicializa los atributos privados usando los parametros que recibe
     * 
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public Bank() throws IOException, FileNotFoundException, ClassNotFoundException {
        Bank.clientList = DeserializeClients.deserializeClients();
    }
    
    /**
     * Método de tipo booleano que revisa si el cliente existe en la base de datos
     * 
     * @param curp
     * @param user
     * @return true si existe, false si no existe
     */
    public boolean existsClient(String curp, String user) {
        for (Client client : clientList) {
            if (client.getClientCurp().equals(curp)) {
                return true;
            }
            if (client.getClientUser().equals(user)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método estatico de acceso get para obtener la instancia de la clase
     * 
     * @return atributo nationalBank de tipo Bank
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public static Bank getInstance() throws IOException, FileNotFoundException, ClassNotFoundException {
        if (nationalBank == null) {
           nationalBank = new Bank();
        }
        return nationalBank;
    }
    
    /**
     * Método de acceso get para obtener una lista de los clientes existentes
     * 
     * @return lista de clientes
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public ArrayList<Client> getClients() throws IOException, FileNotFoundException, ClassNotFoundException {
        return DeserializeClients.deserializeClients();
    }
    
    /**
     * Método de acceso set para agregar un cliente a la base de datos
     * 
     * @param clientUser
     * @throws IOException
     */
    public  void setClient(Client clientUser) throws IOException{
        SerializeClients.serializeClients(clientUser);
    }
}
