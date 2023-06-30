package DAO;

import Model.Client;
import Service.DeserializeClients;
import Service.SerializeClients;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static Service.DeserializeClients.deserializeClients;
import java.util.Objects;


public class ClientsDAO {
       
    /**
     * Método para añadir clientes a la base de datos
     * Llamando al método serializeClients para serializar el objeto client
     *      * 
     * @param client
     * @throws IOException
     */
    public void addClient(Client client) throws IOException{
        SerializeClients.serializeClients(client);
    }
    
    /**
     * Método para revisar si el cliente existe
     * Utilizando el usuario y la constraseña (parámetros) del cliente
     * Deserializa la base de datos y guarda los datos en una lista
     * Se compara cada elemento de la lista utilizando los parámetros del método
     * 
     * @param clientUserCurp
     * @param clientUserName
     * @return boolean
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public boolean existsClient(String clientUserCurp, String clientUserName) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Client> clientList = deserializeClients();

        return clientList.stream()
                .anyMatch(client -> Objects.equals(clientUserCurp, client.getClientCurp()) || Objects.equals(clientUserName, client.getClientUser()));
    }
    
    /**
     * Método que retorna una lista deserializa 
     * Con los clientes guardados en la base de datos
     * 
     * @return DeserializeClientList
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public ArrayList<Client> getDeserializeClientList() throws IOException, FileNotFoundException, ClassNotFoundException {
        return DeserializeClients.deserializeClients();
    }
}