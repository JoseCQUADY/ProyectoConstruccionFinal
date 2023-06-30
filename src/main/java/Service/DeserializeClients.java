/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Client;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DeserializeClients {

    private static final File CLIENTSDATAFILE = new File("src\\main\\java\\Files\\clientesInformation.dat");
    private final static ArrayList<Client> clientList = new ArrayList<>();

    /**
     *
     * @return client list
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Client> deserializeClients() throws FileNotFoundException, IOException, ClassNotFoundException {

        if (CLIENTSDATAFILE.exists()) {
            ObjectInputStream objectInputData = new ObjectInputStream(new FileInputStream(CLIENTSDATAFILE));
            while (true) {
                
                 try {
                        Client userClient = (Client) objectInputData.readObject();
                        clientList.add(userClient);
                    } catch (EOFException e) {
                        break; 
                    }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Not customer information found");
        }

        return clientList;
    }
}
