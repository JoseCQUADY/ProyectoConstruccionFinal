package DAO;
import Model.Account;
import java.util.List;

public interface AccountDAO {
    void addAccount(String idClient, Account account);
    void removeAccount(String idClient, int idAccount);
    void removeAllAccounts(String idClient);
    void deposit(String idClient, int idAccount, double amount);
    void withdraw(String idClient, int idAccount, double amount);
    List<Account> showAccounts(String idClient);
}
