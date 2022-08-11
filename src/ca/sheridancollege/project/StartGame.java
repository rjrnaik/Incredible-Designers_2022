/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *Starter code for the GAME
 * Asks players for their names
 * @author RajrishiNaik
 */
public class StartGame {

    /**
     * Main Class to initiate the game and ask the players their names
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Game g1 = new Game("War");
            Scanner scan1 = new Scanner(System.in);
            System.out.println("==========================================================================================================================================");
            Thread.sleep(500);
            System.out.println("==========================================================================================================================================");
            Thread.sleep(500);
            System.out.println("==========================================================================================================================================");
            Thread.sleep(500);
            System.out.println("===================PLAYER MENU============================================================================================================");
            System.out.println("Enter Player1 name:");
            String name1 = scan1.next();
            Player p1 = new Player(name1);
            g1.setPlayers(p1);
            System.out.println("Enter Player2 name:");
            String name2 = scan1.next();
            Player p2 = new Player(name2);
            g1.setPlayers(p2);
            System.out.println("==========================================================================================================================================");
            Thread.sleep(500);
            System.out.println("==========================================================================================================================================");
            Thread.sleep(500);
            System.out.println("==========================================================================================================================================");
            Thread.sleep(500);
            System.out.println("===================INITIATING GAME========================================================================================================");
            System.out.println("The two players are: " + g1.getPlayers().get(0).getPlayerName() + " & " + g1.getPlayers().get(1).getPlayerName());
            System.out.println(g1.getGameName() + " game started!!");
            Thread.sleep(500);
            g1.play();// delegation satisfied //game initiated
        } catch (InterruptedException ie) {
            ie.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
