/**
*Keliang Yao
*This is the Attendee class used to store all the data about the attendee including
*their id, first and last name, company id, seat and table numer. It also has getter
*functions like getCompany and setter functions like setTable and setSeat.
**/


public class Attendee{//
private int id;//guest id
private String lastName;//guest last name
private String firstName;//guest first name
private int company;//comapny id
private int tableNumber;
private int seatNumber;
public Attendee(int iniId, String iniName1, String iniName2, int iniCompany, int iniTable, int iniSeat){//constructor
  id = iniId;
  firstName = iniName2;
  lastName = iniName1;
  company = iniCompany;
  tableNumber = iniTable;
  seatNumber = iniSeat;
}
public void setTable(int table){//set table # after seating guest
  tableNumber = table;
}
public void setSeat(int seat){//set seat # after seating guest
  seatNumber = seat;
}
public int getID(){//getter-guest id
  return(id);
}
public String getName(){//getter-guest first and last name
  return(lastName + ", " + firstName);
}
public int getCompany(){//getter-company id
  return(company);
}
public int getTable(){//getter-table #
  return(tableNumber);
}
public int getSeat(){//getter-seat#
  return(seatNumber);
}
public String toString(){//to string function
  return(id + ", " + firstName + ", " + lastName + ", " + company + ", " + tableNumber + ", " + seatNumber+"\n");
}
}//Attendee
