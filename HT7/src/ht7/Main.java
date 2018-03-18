
package ht7;

import java.io.IOException;

/**
 * @author Rodrigo Urrutia 16139
 * @author Kevin Macario 17369
 * @version 18.03.2018
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Diccionario d = new Diccionario();
        
        System.out.println("Bienvenido al Diccionario. Se procesará la base de datos:");
        
        d.llenarDiccionario(); //Se llena el diccionario 
        System.out.print(d.retornarDiccionario()); //este es de prueba
        
        System.out.println();
        System.out.println("Asociaciones procesadas exitosamente.");
        System.out.println();
        
        System.out.println("Se despliega la información en el árbol IN-ORDER:");
        d.imprimirArbol();
        d.traducirOracion();
        
        
        
    }
  
}
