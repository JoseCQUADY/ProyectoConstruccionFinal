
package Model;


public class SavingAccount extends Account {
    public double interestSavingRate;

    public SavingAccount(double interestSavingRate, double balanceAccount, int idAccount) {
        super(balanceAccount, idAccount);
        this.interestSavingRate = interestSavingRate;
    }

    @Override
    public void accountWithDraw(double withdrawAmount) {
        
    }

    @Override
    public void accountDeposit(double depositAmount) {
        
    }
    
}
