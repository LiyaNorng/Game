/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstercardgame;

/**
 *
 * @author Welcom
 */
public interface StrategyForAttack {
    public abstract AttackTheOpponent checkingOpponentMonsterOnField(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;
    
    public abstract AttackTheOpponent checkingOpponentHealth(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;
    
    public abstract AttackTheOpponent checkingOpponentMonsterHealth(MonsterCardGame monsterGame, String key)
        throws ClassCastException, NullPointerException;
    
    public abstract AttackTheOpponent attackTheOpponents(MonsterCardGame monsterGame)
        throws ClassCastException, NullPointerException;
}
