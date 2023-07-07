package Model;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 * Subclase de la superclase Account
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
 */
public class CheckingAccount extends Account implements Serializable {
    public int overdraftAmount;
    private static final long serialVersionUID = 1L;

    /**
     * Constructor de la clase
     * Inicializa los atributos privados usando los parametros que recibe
     * 
     * @param balanceAccount
     * @param clientCurp
     */
    public CheckingAccount(double balanceAccount, String clientCurp) {
        super(balanceAccount, clientCurp);
        this.overdraftAmount = 100;
    }
    
    /**
     * Método de acceso get para la variable overdraftAmount
     * 
     * @return overdraftAmount
     */
    public int getOverdraftAmount() {
        return overdraftAmount;
    }

    /**
     * Método de acceso set para la variable overdraftAmount
     * 
     * @param overdraftAmount
     */
    public void setOverdraftAmount(int overdraftAmount) {
        this.overdraftAmount = overdraftAmount;
    }

    /**
     * Método heredado de la superclase
     * Modificado para poder hacer un deposito a una cuenta
     * 
     * @param amount
     */
    @Override
    public void accountDeposit(double amount) {
        double depositAmount = amount;
        
        if (depositAmount > 0) {
            double currentBalance = super.getBalanceAccount();
            double newBalance = currentBalance + depositAmount;
            super.setBalanceAccount(newBalance);
            JOptionPane.showMessageDialog(null, "Deposito realizado con éxito. Nuevo saldo: " + newBalance);
        } else {
            JOptionPane.showMessageDialog(null, "Monto de ingreso invalido");
        }
        
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

        if (withdrawAmount > 0) {
            if (super.getBalanceAccount() + getOverdraftAmount() >= withdrawAmount) {
                double newBalance = super.getBalanceAccount() - withdrawAmount;
                if (withdrawAmount > super.getBalanceAccount()) {
                    double newOverDraftAmount = this.getOverdraftAmount() - (newBalance);
                    this.setOverdraftAmount((int) newOverDraftAmount);
                    super.setBalanceAccount(0);
                    JOptionPane.showMessageDialog(null, "Retiro realizado con éxito");
                } else {
                    super.setBalanceAccount(newBalance);
                    JOptionPane.showMessageDialog(null, "Retiro realizado con éxito. Nuevo saldo: " + newBalance);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Fondos Insuficientes");
            }
        }else {
            JOptionPane.showMessageDialog(null, "Monto de ingreso invalido");
        }
    }
}
