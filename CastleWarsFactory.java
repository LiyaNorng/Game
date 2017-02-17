public class CastleWarsFactory implements GameFactory {
	public Duel createGame(){
		return new Game(new Player(),new Player());
	}
}