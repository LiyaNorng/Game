import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadMonsterCardGame {
	
	public Trainer loadGame(String name){
		Trainer player = new Trainer();
		FileReader file_Input;
		BufferedReader buffer;
		String userName;
		String gender;
		String turn;
		String computer;
		String line = "";
		int point;

		try{
			file_Input = new FileReader("textFile.txt");
			 buffer = new BufferedReader(file_Input);
			
			while((line = buffer.readLine()) != null){
				if (name.equals(line)){
					userName = line;
					gender = buffer.readLine();
					turn = buffer.readLine();
					computer = buffer.readLine();
					point = Integer.valueOf(buffer.readLine());
					player = new Trainer(userName, gender, turn, computer, point);
					break;
				}
			}
            buffer.close();
		}
		catch (IOException e){
            e.printStackTrace();
		}
		return player;
	}

	/**
	
	 file format:
	
	 player username
	 player gender
	 player turn
	 player or comuter
	 points
	 
	 .......
	 .......
	 ....... //// more player
	 .......
	 
	 

	 */
	
}












