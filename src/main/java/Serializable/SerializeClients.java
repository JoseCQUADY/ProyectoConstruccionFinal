package Serializable;

import Model.Client;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeClients {

    /**
     * Constante con la dirección el archivo .dat que representa la base de datos
     */
    private static final File CLIENTSDATAFILE = new File("src\\main\\java\\Files\\clientesInformation.dat");
    
    /**
     * Método para serializar el archivo .dat que representa la base de datos
     * Recibe un objeto (cliente), el cual serializa y guarda en la base de datos
     * 
     * @param client
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void serializeClients(Client client) throws FileNotFoundException, IOException {
        
        ObjectOutputStream ObjectOutput;
        
        if (CLIENTSDATAFILE.length() == 0) {
            ObjectOutput = new ObjectOutputStream(new FileOutputStream(CLIENTSDATAFILE));
            
        } else {
            ObjectOutput = new MyObjectOutputStream(new FileOutputStream(CLIENTSDATAFILE, true));
           
        }
        ObjectOutput.writeObject(client);
        ObjectOutput.close();
        
    }

}

