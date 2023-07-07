package Serializable;

import Model.Account;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase donde se encuentra los métodos para serializar y guardar los datos de las cuentas
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
 */
public class SerializeAccounts {

    /**
     * Constante con la dirección el archivo .dat que representa la base de datos
     */
    private static final File ACCOUNTSDATAFILE = new File("src\\main\\java\\Files\\accountsInfomation.dat");

    /**
     * Método para serializar el archivo .dat que representa la base de datos
     * Recibe un objeto (cuenta), el cual serializa y guarda en la base de datos
     * 
     * @param account
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void serializeAccounts(Account account) throws FileNotFoundException, IOException {
        ObjectOutputStream ObjectOutput;

        if (ACCOUNTSDATAFILE.length() == 0) {
            ObjectOutput = new ObjectOutputStream(new FileOutputStream(ACCOUNTSDATAFILE));
        } else {
            ObjectOutput = new MyObjectOutputStream(new FileOutputStream(ACCOUNTSDATAFILE, true));
        }
        
        ObjectOutput.writeObject(account);
        ObjectOutput.close();
    }

    /**
     *
     * @param accountList
     * @throws IOException
     */
    public static void serializeAccountsList(ArrayList<Account> accountList) throws IOException {
        ObjectOutputStream objectOutput;
        objectOutput = new ObjectOutputStream(new FileOutputStream(ACCOUNTSDATAFILE));
        for (Account account : accountList) {
            objectOutput.writeObject(account);
        }
        objectOutput.close();
    }
    
    /**
     *
     * @param modifiedAccount
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void modifyAccount(Account modifiedAccount) throws IOException, ClassNotFoundException {
        ArrayList<Account> accountList = DeserializeAccounts.deserializeAccounts();

        boolean modified = false;

        for (int i = 0; i < accountList.size(); i++) {
            Account account = accountList.get(i);

            if (account.getIdAccount() == modifiedAccount.getIdAccount()) {
                accountList.set(i, modifiedAccount);
                modified = true;
                break;
            }
        }

        if (modified) {
            serializeAccountsList(accountList);
            JOptionPane.showMessageDialog(null, "Account modified successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Account not found");
        }
    }

    /**
     * Método para eliminar una cuenta especifica, seleccionada por el clientes
     * Remueve un elemento del archivo .dat mediante una lista que se modifica
     * 
     * @param accountToRemove
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void removeAccount(Account accountToRemove) throws IOException, ClassNotFoundException {
        ArrayList<Account> accountList = DeserializeAccounts.deserializeAccounts();
        accountList.removeIf(account -> account.getIdAccount() == accountToRemove.getIdAccount());

        ObjectOutputStream objectOutputData;
        objectOutputData = new ObjectOutputStream(new FileOutputStream(ACCOUNTSDATAFILE));
        
        for (Account account : accountList) {
            objectOutputData.writeObject(account);
        }
        
        objectOutputData.close();
        JOptionPane.showMessageDialog(null, "Account removed successfully");
    }
}
