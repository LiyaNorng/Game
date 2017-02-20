import java.io.Serializable;
import java.util.*;

class Player extends Observable implements PlayerProperty{
	protected int builders;
	protected int bricks;
	protected int soldiers;
	protected int weapons;
	protected int magic;
	protected int crystals;
	protected int castle;
	protected int fence;
	protected int point;
	protected String userName;
	protected Hand hand;
	protected String load;
	protected int level;
	protected Strategy strategy; //attack or basic
	
	public Player(){
		builders=2;
		bricks=5;
		soldiers=2;
		weapons=5;
		magic=2;
		crystals=5;
		castle=30;
		fence=10;
		hand=new Hand();
		for (int i=0;i<hand.size();i++)
		{
			addObserver(hand.getCard(i));
			setChanged();
			notifyObservers();
		}
		strategy= new Basic();
	}
<<<<<<< Updated upstream
	public void setLevel(int level){
		this.level = level;
	}
	public int getLevel(){
		return level;
=======
	public void resetPlayer(){
		builders=2;
		bricks=5;
		soldiers=2;
		weapons=5;
		magic=2;
		crystals=5;
		castle=30;
		fence=10;
>>>>>>> Stashed changes
	}
	public String getLoad(){
		return load;
	}
	public void setLoad(String load){
		this.load = load;
	}
	public void setPoint(int point){
		this.point = point;
	}
	public int getPoint(){
		return point;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserName(){
		return userName;
	}
	public void changeHand(Hand h){
		hand=h;
	}
	public Hand getHand(){
		return hand;
	}
	public void showHand(){
		hand.displayHand();
	}
	public void changeStrategy(Strategy s){strategy=s; }
	public Move makeMove(){
		return strategy.getMove(this);
	}
	public int getBuilders() {return builders;}
	public void increaseBuilders() {builders++;}
	public void decreaseBuilders(){
		if (builders>0)
			builders--;
	}
	public int getBricks() {return bricks;}
	public void increaseBricks(int amount) {
		bricks+=amount;
		setChanged();
		notifyObservers();
	}
	public void decreaseBricks(int amount){
		if (amount>bricks)
			bricks=0;
		else bricks-=amount;
		setChanged();
		notifyObservers();
	}
	public int getSoldiers() {return soldiers;}
	public void increaseSoldiers() {soldiers++;}
	public void decreaseSoldiers(){
		if (soldiers>0)
			soldiers--;
	} 
	public int getWeapons() {return weapons;}
	public void increaseWeapons(int amount) {
		weapons+=amount;
		setChanged();
		notifyObservers();
	}
	public void decreaseWeapons(int amount){
		if (amount>weapons)
			weapons=0;
		else weapons-=amount;
		setChanged();
		notifyObservers();
	}
	public int getMagic() {return magic;}
	public void increaseMagic() {magic++;}
	public void decreaseMagic(){
		if (magic>0)
			magic--;
	} 
	public int getCrystals() {return crystals;}
	public void increaseCrystals(int amount) {
		crystals+=amount;
		setChanged();
		notifyObservers();
	}
	public void decreaseCrystals(int amount){
		if (amount>crystals)
			crystals=0;
		else crystals-=amount;
		setChanged();
		notifyObservers();
	}
	public int getCastle(){ return castle;}
	public void buildCastle(int amount) {castle+=amount;}
	public void destroyCastle(int amount) {castle -=amount;}
	public int getFence() {return fence;}
	public void buildFence(int amount) {fence+=amount;}
	public void destroyFence(int amount){
		if (amount>fence) fence =0;
		else fence-=amount;}
	public Card getCard(int index) {return hand.getCard(index);}
	public void destroyCard(Card card) {
		deleteObserver(card);
		Card newCard=hand.removeCard(card);
		addObserver(newCard);
		setChanged();
		notifyObservers();
	}
	public void exchangeCard(Card card, Card newCard)
	{
		deleteObserver(card);
		hand.exchangeCard(card, newCard);
		addObserver(newCard);
		setChanged();
		notifyObservers();
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}