package Model;

import Serializable.DeserializeClients;
import Serializable.SerializeClients;
import Service.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {

    private static ArrayList<Client> clientList;
    private static Bank nationalBank;
    
    public Bank() throws IOException, FileNotFoundException, ClassNotFoundException {
        Bank.clientList = DeserializeClients.deserializeClients();
    }

    public static Bank getInstance() throws IOException, FileNotFoundException, ClassNotFoundException {

        if (nationalBank == null) {
           nationalBank = new Bank();
        }
        return nationalBank;
    }
    
    public  void setClient(Client clientUser) throws IOException{
        SerializeClients.serializeClients(clientUser);
    }
    
    public ArrayList<Client> getClients() throws IOException, FileNotFoundException, ClassNotFoundException {
        return DeserializeClients.deserializeClients();
    }
    
    public boolean existsClient(String curpName) {
        for (Client client : clientList) {
            if (client.getClientName().equals(curpName)) {
                return true;
            }
        }
        return false;
    }

}
