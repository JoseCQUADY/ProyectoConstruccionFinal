package Model;

import java.io.Serializable;

/**
 * Superclase para el objeto abstracto Account
 * Con sus atributos, constructor, métodos de acceso y métodos propios
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
 */
public abstract class Account implements Serializable {
    private String idClient;
    private static int idCountAccount = 0;
    private int idAccount;
    private double balanceAccount;
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor de la clase
     * Inicializa los atributos privados usando los parametros que recibe
     * 
     * @param balanceAccount
     * @param clientCurp
     */
    public Account(double balanceAccount,String clientCurp) {
        this.idClient = clientCurp;
        idCountAccount++;
        idAccount = idCountAccount; 
        this.balanceAccount = balanceAccount;
    }

    /**
     * Método de acceso get para la variable idClient
     * 
     * @return idClient
     */
    public String getIdClient() {
        return idClient;
    }

    /**
     * Método de acceso set para la variable idClient
     * 
     * @param idClient
     */
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
    
    /**
     * Método de acceso get para la variable idAccount
     * 
     * @return idAccount
     */
    public int getIdAccount() {
        return idAccount;
    }

    /**
     * Método de acceso set para la variable idAccount
     * 
     * @param idAccount
     */
    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
      
    /**
     * Método de acceso get para la variable balanceAccount
     * 
     * @return balanceAccount
     */
    public double getBalanceAccount() {
        return balanceAccount;
    }

    /**
     * Método de acceso set para la variable balanceAccount
     * 
     * @param balanceAccount
     */
    public void setBalanceAccount(double balanceAccount) {
        this.balanceAccount = balanceAccount;
    }

    /**
     * Método abstracto sin código ni funcionamiento
     * Pensado para ser heredado y modificado 
     * Utilizado para hacer depositos en cuentas
     * 
     * @param depositAmount
     */
    public abstract void accountDeposit(double depositAmount);
    
    /**
     * Método abstracto sin código ni funcionamiento
     * Pensado para ser heredado y modificado 
     * Utilizado para hacer retiros en cuentas
     * 
     * @param withdrawAmount
     */
    public abstract void accountWithdraw(double withdrawAmount);
    
}

