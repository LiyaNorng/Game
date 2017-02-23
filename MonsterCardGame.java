/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Liya Norng
 */


/**
 * 
 * @param twoPlayer is to keep track the player computer and user player
 * @param monsterName is an array of the name of the monster
 * @param userInput is getting the user input to manipulate
 * @param playerWin is to keep track when there is a player
 * 
 */
public class MonsterCardGame extends Duel{
    private Trainer player;
    private Map<String, Trainer> twoPlayer;
    private ArrayList<String> monsterName;
    static Cards card;
    static Scanner scanner;
    static String userInput;
    static TrainerMove move;
    static boolean playerWin;
    static AttackTheOpponent attack;
    
    
    public MonsterCardGame(){
        initializeTheGame();
        System.out.println("Do you want start a new game?");
        userInput = scanner.nextLine();
        if (userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("y")){
        	 initializePlayer("Bob", "male", "1", "0");
        	 player.setLoad("new");
             initializePlayer("Smith", "male", "0", "1");
        	 player.setLoad("new");

        }
        else{
        	for (int i = 0; i < 2; i++){
        		System.out.println("Please give me a name for a player and a computer: ");
            	userInput = scanner.nextLine();
            	player = new LoadMonsterCardGame().loadGame(userInput);
            	if (player.getUserName().equals("") ){
            		System.out.println("Sorry, can't find the userName on the data.");
            	    System.exit(1);
            	}
            	else{
            		this.addMonsterToHand();
            		player.setLoad("load");
                	twoPlayer.put(player.getUserName(), player);
            	}	
        	}
        }  
    }
    public void initializePlayer(String userName, String gender, String turn, String computer)
    {
        player = new TotalPoints(userName, gender, turn, computer, 0, 1);
        this.displayPlayer();
        
        //this.addMonsterToHandHardCode();   /// this is for unit testing
        this.addMonsterToHand();         /// this is for actual game
        twoPlayer.put(player.getUserName(), player);
    }
    
    public void initializeTheGame() {
        monsterName = new ArrayList<String>();
        card = new Cards();
        move = new TrainerMove();
        attack= new AttackTheOpponent();
        playerWin = false;
        twoPlayer = new HashMap<String, Trainer>();
        scanner = new Scanner(System.in);
        monsterName.add("bird");
        monsterName.add("cat");
        monsterName.add("dog");
        monsterName.add("bat");
        monsterName.add("fox");
        monsterName.add("mouse");
        monsterName.add("rabbit");
        monsterName.add("tiger");
        monsterName.add("elephant");
        monsterName.add("turtle");
        monsterName.add("snake");
        monsterName.add("liger"); 
    }
    
    
   
    /**
     * this method is to attack the opponent. It first check whether if there are monster on the field, if there isn't 
     * any monster, then it will then attack the user. 
     */
    
     /*
    public void attackOpponent()
    { 
        Player newPlayer = new Player();
        for (String in: twoPlayer.keySet())
        {
            newPlayer = twoPlayer.get(in);
            if (newPlayer.getTurn() == false)
            {
                break;
            }
        }
        if (!newPlayer.isThereAnyMonsterOnField())
        {
            for (String key: player.getMonsterOnField().keySet())
            {
                Cards currentPlayerCard = player.getMonsterOnField().get(key);
                for (String item: newPlayer.getMonsterOnField().keySet())
                {
                    Cards opponetCard = newPlayer.getMonsterOnField().get(item);
                    opponetCard.gotHit(currentPlayerCard.getAttackPiont());
                    if (opponetCard.getHeartPoint() <= 0)
                    {
                        newPlayer.removeACardFromField(key);
                    }
                }
                if (newPlayer.isThereAnyMonsterOnField())
                {
                    playerWin = true;
                    newPlayer.gotAttack(currentPlayerCard.getAttackPiont());
                }
            }
        }
        else
        {
            for (String key: player.getMonsterOnField().keySet())
            {
                Cards currentPlayerCard = player.getMonsterOnField().get(key);
                newPlayer.gotAttack(currentPlayerCard.getAttackPiont());
                if (newPlayer.getHealth() <= 0)
                {
                    playerWin = true;
                    break;
                }
            }
        }  
    }
    
    */
    
    public void displayWinner()
    {
        System.out.println("Player : " +  player.getUserName() + " won the game.");
        player.setPoint(player.getPoint() + 1);
        this.quitGame();
    }
    
    
    /**
     * 
     * This method is use for user only. Getting the action from user 
     * 
     */

    public void player1Move()    /// user is playing 
    {
        while(true)
        {
            if (player.getNumberOfMove() >= 2)
            {
                break;
            }
            if (userInput.equals("fight"))
            {
                if (player.isThereAnyMonsterOnField())
                {
                    System.out.println("You have no monster to fight.");
                    break;
                }
                else
                {
                    attack = attack.attackTheOpponents(this);
                    break;
                }     
            }
            else if (userInput.equals("move monster"))
            {
                userInput = scanner.nextLine();
                player.addMonsterToField(userInput);
                player.removeACardFromHand(userInput);
            }
            else if (userInput.equals("level up"))
            {
                System.out.println("Please give me a monster card and an level up card");
                userInput = scanner.nextLine();
                userInput = scanner.nextLine();
                move = move.levelUpTheMonsterCard(this);
                if (move.getSuccessful())
                {
                    System.out.println("You have successfully level up your monster.");
                }
            }
            userInput = scanner.nextLine();
            player.setNumberOfMove(player.getNumberOfMove() + 1);
        }
        player.setNumberOfMove(0);
    }
    
    public void quitGame(){
    	new SaveMonsterCardGame().saveGame(twoPlayer, player.getUserName());
	    System.exit(1);
    }
    
    
    /**
     * This method is to allow AI to decide what to do and allowing the AI to decide it self what to do
     * with their card.
     */
    public void player2Move()    /// computer AI playing
    { 
        move = move.pickingTheRightCardOnHand(this);
        move = move.levelUpTheMonsterCard(this);
        move = move.IsThereAnyMonsterOnFieldToFight(this);
        
        if (move.getSuccessful())
        {
            System.out.println("Card has level up by 1.");
        }
        
        if (!move.getMonsterOnField())
        {
            attack = attack.attackTheOpponents(this);
        }
        else
        {
            System.out.println("Computer has end turn since there is no monster to fight.");
        }   
    }
    
    /**
     * This method is to determine who turn is it for the next round.
     */
    public void pickPlayer()
    {
        for (String in: twoPlayer.keySet())
        {
            Trainer newPlayer = twoPlayer.get(in);
            if (newPlayer.getTurn().equals("0"))
            {
                player.setTurn("0");
                newPlayer.setTurn("1");
                player = newPlayer;
                break;
            }
        }   
    }
    
    /**
     * This method is to put the game together.
     */
    public void round()
    {        
        for (String in: twoPlayer.keySet())
        {
            player = twoPlayer.get(in);
            if (player.getTurn().equals("1"))
            {
                break;
            }  
        }
        while (true)
        {
            if (player.getComputer().equals("0"))
            {
                this.newLine(5);
                this.DislpayCardOnHand();
                userInput = scanner.nextLine();
                this.player1Move();
                this.DislpayCardOnField();
                this.newLine(5);
            }
            else
            {
                this.newLine(5);
                this.DislpayCardOnHand();
                this.player2Move(); 
                this.DislpayCardOnField();
                this.newLine(5);
            }
            
            if (playerWin == true)
            {
                this.newLine(10);
                this.displayWinner();
                break;
            }
            if (player.getHealth() <= 0)
            {
                break;
            }
            this.pickPlayer();
        }    
    }
        
    public Trainer getPlayer() {
        return player;
    }

    public boolean getPlayerWin() {
        return playerWin;
    }

    public void setPlayerWin(boolean playerWin) {
        MonsterCardGame.playerWin = playerWin;
    }
    
    /// this is for unit testing only
    public void addMonsterToHandHardCode()
    {
        int index;
        int attackPoint;
        int heartPoint;
        int level;
        card = new Cards(monsterName.get(0) + String.valueOf(0),
                    8, 0, 0,false);
        player.addMonsterToHand(card.getName(), card);

        card = new Cards(monsterName.get(1) + String.valueOf(1),
                    2, 0, 0,false);
        player.addMonsterToHand(card.getName(), card);

        card = new Cards(monsterName.get(2) + String.valueOf(2),
                    5, 0, 0,false);
        player.addMonsterToHand(card.getName(), card);
    }
    
    public Trainer getSinglePlayer(String key)
    {
        return twoPlayer.get(key);
    }

    public void setPlayer(Trainer player) {
        this.player = player;
    }
        
    
    /**
     * This method is to put the monster into user and AI hands.
     */ 
    
    public void addMonsterToHand()
    {
        int index;
        int attackPoint;
        int heartPoint;
        int level;
        
        for (int i = 0; i < 5; i++)
        {
            index = (int) (Math.random() * 12 );
            attackPoint = (int) (Math.random() * 10 + 1);
            heartPoint = 10;
            level = (int) (Math.random() * 5 + 1);
            card = new Cards(monsterName.get(index) + String.valueOf(i),
                    attackPoint, heartPoint, level,false);
            /**
            if (index > 5)		
            {
                card = new Cards(monsterName.get(index) + String.valueOf(i),
                    0, heartPoint, level,true);
            }
            else if (index < 6)
            {
                card = new Cards(monsterName.get(index) + String.valueOf(i),
                    attackPoint, heartPoint, level,false);
            }
            **/
            player.addMonsterToHand(card.getName(), card);
        }    
    }

    public ArrayList<String> getMonsterName() {
        return monsterName;
    }
    
    /**
    * This method is just displaying some info about the player between each turn to show 
    * the health of the player.
    */
    
    public void displayPlayer()
    {
        this.newLine(2);
        System.out.println("Player: ");
        System.out.print("Name: ");
        System.out.println(player.getUserName());
        System.out.print("Gender: ");
        System.out.println(player.getGender());
        System.out.print("Health: ");
        System.out.println(player.getHealth());
        System.out.print("Number of Move: ");
        System.out.println(player.getNumberOfMove());
        System.out.print("Won: ");
        System.out.println(player.getPoint());
        System.out.print("Level: ");
        System.out.print(player.getLevel());
        this.newLine(2);
    }

    public Map<String, Trainer> getTwoPlayer() {
        return twoPlayer;
    }
    
    
    
    /**
     * This method is to display player card each turn to remind them what they have on hand.
     */
    
    public void DislpayCardOnHand()
    {
        this.displayPlayer();
        if (!player.isCardsOnHandEmpty())
        {
            System.out.println("Here are the card(s) on hand to play");
        }
        for (String in : player.getCardsOnHand().keySet())
        {
            card =  player.getSingleCardOnHand(in);
            System.out.print("Name: ");
            System.out.println(card.getName());
            System.out.print("Attack Power: ");
            System.out.println(card.getAttackPiont());
            System.out.print("Heart: ");
            System.out.println(card.getHeartPoint());
            System.out.print("Level: ");
            System.out.println(card.getLevel());
            this.newLine(3);
        }     
    }
    
    /**
     * This is to display the monster on the field.
     */
    
    public void DislpayCardOnField()
    {
        if (!player.isThereAnyMonsterOnField())
        {
            System.out.println("Here are the card(s) on the field to fight");
        }
        for (String in : player.getMonsterOnField().keySet())
        {
            card = player.getSingleMonsterOnField(in);
            System.out.print("Name: ");
            System.out.println(card.getName());
            System.out.print("Attack Power: ");
            System.out.println(card.getAttackPiont());
            System.out.print("Heart: ");
            System.out.println(card.getHeartPoint());
            System.out.print("Level: ");
            System.out.println(card.getLevel());
            this.newLine(3);
        }     
    }

    public void newLine(int line)
    {
        for (int i = 0; i < line; i++)
        {
            System.out.println(" ");
        }   
    }  
}
