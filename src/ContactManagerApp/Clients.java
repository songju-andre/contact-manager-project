package ContactManagerApp;

public class Clients {

    String firstName;
    String lastName;

    String fullName;
    int phoneNum;

    String phoneNumString;

    public Clients(String firstName, String lastName, int phoneNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
    }

    public Clients(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Clients(String fullName, int phoneNum){
        this.fullName = fullName;
        this.phoneNum = phoneNum;
    }

    public Clients(String fullName){
        this.fullName = fullName;
    }


    public String getPhoneNumString() { return  phoneNumString;}


    public String getFullName() { return  fullName;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNum() {
        return phoneNum;
    }


    public  void setPhoneNumString(String phoneNumString){ this.phoneNumString = phoneNumString; }


    public  void setFullName(String fullName){ this.fullName = fullName; }

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
