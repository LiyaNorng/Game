
public class Rider extends Card {
	
	public Rider(){
		name="Rider";
		resource="weapons";
		amount=2;
		type="attack";
		power="attack 4";
	}

	@Override
	public void effect(Player p1, Player p2) {
		if (p2.getFence()>=4)
			p2.destroyFence(4);
		else
		{
			int remaining=4-p2.getFence();
			p2.destroyFence(4-remaining);
			p2.destroyCastle(remaining);
		}
	}
}
