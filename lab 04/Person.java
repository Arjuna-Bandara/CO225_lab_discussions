

public class Person {

    // person's attributes
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // constructor with field
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // default constructor
    public Person() {
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    // toString() method; this will print object as string when call in System.out.println(person)
    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            "}";
    }
    


}
