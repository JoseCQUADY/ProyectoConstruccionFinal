package Serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Subclase de ObjectOutputStream (superclase/libreria)
 * Creada para poder modificar los métodos de la clase que hereda
 * 
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
 */
public class MyObjectOutputStream extends ObjectOutputStream {

    /**
     * Método heredado propio de la subclase (modificado)
     * 
     * @throws IOException
     */
    public MyObjectOutputStream() throws IOException{
        super();
    }
    
    /**
     * Método heredado propio de la subclase (modificado)
     * Método para sobreescribir en el serializado de los objetos
     * @param out
     * @throws IOException
     */
    public MyObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }
    
    /**
     * Método heredado de la superclase (modificado)
     * Método de la clase extendida ObjectOutputStream que crea una nueva cabecera con nuevo objeto
     * Modificado para no crear una nueva cabecera 
     * Utilizando siempre la misma cabecera para guardar los nuevos objetos
     * 
     * @throws IOException
     */
    @Override
    protected void writeStreamHeader() throws IOException{
        
    }
}
