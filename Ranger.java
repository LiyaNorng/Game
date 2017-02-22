
public class Ranger extends ClassDecorator{
	Player player;
	
	public Ranger(Player player){
		super();
		this.player = player;
	}
		
	public String getDescription(){
		return player.getDescription() + " Ranger";
	}
}
