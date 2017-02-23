public class CastleWarsFactory implements GameFactory {
	public Duel createGame(){
		return new Game(new PlayerName("Simpson", 0, 1),new PlayerName("Jack", 0, 1));
	}
}