
public class Company {
    private int companyID;
    private int companyNum;
    private int id;
    public Company(int iniCompangID, int iniCompanyNum){
        companyID = iniCompangID;
        companyNum = iniCompanyNum;
        //id = iniID;
    }
    public void removeMember(){
        companyNum--;
    }
    public int getCompanyNum(){
        return(companyNum);
    }
    public int getAttendeeID(){
        return(id);
    }
    public String toString(){
        return(companyID + " " + companyNum);
    }
}
