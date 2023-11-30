/**
*Keliang Yao
*This is the party class. It has methods to parse text file and load data onto the ArrayList guestList while also removing extra people. It will also make a 2d array of Attende objects of guests sorted by company. It has a printGuest method that is not used in Tester class of final project because it is only used to check my work. It also has a manual register method to gets user input of Attendee objects and adds them to guestList while also removing extra people. 
**/

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;//import ArrayList class

public class Party{
Scanner scan = new Scanner(System.in);
private int numCompanies = 16;
private int numRegister = 90;
private int totalNumGuest = 100;
public int[] company = new int[16];//arrayList to keep track of # of people from each company
public ArrayList<Attendee> guestList = new ArrayList<Attendee>();//ArrayList of Attendee objects 
public static String[] companies = {"Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor", "AMD", "Razer"};
public void parseData(){//parse data from downloaded file and upload them to arrayList guestList-also checks for and removes extra people
 try {
     File myObj = new File("partyguests (1).txt");
     Scanner myReader = new Scanner(myObj);
     while (myReader.hasNextLine()) {
       String data = myReader.nextLine();
       String[] myArray = data.split(",", 0);
       int iniId = Integer.parseInt(myArray[0]) - 1; //setting id to start at 0
       String iniName1 = myArray[1];//getting last name
       String iniName2 = myArray[2]; //getting first name
       int iniCompany = Integer.parseInt(myArray[3]) - 1;//get int for company and set company 1 to 0
       int iniTable = 0;//placeholder for table #
       int iniSeat = 0;//placeholder for seat #
       Attendee guest = new Attendee(iniId, iniName1, iniName2, iniCompany, iniTable, iniSeat);
       if(getCompany(iniCompany) == true){//if there are less than 10 people from company iniCompany
         guestList.add(guest);
       }//if
     }//while
     myReader.close();
   } catch (FileNotFoundException e) {
     System.out.println("An error occurred.");
     e.printStackTrace();
   }//catch
   //return (guestList);
}//parseData
public boolean getCompany(int j){//return true if adding the person to the company will not exceed 10 people/company
	if(company[j]+1 <= 10)
	{
		company[j]++;
		return true;
	}
	return false;
}
public void makeCompany(int holdCompany, ArrayList<ArrayList<Attendee>> company){//make 2d arrayList of attendee objects sorted by company
  for(int i = 0; i < guestList.size(); i++){
    if(guestList.get(i).getCompany() == holdCompany){//if attendee if from company      company.get(holdCompany).add(guestList.get(i));
    }
  }
}
 
public void printGuest(ArrayList<Attendee> guestList){//print guestList
 for(int i = 0; i < guestList.size(); i++){
   System.out.println(guestList.get(i));
 }
}//printGuest  
public void manualRegister(){//manual register attendees after preregistered list is loaded into guestList
 int registeredMem = guestList.size();//get # of people preregistered
 int stillNeed = totalNumGuest - registeredMem;
 System.out.println("There are " + registeredMem + " people preregistered. You can manually register " + stillNeed + " people.");
 System.out.println("Enter attendee ID in numerical order starting with 90 (so 1st manually registered guest is 90, 2nd is 91, etc): ");
 int iniId = scan.nextInt();//getting id
 System.out.println("Enter attendee last name: ");
 String iniName1 = scan.nextLine();//getting last name
 scan.nextLine();
 System.out.println("Enter attendee first name: ");
 String iniName2 = scan.nextLine();//getting first name
 //scan.nextLine();
 System.out.println("Enter attendee's company ID (it sould be a number): ");
 int iniCompany = scan.nextInt() - 1;//getting company id
 scan.nextLine();
 Attendee manualA = new Attendee(iniId, iniName1, iniName2, iniCompany, 0, 0);
  if(getCompany(iniCompany) == true){//if there are less than 10 people in company iniCompany
     guestList.add(manualA);
   }//if
}//manualRegister
}//party
