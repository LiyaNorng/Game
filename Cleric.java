
public class Cleric extends ClassDecorator{
	Player player;
	
	public Cleric(Player player){
		super();
		this.player = player;
	}
	
	public String getDescription(){
		return  player.getDescription() + " CLeric"; 
	}
}
