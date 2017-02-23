

public class Wall extends Card {
	public Wall()
	{
		name="Wall";
		resource="bricks";
		amount=1;
		type="build";
		power="fence +3";
	}

	@Override
	public void effect(Player p1, Player p2) {
		p1.buildFence(3);
	}
}
