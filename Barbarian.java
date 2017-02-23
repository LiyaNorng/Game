
public class Barbarian extends ClassDecorator{
	
	Player player;
	
	public Barbarian(Player player){
		super();
		this.player = player;
	}
	
	public String getDescription(){
		return player.getDescription() + " Babarian";
	}
}
