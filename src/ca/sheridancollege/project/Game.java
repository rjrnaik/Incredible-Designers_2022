/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author Rajrishi Naik
 */
public class Game {

    private final String gameName;//the title of the game
    private static ArrayList<Player> players;// the players of the game

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
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(Player p) {
        players.add(p);
    }

    /**
     * Play the game. This might be one method or many method calls depending on
     * your game.
     */
    public void play() {

        GroupOfCards goc = new GroupOfCards(52);
        goc.generateDeck();
        //while (true) {
        drawCard();
        //}
    }

    public void drawCard() {
        //GroupOfCards goc = new GroupOfCards(52);
        Scanner sc = new Scanner(System.in);
        String p1Resp = "d";
        String p2Resp = "d";
        int drawCount = 0;
        boolean quitGame = false;
        System.out.println("-------------------------------------");
        while (!quitGame) {
            System.out.println("\nPlayer 1's turn: \nEnter d to drawCard");
            p1Resp = sc.next();
            System.out.println("Player 2's turn: \nEnter d to drawCard");
            p2Resp = sc.next();
            if (p1Resp.equalsIgnoreCase("q")) {
                quitGame = true;
                System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), p1Resp, p2Resp));
            } else if (p2Resp.equalsIgnoreCase("q")) {
                quitGame = true;
                System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), p1Resp, p2Resp));
            } else {
                if (!GroupOfCards.player1Deck.isEmpty() || !GroupOfCards.player2Deck.isEmpty()) {
                    if (drawCount > 25) {
                        drawCount = 0;
                        Collections.shuffle(GroupOfCards.player1Deck);
                        Collections.shuffle(GroupOfCards.player1Deck);
                    }
                    compareCard(0);
                } else {
                    break;
                }
            }
            drawCount++;
        }
        //System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), p1Resp, p2Resp));
        sc.close();
    }

    public void compareCard(int drawCount) {
        if (GroupOfCards.player1Deck.isEmpty() || GroupOfCards.player2Deck.isEmpty()) {
            System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
            System.exit(0);
        } else {
            if (GroupOfCards.player1Deck.get(drawCount).getRankValue() > GroupOfCards.player2Deck.get(drawCount).getRankValue()) {
                System.out.println("drawCount:" + drawCount);
                System.out.println("Player1 drew " + GroupOfCards.player1Deck.get(drawCount).getRank() + " of " + GroupOfCards.player1Deck.get(drawCount).getSuite());
                System.out.println("Player2 drew " + GroupOfCards.player2Deck.get(drawCount).getRank() + " of " + GroupOfCards.player2Deck.get(drawCount).getSuite());
                GroupOfCards.player1Deck.add(GroupOfCards.player1Deck.get(drawCount));
                GroupOfCards.player1Deck.add(GroupOfCards.player2Deck.get(drawCount));
                GroupOfCards.player1Deck.remove(drawCount);
                GroupOfCards.player2Deck.remove(drawCount);
                System.out.println("Player1 wins the round!!");
                System.out.println("Player1 deck size:" + GroupOfCards.player1Deck.size());
                System.out.println("Player2 deck size:" + GroupOfCards.player2Deck.size());
            } else if (GroupOfCards.player1Deck.get(drawCount).getRankValue() < GroupOfCards.player2Deck.get(drawCount).getRankValue()) {
                System.out.println("drawCount:" + drawCount);
                System.out.println("Player1 drew " + GroupOfCards.player1Deck.get(drawCount).getRank() + " of " + GroupOfCards.player1Deck.get(drawCount).getSuite());
                System.out.println("Player2 drew " + GroupOfCards.player2Deck.get(drawCount).getRank() + " of " + GroupOfCards.player2Deck.get(drawCount).getSuite());
                GroupOfCards.player2Deck.add(GroupOfCards.player2Deck.get(drawCount));
                GroupOfCards.player2Deck.add(GroupOfCards.player1Deck.get(drawCount));
                GroupOfCards.player2Deck.remove(drawCount);
                GroupOfCards.player1Deck.remove(drawCount);
                System.out.println("Player2 wins the round!!");
                System.out.println("Player1 deck size:" + GroupOfCards.player1Deck.size());
                System.out.println("Player2 deck size:" + GroupOfCards.player2Deck.size());
            } else if (GroupOfCards.player1Deck.get(drawCount).getRankValue() == GroupOfCards.player2Deck.get(drawCount).getRankValue()) {
                System.out.println("drawCount:" + drawCount);
                System.out.println("Player1 drew " + GroupOfCards.player1Deck.get(drawCount).getRank() + " of " + GroupOfCards.player1Deck.get(drawCount).getSuite());
                System.out.println("Player2 drew " + GroupOfCards.player2Deck.get(drawCount).getRank() + " of " + GroupOfCards.player2Deck.get(drawCount).getSuite());
                System.out.println("War mode initiated");
                if (GroupOfCards.player1Deck.size() <= 4 || GroupOfCards.player2Deck.size() <= 4) {
                    System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
                    System.exit(0);
                } else {
                    War w = new War("War");
                    w.compareCard();
                }
            }
        }
    }

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     *
     * @param p1DeckSize
     * @param p2DeckSize
     * @param p1Resp
     * @param p2Resp
     * @return
     */
    public String declareWinner(int p1DeckSize, int p2DeckSize, String p1Resp, String p2Resp) {
        if (GroupOfCards.player1Deck.size() == 52) {
            return "Player1 is the winner!!";
        } else if (GroupOfCards.player2Deck.size() == 52) {
            return "Player2 is the winner!!";
        } else if (p1DeckSize < 4) {
           return "Player2 is the winner!!";
        } else if (p2DeckSize < 4) {
            return "Player1 is the winner!!";
        } else if (GroupOfCards.player1Deck.size() > GroupOfCards.player2Deck.size()) {
            return "Player1 is the winner!!";
       } else if (GroupOfCards.player1Deck.size() < GroupOfCards.player2Deck.size()) {
           return "Player2 is the winner!!";
        } else if (p1Resp.equalsIgnoreCase("q")) {
            return "Player1 Quit...Player2 is the winner!!";
        } else if (p2Resp.equalsIgnoreCase("q")) {
            return "Player2 Quit...Player1 is the winner!!";
        }
        return "No Result";
    }

}//end class
