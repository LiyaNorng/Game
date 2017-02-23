
public class Paladin extends ClassDecorator{
	Player player;
	
	public Paladin(Player player){
		super();
		this.player = player;
	}
	
	public String getDescription(){
		return player.getDescription() + " Paladin";
	}
}
