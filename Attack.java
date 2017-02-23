import java.util.*;
class Attack implements Strategy{
	public Card discardCard(Player p)
	{/**
		//find lowest resource
		int lowest=p.getBricks();
		String lowestResource="bricks";
		if (lowest>p.getCrystals())
		{
			lowest=p.getCrystals();
			lowestResource="crystals";
		}
		if (lowest>p.getWeapons())
		{
			lowest=p.getWeapons();
			lowestResource="weapons";
		}
		*/
		
		Card highest=p.getCard(0);;
		/**boolean set=false;
		//finds card that requires the most of the scarcest resource player has
		for(int i=0;i<8;i++)
		{
			if (p.getCard(i).getResource()==lowestResource)
				if (set==false){
					highest=p.getCard((i));
					set=true;
				}
				else{if (p.getCard(i).getAmount()>highest.getAmount())
					highest=p.getCard(i);}
		}*/
		//if player doesn't have any cards that require his scarcest resource he'll discard his highest card
		//if (set==false){
		for (int i=1;i<8;i++)
		{
			if (highest.getAmount()<p.getCard(i).getAmount())
				highest=p.getCard(i);
		}//}
		return highest;
	}
	public Move getMove(Player p)
	{
		String priority="attack";
		if (p.getCastle()+p.getFence()<40)
		{
			priority="build";
		}
		ArrayList<Card> legalMoves=new ArrayList<Card>();
		for(int i=0;i<8;i++)
		{
			if (p.getCard(i).isPlayable()){
				legalMoves.add(p.getCard(i));}
		}
		Move m=new UseCard(p.getCard(0));
		if (legalMoves.isEmpty()){
			m=new DiscardCard(discardCard(p));
			return m;
		}
		//if only one option use it
		if (legalMoves.size()==1)
		{
			m=new UseCard(legalMoves.get(0));
			return m;
		}
	
		//first look to increase builders,soldiers, and magic because after each round you acquire as many bricks,weapons,and crystals respectively;
		for(int i=0;i<legalMoves.size();i++)
		{
			if (legalMoves.get(i).getType()=="resource")
				return m=new UseCard(legalMoves.get(i));
		}
		//choose based on priority 
		for(int i=0;i<legalMoves.size();i++)
		{
			if (legalMoves.get(i).getType()==priority)
				return m=new UseCard(legalMoves.get(i));
		}
		//do opposite
		if (priority=="build")
			priority="attack";
		if (priority=="attack")
			priority="build";
		//choose based on priority 
		for(int i=0;i<legalMoves.size();i++)
		{
			if (legalMoves.get(i).getType()==priority)
				return m=new UseCard(legalMoves.get(i));
		}
		//gain 
		for(int i=0;i<legalMoves.size();i++)
		{
			if (legalMoves.get(i).getType()=="gain")
				return m=new UseCard(legalMoves.get(i));
		}
		return m;
	}
}