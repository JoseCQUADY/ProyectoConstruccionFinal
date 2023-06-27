package Model;

public class Account {
    private String idClient;
    private int idAccount;
    private double balance;

    public Account(String curpClient, int id) {
        this.idClient = curpClient;
        this.idAccount = id;
        this.balance = 0.0;
    }
    
    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String id) {
        this.idClient = id;
    }
    
    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int id) {
        this.idAccount = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

