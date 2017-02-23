public class UseCard extends Move{
	public UseCard(Card _card)
	{
		card=_card;
	}
	public void execute(Player user,Player enemy){
		System.out.print("Chose ");
		card.consumeStocks(user);
		card.effect(user,enemy);
		user.destroyCard(card);
	}
}