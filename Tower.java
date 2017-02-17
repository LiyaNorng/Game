
public class Tower extends Card{
	
	public Tower(){
		name="Tower";
		resource="bricks";
		amount=5;
		type="build";
		power="castle +5";
	}

	@Override
	public void effect(Player p1, Player p2) {
		p1.buildCastle(5);
	}

}
