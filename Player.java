/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstercardgame;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Liya Norng
 */

/**
 * 
 * @param userName is the name of the user
 * @param health is the user health
 * @param numberOfMove is keeping track number of move player has done
 * @param cardsOnHand is a map of cards, like a deck of card on hand
 * @param monsterOnField is a map of cards, like a deck of card on field
 * @param turn is keeping track who turn is it
 * @param computer to keep track whether this player is computer or user
 */

public class Player {
    
    private String userName;
    private int health;
    private String gender;
    private int numberOfMove;
    private Map<String, Cards> cardsOnHand;
    private Map<String, Cards> monsterOnField;
    private boolean turn;
    private boolean computer;
    
    public Player(String userName, String gender, boolean turn, boolean computer) {
        this.userName = userName;
        this.computer = computer;
        this.turn = turn;
        health = 50;
        this.gender = gender;
        numberOfMove = 0;
        cardsOnHand = new HashMap<String, Cards>();
        monsterOnField = new HashMap<String, Cards>();
    }

    Player() {
        
    }

    public void gotAttack(int value)
    {
        health = health - value;
    }
    
    public boolean getComputer() {
        return computer;
    }

    public void setComputer(boolean computer) {
        this.computer = computer;
    }
        
    public void addMonsterToHand(String key, Cards card)
    {
        cardsOnHand.put(key, card);
    }
    
    public void addMonsterToField(String key)
    {
        monsterOnField.put(key, cardsOnHand.get(key));
    }
    
    public void removeACardFromHand(String key)
    {
        cardsOnHand.remove(key);
    }
    
    public boolean isCardsOnHandEmpty()
    {
        return cardsOnHand.isEmpty();
    }
    
    public boolean isThereAnyMonsterOnField()
    {
        return monsterOnField.isEmpty();
    }
    
    public void removeACardFromField(String key)
    {
        monsterOnField.remove(key);
    }
    
    public Cards getSingleCardOnHand(String key)
    {
        return cardsOnHand.get(key);
    }
      
    public Cards getSingleMonsterOnField(String key)
    {
        return monsterOnField.get(key);
    }
        
    public String getUserName() {
        return userName;
    }

    public int getHealth() {
        return health;
    }

    public String getGender() {
        return gender;
    }

    public int getNumberOfMove() {
        return numberOfMove;
    }
    
    public Map<String, Cards> getCardsOnHand() {
        return cardsOnHand;
    }

    public Map<String, Cards> getMonsterOnField() {
        return monsterOnField;
    }

    public boolean getTurn() {
        return turn;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNumberOfMove(int numberOfMove) {
        this.numberOfMove = numberOfMove;
    }

    public void setCardsOnHand(Map<String, Cards> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    public void setMonsterOnField(Map<String, Cards> monsterOnField) {
        this.monsterOnField = monsterOnField;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }   
}
