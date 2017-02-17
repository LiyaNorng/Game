public abstract class Move {
	Card card;
	
	public abstract void execute(Player user,Player enemy);
	
	public Card getCard(){
		return card;
	}
	
	//for testing purposes
	public boolean checkMove(String name)
	{
		return (name==card.getName());
	}
}