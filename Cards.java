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
 * @param name is to keep track of the name of the monster
 * @param attackPoint is to keep track how strong the monster is 
 * @param heartPoint is to keep track how much health left
 * @param level is to keep track the level the monster is
 * @param levelCard is to keep track if the card is a upgradable
 */
public class Cards {

    private String name;
    private int attackPiont;
    private int heartPoint;
    private int level;
    private boolean levelCard;

    public Cards(String name, int attackPiont, int heartPoint, int level, boolean levelCard) {
        this.name = name;
        this.attackPiont = attackPiont;
        this.heartPoint = heartPoint;
        this.level = level;
        this.levelCard = levelCard;
    }

    public void setLevelCard(boolean levelCard) {
        this.levelCard = levelCard;
    }

    public boolean getLevelCard() {
        return levelCard;
    }

    public Cards() {
    }

    public String getName() {
        return name;
    }

    public int getAttackPiont() {
        return attackPiont;
    }

    public int getHeartPoint() {
        return heartPoint;
    }

    public void gotHit(int value) {
        heartPoint = heartPoint - value;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttackPiont(int attackPiont) {
        this.attackPiont = attackPiont;
    }

    public void setHeartPoint(int heartPoint) {
        this.heartPoint = heartPoint;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
