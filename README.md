# Incredible-Designers_2022

WAR GAME DESIGN DOCUMENT

OVERVIEW

PROJECT BACKGROUND AND DESCRIPTION

The WAR game involves two players between which the deck of 52 cards will be distributed. Each player draws a card each and those two cards are compared for the Rank of the card. The player with the higher rank card receives both cards. The game continues until a player has 52 cards and is declared the winner. In the case that both cards have same Rank, WAR mode will be initiated, which involves both players drawing 4 cards and the outcome of the 4th card determines who wins the round. The game ends if a player ends with 0 cards.

DESIGN CONSIDERATIONS

In the design of the WAR game source code, there are 4 major classes:
1. Card: This class has member variables as Enums for differentiating the cards based on the rank and the suite. Enums used are Rank and Suite specifying 13 and 4 different values adding to 52 cards in the deck.
2. Player: The class has member variables playerName responsible for setting the names of the players. The player class is referenced or associated with the Game class. (Associativity)
3. Game: The game class uses the player reference and consists of methods like play() and drawCard() which actually fulfill the rules of the game. declareWinner() declares the winner at the end.
4. GroupOfCards: Another class associated with Card class involving methods like shuffle(), generateDeck() etc. handling all the card specific functionality.

Two enums:
1. Rank: Having values { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING} are used in the Card class to differentiate the cards based on Rank
2. Suite: Having values
{CLUBS, DIAMONDS, HEARTS, SPADES}
Are used to sort cards based on their suite value.
The use of Enums ensure loose coupling and better flexibility and easy comparisons than Strings.
War class is a subclass of Game class and is invoked when the same Rank card is drawn. It overrides a method drawCard() to modify the functionality of the game as per the rules. By this we achieve inheritance and better manageability. All class variables are declared private to ensure the Encapsulation principle and delegation is achieved by calling the functions only where they are actually needed and also ensure high Cohesion.
