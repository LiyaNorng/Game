

public class Fence extends Card{
	
	public Fence(){
		name="Fence";
		resource="bricks";
		amount=12;
		type="build";
		power="fence +22";
		
	}
	@Override
	public void effect(Player p1, Player p2) {
		p1.buildFence(22);
	}
}