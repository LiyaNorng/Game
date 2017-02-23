
public class Babylon extends Card{

	public Babylon()
	{
		name="Babylon";
		resource="bricks";
		amount=39;
		type="build";
		power="castle +32";
	}

	@Override
	public void effect(Player p1, Player p2) {
		p1.buildCastle(32);
	}
}
