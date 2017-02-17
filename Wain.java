
public class Wain extends Card{

	public Wain (){
		name="Wain";
		resource="bricks";
		amount=10;
		type="build";
		power="castle +8, enemy castle -4";
	}

	@Override
	public void effect(Player p1, Player p2) {
		p1.buildCastle(8);
		p2.destroyCastle(-4);
	}
}
