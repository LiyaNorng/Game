
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class Driver {
	Player p1=new Player();
	Player p2=new Player();
	
	@Test
	public void useCardtest()
	{	
		//players start off with 5 of each resource and 30 castle and 10 fence.
		Card card=new Wall(); //fence +3
		Move move=new UseCard(card);
		
		//once the move is executed, fence should be 13, and player should have lost the one brick it needed to use the card
		move.execute(p1, p2);
		assertEquals(p1.getFence(),13);
		assertEquals(p1.getBricks(),4);
	}
	@Test
	public void discardCardtest(){
		Card card=new Banshee();
		Move move=new DiscardCard(card);
		
		//once the move is executed, player should not have lost any resources since it didn't use its power
		move.execute(p2, p1);
		assertEquals(p2.getWeapons(),5);
		assertEquals(p2.getBricks(),5);
		assertEquals(p2.getCrystals(),5);
	}
	
	@Test
	public void BansheeTest(){
		//add Banshee card to player's hand
		//assert the card is not playable because player doesn't start off with enough stocks
		Card card=new Banshee();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Banshee",player.getHand().getCard(7).getName());
		assertFalse(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void FenceTest(){
		//add Fence card to player's hand
		//assert the card is not playable because player doesn't start off with enough stocks
		Card card=new Fence();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Fence",player.getHand().getCard(7).getName());
		assertFalse(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void PlatoonTest(){
		//add Platoon card to player's hand
		//assert the card is playable because player starts off with enough stocks
		Card card=new Platoon();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Platoon",player.getHand().getCard(7).getName());
		assertTrue(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void WallTest(){
		//add Platoon card to player's hand
		//assert the card is playable because player starts off with enough stocks
		Card card=new Wall();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Wall",player.getHand().getCard(7).getName());
		assertTrue(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void AttacksTest(){
		//add Attack card to player's hand
		//assert the card is not playable because player doesn't start off with enough stocks
		Card card=new Attacks();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Attack",player.getHand().getCard(7).getName());
		assertFalse(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void KnightTest(){
		//add Knight card to player's hand
		//assert the card is playable because player starts off with enough stocks
		Card card=new Knight();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Knight",player.getHand().getCard(7).getName());
		assertTrue(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void BabylonTest(){
		//add Babylon card to player's hand
		//assert the card is not playable because player doesn't start off with enough stocks
		Card card=new Babylon();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Babylon",player.getHand().getCard(7).getName());
		assertFalse(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void DragonTest(){
		//add Babylon card to player's hand
		//assert the card is not playable because player doesn't start off with enough stocks
		Card card=new Dragon();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Dragon",player.getHand().getCard(7).getName());
		assertFalse(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void PixiesTest(){
		//add Babylon card to player's hand
		//assert the card is not playable because player doesn't start off with enough stocks
		Card card=new Pixies();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Pixies",player.getHand().getCard(7).getName());
		assertFalse(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void TowerTest(){
		//add Tower card to player's hand
		//assert the card is playable because player starts off with enough stocks
		Card card=new Tower();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Tower",player.getHand().getCard(7).getName());
		assertTrue(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void WainTest(){
		//add Wain card to player's hand
		//assert the card is not playable because player doesn't start off with enough stocks
		Card card=new Wain();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Wain",player.getHand().getCard(7).getName());
		assertFalse(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void SchoolTest(){
		//add School card to players hand
		//assert the card is not playable because player doesn't start of with enough stocks
		Card card=new School();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("School",player.getHand().getCard(7).getName());
		assertFalse(player.getHand().getCard(7).isPlayable());	
	}
	@Test
	public void ConjureCrystalsTest(){
		//add Conjure Crystal card to player's hand
		//assert the card is playable because player starts off with enough stocks
		Card card=new ConjureCrystal();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Conjure Crystals",player.getHand().getCard(7).getName());
		assertTrue(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void RiderTest(){
		//add Rider card to players hand
		//assert the card is playable because player starts off with enough stocks
		Card card=new Rider();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Rider",player.getHand().getCard(7).getName());
		assertTrue(player.getHand().getCard(7).isPlayable());
	}
	@Test
	public void FortTest(){
		//add School card to players hand
		//assert the card is not playable because player doesn't start of with enough stocks
		Card card=new Fort();
		Player player=new Player();
		player.exchangeCard(player.getHand().getCard(1),card);
		assertEquals("Fort",player.getHand().getCard(7).getName());
		assertFalse(player.getHand().getCard(7).isPlayable());		
	}
	@AfterClass
	public static void runOnce(){
		System.out.println("\n\n\nBattle\n\n\n");
		Player p1=new Player();
		Player p2=new Player();
		p1.changeStrategy(new Attack());
		Duel game = new Game(p1,p2);
		game.play();
	}
	

}