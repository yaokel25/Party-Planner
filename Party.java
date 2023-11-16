import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class Party{


public void parseData(){
	try{
		File givenData = new File (partyguest.txt);
		Scanner readFile = new Scanner(givenData);
		while(readFile.hasNextLine()){
			String data = readFile.nextLine();//find way to parse through data and make method to add to arrayList
			//myArray = text.split(",");
		}
		readFile.close();
	}
	catch (FileNotFoundException e){
		System.out.println("An error occurred.");
		e.printStackTrace();
	}
}
		
		
}


