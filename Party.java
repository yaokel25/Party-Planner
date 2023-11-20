import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
public class Party{

public ArrayList<Attendee> guestList = new ArrayList<Attendee>();
public ArrayList<Attendee> parseData(){
//String[] myArray;
//ArrayList<Attendee> guestList = new ArrayList<Attendee>();
	try {
      File myObj = new File("partyguests (1).txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] myArray = data.split(",", 0);
        if(myArray[0].length() == 1){
        /*int iniId = myArray[0].charAt(0)- '0';
		}
		else{
			int iniId = myArray[0].chartAt(0) - '0' + myArray[0].chartAt(1) - '0';
		} */ //need to parse int
        String iniName1 = myArray[1];
        String iniName2 = myArray[2]; 
        if(myArray[3].length() == 1){
        /*int iniCompany = myArray[3].charAt(0)- '0';
		}
		else{
			int iniCompany = myArray[3].chartAt(0) - '0' + myArray[3].chartAt(1) - '0';
		} */ //need to parse int
        int iniTable = 0;
        int iniSeat = 0;
        Attendee guest = new Attendee(iniId, iniName1, iniName2, iniCompany, iniTable, iniSeat);
        guestList.add(guest);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return (guestList);
}
public void printGuest(ArrayList<Attendee> guestList){
	for(int i = 0; i < guestList.size(); i++){
		System.out.println(guestList.get(i));
	}
}		
		
}


