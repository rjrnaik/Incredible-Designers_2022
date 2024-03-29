/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *@author Siddhartha Reddy
 */
public class Player {

    private String playerName; //the unique ID for this player

    /**
     *@param playerName String
     */
    
    public Player(String playerName){
        this.playerName = playerName;
    }
    
    public Player(){
      this("Default")  ;
    }
    
    public String getPlayerName() {
        return this.playerName;
    }
}
