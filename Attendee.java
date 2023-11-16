

public class Attendee{
private int id;
private String name;
private String company;
private int tableNumber;
private int seatNumber;

public Attendee(int iniId, String iniName, String iniCompany, int iniTable, int iniSeat){
	id = iniId;
	name = iniName;
	company = iniCompany;
	tableNumber = iniTable;
	seatNumber = initSeat;
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
	return(name);
}
public String getCompany(){
	return(company);
}
public int getTable(){
	return(tableNumber);
}
public int getSeat(){
	return(seatNumber);
}
pubic String toString(){
	return(name + " " + company + " " + tableNumber + " " seatNumber);
}
}
