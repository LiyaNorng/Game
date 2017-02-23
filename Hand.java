import java.util.*;
import java.util.Random;
class Hand {
	private ArrayList<Card> hand=new ArrayList<Card>(); //array of cards
	private List<String> cardNames=Arrays.asList("Fence","Banshee","Wall","Pixies","Dragon","Platoon","Recruit", "Attack", "Babylon", "Knight", "Wain","School","Conjure Crystals","Rider","Fort");
	
	//no-param constructor creates hand of random cards
	public Hand(){
		for(int i=0;i<8;i++)
		{
			Card randomCard=getRandomCard();
			hand.add(randomCard);
		}
	}
	public Card getRandomCard(){
		Card randomCard;
		Random randomizer=new Random();
		int rand=randomizer.nextInt(cardNames.size());
		switch(rand){
			case 0:
				randomCard=new Fence();
				break;
			case 1:
				randomCard=new Banshee();
				break;
			case 2:
				randomCard=new Wall();
				break;
			case 3:
				randomCard=new Pixies();
				break;
			case 4:
				randomCard= new Dragon();
				break;
			case 5:
				randomCard=new Platoon();
				break;
			case 6:
				randomCard=new Recruit();
				break;
			case 7:
				randomCard=new Attacks();
				break;
			case 8:
				randomCard=new Babylon();
				break;
			case 9:
				randomCard=new Knight();
				break;
			case 10:
				randomCard=new Wain();
				break;
			case 11:
				randomCard=new School();
				break;
			case 12:
				randomCard=new ConjureCrystal();
				break;
			case 13:
				randomCard=new Rider();
				break;
			case 14:
				randomCard=new Fort();
				break;
			default:
				randomCard= new Banshee();
		}
		return randomCard;
	}
	public int size(){
		return hand.size();
	}
	
	//prints out each card in player's hand
	public void displayHand(){
		for (int i=0;i<hand.size();i++)
		{
			System.out.print(getCard(i).getName()+"\t");
		}
		System.out.println();
	}
	//returns the card at the position
	public Card getCard(int index)
	{
		return hand.get(index);
	}
	//removes the card and adds a random card
	public Card removeCard(Card card)
	{
		Card newCard=getRandomCard();
		hand.remove(card);
		hand.add(newCard);
		return newCard;
	}
	//for testing purposes
	public void exchangeCard(Card card, Card newCard){
		hand.remove(card);
		hand.add(newCard);
	}
}