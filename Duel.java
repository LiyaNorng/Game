
public abstract class Duel{ 
	//continuous loop to execute each round
	public void play()
	{
		while(true){
			round();
		}
	}
	public abstract void round();
}
