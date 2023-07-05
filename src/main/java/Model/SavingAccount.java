package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class SavingAccount extends Account implements Serializable{

    public double interestSavingRate;
    private LocalDate lastInterestAppliedDate;
    private static final long serialVersionUID = 1L;

    public SavingAccount(double interestSavingRate, LocalDate lastInterestAppliedDate, double balanceAccount, String clientCurp) {
        super(balanceAccount, clientCurp);
        this.interestSavingRate = interestSavingRate;
        this.lastInterestAppliedDate = lastInterestAppliedDate;
    }

    @Override
    public void accountDeposit(double depositAmount) {
        // Verificar si ha pasado un mes desde la última vez que se aplicó el interés
        if (hasPassedOneMonth()) {
            applyInterest();
        }
        // Realizar el depósito en la cuenta de ahorros
        setBalanceAccount(getBalanceAccount() + depositAmount);
    }

    private boolean hasPassedOneMonth() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getMonthValue() != lastInterestAppliedDate.getMonthValue();
    }

    private void applyInterest() {
        double currentBalance = getBalanceAccount();
        double interestAmount = currentBalance * (interestSavingRate / 100.0);
        setBalanceAccount(currentBalance + interestAmount);
        lastInterestAppliedDate = LocalDate.now();
    }

}
