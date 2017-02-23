
public class Knight extends Card{
	
	public Knight(){
		name="Knight";
		resource="weapons";
		amount=2;
		type="attack";
		power="attack 3";
	}

	@Override
	public void effect(Player p1, Player p2) {
		if (p2.getFence()>=3)
			p2.destroyFence(3);
		else
		{
			int remaining=3-p2.getFence();
			p2.destroyFence(3-remaining);
			p2.destroyCastle(remaining);
		}
	}
}
