package Model;

import Model.Client;
import Model.MyObjectOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeClients {

    private static final File CLIENTSDATAFILE = new File("clientsInformation.dat");
    
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
