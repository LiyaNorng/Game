/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstercardgame;

/**
 *
 * @author Liya Norng
 */
public class Driver {
    
    public static void main(String[] args) {
    
        /**
        
            So initialize the game with two play, player Liya is a userPlayer and player Kanal is computer player.
        This is a user vs computer battle. Each player will get 5 cards to begin and to play for the rest of the game. 
        For User purpose:
        *   to add monster to field:
                    move monster
                    monster name
        
        *   to fight :
                    fight , if there is monster on the field.
        
        *   to level up monster:
                    level up
                    name of card on field
                    name of card on Hand that match up for the level up.
        
        **/
        MonsterCardGame newGame = new MonsterCardGame();
        newGame.initializeTheGame();
        newGame.initializePlayer("Bob", "male", true, false);
        newGame.initializePlayer("Smith", "male", false, true);
        newGame.PlayGame();   
    }   
}
