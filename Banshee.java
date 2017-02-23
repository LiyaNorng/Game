
public class Banshee extends Card {
	public Banshee(){
		name="Banshee";
		resource="weapons";
		amount=28;
		type="attack";
		power="attack 32";
	}

	@Override
	public void effect(Player p1, Player p2) {
		if (p2.getFence()>=32)
			p2.destroyFence(32);
		else
		{
			int remaining=32-p2.getFence();
			p2.destroyFence(32-remaining);
			p2.destroyCastle(remaining);
		}
		
	}

}
