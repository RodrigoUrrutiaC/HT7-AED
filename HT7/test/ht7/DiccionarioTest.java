/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht7;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Natito
 */
public class DiccionarioTest {
    
    public DiccionarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of llenarDiccionario method, of class Diccionario.
     */
    @Test
    public void testLlenarDiccionario() throws Exception {
        System.out.println("llenarDiccionario");
        Diccionario instance = new Diccionario();
        instance.llenarDiccionario();

    }

    /**
     * Test of insertarNodo method, of class Diccionario.
     */
    @Test
    public void testInsertarNodo() {
        System.out.println("insertarNodo");
        BinaryTree<Association<String, String>> padre = null;
        Association<String, String> dato = null;
        Diccionario instance = new Diccionario();
        instance.insertarNodo(padre, dato);

    }

    /**
     * Test of retornarDiccionario method, of class Diccionario.
     */
    @Test
    public void testRetornarDiccionario() {
        System.out.println("retornarDiccionario");
        Diccionario instance = new Diccionario();
        String expResult = "";
        String result = instance.retornarDiccionario();
        assertEquals(expResult, result);

    }

    /**
     * Test of imprimirArbol method, of class Diccionario.
     */
    @Test
    public void testImprimirArbol() {
        System.out.println("imprimirArbol");
        Diccionario instance = new Diccionario();
        instance.imprimirArbol();

    }

    /**
     * Test of traducirPalabra method, of class Diccionario.
     */
    @Test
    public void testTraducirPalabra() {
        System.out.println("traducirPalabra");
        BinaryTree<Association<String, String>> parent = null;
        String palabra = "";
        Diccionario instance = new Diccionario();
        String expResult = "";
        String result = instance.traducirPalabra(parent, palabra);
        assertEquals(expResult, result);

    }

    /**
     * Test of traducirOracion method, of class Diccionario.
     */
    @Test
    public void testTraducirOracion() throws Exception {
        System.out.println("traducirOracion");
        Diccionario instance = new Diccionario();
        instance.traducirOracion();

    }


    /**
     * Test of leerOracion method, of class Diccionario.
     */
    @Test
    public void testLeerOracion() throws Exception {
        System.out.println("leerOracion");
        Diccionario instance = new Diccionario();
        instance.leerOracion();

    }
    
}
