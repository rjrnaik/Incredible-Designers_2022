/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rjrna
 */
public class CardTest {
    
    public CardTest() {
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
     * Test of getSuite method, of class Card.
     */
//    @Test
//    public void testGetSuite() {
//        System.out.println("getSuite");
//        Card instance = null;
//        Card.Suite expResult = null;
//        Card.Suite result = instance.getSuite();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setSuite method, of class Card.
     */
//    @Test
//    public void testSetSuite() {
//        System.out.println("setSuite");
//        Card.Suite suite = null;
//        Card instance = null;
//        instance.setSuite(suite);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getRank method, of class Card.
     */
//    @Test
//    public void testGetRank() {
//        System.out.println("getRank");
//        Card instance = null;
//        Card.Rank expResult = null;
//        Card.Rank result = instance.getRank();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setRank method, of class Card.
     */
//    @Test
//    public void testSetRank() {
//        System.out.println("setRank");
//        Card.Rank rank = null;
//        Card instance = null;
//        instance.setRank(rank);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getRankValue method, of class Card.
     */
    @Test
    public void testGetRankValueGood() {
        System.out.println("getRankValueGood");
        Card c = new Card(Card.Suite.CLUBS, Card.Rank.JACK);
        int expResult = 11;
        int result = c.getRankValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetRankValueBad() {
        System.out.println("getRankValueBad");
        Card c = new Card(Card.Suite.HEARTS, Card.Rank.ACE);
        int expResult = 1;
        int result = c.getRankValue();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetRankValueBoundary() {
        System.out.println("getRankValueBoundary");
        Card c = new Card(Card.Suite.HEARTS, Card.Rank.ACE);
        int expResult = -1;
        int result = c.getRankValue();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
