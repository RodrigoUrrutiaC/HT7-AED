
package ht7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Rodrigo Urrutia 16139
 * @author Kevin Macario 17369
 * @version 18.03.2018
 */

public class Diccionario {
    
    ArrayList<Association<String,String>> asociaciones;
    
    FileReader fr = null;
    BufferedReader br = null;
    BinaryTree<Association<String,String>> raiz;
    ArrayList <String> oracion = new ArrayList<>();
    
    public Diccionario(){
        asociaciones= new ArrayList<>();
        raiz = new BinaryTree<>(null, null, null, null);
    }
    
    public void llenarDiccionario() throws FileNotFoundException, IOException{
        ArrayList<String> palabras= new ArrayList<>();

        fr = new FileReader("diccionario.txt");
        br = new BufferedReader(fr);

        String linea;

        while((linea=br.readLine())!=null){
            palabras.add(linea);
        }

        for(int i=0; i<palabras.size()-1;i++){
            //se separan las palabras
                int lugar=palabras.get(i).indexOf(',');
                String ingles=palabras.get(i).substring(1,lugar);
                String espaniol=palabras.get(i).substring(lugar+1,palabras.get(i).length()-1);
                //asociaciones agregadas
                asociaciones.add(new Association(ingles, espaniol));
        }
        
        raiz.setValue(asociaciones.get(0));
        for (int i=1; i<asociaciones.size(); i++){
            insertarNodo(raiz, asociaciones.get(i));     
        }
    } //se llena el diccionario
    
    // llenar Diccionario inserta los nodos correspondientes al arbol 
    public void insertarNodo(BinaryTree<Association<String,String>> padre, Association<String,String> dato){
        Association<String,String> asociacion=padre.value();
        String llavePadre=asociacion.getKey();
        String llaveDato=dato.getKey();
        //se insertan los datos comparandolos con cada padre
        int num=llavePadre.compareToIgnoreCase(llaveDato);
        //Si el padre es mayor, se inserta a la izquierda
        if(num>0 && padre.left()==null){
            padre.setLeft(new BinaryTree<>(null, null, null,null));
            padre.left().setValue(dato);
        }else if(padre.left()!=null){
            insertarNodo(padre.left(),dato);
        }
        //Si el padre es menor, se inserta a la derecha
        if(num<0 && padre.right()==null){
            padre.setRight(new BinaryTree<>(null, null, null,null));
            padre.right().setValue(dato);
        }else if(padre.right()!=null){
            //Insercion a la derecha
            insertarNodo(padre.right(),dato);
        }
    }
    
    public String retornarDiccionario(){
        return asociaciones.toString();
    }
    
    //Trabaja en conjunto con Imprimir Arbol para recorrerlo IN-ORDER
    public void imprimirArbol() {
        imprimirArbol(raiz);
    }
   
//    Imprimir el contenido del arbol IN-ORDER
    public void imprimirArbol(BinaryTree<Association<String,String>> arbol){
        if(arbol.left() != null){
            imprimirArbol(arbol.left());
            System.out.println(arbol.left().value().getKey()+",");
        }
        if(arbol.right() != null){
            imprimirArbol(arbol.right());
            System.out.println(arbol.right().value().getKey()+",");
        }
        System.out.println(arbol.value().getKey()+",");
    }
   
    //LOS SIGUIENTES TRES METODOS FUNCIONAN JUNTOS PARA TRADUCIR LA ORACION
    public String traducirPalabra(BinaryTree<Association<String,String>> parent, String palabra){
        String palabraTraducida = "";
        Association<String,String> asociacion = parent.value();
        String parentKey = asociacion.getKey();
        int n = parentKey.compareToIgnoreCase(palabra);
        if(n==0){
            palabraTraducida = parent.value().getValue();
        }
        if(n<0){
            if(parent.right()!=null){
                palabraTraducida = traducirPalabra(parent.right(),palabra);
            }else{
                return("*"+palabra+"*");
            }
        }
        if(n>0){
            if(parent.left()!=null){
                palabraTraducida = traducirPalabra(parent.left(),palabra);
            }else{
                return("*"+palabra+"*");
            }
        }
        return palabraTraducida;
    }
    
    public void traducirOracion() throws IOException{
        leerOracion();
        String resultado ="";
        for(int i=0; i<oracion.size();i++){
            resultado+=traducirPalabra(raiz,oracion.get(i).trim())+"";
        }
        System.out.println(resultado);
    }
    
    public void leerOracion() throws FileNotFoundException, IOException{
        
        String palabras="";

        fr = new FileReader("texto.txt");
        br = new BufferedReader(fr);

        String linea;

        while((linea=br.readLine())!=null){
             palabras=linea;
        }    
        while(palabras.compareTo("")!=0){
	int lugar=palabras.indexOf(' ');
            if(lugar!=-1){
                    oracion.add(palabras.substring(0,lugar));
                    palabras=palabras.substring(lugar+1);
            }else{
                    oracion.add(palabras);
                    palabras="";
            }
        }
    }
    
}