import java.util.ArrayList;

class Demo {
	public static void main(String[] args) {
		System.out.println("\n\n\nBattle\n\n\n");
		GameFactory cw=new CastleWarsFactory();
		Duel game = cw.createGame();
		game.play();
		
		
		GameFactory mc=new MonsterCardsFactory();
		Duel game2=mc.createGame();
		game2.play();
	}
}