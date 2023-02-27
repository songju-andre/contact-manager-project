package src.ContactManagerApp;

public class Clients {

    String firstName;
    String lastName;

    String fullName;
    int phoneNum;

    public Clients(String firstName, String lastName, int phoneNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
    }

    public Clients(String fullName, int phoneNum){
        this.fullName = fullName;
        this.phoneNum = phoneNum;
    }





    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNum() {
        return phoneNum;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
}
