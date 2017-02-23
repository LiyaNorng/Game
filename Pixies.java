
public class Pixies extends Card{
	public Pixies(){
		name="Pixies";
		resource="crystals";
		amount=22;
		type="build";
		power="castle +22";
	}

	@Override
	public void effect(Player p1, Player p2) {
		p1.buildCastle(22);
		
	}
}
