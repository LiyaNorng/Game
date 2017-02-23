import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveCastleWarsGame {
	public void saveGame(ArrayList<Player> player){
		try{
			ArrayList <String> listOfPlayer = new ArrayList<String>();
        	String line = "";
	    	Player setPlayer = null;
        	String playerOneUserName = null;
        	String playerTwoUserName = null;
        	for (int i = 0; i < player.size(); i++){
    			setPlayer = player.get(i);
        		if (i == 0){
                	playerOneUserName = setPlayer.getUserName();
        		}
        		else{
                	playerTwoUserName = setPlayer.getUserName();
        		}
        	}
			FileReader file_Input = new FileReader("textFiles.txt");
			BufferedReader buffers = new BufferedReader(file_Input);
			while((line = buffers.readLine()) != null){
				if (line.equals(playerOneUserName) || line.equals(playerTwoUserName)){
					if (player.get(0).getLoad().equals("new")){
						player.get(0).setLoad("");
						player.get(0).setPoint(player.get(0).getPoint() + Integer.valueOf(buffers.readLine()));
						player.get(0).setLevel(Integer.valueOf(buffers.readLine()));
					}
					else if (player.get(1).getLoad().equals("new")){
						player.get(1).setLoad("");
						player.get(1).setPoint(player.get(1).getPoint() + Integer.valueOf(buffers.readLine()));
						player.get(1).setLevel(Integer.valueOf(buffers.readLine()));
					}
					else if (player.get(0).getLoad().equals("load") || (player.get(0).getLoad().equals("load"))){
						buffers.readLine();
						buffers.readLine();
					}
				}
				else
				{
					for (int i = 0; i < 2; i++){
						line = buffers.readLine();
						listOfPlayer.add(line);
					}	
				}
			}
			
			FileWriter fileWriter = new FileWriter("textFiles.txt");
        	BufferedWriter buffer = new BufferedWriter(fileWriter);
	    	for (int i = 0; i < listOfPlayer.size(); i++){
	    		buffer.write(listOfPlayer.get(i));
	    		buffer.newLine();
	    	}
	    	for (int i = 0; i < player.size(); i++){
	    		setPlayer = player.get(i);
    			buffer.write(setPlayer.getUserName());
    			buffer.newLine();
    			if (setPlayer.getPoint() >= 3){
    				setPlayer.setLevel(setPlayer.getLevel() + 1);
    				setPlayer.setPoint(0);
    			}
    			buffer.write(String.valueOf(setPlayer.getPoint()));
    			buffer.newLine();
    			buffer.write(String.valueOf(setPlayer.getLevel()));
    			if (i != player.size() - 1){
        			buffer.newLine();
    			}
	        }   
	    	buffer.close();
	    	buffers.close();
	    	listOfPlayer.clear();
	    	System.out.println("Game Saved");
		}
		catch ( IOException e){
            e.printStackTrace();
		}	
	}
}

