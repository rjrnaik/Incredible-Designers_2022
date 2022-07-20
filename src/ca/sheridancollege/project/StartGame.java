/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author RajrishiNaik
 */
public class StartGame {

    public static void main(String[] args) {

        Game g1 = new Game("War");
        System.out.println("The two players are: " + g1.getPlayers());

//        System.out.println("-------------------------------------");
//        GroupOfCards gd = new GroupOfCards(52);
//        gd.generateDeck();// delegation satisfied 
//        System.out.println("-------------------------------------");
    }
}
