import java.util.ArrayList;
class Basic implements Strategy {
	public int discardCard(Player p)
	{
		//discard card that requires the most stocks
		int highest= 0;
		for (int i=1;i<8;i++)
		{
			if (p.getCard(highest).getAmount()<p.getCard(i).getAmount())
				highest=i;
		}
		return highest;
	}
	public Move getMove(Player p)
	{
		ArrayList<Card> legalMoves=new ArrayList<Card>();
		for(int i=0;i<8;i++)
		{
			if (p.getCard(i).isPlayable())
				legalMoves.add(p.getCard(i));
		}
		Move m=new UseCard(p.getCard(0));
		//if theres no other cards to choose from, return this move
		if (legalMoves.isEmpty())
		{
			return m=new DiscardCard(p.getCard(discardCard(p)));
		}
		//first look to increase builders,soldiers, and magic because after each round you acquire as many bricks,weapons,and crystals respectively;
		for (int i=0;i<legalMoves.size();i++)
		{
			if (legalMoves.get(i).getType()=="resource")
				return m=new UseCard(legalMoves.get(i));
		}
		//build your castle to stay alive
		for (int i=0;i<legalMoves.size();i++)
		{
			if (legalMoves.get(i).getType()=="build")
				return m=new UseCard(legalMoves.get(i));
		}
		//attack to prevent other player to win
		for (int i=0;i<legalMoves.size();i++)
		{
			if (legalMoves.get(i).getType()=="attack")
				return m=new UseCard(legalMoves.get(i));
		}
		//gain stocks to be able to use cards
		for (int i=0;i<legalMoves.size();i++)
		{
			if (legalMoves.get(i).getType()=="gain")
				return m=new UseCard(legalMoves.get(i));
		}
		return m;
	}
}