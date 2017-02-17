/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Liya Norng
 */

/**
 * 
 * @param monsterOnField is to check whether there is a monster on field
 * @param opponentHealthBelowZero is to keep track the opponent health below zero
 * @param opponentMonsterHealthBelowZero is to keep track the opponent monster below zero
 */

public class AttackTheOpponent implements StrategyForAttack{
    static AttackTheOpponent attackTheOpponent = new AttackTheOpponent();
    private boolean monsterOnField;
    private boolean opponentHealthBelowZero;
    private boolean opponentMonsterHealthBelowZero;

    public AttackTheOpponent() {
        monsterOnField = false;
        opponentHealthBelowZero = false;
        opponentMonsterHealthBelowZero = false;
    }

    public AttackTheOpponent getAttackTheOpponent() {
        return attackTheOpponent;
    }

    public boolean isMonsterOnField() {
        return monsterOnField;
    }

    public boolean isOpponentHealthBelowZero() {
        return opponentHealthBelowZero;
    }

    public boolean isOpponentMonsterHealthBelowZero() {
        return opponentMonsterHealthBelowZero;
    }

    public void setAttackTheOpponent(AttackTheOpponent attackTheOpponent) {
        this.attackTheOpponent = attackTheOpponent;
    }

    public void setMonsterOnField(boolean monsterOnField) {
        this.monsterOnField = monsterOnField;
    }

    public void setOpponentHealthBelowZero(boolean opponentHealthBelowZero) {
        this.opponentHealthBelowZero = opponentHealthBelowZero;
    }

    public void setOpponentMonsterHealthBelowZero(boolean opponentMonsterHealthBelowZero) {
        this.opponentMonsterHealthBelowZero = opponentMonsterHealthBelowZero;
    }

    /**
     * 
     * @param monsterGame
     * @return attackTheOpponent is to check if there is a monster on field
     * @throws ClassCastException
     * @throws NullPointerException 
     */
    
    public AttackTheOpponent checkingOpponentMonsterOnField(MonsterCardGame monsterGame) throws ClassCastException, NullPointerException {
        
        monsterOnField = false;
        for (String in:monsterGame.getTwoPlayer().keySet())
        {
            Trainer player = monsterGame.getTwoPlayer().get(in);
            if (player.getTurn() == false)
            {
                if (player.isThereAnyMonsterOnField())
                {
                    monsterOnField = true;
                }
                break;
            }
        }
        return attackTheOpponent; 
    }

    /**
     * 
     * @param monsterGame
     * @return attackTheOpponent is for checking for opponent health
     * @throws ClassCastException
     * @throws NullPointerException 
     */
    
    public AttackTheOpponent checkingOpponentHealth(MonsterCardGame monsterGame) throws ClassCastException, NullPointerException {
        opponentHealthBelowZero = false;
        for (String in: monsterGame.getTwoPlayer().keySet())
        {
            Trainer player = monsterGame.getTwoPlayer().get(in);
            if (player.getTurn() == false)
            {
                if (player.getHealth() <= 0)
                {
                    opponentHealthBelowZero = true;
                }
                break;
            }
        }
        return attackTheOpponent;  
    }    

    /**
     * 
     * @param monsterGame
     * @param key
     * @return attackTheOpponent is for checking opponent monster health
     * @throws ClassCastException
     * @throws NullPointerException 
     */
    
    public AttackTheOpponent checkingOpponentMonsterHealth(MonsterCardGame monsterGame, String key) throws ClassCastException, NullPointerException {
        
        opponentMonsterHealthBelowZero = false;
        for (String in: monsterGame.getTwoPlayer().keySet())
        {
            Trainer player = monsterGame.getTwoPlayer().get(in);
            if (player.getTurn() == false)
            {
                Cards card = player.getSingleMonsterOnField(key);
                if (card.getHeartPoint() <= 0)
                {
                    opponentMonsterHealthBelowZero = true;
                }
                break;
            }
        }
        return attackTheOpponent;  
    }

    /**
     * 
     * @param monsterGame
     * @return attackTheOpponent is for attacking the opponent player. 
     * @throws ClassCastException
     * @throws NullPointerException 
     */
    
    public AttackTheOpponent attackTheOpponents(MonsterCardGame monsterGame) throws ClassCastException, NullPointerException {
        
        Trainer newPlayer = null;
        for (String in: monsterGame.getTwoPlayer().keySet())
        {
            newPlayer = monsterGame.getTwoPlayer().get(in);
            if (newPlayer.getTurn() == false)
            {
                break;
            }
        }
        if (!newPlayer.isThereAnyMonsterOnField())
        {
            for (String key: monsterGame.getPlayer().getMonsterOnField().keySet())
            {
                Cards currentPlayerCard = monsterGame.getPlayer().getMonsterOnField().get(key);
                for (String item: newPlayer.getMonsterOnField().keySet())
                {
                    Cards opponetCard = newPlayer.getMonsterOnField().get(item);
                    opponetCard.gotHit(currentPlayerCard.getAttackPiont());
                    if (opponetCard.getHeartPoint() <= 0)
                    {
                        newPlayer.removeACardFromField(item);
                    }
                }
                if (newPlayer.isThereAnyMonsterOnField())
                {
                    newPlayer.gotAttack(currentPlayerCard.getAttackPiont());
                }
            }
        }
        else
        {
            for (String key: monsterGame.getPlayer().getMonsterOnField().keySet())
            {
                Cards currentPlayerCard = monsterGame.getPlayer().getMonsterOnField().get(key);
                newPlayer.gotAttack(currentPlayerCard.getAttackPiont());
                if (newPlayer.getHealth() <= 0)
                {
                    monsterGame.setPlayerWin(true);
                    break;
                }
            }
        }  
        return attackTheOpponent;
    }
}
