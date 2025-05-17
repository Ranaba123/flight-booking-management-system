package w2052777_PlaneManagement;

import java.io.IOException;
import java.io.PrintWriter;

public class Ticket {
    //attributes(Instance Variables)
    private String row;
    private int seat;
    private int price;
    private Person person;

    public Ticket(String row, int seat, int price, Person person) {
        /**
         * Creating a class constructor
         * String row, int seat, int price, Person person are arguments
         */
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    //getters Methods
    public String getRow() {
        return row;
    }
    public int getSeat(){
        return  seat;
    }
    public double getPrice(){
        return price;
    }
    public Person getPerson(){
        return person;
    }
    public void setRow(String row){
        this.row = row;
    }
    public void setSeat(int seat){
        this.seat = seat;
    }

    //setters Method
    public void setPrice(int price){
        this.price = price;
    }
    public void setPerson(Person person){
        this.person = person;
    }

    public void printTicketInfo(){
        /**
         * This method is used to print the information of the method and also printPersonInfo method is also called in that method
         */
        System.out.println("Row : "+row);
        System.out.println("Seat : "+seat);
        System.out.println("Price €: "+price);
        System.out.println("Person Information: ");
        person.printPersonInfo();

    }
    public void save(String fileName) throws IOException {
        /**
         * This method is called when a person ticket is sold to save the details of the ticket and the personal information in text file
         */

        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println("***********   Person Information    ************");
            writer.println("Name: " + person.getName());
            writer.println("Surname: " + person.getSurname());
            writer.println("Email: " + person.getEmail());
            writer.println();
            writer.println("***********   Ticket Information    *************");
            writer.println("Row: " + row);
            writer.println("Seat: " + seat);
            writer.println("Price: €" + price);
        }
    }
}