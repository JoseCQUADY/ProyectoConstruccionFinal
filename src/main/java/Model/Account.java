package Model;

import java.io.Serializable;

public abstract class Account implements Serializable {

    private double balanceAccount;
    private static int idcount = 0;
    private int idAccount;
    private static final long serialVersionUID = 1L;
    private String idClient;
    
    public Account(double balanceAccount,String clientCurp) {
        this.balanceAccount = balanceAccount;
        idcount++;
        idAccount = idcount;
        this.idClient = clientCurp;
    }
  
    public abstract void accountDeposit(double depositAmount);

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
      
    public double getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(double balanceAccount) {
        this.balanceAccount = balanceAccount;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
    
    
   
}

