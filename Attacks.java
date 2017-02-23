
public class Attacks extends Card{

	public Attacks()
	{
		name = "Attack";
		resource= "weapons";
		amount=10;
		type="attack";
		power="attack 12";
	}

	@Override
	public void effect(Player p1, Player p2) {
		if (p2.getFence()>=12)
			p2.destroyFence(12);
		else
		{
			int remaining=12-p2.getFence();
			p2.destroyFence(12-remaining);
			p2.destroyCastle(remaining);
		}
	}
}
