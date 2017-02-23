
public class ConjureCrystal extends Card{
	public ConjureCrystal(){
		name="Conjure Crystals";
		resource="crystals";
		amount=4;
		type="gain";
		power="crystals +8";	
	}
	@Override
	public void effect(Player p1, Player p2) {
		p1.increaseCrystals(8);
	}
}
