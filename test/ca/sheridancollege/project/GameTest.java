/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
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
public class GameTest {
    
    public GameTest() {
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
     * Test of getGameName method, of class Game.
     */
//    @Test
//    public void testGetGameName() {
//        System.out.println("getGameName");
//        Game instance = null;
//        String expResult = "";
//        String result = instance.getGameName();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getPlayers method, of class Game.
     */
    @Test
    public void testGetPlayersGood() {
        System.out.println("getPlayersGood");
        Player p1 = new Player("P1");
        Player p2 = new Player("P1");
        Game g = new Game("War");
        g.setPlayers(p1);
        g.setPlayers(p2);
        String expPlayerNameResult = g.getPlayers().get(1).getPlayerName();
        String playerNameResult = g.getPlayers().get(0).getPlayerName();
        assertEquals(expPlayerNameResult, playerNameResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetPlayersBad() {
        System.out.println("getPlayersBad");
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        Game g = new Game("War");
        g.setPlayers(p1);
        g.setPlayers(p2);
        String expPlayerNameResult = g.getPlayers().get(1).getPlayerName();
        String playerNameResult = g.getPlayers().get(0).getPlayerName();
        assertNotEquals(expPlayerNameResult, playerNameResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetPlayersBoundary() {
        System.out.println("getPlayersBoundary");
        Player p1 = new Player("P1");
        Player p2 = new Player("");
        Game g = new Game("War");
        g.setPlayers(p1);
        g.setPlayers(p2);
        String expPlayerNameResult = g.getPlayers().get(1).getPlayerName();
        String playerNameResult = g.getPlayers().get(0).getPlayerName();
        assertNotEquals(expPlayerNameResult, playerNameResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }    

    /**
     * Test of setPlayers method, of class Game.
     */
//    @Test
//    public void testSetPlayers() {
//        System.out.println("setPlayers");
//        Player p = null;
//        Game instance = null;
//        instance.setPlayers(p);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of play method, of class Game.
//     */
//    @Test
//    public void testPlay() throws Exception {
//        System.out.println("play");
//        Game instance = null;
//        instance.play();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of drawCard method, of class Game.
//     */
//    @Test
//    public void testDrawCard() throws Exception {
//        System.out.println("drawCard");
//        Game instance = null;
//        instance.drawCard();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of compareCard method, of class Game.
//     */
//    @Test
//    public void testCompareCard() throws Exception {
//        System.out.println("compareCard");
//        int drawCount = 0;
//        Game instance = null;
//        instance.compareCard(drawCount);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of declareWinner method, of class Game.
     */
    @Test
    public void testDeclareWinnerGood() {
        System.out.println("declareWinnerGood");
        int p1DeckSize = 52;
        int p2DeckSize = 0;
        String p1Resp = "d";
        String p2Resp = "d";
        Player p1 = new Player("P1");
        Game g = new Game("War");
        g.setPlayers(p1);
        Player p2 = new Player("P2");
        g.setPlayers(p2);
        String expResult = "P1 IS THE WINNER!!";
        String result = g.declareWinner(p1DeckSize, p2DeckSize, p1Resp, p2Resp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testDeclareWinnerBad() {
        System.out.println("declareWinnerBad");
        int p1DeckSize = 0;
        int p2DeckSize = 0;
        String p1Resp = "p";
        String p2Resp = "p";
        Player p1 = new Player("P1");
        Game g = new Game("War");
        g.setPlayers(p1);
        Player p2 = new Player("P2");
        g.setPlayers(p2);
        String expResult = "DRAW";
        String result = g.declareWinner(p1DeckSize, p2DeckSize, p1Resp, p2Resp);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testDeclareWinnerBoundary() {
        System.out.println("declareWinnerBoundary");
        int p1DeckSize = 27;
        int p2DeckSize = 23;
        String p1Resp = "q";
        String p2Resp = "m";
        Player p1 = new Player("P1");
        Game g = new Game("War");
        g.setPlayers(p1);
        Player p2 = new Player("P2");
        g.setPlayers(p2);
        String expResult = "P2 IS THE WINNER!!";
        String result = g.declareWinner(p1DeckSize, p2DeckSize, p1Resp, p2Resp);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
