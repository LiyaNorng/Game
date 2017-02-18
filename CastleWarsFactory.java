public class CastleWarsFactory implements GameFactory {
	public Duel createGame(){
		return new Game(new Player("Simpson", 0),new Player("Jack", 0));
	}
}