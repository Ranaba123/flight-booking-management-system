package w2052777_PlaneManagement;

public class Person {
    //attributes(Instance Variables)
    private String name;
    private String surname;
    private String email;

    public Person(String name,String surname,String email){
        /**
         * Creating a class constructor
         * String name,String surname,String email are arguments
         */
        this.name=name;
        this.surname=surname;
        this.email=email;

    }
    //getters Methods
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getEmail(){
        return email;
    }

    //setters Method
    public void setName(String name){
        this.name=name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void printPersonInfo(){
        /**
         * This method is used to print the personal information
         */
        System.out.println("Enter the name : "+name);
        System.out.println("Enter the surname : "+surname);
        System.out.println("Enter the gmail : "+email);
    }
}
