/**
*Keliang Yao
*This is the Tester class. It will parse and load the data from the text file into ArrayList guestList. It will remove extra people, and place every person at a table and 
*have search functionality to print rosters by table and company and to search for specific
*guests with guest ID.
**/

import java.util.ArrayList;//import ArrayList class
import java.util.Scanner;//import Scanner class

public class Main{
   public static final Scanner scan = new Scanner(System.in);
  public static ArrayList<ArrayList<Attendee>> company = new ArrayList<ArrayList<Attendee>>();
   public static int numCompanies = 16;
  public static ArrayList<ArrayList<Attendee>> table = new ArrayList<ArrayList<Attendee>>();

   public static String[] companies = {"Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor", "AMD", "Razer"};
  
   public static int numTables = 10;
   public static int numSeats = 10;
public static void main (String[] args){
   Party p1 = new Party();
   p1.parseData();//parse text file and add attendee objects to guestList-also removes extra people
  while(p1.guestList.size() < 100){//prompts user to manually register while there are less than 100 guests
    p1.manualRegister();
  }//if
  for(int y = 0; y < numCompanies; y++){//make 2d arrayList of attendee objects sorted into companies
    company.add(new ArrayList<Attendee>());
    p1.makeCompany(y, company);
  }
  System.out.print(company);
  for(int c = 0; c < numTables; c++){//initializing ArrayList tables so it has 10 tables
    table.add(new ArrayList<Attendee>());
  }
  int tableCount = 0;
  int seatCount = 0;
  
  for(int n = 0; n < numCompanies; n++){//seating people into tables
    for(int u = 0; u < company.get(n).size(); u++){
      if(tableCount == numTables){//if there are no more tables with the seat number seatCount available, move on to next seat#
        tableCount = 0;//go to table 1
        seatCount++;//move to next seat #
      }
      company.get(n).get(u).setTable(tableCount);//setting table # to attendee object
      company.get(n).get(u).setSeat(seatCount);//setting seat # to attendee object
      table.get(tableCount).add(company.get(n).get(u));//adding attendee object to arrayList table 
      tableCount++;//moving to next table
    }//for-u
  }//for-n
  //System.out.print(table); print table to check code
  
 
   
   System.out.println("Would you like to print roster by company? (y/n)");
   char answer = scan.nextLine().charAt(0);
   if(answer == 'y'){
       System.out.println("Enter company ID (should be a number): ");
       int companySearch = scan.nextInt() - 1;
       scan.nextLine();
       System.out.print(company.get(companySearch));
   }//if
   System.out.println("Would you like to print roster by table (y/n)");
   char answer1 = scan.nextLine().charAt(0);
   if(answer1 == 'y'){
       System.out.println("Enter table number (0-9): ");
       int tableSearch = scan.nextInt();
       scan.nextLine();
       System.out.print(table.get(tableSearch));
   }
   System.out.println("Would you like to get user information using their id? (y/n)");
   char answer2 = scan.nextLine().charAt(0);
   if(answer2 == 'y'){
       System.out.println("Enter person ID: ");
       int personID = scan.nextInt();
       scan.nextLine();
      for(int h = 0; h < numCompanies; h++){
        for(int j = 0; j < company.get(h).size(); j++){
          if(company.get(h).get(j).getID() == personID){
            System.out.println(company.get(h).get(j));
            break;
          }
        }
      }
      
   }
}//main
}//tester
