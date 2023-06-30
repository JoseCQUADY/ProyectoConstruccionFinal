package Service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class MyObjectOutputStream extends ObjectOutputStream {
   
    /**
     * Método de la clase extendida ObjectOutputStream que crea una nueva cabecera con nuevo objeto
     * Modificado para no crear una nueva cabecera 
     * Utilizando siempre la misma cabecera para guardar los nuevos objetos
     * 
     * @throws IOException
     */
    @Override
    protected void writeStreamHeader() throws IOException{
        
    }

    /**
     *
     * @throws IOException
     */
    public MyObjectOutputStream() throws IOException{
        super();
    }
    
    /**
     * Método para sobreescribir en el serializado de los objetos
     * @throws IOException
     */
    public MyObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }
    
}
