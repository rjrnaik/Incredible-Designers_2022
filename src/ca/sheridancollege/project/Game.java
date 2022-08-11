/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models the war game. It contains the methods like play(),
 * drawCard(), compareCard() and declareWinner().
 *
 * @author Rajrishi Naik
 * @author Jaskaran Singh
 */
public class Game {
    
    private final String gameName;//the title of the game
    private static ArrayList<Player> players;// the players of the game
    public static int drawCount = 0;
    
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
     * @param p
     */
    public void setPlayers(Player p) {
        players.add(p);
    }

    /**
     * Play the game.This might be one method or many method calls depending on
     * your game.
     *
     * @throws java.lang.InterruptedException
     */
    public void play() throws InterruptedException {
        
        GroupOfCards goc = new GroupOfCards(52);
        Thread.sleep(250);
        goc.generateDeck();
        Thread.sleep(250);
        drawCard();
    }
    
    public void drawCard() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String p1Resp;
        String p2Resp;
        System.out.println("-------------------------------------");
        while (drawCount < 10) {
            try {
                System.out.println("\n" + players.get(0).getPlayerName() + "'s turn: \nEnter d to drawCard");
                p1Resp = sc.next();
                System.out.println(players.get(1).getPlayerName() + "'s turn: \nEnter d to drawCard");
                p2Resp = sc.next();
                if (p1Resp.equalsIgnoreCase("q")) {
                    System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), p1Resp, p2Resp));
                    System.exit(0);
                } else if (p2Resp.equalsIgnoreCase("q")) {
                    System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), p1Resp, p2Resp));
                    System.exit(0);
                } else if (!p1Resp.equalsIgnoreCase("d") || !p2Resp.equalsIgnoreCase("d")) {
                    System.out.println("Please enter d to draw card!!");
                } else {
                    compareCard(0);
                    drawCount++;
                }
                
            } catch (IndexOutOfBoundsException iob) {
                iob.getMessage();
            }
        }
        System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
    }
    
    public void compareCard(int drawCount) throws InterruptedException {
        if (GroupOfCards.player1Deck.isEmpty() || GroupOfCards.player2Deck.isEmpty()) {
            System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
            System.exit(0);
        } else {
            if (GroupOfCards.player1Deck.get(drawCount).getRankValue() > GroupOfCards.player2Deck.get(drawCount).getRankValue()) {
                System.out.println(players.get(0).getPlayerName() + " drew " + GroupOfCards.player1Deck.get(drawCount).getRank() + " of " + GroupOfCards.player1Deck.get(drawCount).getSuite());
                System.out.println(players.get(1).getPlayerName() + " drew " + GroupOfCards.player2Deck.get(drawCount).getRank() + " of " + GroupOfCards.player2Deck.get(drawCount).getSuite());
                GroupOfCards.player1Deck.add(GroupOfCards.player1Deck.get(drawCount));
                GroupOfCards.player1Deck.add(GroupOfCards.player2Deck.get(drawCount));
                GroupOfCards.player1Deck.remove(drawCount);
                GroupOfCards.player2Deck.remove(drawCount);
                System.out.println(players.get(0).getPlayerName() + " wins the round!!");
                System.out.println(players.get(0).getPlayerName() + "'s deck size:" + GroupOfCards.player1Deck.size());
                System.out.println(players.get(1).getPlayerName() + "'s deck size:" + GroupOfCards.player2Deck.size());
                //System.out.println("Drawcount: " + Game.drawCount);
                System.out.println("=================================================");
                Thread.sleep(250);
            } else if (GroupOfCards.player1Deck.get(drawCount).getRankValue() < GroupOfCards.player2Deck.get(drawCount).getRankValue()) {
                System.out.println(players.get(0).getPlayerName() + " drew " + GroupOfCards.player1Deck.get(drawCount).getRank() + " of " + GroupOfCards.player1Deck.get(drawCount).getSuite());
                System.out.println(players.get(1).getPlayerName() + " drew " + GroupOfCards.player2Deck.get(drawCount).getRank() + " of " + GroupOfCards.player2Deck.get(drawCount).getSuite());
                GroupOfCards.player2Deck.add(GroupOfCards.player2Deck.get(drawCount));
                GroupOfCards.player2Deck.add(GroupOfCards.player1Deck.get(drawCount));
                GroupOfCards.player2Deck.remove(drawCount);
                GroupOfCards.player1Deck.remove(drawCount);
                System.out.println(players.get(1).getPlayerName() + " wins the round!!");
                System.out.println(players.get(0).getPlayerName() + "'s deck size:" + GroupOfCards.player1Deck.size());
                System.out.println(players.get(1).getPlayerName() + "'s deck size:" + GroupOfCards.player2Deck.size());
                //System.out.println("Drawcount: " + Game.drawCount);
                System.out.println("=================================================");
                Thread.sleep(250);
            } else if (GroupOfCards.player1Deck.get(drawCount).getRankValue() == GroupOfCards.player2Deck.get(drawCount).getRankValue()) {
                System.out.println(players.get(0).getPlayerName() + " drew " + GroupOfCards.player1Deck.get(drawCount).getRank() + " of " + GroupOfCards.player1Deck.get(drawCount).getSuite());
                System.out.println(players.get(1).getPlayerName() + " drew " + GroupOfCards.player2Deck.get(drawCount).getRank() + " of " + GroupOfCards.player2Deck.get(drawCount).getSuite());
                System.out.println("War mode initiated");
                GroupOfCards.player1Deck.add(GroupOfCards.player1Deck.get(drawCount));
                GroupOfCards.player1Deck.remove(drawCount);
                GroupOfCards.player2Deck.add(GroupOfCards.player2Deck.get(drawCount));
                GroupOfCards.player2Deck.remove(drawCount);
                System.out.println("This round is a draw!!");
                System.out.println(players.get(0).getPlayerName() + "'s deck size:" + GroupOfCards.player1Deck.size());
                System.out.println(players.get(1).getPlayerName() + "'s deck size:" + GroupOfCards.player2Deck.size());
                
                System.out.println("=================================================");
                Thread.sleep(250);
                if (GroupOfCards.player1Deck.size() <= 4 || GroupOfCards.player2Deck.size() <= 4) {
                    System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
                    System.exit(0);
                } else if (Game.drawCount == 9) {
                    System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
                    System.exit(0);
                } else {
                    War w = new War("War");       //Functionality unused due to change in the requrements
                    w.compareCard(0);
//                }
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
            return players.get(0).getPlayerName().toUpperCase() + " IS THE WINNER!!";
        } else if (GroupOfCards.player2Deck.size() == 52) {
            return players.get(1).getPlayerName().toUpperCase() + " IS THE WINNER!!";
        } else if (p1DeckSize < 4) {
            return players.get(1).getPlayerName().toUpperCase() + " IS THE WINNER!!";
        } else if (p2DeckSize < 4) {
            return players.get(0).getPlayerName().toUpperCase() + " IS THE WINNER!!";
        } else if (GroupOfCards.player1Deck.size() > GroupOfCards.player2Deck.size()) {
            return players.get(0).getPlayerName().toUpperCase() + " IS THE WINNER!!";
        } else if (GroupOfCards.player1Deck.size() < GroupOfCards.player2Deck.size()) {
            return players.get(1).getPlayerName().toUpperCase() + " IS THE WINNER!!";
        } else if (p1Resp.equalsIgnoreCase("q") && p2Resp.equalsIgnoreCase("q")) {
            return "Both Players quit, NO RESULT";
        } else if (p1Resp.equalsIgnoreCase("q")) {
            return players.get(0).getPlayerName().toUpperCase() + " quit, " + players.get(1).getPlayerName().toUpperCase() + " IS THE WINNER!!";
        } else if (p2Resp.equalsIgnoreCase("q")) {
            return players.get(1).getPlayerName().toUpperCase() + " quit, " + players.get(0).getPlayerName().toUpperCase() + " IS THE WINNER!!";
        }
        return "DRAW!!!";
    }
    
}//end class
