

public class Attendee{
private int id;
private String lastName;
private String firstName;
private int company;
private int tableNumber;
private int seatNumber;

public Attendee(int iniId, String iniName1, String iniName2, int iniCompany, int iniTable, int iniSeat){
	id = iniId;
	firstName = iniName2;
	lastName = iniName1;
	company = iniCompany;
	tableNumber = iniTable;
	seatNumber = iniSeat;
}
public void setTable(int table){
	tableNumber = table;
}
public void setSeat(int seat){
	seatNumber = seat;
}
public int getID(){
	return(id);
}
public String getName(){
	return(lastName + ", " + firstName);
}
public int getCompany(){
	return(company);
}
public int getTable(){
	return(tableNumber);
}
public int getSeat(){
	return(seatNumber);
}
public String toString(){
	return(id + ", " + firstName + ", " + lastName + ", " + company + ", " + tableNumber + ", " + seatNumber);
}
}
