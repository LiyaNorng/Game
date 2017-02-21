import java.util.ArrayList;
import java.util.Scanner;

class Game extends Duel{
	Player p1,p2, player;
	ArrayList <Player> listOfPlayer = new ArrayList<Player>();
	Scanner scanner = new Scanner(System.in);
	String userInput;
	boolean campaign=false;
	int stage=1;
	
	public Game(Player player1,Player player2){
		System.out.println("Do you want start a new game?");
		userInput = scanner.nextLine();
		if (userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("y")){
			Player p1=new PlayerName("Smith", 0, 1);
			Player p2=new PlayerName("Bob", 0, 1);
			p1.setLoad("new");
			p2.setLoad("new");
			listOfPlayer.add(p1);
			listOfPlayer.add(p2);
	    }
	    else{
	    	for (int i = 0; i < 2; i++){
	    		System.out.println("Please give me player name: ");
	        	userInput = scanner.nextLine();
            	player = new LoadCastleWarsGame().loadGame(userInput);
            	if (player.getUserName().equals("") ){
            		System.out.println("Sorry, can't find the userName on the data.");
            	    System.exit(1);
            	}
            	else{
            		player.setLoad("load");
                	listOfPlayer.add(player);
                	
            	}	
        	}
	    }
		for ( int i = 0; i < listOfPlayer.size(); i++){
			if (i == 0){
				p1 = listOfPlayer.get(i);
			}
			else{
				p2 = listOfPlayer.get(i);
			}
		}
		System.out.println("Would you like to play the campaign mode?");
		userInput=scanner.nextLine();
		if (userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("y"))
			campaign=true;
	}
	public void getStats(Player player){
		System.out.print("\tCastle: "+player.getCastle()+"\tFence: "+player.getFence()+"\t b:"+player.getBricks()+" w:"+player.getWeapons()+" c:"+player.getCrystals()+
				"\n__________________________________________________________________\nHand------->");
		
	}
	public void showHand(Player player)
	{
			getStats(player);
			player.showHand();
	}
	//each player gets a move
	//game checks for a winner after each move is executed
	public void round(){
		System.out.print("Player 1");
		showHand(p1);
		Move moveMade=p1.makeMove();
		moveMade.execute(p1,p2);
		System.out.print(moveMade.getCard().getName());
		System.out.println(" - "+moveMade.getCard().getPower());
		System.out.println("\n\n\n");
		
		checkForWin(p1,p2);
		
		System.out.print("Player 2");
		showHand(p2);
		moveMade=p2.makeMove();
		moveMade.execute(p2,p1);
		System.out.print(moveMade.getCard().getName());
		System.out.println(" - "+moveMade.getCard().getPower());
		System.out.println("\n\n\n");
		
		checkForWin(p1,p2);
		
		//after each round, stocks are increased for each player accordingly
		increaseStocks(p1,p2);
	}
	public void checkForWin(Player p1,Player p2)
	{
		
		//Users can win by destroying their enemy's castle or building their castle up to 100
		String winner=null;
		if(p1.getCastle()>99)
		{
			winner="Player 1 ";
		}
		else if (p1.getCastle()<1)
		{
			winner="Player 2 ";
		}
		else if (p2.getCastle()>99)
		{
			winner="Player 2 ";
		}
		else if (p2.getCastle()<1)
		{
			winner="Player 1 ";
		}
		//if there's a winner, display message and terminate the program
		if (winner!=null)
		{
			System.out.println(winner+ " won!");
			if (!campaign){
				if (winner.contains("1")){
					p1.setPoint(p1.getPoint() + 1);
				}
				else{
					p2.setPoint(p2.getPoint() + 1);
				}
				new SaveCastleWarsGame().saveGame(listOfPlayer);
				listOfPlayer.clear();
			}
			if (campaign){
				if (winner.contains("1")){
					if (stage==3){
						System.out.println("You won the campaign challenge");
						System.exit(0);
					}
					else if (stage==1)
					{
						System.out.println("\n\n\n======================================");
						System.out.println("Congratulations you passed stage 1");
						System.out.println("======================================\n\n\n");
						stage+=1;
						playMediumDifficulty();
					}
					else if(stage==2){
						System.out.println("\n\n\n======================================");
						System.out.println("Congratulations you passed stage 1");
						System.out.println("======================================\n\n\n");
						stage+=1;
						playHardDifficulty();}
				}
				else{ System.out.println("You lost the campaign challenge in stage "+stage);
					System.exit(0);}
			}else System.exit(0);//quit the game
		}
		
	}
	public void playMediumDifficulty(){
		p1.resetPlayer();
		p2.resetPlayer();
		p2.buildFence(10);
		super.play();
	}
	public void playHardDifficulty(){
		p1.resetPlayer();
		p2.resetPlayer();
		p2.buildFence(15);
		super.play();
	}
	//bricks are increased depending on how many builders you have
	//weapons are increased depending on how many soldiers you have
	//crystals are increased depending on how much magic you have
	public void increaseStocks(Player p1, Player p2)
	{
		int amount;
		amount=p1.getBuilders();
		p1.increaseBricks(amount);
		amount=p2.getBuilders();
		p2.increaseBricks(amount);
		amount=p1.getSoldiers();
		p1.increaseWeapons(amount);
		amount=p2.getSoldiers();
		p2.increaseWeapons(amount);
		amount=p1.getMagic();
		p1.increaseCrystals(amount);
		amount=p2.getMagic();
		p2.increaseCrystals(amount);
	}
}