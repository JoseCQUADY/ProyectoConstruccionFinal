package Model;

import java.io.Serializable;

public class CheckingAccount extends Account implements Serializable {

    public int overdraftAmount;
    private static final long serialVersionUID = 1L;

    public CheckingAccount(double balanceAccount, String clientCurp) {
        super(balanceAccount, clientCurp);
        this.overdraftAmount = 100;
    }

    public double accountWithDraw(double withdraw) {
        double withdrawAmount = withdraw;

        if (withdrawAmount > 0) {
            if (super.getBalanceAccount() + getOverdraftAmount() >= withdrawAmount) {
                if (withdrawAmount > super.getBalanceAccount()) {
                    double newOverDraftAmount = this.getOverdraftAmount() - (withdrawAmount - super.getBalanceAccount());
                    this.setOverdraftAmount((int) newOverDraftAmount);
                    super.setBalanceAccount(0);
                } else {
                    double newBalance = super.getBalanceAccount() - withdrawAmount;
                    super.setBalanceAccount(newBalance);
                }
                return super.getBalanceAccount();
            }
        }
        return -1; // Retorno de un valor negativo para indicar que el retiro no fue válido
    }

    public int getOverdraftAmount() {
        return overdraftAmount;
    }

    public void setOverdraftAmount(int overdraftAmount) {
        this.overdraftAmount = overdraftAmount;
    }

    @Override
    public void accountDeposit(double depositAmount) {
        double accountDepositAmount = depositAmount;
        
        if (accountDepositAmount > 0) {
            double currentBalance = super.getBalanceAccount();
            double newBalance = currentBalance + accountDepositAmount;
            super.setBalanceAccount(newBalance);
            System.out.println("Deposit successful. New balance: " + newBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}
