
package DAO;

import Model.Client;
import static Model.DeserializeClients.DeserializeClients;
import Model.SerializeClients;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class ClientsDAO {
    
    
    private final File CLIENTSDATAFILE = new File("clientesInformation.dat");
    
  
    
    public void addClient(Client client) throws IOException{
        SerializeClients.serializeClients(client);
    }
    
    public boolean existsClient(String clientUserName, String clientPassword) throws IOException, FileNotFoundException, ClassNotFoundException{
        ArrayList<Client> clientList = DeserializeClients();
        
        for(int i=0;i<clientList.size();i++){
            
           if(clientUserName == null ? clientList.get(i).getClientUser() == null : clientUserName.equals(clientList.get(i).getClientUser())){
                if (clientUserName == null ? clientList.get(i).getClientPassWord() == null : clientUserName.equals(clientList.get(i).getClientPassWord())) {
                return true;
                }   
           } 
        }
        return false; 
    }
    
    
    
    
    
}
