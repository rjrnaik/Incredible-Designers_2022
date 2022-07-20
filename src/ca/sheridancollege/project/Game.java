/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye, 2018
 */
public class Game {

    private final String gameName;//the title of the game
    private ArrayList<Player> players;// the players of the game

    public Game(String givenName) {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter Player1 name:");
        String name1 = scan1.next();
        System.out.println("Enter Player2 name:");
        String name2 = scan1.next();
        Player p1 = new Player(name1);
        Player p2 = new Player(name2);
        players.add(p1);
        players.add(p2);
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on
     * your game.
     */
    
    public void play() {
        
        GroupOfCards goc = new GroupOfCards(52);
        goc.generateDeck();
        drawCard();
    }
    
    public void drawCard(){
        
    }

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public void declareWinner() {

    }

}//end class
