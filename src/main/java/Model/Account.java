package Model;

public abstract class Account {

    private double balanceAccount;
    private int idAccount;
    
    public Account(double balanceAccount,int idAccount) {
        this.balanceAccount = balanceAccount;
        this.idAccount = idAccount;
    }
    
    public abstract void accountWithDraw(double withdrawAmount);
    
    public abstract void accountDeposit(double depositAmount);
    
    
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

