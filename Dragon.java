
public class Dragon extends Card{
	public Dragon(){
		name="Dragon";
		resource="crystals";
		amount=21;
		type="attack";
		power="attack 25";
	}

	@Override
	public void effect(Player p1, Player p2) {
		if (p2.getFence()>=25)
			p2.destroyFence(25);
		else
		{
			int remaining=25-p2.getFence();
			p2.destroyFence(25-remaining);
			p2.destroyCastle(remaining);
		}
		
	}
}
