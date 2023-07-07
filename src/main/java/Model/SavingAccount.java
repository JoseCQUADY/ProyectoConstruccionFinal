package Model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 * Subclase de la superclase Account
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
 */
public class SavingAccount extends Account implements Serializable{
    public double interestSavingRate;
    private LocalDate lastInterestAppliedDate;
    private static final long serialVersionUID = 1L;

    /**
     * Constructor de la clase
     * Inicializa los atributos privados usando los parametros que recibe
     * 
     * @param interestSavingRate
     * @param lastInterestAppliedDate
     * @param balanceAccount
     * @param clientCurp
     */
    public SavingAccount(double interestSavingRate, LocalDate lastInterestAppliedDate, double balanceAccount, String clientCurp) {
        super(balanceAccount, clientCurp);
        this.interestSavingRate = interestSavingRate;
        this.lastInterestAppliedDate = lastInterestAppliedDate;
    }
    
    /**
     * Método de acceso get para la variable getInterestSavingRate
     * 
     * @return getInterestSavingRate
     */
    public double getInterestSavingRate() {
        return interestSavingRate;
    }

    /**
     * Método de acceso set para la variable interestSavingRate
     * 
     * @param interestSavingRate
     */
    public void setInterestSavingRate(double interestSavingRate) {
        this.interestSavingRate = interestSavingRate;
    }

    /**
     * Método de acceso get para la variable lastInterestAppliedDate
     * 
     * @return lastInterestAppliedDate
     */
    public LocalDate getLastInterestAppliedDate() {
        return lastInterestAppliedDate;
    }
    
    /**
     * Método de acceso set para la variable lastInterestAppliedDate
     * 
     * @param lastInterestAppliedDate
     */
    public void setLastInterestAppliedDate(LocalDate lastInterestAppliedDate) {
        this.lastInterestAppliedDate = lastInterestAppliedDate;
    }
    
    /**
     * Método que aplica un interes especifico al saldo de la cuenta
     */
    private void applyInterest() {
        double currentBalance = super.getBalanceAccount();
        double interestAmount = currentBalance * (getInterestSavingRate() / 100.0);
        super.setBalanceAccount(currentBalance + interestAmount);
        setLastInterestAppliedDate(LocalDate.now());
    }
    
    /**
     * Método que comprueba la fecha actual 
     * 
     * @return true si ya paso un mes
     */
    private boolean hasPassedOneMonth() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getMonthValue() != getLastInterestAppliedDate().getMonthValue();
    }
    
    /**
     * Método heredado de la superclase
     * Modificado para poder hacer un deposito a una cuenta
     * 
     * @param depositAmount
     */
    @Override
    public void accountDeposit(double depositAmount) {
        if (hasPassedOneMonth()) {
            applyInterest();
        }
        double newBalance = getBalanceAccount() + depositAmount;
        setBalanceAccount(newBalance);
        JOptionPane.showMessageDialog(null, "Retiro realizado con éxito. Nuevo saldo: " + newBalance);
    }
    
    /**
     * Método heredado de la superclase
     * Modificado para poder hacer un retiro a una cuenta
     * 
     * @param amount
     */
    @Override
    public void accountWithdraw(double amount) {
        double withdrawAmount = amount;
        if (withdrawAmount <= super.getBalanceAccount()) {
            double newBalance = super.getBalanceAccount() - withdrawAmount;
            super.setBalanceAccount(newBalance);
            JOptionPane.showMessageDialog(null, "Retiro realizado con éxito. Nuevo saldo: " + newBalance);
        } else {
            JOptionPane.showMessageDialog(null, "Fondos Insuficientes");
        }
    }

}
