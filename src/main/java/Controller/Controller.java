package Controller;
import DAO.AccountDAO;
import DAO.ClientDAO;
import Model.Account;
import Service.Algorithm;
import Model.Client;
import Service.Validation;
import java.util.List;
import java.util.Random;

public class Controller {
    private ClientDAO clientDAO;
    private AccountDAO accountDAO;
    private Validation validator;
    //private Algorithm algorithm;

    String secretKey = "clave";
    

    public Controller(ClientDAO clientDAO, AccountDAO accountDAO, Validation validator, Algorithm algorithm) {
        this.clientDAO = clientDAO;
        this.accountDAO = accountDAO;
        this.validator = validator;
        //this.algorithm = algorithm;
    }

    public void addClient(String nameClient, String curpClient) {
        if (validator.validateCURP(curpClient)){
            if (existClient(curpClient)){
                System.out.println("Cliente existente");
            }else{
                //String encryptCURP = algorithm.encryptTL(curpClient, secretKey); 
                //String encryptName = algorithm.encryptTL(nameClient, secretKey);
                Client client = new Client(nameClient, curpClient);
                clientDAO.addClient(client);
                Account account = new Account(curpClient, generateID());
                accountDAO.addAccount(curpClient, account);
                System.out.println("Cliente agregado correctamente.");
                System.out.println("ID de Cuenta:"+ account.getIdAccount());
            }
        }
    }

    public void removeClient(String idClient) {
        if (existClient(idClient)){
            clientDAO.removeClient(idClient);
            accountDAO.removeAllAccounts(idClient);
            System.out.println("Cliente eliminado correctamente.");
        }else{
            System.out.println("Cliente no existente");
        }
    }
    
    public Client showClient(String idClient) {
        return clientDAO.showClient(idClient);
    }

    public List<Client> showAllClients() {
        return clientDAO.showAllClients();
    }

    public void addAccount(String curpClient) {
        if (existClient(curpClient)){
            Account account = new Account(curpClient, generateID());
            accountDAO.addAccount(curpClient, account);
            System.out.println("Cuenta agregada al cliente correctamente."); 
            System.out.println("ID de Cuenta:"+ account.getIdAccount());
        }else{
            System.out.println("Cliente no existente");
        }  
    }

    public void removeAccount(String idClient, int idAccount) {
        if (existClient(idClient)){
            accountDAO.removeAccount(idClient, idAccount);
            System.out.println("Cuenta eliminada correctamente.");
        }else{
            System.out.println("Cliente no existente");
        }
    }

    public List<Account> showAccounts(String idClient) {
        return accountDAO.showAccounts(idClient);
    }
    
    public void deposit(String idClient, int idAccount, double amount){
        if (existClient(idClient)){
            accountDAO.deposit( idClient,  idAccount,  amount);
            System.out.println("Depósito realizado.");
        }else{
            System.out.println("Cliente no existente");
        } 
    }
    
    public void withdraw(String idClient, int idAccount, double amount){
        if (existClient(idClient)){
            accountDAO.withdraw( idClient,  idAccount,  amount);
            System.out.println("Retiro realizado.");
        }else{
            System.out.println("Cliente no existente");
        } 
    }
        
    private int generateID() {
        Random random = new Random();
        int min = 100_000_000; // Mínimo valor de 8 dígitos
        int max = 999_999_999; // Máximo valor de 9 dígitos
        return random.nextInt(max - min + 1) + min;
    }
    
    private boolean existClient(String idClient){
        return clientDAO.existClient(idClient);
    }
    
}

