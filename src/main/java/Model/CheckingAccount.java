
package Model;


public class CheckingAccount extends Account{
    public int overdraftAmount;

    public CheckingAccount(int overdraftAmount, double balanceAccount, int idAccount) {
        super(balanceAccount, idAccount);
        this.overdraftAmount = overdraftAmount;
    }
    
    @Override
    public void accountWithDraw(double withdrawAmount) {
       
    }

    @Override
    public void accountDeposit(double depositAmount) {
       
    }
    
}
