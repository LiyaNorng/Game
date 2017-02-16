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
public interface Strategy {
    
    public abstract Move pickingTheRightCardOnHand(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;
    
    public abstract Move IsThereAnyMonsterOnFieldToFight(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;

    public abstract Move numberOfCardToBePlaceOnTheField(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;

    public abstract Move numberOfMovePlayerHasMove(Player player)
        throws ClassCastException, NullPointerException;

    public abstract Move levelUpTheMonsterCard(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;
}
