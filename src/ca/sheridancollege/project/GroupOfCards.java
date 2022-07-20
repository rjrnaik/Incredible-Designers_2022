 /**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private int size;//the size of the grouping
    ArrayList<Card> cards = new ArrayList<>();
    ArrayList<Card> player1Deck = new ArrayList<>();
    ArrayList<Card> player2Deck = new ArrayList<>();
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
    public void generateDeck() {
        
        int index = 0;
        for (Card.Suite suite : Card.Suite.values()) {
            for (Card.Rank rank : Card.Rank.values())// hearts,ace
            {
                cards.add(new Card(suite, rank));
                index++;
            }
        }
        shuffle();
        for (int i = 0; i < cards.size(); i += 2) {

            player1Deck.add(cards.get(i));
            player2Deck.add(cards.get(i + 1));
        }
        System.out.println("Player 1 deck:");
        for (Card card : player1Deck) {
            System.out.println(card.getRank() + " of " + card.getSuite());
        }

        System.out.println("Player 2 deck:");
        for (Card card : player2Deck) {
            System.out.println(card.getRank() + " of " + card.getSuite());
        }
    }
    
}//end class
