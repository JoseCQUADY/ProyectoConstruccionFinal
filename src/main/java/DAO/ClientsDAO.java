
package DAO;

import Model.Client;
import Service.SerializeClients;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static Service.DeserializeClients.deserializeClients;


public class ClientsDAO {
       
    /**
     *
     * @param client
     * @throws IOException
     */
    public void addClient(Client client) throws IOException{
        SerializeClients.serializeClients(client);
    }
    
    /**
     *
     * @param clientUserName
     * @param clientPassword
     * @return boolean
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public boolean existsClient(String clientUserName, String clientPassword) throws IOException, FileNotFoundException, ClassNotFoundException{
        ArrayList<Client> clientList = deserializeClients();
        
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
