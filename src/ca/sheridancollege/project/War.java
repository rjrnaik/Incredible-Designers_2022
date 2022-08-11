/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

//import java.util.Collections;

/**
 * WAR class is used to handle war level when Card Rank Values are same
 *
 * @author Siddhartha Reddy
 */
public class War extends Game {

    public War(String givenName) {
        super(givenName);
    }

    @Override
    public void compareCard(int drawCount) throws InterruptedException {
        if (GroupOfCards.player1Deck.get(drawCount + 3).getRankValue() > GroupOfCards.player2Deck.get(drawCount + 3).getRankValue()) {
            System.out.println("War mode drew = " + GroupOfCards.player1Deck.get(3).getRank() + " of " + GroupOfCards.player1Deck.get(3).getSuite());
            System.out.println("War mode drew = " + GroupOfCards.player2Deck.get(3).getRank() + " of " + GroupOfCards.player2Deck.get(3).getSuite());
            if (GroupOfCards.player1Deck.size() <= 4 || GroupOfCards.player2Deck.size() <= 4) {
                System.out.println(super.declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
                System.exit(0);
            } else if (Game.drawCount == 9) {
                System.out.println(super.declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
                System.exit(0);
            } else {
                GroupOfCards.player1Deck.add(GroupOfCards.player2Deck.get(0));
                GroupOfCards.player1Deck.add(GroupOfCards.player2Deck.get(1));
                GroupOfCards.player1Deck.add(GroupOfCards.player2Deck.get(2));
                GroupOfCards.player1Deck.add(GroupOfCards.player2Deck.get(3));
                GroupOfCards.player1Deck.add(GroupOfCards.player1Deck.get(0));
                GroupOfCards.player1Deck.add(GroupOfCards.player1Deck.get(1));
                GroupOfCards.player1Deck.add(GroupOfCards.player1Deck.get(2));
                GroupOfCards.player1Deck.add(GroupOfCards.player1Deck.get(3));
                GroupOfCards.player1Deck.remove(0);
                GroupOfCards.player1Deck.remove(1);
                GroupOfCards.player1Deck.remove(2);
                GroupOfCards.player1Deck.remove(3);
                GroupOfCards.player2Deck.remove(0);
                GroupOfCards.player2Deck.remove(1);
                GroupOfCards.player2Deck.remove(2);
                GroupOfCards.player2Deck.remove(3);
                System.out.println("Player1 deck size:" + GroupOfCards.player1Deck.size());
                System.out.println("Player2 deck size:" + GroupOfCards.player2Deck.size());
                Game.drawCount++;
                //System.out.println("Drawcount: " + Game.drawCount);
                System.out.println("=================================================");
                //Thread.sleep(250);
                System.out.println(declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
//                System.out.println("Shuffling the decks...");
//                Collections.shuffle(GroupOfCards.player1Deck);
//                Collections.shuffle(GroupOfCards.player2Deck);
            }
        } else if (GroupOfCards.player1Deck.get(drawCount + 3).getRankValue() < GroupOfCards.player2Deck.get(drawCount + 3).getRankValue()) {
            System.out.println("War mode drew = " + GroupOfCards.player1Deck.get(3).getRank() + " of " + GroupOfCards.player1Deck.get(3).getSuite());
            System.out.println("War mode drew = " + GroupOfCards.player2Deck.get(3).getRank() + " of " + GroupOfCards.player2Deck.get(3).getSuite());
            if (GroupOfCards.player1Deck.size() <= 4 || GroupOfCards.player2Deck.size() <= 4) {
                System.out.println(super.declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
                System.exit(0);
            } else if (Game.drawCount == 9) {
                System.out.println(super.declareWinner(GroupOfCards.player1Deck.size(), GroupOfCards.player2Deck.size(), "d", "d"));
                System.exit(0);
            } else {
                GroupOfCards.player2Deck.add(GroupOfCards.player1Deck.get(0));
                GroupOfCards.player2Deck.add(GroupOfCards.player1Deck.get(1));
                GroupOfCards.player2Deck.add(GroupOfCards.player1Deck.get(2));
                GroupOfCards.player2Deck.add(GroupOfCards.player1Deck.get(3));
                GroupOfCards.player2Deck.add(GroupOfCards.player2Deck.get(0));
                GroupOfCards.player2Deck.add(GroupOfCards.player2Deck.get(1));
                GroupOfCards.player2Deck.add(GroupOfCards.player2Deck.get(2));
                GroupOfCards.player2Deck.add(GroupOfCards.player2Deck.get(3));
                GroupOfCards.player2Deck.remove(0);
                GroupOfCards.player2Deck.remove(1);
                GroupOfCards.player2Deck.remove(2);
                GroupOfCards.player2Deck.remove(3);
                GroupOfCards.player1Deck.remove(0);
                GroupOfCards.player1Deck.remove(1);
                GroupOfCards.player1Deck.remove(2);
                GroupOfCards.player1Deck.remove(3);
                System.out.println("Player1 deck size:" + GroupOfCards.player1Deck.size());
                System.out.println("Player2 deck size:" + GroupOfCards.player2Deck.size());
                //Game.drawCount++;
                //System.out.println("Drawcount: " + Game.drawCount);
                System.out.println("=================================================");

                //Thread.sleep(250);
//                System.out.println("Shuffling the decks...");
//                Collections.shuffle(GroupOfCards.player1Deck);
//                Collections.shuffle(GroupOfCards.player2Deck);
            }
        }
    }
}
