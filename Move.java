/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstercardgame;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Liya Norng
 */

/**
 * 
 * @param value is a constant for keeping track that there is only 3 cards that can be place on field
 * @param numberOfCardOnField is keeping track of current number of card on field
 * @param numberOfMove is keeping track the current number of move player has move
 * @param endTurn is keeping track when the turn is turnaround
 * @param successful is keeping track whether the level up a card gone successful
 */
public class Move implements Strategy{
    static Move move = new Move();
    static Cards card;
    static final int value = 3;
    private int numberOfCardOnField;
    private int numberOfMove;
    private boolean monsterOnField;
    private boolean endTurn;
    private boolean successful;

    public Move() {
        endTurn = false;
        monsterOnField = false;
        successful = false;
    }

    public boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public static Move getMove() {
        return move;
    }

    public static Cards getCard() {
        return card;
    }

    public static int getValue() {
        return value;
    }

    public int getNumberOfCardOnField() {
        return numberOfCardOnField;
    }

    public int getNumberOfMove() {
        return numberOfMove;
    }

    public boolean getMonsterOnField() {
        return monsterOnField;
    }

    public boolean getEndTurn() {
        return endTurn;
    }

    public static void setMove(Move move) {
        Move.move = move;
    }

    public static void setCard(Cards card) {
        Move.card = card;
    }

    public void setNumberOfCardOnField(int numberOfCardOnField) {
        this.numberOfCardOnField = numberOfCardOnField;
    }

    public void setNumberOfMove(int numberOfMove) {
        this.numberOfMove = numberOfMove;
    }

    public void setMonsterOnField(boolean monsterOnField) {
        this.monsterOnField = monsterOnField;
    }

    public void setEndTurn(boolean endTurn) {
        this.endTurn = endTurn;
    }

    /**
     * 
     * @param monsterGame
     * @return move picking the right card on hand and put it on the field. 
     * @throws ClassCastException
     * @throws NullPointerException 
     */
    
    public Move pickingTheRightCardOnHand(MonsterCardGame monsterGame) throws ClassCastException, NullPointerException {

        Player player = monsterGame.getPlayer();
        Cards temp = new Cards("dummyValue",
                    0, 0, 0 , false);
        String key = "";
        int count = 0;
        while (true)
        {
            this.numberOfCardToBePlaceOnTheField(monsterGame);
            if (numberOfCardOnField >= 3)
            {
                break;
            }
            if (numberOfMove >= 2)
            {
                break;
            }
     
            if (player.isCardsOnHandEmpty())
            {
                System.out.print("no card on hand.");
                break;
            }
            for (String in: player.getCardsOnHand().keySet())
            {
                card = player.getCardsOnHand().get(in);
                if (card.getAttackPiont() > temp.getAttackPiont())
                {
                    temp = card;
                    key = in;
                }
            }          
            if (temp.getLevelCard() == false)
            {
                player.addMonsterToField(key);
                player.removeACardFromHand(key);
            }
            temp = new Cards("dummyValue",
                    0, 0, 0 , false);
     
            numberOfMove++;
        }
        player.setNumberOfMove(0);
        numberOfMove = 0;
        return move;
    }

    /**
     * 
     * @param monsterGame
     * @return  move this would check whether there is any card on field to fight
     * @throws ClassCastException
     * @throws NullPointerException 
     */
    
    public Move IsThereAnyMonsterOnFieldToFight(MonsterCardGame monsterGame) throws ClassCastException, NullPointerException {
        move.setMonsterOnField(false);

        Player player = monsterGame.getPlayer(); 
        move.setMonsterOnField(player.isThereAnyMonsterOnField());
        return move;        
    }
    
    /**
     * 
     * @param monsterGame
     * @return move this would count number of card on field to make sure it didn't pass the limit of 3 cards on field
     * @throws ClassCastException
     * @throws NullPointerException 
     */

    public Move numberOfCardToBePlaceOnTheField(MonsterCardGame monsterGame) throws ClassCastException, NullPointerException {
        
        Player player = monsterGame.getPlayer();        
        this.setNumberOfCardOnField(player.getMonsterOnField().size());
        return move;        
    }

    /**
     * 
     * @param player
     * @return move this would check for current amount of move player has move.
     * @throws ClassCastException
     * @throws NullPointerException 
     */
    
    public Move numberOfMovePlayerHasMove(Player player) throws ClassCastException, NullPointerException {
        
        numberOfMove = player.getNumberOfMove();
        if (numberOfMove == value)
        {
            endTurn = false;
        }
        return move; 
    }

    /**
     * 
     * @param monsterGame
     * @return move this would level up a card if there is a match in between the two card on the hand and field.
     * @throws ClassCastException
     * @throws NullPointerException 
     */
    
    public Move levelUpTheMonsterCard(MonsterCardGame monsterGame) throws ClassCastException, NullPointerException {
        
        Player player = monsterGame.getPlayer();  
        for (String in: player.getCardsOnHand().keySet())
        {
            Cards upgradeCard = player.getCardsOnHand().get(in);
            for (String key: player.getMonsterOnField().keySet())
            {
                card = player.getMonsterOnField().get(key);
                
                if (upgradeCard.getName().contains(card.getName()))
                {
                    card.setAttackPiont(upgradeCard.getLevel() + card.getAttackPiont());
                    card.setLevel(card.getLevel() + 1);
                    successful = true;
                    player.removeACardFromHand(in);
                }
            }
        }
        return move;
    }  
}
