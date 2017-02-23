public class DiscardCard extends Move{
	public DiscardCard(Card _card)
	{
		card=_card;
	}
	public void execute(Player user,Player enemy){
		System.out.print("Discarded ");
		user.destroyCard(card);
	}
}