
public class School extends Card{
	
	public School(){
		name="School";
		resource="bricks";
		amount=8;
		type="resource";
		power="builders +1";
	}
	
	@Override
	public void effect(Player p1, Player p2) {
		p1.increaseBuilders();
	}

}
