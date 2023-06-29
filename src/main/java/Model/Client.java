/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author You
 */
public class Client implements Serializable {
    private String clientName;
    private String clientCurp;
    private String clientUser;
    private String clientPassWord;
    private static final long serialVersionUID = 1L;
    
    public Client(String clientName, String clientCurp, String clientUser, String clientPass) {
        this.clientName = clientName;
        this.clientCurp = clientCurp;
        this.clientUser = clientUser;
        this.clientPassWord = clientPass;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCurp() {
        return clientCurp;
    }

    public void setClientCurp(String clientCurp) {
        this.clientCurp = clientCurp;
    }

    public String getClientUser() {
        return clientUser;
    }

    public void setClientUser(String clientUser) {
        this.clientUser = clientUser;
    }

    public String getClientPassWord() {
        return clientPassWord;
    }

    public void setClientPassWord(String clientPass) {
        this.clientPassWord = clientPass;
    }

   
    
   
}
