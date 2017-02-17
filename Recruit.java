
public class Recruit extends Card{
	public Recruit(){
		name="Recruit";
		resource="weapons";
		amount=8;
		type="resource";
		power="soldiers +1";
	}

	@Override
	public void effect(Player p1, Player p2) {
		p1.increaseSoldiers();
		
	}


}