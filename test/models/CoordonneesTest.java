/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Louis
 */
public class CoordonneesTest {
    private final Coordonnees coord;
    private static Coordonnees autre;
    public CoordonneesTest() {
        coord = new Coordonnees(3,5);
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Début de test unitiare pour la classe Coordonnees");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin de test unitiare pour la classe Coordonnees");
    }
    @Before
    public void setUp(){
        autre= new Coordonnees(3,4);
    }
    @After
    public void tearDown(){
        autre=null;
    }

    /**
     * Test of getX method, of class Coordonnees.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        assertEquals(3, coord.getX());
        Coordonnees newCoord = new Coordonnees(7,5);
        assertEquals(7, newCoord.getX());
    }

    /**
     * Test of getY method, of class Coordonnees.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        assertEquals(5, coord.getY());
        Coordonnees newCoord = new Coordonnees(7,5);
        assertEquals(5, newCoord.getY());
    }

    /**
     * Test of toString method, of class Coordonnees.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("[3, 5]",coord.toString());
        autre=new Coordonnees(8,9);
        assertEquals("[8, 9]",autre.toString());
    }

    /**
     * Test of equals method, of class Coordonnees.
     */
    @Test
    public void testEquals_Object_False() {
        System.out.println("equals(obj : Object) FALSE");
        assertFalse(coord.equals("autre"));
    }
    @Test
    public void testEquals_Object_True() {
        System.out.println("equals(obj : Object) TRUE");
        assertTrue(coord.equals(coord));
    }

    /**
     * Test of equals method, of class Coordonnees.
     */
    @Test
    public void testEquals_Coordonnees_False() {
        System.out.println("equals(coord : Coordonnees) FALSE");
        assertFalse(coord.equals(autre));
    }
    @Test
    public void testEquals_Coordonnees_True() {
        System.out.println("equals(coord : Coordonnees) TRUE");
        assertTrue(coord.equals(coord));
    }

    /**
     * Test of estCoteACote method, of class Coordonnees.
     */
    @Test
    public void testEstCoteACote_False() {
        System.out.println("estCoteACote FALSE");
        assertFalse(coord.estCoteACote(coord));
        assertFalse(coord.estCoteACote(new Coordonnees(99,99)));
    }
    @Test
    public void testEstCoteACote_True_Xplus1() {
        System.out.println("estCoteACote TRUE X+1");
        assertTrue(coord.estCoteACote(new Coordonnees(coord.getX()+1,coord.getY())));
    }
    @Test
    public void testEstCoteACote_True_Xmoins1() {
        System.out.println("estCoteACote TRUE X-1");
        assertTrue(coord.estCoteACote(new Coordonnees(coord.getX()-1,coord.getY())));
    }
    @Test
    public void testEstCoteACote_True_Yplus1() {
        System.out.println("estCoteACote TRUE Y+1");
        assertTrue(coord.estCoteACote(new Coordonnees(coord.getX(),coord.getY()+1)));
    }
    public void testEstCoteACote_True_Ymois1() {
        System.out.println("estCoteACote TRUE y-1");
        assertTrue(coord.estCoteACote(new Coordonnees(coord.getX(),coord.getY()-1)));
    }
    
}
