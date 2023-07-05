package Serializable;

import Model.Account;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DeserializeAccounts {

    /**
     * Método para deserializar el archivo .dat que representa la base de datos
     * Devuelve una lista desearilizada con los datos de las cuentas registradas
     * 
     * @return client list
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Account> deserializeAccounts() throws FileNotFoundException, IOException, ClassNotFoundException {
        File ACCOUNTSDATAFILE = new File("src\\main\\java\\Files\\accountsInfomation.dat");
        ArrayList<Account> accountList = new ArrayList<>();
        if (ACCOUNTSDATAFILE.exists()) {
            ObjectInputStream objectInputData = new ObjectInputStream(new FileInputStream(ACCOUNTSDATAFILE));
            while (true) {

                try {
                    Account accountType = (Account) objectInputData.readObject();
                    accountList.add(accountType);
                } catch (EOFException e) {
                    break;
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Not account information found");
        }

        return accountList;
    }

}
