import java.util.ArrayList;
import java.util.Scanner;

public class Tester{
	public static final Scanner scan = new Scanner(System.in);
	public static int numCompanies = 16;
	public static ArrayList<Company> company = new ArrayList<Company>();
	public static String[] companies = {"Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor", "AMD", "Razer"};
	private static ArrayList<Attendee> A1= new ArrayList<Attendee>();
	public static ArrayList<ArrayList<Integer>> companyMulti = new ArrayList<ArrayList<Integer>>();
	public static int[][] table = new int[10][10];
	public static int numTables = 10;
	public static int numSeats = 10;
public static void main (String[] args){
	Party p1 = new Party();
	p1.parseData();
	do{
		while(p1.guestList.size() < 100){
			p1.manualRegister();
		}
			for(int i = 0; i < numCompanies; i++){
				companyMulti.add(new ArrayList<Integer>());
				for(int j = 0; j< p1.guestList.size(); j++){
					int holdMem = p1.setCompanyMem(i, j);
					if(holdMem != 0){
						companyMulti.get(i).add(holdMem);
					}
				}
				Company c1 = new Company(i, p1.setCompanyNum(p1.guestList, i));
				company.add(c1);
			}//for
	
		p1.removePeople(company, companyMulti);
	}
	while(p1.guestList.size() < 100);
	for(int l = 0; l < numTables; l++){//initializing table array so empty seats are -1
		for(int p = 0; p < numSeats; p++){
			table[l][p] = -1;
		}
	}
	for(int k = 0; k < numCompanies; k++){
		p1.placePeople(companyMulti, k, p1.guestList);
	}
	System.out.println("Would you like to print roster by company? (y/n)");
	char answer = scan.nextLine().charAt(0);
	if(answer == 'y'){
		System.out.println("Enter company ID (should be a number): ");
		int companySearch = scan.nextInt();
		scan.nextLine();
		for(int k = 0; k < companyMulti.get(companySearch).size(); k++){
			System.out.print(p1.printRoster1(companyMulti, companySearch, k));
		}

	}
	System.out.println("Would you like to print roster by table (y/n)");
	char answer1 = scan.nextLine().charAt(0);
	if(answer1 == 'y'){
		System.out.println("Enter table number (0-9): ");
		int tableSearch = scan.nextInt();
		scan.nextLine();
		for(int b = 0; b < numSeats; b++){
			System.out.print(p1.printRoster2(tableSearch) + " ");
		}
	}
	System.out.println("Would you like to get user information using their id? (y/n)");
	char answer2 = scan.nextLine().charAt(0);
	if(answer2 == 'y'){
		System.out.println("Enter person ID: ");
		int personID = scan.nextInt();
		scan.nextLine();
		System.out.println(p1.getPerson(personID));
	}
}//main
}//tester
