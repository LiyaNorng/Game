
public class Platoon extends Card{
	public Platoon(){
		name="Platoon";
		resource="weapons";
		amount=4;
		type="attack";
		power="attack 6";
	}

	@Override
	public void effect(Player p1, Player p2) {
		if (p2.getFence()>=6)
			p2.destroyFence(6);
		else
		{
			int remaining=6-p2.getFence();
			p2.destroyFence(6-remaining);
			p2.destroyCastle(remaining);
		}
		
	}
}