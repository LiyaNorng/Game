public class MonsterCardsFactory implements GameFactory {
	public Duel createGame(){
		return new MonsterCardGame();
	}
}