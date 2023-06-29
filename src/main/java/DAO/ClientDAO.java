package DAO;
import Model.Client;
import java.util.List;

public interface ClientDAO {
    void addClient(Client client);
    void removeClient(String id);
    Client showClient(String id);
    List<Client> showAllClients();
    boolean existClient(String idClient);
}

