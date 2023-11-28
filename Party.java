import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
public class Party{
Scanner scan = new Scanner(System.in);
public int[][] table = new int[10][10];
public static int numCompanies = 16;
public static int numRegister = 90;
public static int totalNumGuest = 100;
public ArrayList<Attendee> guestList = new ArrayList<Attendee>();
public static String[] companies = {"Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor", "AMD", "Razer"};
public ArrayList<Attendee> parseData(){
//String[] myArray;
//ArrayList<Attendee> guestList = new ArrayList<Attendee>();
	try {
      File myObj = new File("partyguests (1).txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] myArray = data.split(",", 0);
        int iniId = Integer.parseInt(myArray[0]) - 1; //setting id to start at 0
        /*if(myArray[0].length() == 1){
        int iniId = myArray[0].charAt(0)- '0';
		    }
		    else{
			    int iniId = myArray[0].chartAt(0) - '0' + myArray[0].chartAt(1) - '0';
		    }  */// previous attempt to parse int
        String iniName1 = myArray[1];//getting last name
        String iniName2 = myArray[2]; //getting first name
        int iniCompany = Integer.parseInt(myArray[3]) - 1;//get int for company and set company 1 to 0
        /*if(myArray[3].length() == 1){
        int iniCompany = myArray[3].charAt(0)- '0';
		    }
		    else{
			  int iniCompany = myArray[3].chartAt(0) - '0' + myArray[3].chartAt(1) - '0';
		    } */ //previous attempt to parse int
        int iniTable = 0;
        int iniSeat = 0;
        Attendee guest = new Attendee(iniId, iniName1, iniName2, iniCompany, iniTable, iniSeat);
        guestList.add(guest);
      }//while
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }//catch
    return (guestList);
}//parseData


public void printGuest(ArrayList<Attendee> guestList){
	for(int i = 0; i < guestList.size(); i++){
		System.out.println(guestList.get(i));
	}
}//printGuest		

public int setCompanyNum(ArrayList<Attendee> guestList, int company){//check number of employees are preregistered for given company
  boolean filler = false;
  int counter = 0;
  for(int j = 0; j < guestList.size(); j++){
    if(guestList.get(j).getCompany() == company){
      counter++;
      //guestList.set(counter, guestList.get(j));
    }//if
    else{
      filler = true;
    }//else
  }//for
    return (counter);
}//setCompanyNum

public int setCompanyMem(int company, int index){
    if(guestList.get(index).getCompany() == company){
      return(guestList.get(index).getID());
    }
    else{
      return (-1);
    }
}//setCompanyNum

public ArrayList<Attendee> removePeople(ArrayList<Company> company, ArrayList<ArrayList<Integer>> companyMulti){//remove extra people from preregistered list
  boolean filler = true;
  for(int k = 0; k < numCompanies; k++){
    if(company.get(k).getCompanyNum() > 10){
      companyMulti.get(k).remove(0);//remove extra registered person's id from array of company members
      int counter = 0;
      int extraPeople = company.get(k).getCompanyNum() - 10;
      System.out.println("Sorry there are more than 10 people from " + companies[k] + ". " + extraPeople + " people are automatically removed.");
      for(int i = 0; i < extraPeople; i++){//remove extra people from guestList starting with the smallest id
        for(int h = 0; h < guestList.size(); h++){
          if(guestList.get(h).getCompany() == k && counter < 1){
            counter++;//make sure only one object gets removed
            guestList.remove(h);
            company.get(k).removeMember();
            break;
          }//if
          else{
            filler = false;
          }//else
        }//for-h
      }//for-i
    }//if
    else{
      filler = true;
    }
  }
  return(guestList);

}//removePeople

public void placePeople(ArrayList<ArrayList<Integer>> companyMulti, int company, ArrayList<Attendee> guestList){//place preregistered people int tables
  int tableNum = 0;
  int seatNum = 0;
  for(int i = 0; i < companyMulti.get(company).size(); i++){
    if(tableNum == 9){
      seatNum++;
      tableNum = 0;
    }
    table[tableNum][seatNum] = companyMulti.get(company).get(i);
    int index = 0;
    for(int y = 0; y < guestList.size(); y++){
      if(guestList.get(i).getID() == companyMulti.get(company).get(i)){
        index = i;
        break;
      }
    }
    guestList.get(index).setTable(tableNum);
    guestList.get(index).setSeat(seatNum);
    tableNum++;
  }
}//placePeople
public void manualRegister(){
  int registeredMem = guestList.size();
	int stillNeed = totalNumGuest - registeredMem;
	System.out.println("There are " + registeredMem + " people preregistered. You can manually register " + stillNeed + " people.");
  System.out.println("Enter attendee ID in numerical order starting with 90 (so 1st manually registered guest is 90, 2nd is 91, etc): ");
  int iniId = scan.nextInt();
  System.out.println("Enter attendee last name: ");
  String iniName1 = scan.nextLine();
  scan.nextLine();
  System.out.println("Enter attendee first name: ");
  String iniName2 = scan.nextLine();
  //scan.nextLine();
  System.out.println("Enter attendee's company ID (it sould be a number): ");
  int iniCompany = scan.nextInt();
  scan.nextLine();
  Attendee manualA = new Attendee(iniId, iniName1, iniName2, iniCompany, 0, 0);
  guestList.add(manualA);
}//manualRegister
public String printRoster1(ArrayList<ArrayList<Integer>> companyMulti, int company, int index){//gets roster of tables and seats with inputted company
int numTables = 10;
int numSeats = 10;
int findTable = 0;
int findSeat = 0;
    for(int j = 0; j < numTables; j++){
      for(int a = 0; a < numSeats; a++){
        if(table[j][a] == companyMulti.get(company).get(index)){
          findTable = j;
          findSeat = a;
        }
      }
    }
    return("table: " + findTable + " seat: " + findSeat + " ");
  
}//printRoster1
public Attendee printRoster2(int table){//gets roster by table with imputted table
  int numTables = 10;
  int numSeats = 10;
  int getInfo = 0;
  for(int i = 0; i < guestList.size(); i++){
    if(guestList.get(i).getTable() == table){
      getInfo = i;
      break;
    }
  }
  return(guestList.get(getInfo));
  
}//printRoster2
public Attendee getPerson(int id){
Attendee a1 = new Attendee(0, "0", "0", 0, 0, 0); 
  for(int i = 0; i < guestList.size(); i++){
    if(guestList.get(i).getID() == id){
      a1 = guestList.get(i);
      break;
    }
  }
  return(a1);
}

		
}//party


