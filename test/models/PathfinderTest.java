/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lalleaul
 */
public class PathfinderTest {
    private ArrayList<Coordonnees>list;
    public PathfinderTest() {
        this.list=new ArrayList<>();
        this.list.add(new Coordonnees(1,1));
        this.list.add(new Coordonnees(1,2));
        this.list.add(new Coordonnees(1,3));
        this.list.add(new Coordonnees(1,4));
        this.list.add(new Coordonnees(2,3));
        this.list.add(new Coordonnees(2,4));
        this.list.add(new Coordonnees(3,4));
        this.list.add(new Coordonnees(4,1));
        this.list.add(new Coordonnees(4,2));
        this.list.add(new Coordonnees(4,3));
        this.list.add(new Coordonnees(4,4));
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
     * Test of theWayFromTo method, of class Pathfinder.
     */
    @Test
    public void testTheWayFromTo() {
        Coordonnees depart = null;
        Coordonnees arrivee = null;
        Pathfinder instance = new Pathfinder();
        ArrayList<Coordonnees> expResult = null;
        //ArrayList<Coordonnees> result = instance.theWayFromTo(depart, arrivee);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
