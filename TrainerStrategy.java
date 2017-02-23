/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Liya Norng
 */
public interface TrainerStrategy {
    
    public abstract TrainerMove pickingTheRightCardOnHand(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;
    
    public abstract TrainerMove IsThereAnyMonsterOnFieldToFight(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;

    public abstract TrainerMove numberOfCardToBePlaceOnTheField(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;

    public abstract TrainerMove numberOfMovePlayerHasMove(Trainer player)
        throws ClassCastException, NullPointerException;

    public abstract TrainerMove levelUpTheMonsterCard(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;
}
