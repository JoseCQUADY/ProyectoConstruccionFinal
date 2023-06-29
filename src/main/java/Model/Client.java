/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

public class Client implements Serializable {
    private String clientName;
    private String clientCurp;
    private String clientUser;
    private String clientPassWord;
    private static final long serialVersionUID = 1L;
    
    /**
     *
     * @param clientName
     * @param clientCurp
     * @param clientUser
     * @param clientPass
     */
    public Client(String clientName, String clientCurp, String clientUser, String clientPass) {
        this.clientName = clientName;
        this.clientCurp = clientCurp;
        this.clientUser = clientUser;
        this.clientPassWord = clientPass;
    }

    /**
     *
     * @return
     */
    public String getClientName() {
        return clientName;
    }

    /**
     *
     * @param clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     *
     * @return
     */
    public String getClientCurp() {
        return clientCurp;
    }

    /**
     *
     * @param clientCurp
     */
    public void setClientCurp(String clientCurp) {
        this.clientCurp = clientCurp;
    }

    /**
     *
     * @return
     */
    public String getClientUser() {
        return clientUser;
    }

    /**
     *
     * @param clientUser
     */
    public void setClientUser(String clientUser) {
        this.clientUser = clientUser;
    }

    /**
     *
     * @return
     */
    public String getClientPassWord() {
        return clientPassWord;
    }

    /**
     *
     * @param clientPass
     */
    public void setClientPassWord(String clientPass) {
        this.clientPassWord = clientPass;
    }

   
    
   
}
