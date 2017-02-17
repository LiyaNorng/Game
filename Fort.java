
public class Fort extends Card{
	public Fort(){
		name="Fort";
		resource="bricks";
		amount=18;
		type="build";
		power="castle +20";
	}

	@Override
	public void effect(Player p1, Player p2) {
		p1.buildCastle(20);
	}
}
