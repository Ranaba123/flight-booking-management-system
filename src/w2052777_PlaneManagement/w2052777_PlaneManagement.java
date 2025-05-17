package w2052777_PlaneManagement;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class w2052777_PlaneManagement {
    String surname;
    String name;
    String choice;
    static Ticket[] arrayOfTickets = new Ticket[52]; //creates a new instances of Ticket array.This can store 52 Ticket Objects
    static int ticketCount=1;


    public static void main(String[] args) {
        /**
         *This is the method is the main method that holds the entire program with a main menu
         */
        int selection;
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        System.out.println("**********************            Welcome to the Plane Management application              **********************");
        System.out.println("\n");

        //Creating the seating plan using a 2D array
        int rows[][] = new int[4][];
        rows[0] = new int[14];
        rows[1] = new int[12];
        rows[2] = new int[12];
        rows[3] = new int[14];

        //This is the main menu that is looping until the user enter selection 0
        while (quit != true) {
            System.out.println("****************************************************");
            System.out.println("*                   MENU OPTIONS                   *");
            System.out.println("****************************************************");
            System.out.println("      1)Buy a seat                                  ");
            System.out.println("      2)Cancel a seat                               ");
            System.out.println("      3)Find first available seat                   ");
            System.out.println("      4)Show seating plan                           ");
            System.out.println("      5)Print ticket and information and total sales");
            System.out.println("      6)Search Ticket"                               );
            System.out.println("      0)Quit                                        ");
            System.out.println("****************************************************");

            //selection variable validate using bellow
            while (true) {
                try {
                    System.out.print("Please choose an option : ");
                    selection = input.nextInt();
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Wrong data type.Please enter a integer between 0-6");
                    input.nextLine();
                }
            }

            //Main men is controlling structure (switch)
            if (selection == 0) {
                quit = true;
                System.out.println("!!!!!!!!!!!  Have a Nice Day   !!!!!!!!!!!!!");
                break;
            } else {
                switch (selection) {
                    /*
                        From case 1-6 creates a new object of the class w2052777_PlaneManagement and assigns
                        it to a Refference variable and calling the methods with relevant arguments
                     */

                    case 1:
                        System.out.println("+++++++++   SeatHub   +++++++++++\n");
                        w2052777_PlaneManagement SeatBooking = new w2052777_PlaneManagement();
                        if(ticketCount>52){
                            System.out.println("Sorry all the seats are booked try another session");
                        }
                        else {


                            SeatBooking.buy_seat(rows,arrayOfTickets);
                            System.out.println("For this session there are "+(53-ticketCount)+" remaining");
                        }
                        break;
                    case 2:
                        System.out.println("---------------  Cancel Seating  ---------------");
                        w2052777_PlaneManagement CancelSeat = new w2052777_PlaneManagement();

                        CancelSeat.cancel_seat(rows,arrayOfTickets);
                        System.out.println("For this session there are "+(53-ticketCount)+" remaining");
                        break;
                    case 3:
                        System.out.println("+++++++++++      Find First       +++++++++++");
                        w2052777_PlaneManagement FindFirstSeat = new w2052777_PlaneManagement();
                        FindFirstSeat.find_first_seat_available(rows);
                        break;
                    case 4:
                        System.out.println("###########    Seating Plan    #############");
                        w2052777_PlaneManagement ShowSeatingPlan = new w2052777_PlaneManagement();
                        ShowSeatingPlan.show_seating_plan(rows);
                        break;
                    case 5:
                        w2052777_PlaneManagement PrintTicket = new w2052777_PlaneManagement();
                        PrintTicket.print_tickets_info(PrintTicket.arrayOfTickets);
                        break;
                    case 6:
                        System.out.println("&&&&&&&&&&&&    Ticket Searcher   &&&&&&&&&&&&");
                        w2052777_PlaneManagement SearchInformation = new w2052777_PlaneManagement();
                        SearchInformation.search_ticket(rows,arrayOfTickets);
                        break;
                    default:
                        System.out.println("Unidentified option");
                }
            }
        }
    }

    public void buy_seat(int[][] rows, Ticket[] arrayOfTickets) {
        /**
         * Thid method is called when the user want to buy a seat
         * int[][] rows, Ticket[] arrayOfTickets takes as method parameters
         * new Ticket is also opening when the user is buying a seat
         * Also when a Ticket is sold The information of the Ticket and the Personal information is saved as text file
         */
        String email;
        boolean inStr;
        String rownum;
        String row;
        int seat;
        int price;
        System.out.println("\n");
        System.out.println("******   First Enter the Seat Row[A,B,C,D] you want to book.Then Enter the seat number you want  *****\n");
        System.out.println("A row 1 to 14 seats ");
        System.out.println("B row 1 to 12 seats ");
        System.out.println("C row 1 to 12 seats ");
        System.out.println("D row 1 to 14 seats ");
        Scanner input = new Scanner(System.in);
        int colnum;
        /*
            Check Each row letter is valid and check seat number is valid or not
            then if the seat is available user can buy that else user cannot buy that.
         */
        while (true) {
            System.out.print("Enter the row letter you want : ");
            rownum= input.next().toUpperCase();
            row=rownum;
            if (rownum.equals("A")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 14) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-14");
                        } else {
                            seat=colnum;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-14");
                        input.nextLine();
                    }
                }
                if (rows[0][colnum - 1] == 0) {
                    System.out.println("you can  book the ["+rownum+(colnum)+"] Seat");
                    while (true) {
                        System.out.print("Please enter [y] to book the seat: ");
                        choice = input.next().toLowerCase();
                        if (choice.length() != 1) {
                            System.out.println("Too many characters. Please enter [y] only");
                            continue;
                        } else if (!choice.equals("y")) {
                            System.out.println("Wrong character. Please enter [y]");
                            continue;
                        } else {
                            break; // Exit the loop if user enters 'y'
                        }
                    }
                    if (choice.equals("y")) {
                        rows[0][colnum - 1] = 1;
                    }
                } else {
                    System.out.println("Sorry!.The seat ["+rownum+(colnum) +"] is already booked.");
                    System.out.println("Please select a different row or seat number");
                    continue;
                }
            } else if (rownum.equals("B")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 12) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-12");
                        } else {
                            seat=colnum;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-12");
                        input.nextLine();
                    }
                }
                if (rows[1][colnum - 1] == 0) {
                    System.out.println("you can  book the ["+rownum+(colnum)+"] Seat");
                    while (true) {
                        System.out.print("Please enter [y] to book the seat : ");
                        choice= input.next().toLowerCase();
                        if (choice.length() != 1) {
                            System.out.println("Too much characters.Please Enter [y] only");
                            continue;
                        } else if (!choice.equals("y")) {
                            System.out.println("Wrong character.Please enter [y]");
                            continue;
                        } else {
                            break;
                        }
                    }

                    if (choice.equals("y")) {
                        rows[1][colnum - 1] = 1;
                    }
                } else {
                    System.out.println("Sorry!.The seat ["+rownum+(colnum) +"] is already booked.");
                    System.out.println("Please select a different row or seat number");
                    continue;
                }
            } else if (rownum.equals("C")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 12) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-12");
                        } else {
                            seat=colnum;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-12");
                        input.nextLine();
                    }
                }
                if (rows[2][colnum - 1] == 0) {
                    System.out.println("you can  book the ["+rownum+(colnum)+"] Seat");
                    while (true) {
                        System.out.print("Please enter [y] to book the seat : ");
                        choice= input.next().toLowerCase();
                        if (choice.length() != 1) {
                            System.out.println("Too much characters.Please Enter [y] only");
                            continue;
                        } else if (!choice.equals("y")) {
                            System.out.println("Wrong character.Please enter [y]");
                            continue;
                        } else {
                            break;
                        }
                    }

                    if (choice.equals("y")) {
                        rows[2][colnum - 1] = 1;
                    }
                } else {
                    System.out.println("Sorry!.The seat ["+rownum+(colnum) +"] is already booked.");
                    System.out.println("Please select a different row or seat number");
                    continue;
                }
            } else if (rownum.equals("D")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 14) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-14");
                        } else {
                            seat=colnum;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-14");
                        input.nextLine();
                    }
                }
                if (rows[3][colnum - 1] == 0) {
                    System.out.println("you can  book the ["+rownum+(colnum)+"] Seat");
                    while (true) {
                        System.out.print("Please enter [y] to book the seat : ");
                        choice= input.next().toLowerCase();
                        if (choice.length() != 1) {
                            System.out.println("Too much characters.Please Enter [y] only");
                            continue;
                        } else if (!choice.equals("y")) {
                            System.out.println("Wrong character.Please enter [y]");
                            continue;
                        } else {
                            break;
                        }
                    }

                    if (choice.equals("y")) {
                        rows[3][colnum - 1] = 1;
                    }

                } else {
                    System.out.println("Sorry!.The seat ["+rownum+(colnum) +"] is already booked.");
                    System.out.println("Please select a different row or seat number");
                    continue;
                }
            } else {
                System.out.println("Invalid seat row");
                System.out.println("Please enter a valid seat Row");
                continue;
            }

        break;
        }
        /*
            When buying a ticket it asks all the personal information of the person
            in the first all the personal information are validating
         */
        System.out.println("Make sure when you are entering name and the surname please use at least 5 characters and maximum 100 letters ");
        while (true){
            System.out.print("Enter your name : ");
            name=input.next();
            if(name.length()<5 || name.length()>150){
                System.out.println("Please enter a name which has letters 5-100");
                continue;
            }
            else if(name.contains("0") || name.contains("1") || name.contains("2") || name.contains("3") || name.contains("4") || name.contains("5") || name.contains("6") || name.contains("7") || name.contains("8") || name.contains("9")){
                System.out.println("Please only enter English letters");
                continue;
            }

            else{
                break;
            }
        }
        while (true){
            System.out.print("Enter your surname : ");
            surname= input.next();
            if(surname.length()<5 || surname.length()>150){
                System.out.println("Please enter a surname which has letters 5-100");
                continue;
            }
            else if(name.contains("0") || name.contains("1") || name.contains("2") || name.contains("3") || name.contains("4") || name.contains("5") || name.contains("6") || name.contains("7") || name.contains("8") || name.contains("9")){
                System.out.println("Please only enter English letters");
                continue;
            }
            else{
                break;
            }
        }
        System.out.println("******     Please Enter a valid gmail because all the communications are done through gmail     ******");
        while(true){
            System.out.print("Enter your email Address : ");
            email=input.next();
            inStr=email.contains("@gmail.com");
            if(inStr==true && email.length()>10){
                break;
            }
            else{
                System.out.println("The gmail is in valid please enter valid gmail");
                continue;
            }

        }
        Person person=new Person(name,surname,email);
         /*
            Creating new Object Person and stores the information about the personal information
         */
        if (colnum>=1 && colnum<=5){
            price=200;


        } else if (colnum>=6 && colnum<=9) {
            price=150;

        }
        else {
            price=180;

        }
        Ticket ticket = new Ticket(row,seat,price,person);
        /*
         creates a new Ticket object, likely storing information about a purchased seat,
         row, seat number, price and the personal information
         */



        System.out.println("You had booked the ["+rownum+(colnum)+"] Seat");
        /*
            Checks each element of the arrayOfTickets and find the latest null value element in
            the array and store the ticket information in that element
            Calls the save method and name it using booked row letter and seat number
         */
        for(int x=0;x< arrayOfTickets.length;x++){
            if (arrayOfTickets[x]==null){
                arrayOfTickets[x] =ticket;
                try {
                    ticket.save( arrayOfTickets[x].getRow()+arrayOfTickets[x].getSeat()+".txt"); // Construct file name
                    System.out.println("Ticket purchased and information saved successfully!");
                } catch (IOException e) {
                    System.err.println("Error saving ticket information: " + e.getMessage());
                }
                ticketCount++;
                break;

            }
        }
        while (true) {
            System.out.print("**************  Please Enter [n] ************* : ");
            choice= input.next().toLowerCase();
            if (choice.length() != 1) {
                System.out.println("Too much characters.Please Enter [n] only");
            } else if (!choice.equals("n")) {
                System.out.println("Wrong character.Please enter [n]");
            } else {
                break;
            }
        }

    }

    public void cancel_seat(int rows[][],Ticket[] arrayOfTickets) {
        /**
         * This method is called when the user need to cancel the booking
         * int rows[][],Ticket[] arrayOfTickets taking as method parameters
         * The canceled seat text file also deleted
         */
        String rownum;
        String row;
        int seat;
        int price;
        System.out.println("#####     Cancel a seat #######");
        System.out.println("***** First enter your row and then enter the seat number you had booked");
        while (true) {
            Scanner input = new Scanner(System.in);
            int colnum;
            System.out.print("Enter the row letter you want : ");
            rownum = input.next().toUpperCase();
            row=rownum;
            if (rownum.equals("A")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 14) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-14");
                        } else {
                            break;
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-14");
                        input.nextLine();
                    }
                }
                if (rows[0][colnum - 1] == 1) {
                    System.out.println("To cancel the ["+rownum+(colnum)+"] Seat");
                    while (true) {
                        System.out.print("Please enter [y] to cancel the seat : ");
                        choice= input.next().toLowerCase();
                        if (choice.length() != 1) {
                            System.out.println("Too much characters.Please Enter [y] only");
                            continue;
                        } else if (!choice.equals("y")) {
                            System.out.println("Wrong character.Please enter [y]");
                            continue;
                        } else {
                            break;
                        }
                    }

                    if (choice.equals("y")) {
                        rows[0][colnum - 1] = 0;
                    }
                } else {
                    System.out.println("The seat ["+rownum+(colnum) +"] is not booked.You can book this seat please go back to the main menu and go to the buy seat option");
                    break;
                }
            } else if (rownum.equals("B")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 12) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-12");
                        } else {
                            break;
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-12");
                        input.nextLine();
                    }

                }

                if (rows[1][colnum - 1] == 1) {
                    System.out.println("To cancel the ["+rownum+(colnum)+"] Seat");

                    while (true) {
                        System.out.print("Please enter [y] to cancel the seat : ");
                        choice= input.next().toLowerCase();
                        if (choice.length() != 1) {
                            System.out.println("Too much characters.Please Enter [y] only");
                            continue;
                        } else if (!choice.equals("y")) {
                            System.out.println("Wrong character.Please enter [y]");
                            continue;
                        } else {
                            break;
                        }
                    }
                    if (choice.equals("y")) {
                        rows[1][colnum - 1] = 0;
                    }
                } else {
                    System.out.println("The seat ["+rownum+(colnum) +"] is not booked.You can book this seat please go back to the main menu and go to the buy seat option");
                }   break;
            } else if (rownum.equals("C")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 12) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-12");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-12");
                        input.nextLine();
                    }
                }
                if (rows[2][colnum - 1] == 1) {
                    System.out.println("To cancel the ["+rownum+(colnum)+"] Seat");
                    while (true) {
                        System.out.print("Please enter [y] to cancel the seat : ");
                        choice= input.next().toLowerCase();
                        if (choice.length() != 1) {
                            System.out.println("Too much characters.Please Enter [y] only");
                            continue;
                        } else if (!choice.equals("y")) {
                            System.out.println("Wrong character.Please enter [y]");
                            continue;
                        } else {
                            break;
                        }
                    }

                    if (choice.equals("y")) {
                        rows[2][colnum - 1] = 0;
                    }
                } else {
                    System.out.println("The seat ["+rownum+(colnum) +"] is not booked.You can book this seat please go back to the main menu and go to the buy seat option");
                    break;
                }
            } else if (rownum.equals("D")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 14) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-14");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-14");
                        input.nextLine();
                    }
                }
                if (rows[3][colnum - 1] == 1) {
                    System.out.println("To cancel the ["+rownum+(colnum)+"] Seat");
                    while (true) {
                        System.out.print("Please enter [y] to cancel the seat : ");
                        choice= input.next().toLowerCase();
                        if (choice.length() != 1) {
                            System.out.println("Too much characters.Please Enter [y] only");
                            continue;
                        } else if (!choice.equals("y")) {
                            System.out.println("Wrong character.Please enter [y]");
                            continue;
                        } else {
                            break;
                        }
                    }

                    if (choice.equals("y")) {
                        rows[3][colnum - 1] = 0;
                    }
                } else {
                    System.out.println("The seat ["+rownum+(colnum) +"] is not booked.You can book this seat please go back to the main menu and go to the buy seat option");
                    break;
                }
            } else {
                System.out.println("Invalid seat row");
                System.out.println("Please enter a valid seat Row");
                continue;
            }
            System.out.println("You had canceled the ["+rownum+(colnum)+"] Seat");
            /*
            Checks each element of the arrayOfTickets and find the latest  valued element in
            the array and make it null save it to  that element
            Also Saved ticket file is also removing
         */
            for(int x=0;x< arrayOfTickets.length;x++){
                if (arrayOfTickets[x]!=null){
                    String fileName = arrayOfTickets[x].getRow() + arrayOfTickets[x].getSeat() + ".txt"; // Construct file name
                    File file = new File(fileName);
                    if (file.exists()) {
                        file.delete();
                        System.out.println("Ticket cancelled and saved file deleted successfully!");
                    } else {
                        System.err.println("The file is not Found " + fileName);
                    }
                    arrayOfTickets[x] =null;
                    ticketCount--;

                    break;

                }
            }
            while (true) {
                System.out.print("**************  Please Enter [n] ************* : ");
                choice= input.next().toLowerCase();
                if (choice.length() != 1) {
                    System.out.println("Too much characters.Please Enter [n] only");
                } else if (!choice.equals("n")) {
                    System.out.println("Wrong character.Please enter [n]");
                } else {
                    break;
                }
            }
            break;
        }

    }

    public void find_first_seat_available(int rows[][]){
        /**
         * This method is called when the user want to find the closest available seat
         */
        Scanner input = new Scanner(System.in);
        boolean SeatFound=false;
        for(int i=0;i< rows.length && !SeatFound;i++) {
                for (int j = 0; j < rows[i].length; j++) {
                    if (rows[i][j] == 0) {
                        SeatFound=true;
                        if (rows[0][j] == 0) {
                            System.out.println("you can book [A" + (j + 1) + "] Seat");
                        }
                        else if (rows[1][j] == 0) {
                            System.out.println("you can book [B" + (j + 1) + "] Seat");
                        } else if (rows[2][j] == 0) {
                            System.out.println("you can book [C" + (j + 1) + "] Seat");
                        } else {
                            System.out.println("you can book [D" + (j + 1) + "] Seat");
                        }
                    break;
                    }
                }
        }

        while(true){
            System.out.print("Please press [n] to visit to the main menu : ");
            choice= input.next().toLowerCase();
            if (choice.length() != 1) {
                System.out.println("Too much characters.Please Enter [n] only");
            }
            else if(!choice.equals("n")){
                System.out.println("Wrong character.Please enter [n] only");
            }
            else{
                break;
            }
        }
    }

    public void show_seating_plan(int rows[][]){
        /**
         * This method is called  when the user want to see how the seats were booked
         * int rows[][] as taking as method parameters
         */
        System.out.println("    O - Available Seats");
        System.out.println("    X - Sold Seats");
        System.out.println();
        String choice;
        Scanner input = new Scanner(System.in);
        for(int i=0;i< rows.length;i++){
            for(int j=0;j<rows[i].length;j++){
                if(rows[i][j]==0) {
                    System.out.print("O ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
            if(i==1){
                System.out.println();
            }
        }
        while(true){
            System.out.print("Please press [n] to visit to the main menu : ");
            choice= input.next().toLowerCase();
            if (choice.length() != 1) {
                System.out.println("Too much characters.Please Enter [n] only");
            }
            else if(!choice.equals("n")){
                System.out.println("Wrong character.Please enter [n] only");
            }
            else{
                break;
            }
        }
    }
    public static void print_tickets_info(Ticket[] arrayOfTickets){
        /**
         * This method is called when the user want to see the all the information about the tickets that had sold in that session and the personal information
         * Ticket[] arrayOfTickets taking as method parameters
         * total sales of the tickets also calculated in this method
         * Ticket is the object
         * if the current element is not null it calls printTicketInfo() method
         */
        Scanner input = new Scanner(System.in);
        String choice;
        int totalTicketsSale=0;
        for (Ticket element:arrayOfTickets){
            if (element !=null){
                element.printTicketInfo();
                System.out.println("-------------------------------------------------------------------------------------------");
                totalTicketsSale+=element.getPrice();

            }
        }
        System.out.println("Total Sales of the Tickets : €"+(totalTicketsSale));

        while(true){
            System.out.print("Please press [n] to visit to the main menu : ");
            choice= input.next().toLowerCase();
            if (choice.length() != 1) {
                System.out.println("Too much characters.Please Enter [n] only");
            }
            else if(!choice.equals("n")){
                System.out.println("Wrong character.Please enter [n] only");
            }
            else{
                break;
            }
        }
    }
    public void search_ticket(int rows[][],Ticket[] arrayOfTickets){
        /**
         * This method is called when the user need to know the specific seat is booked or not
         * int rows[][],Ticket[] arrayOfTickets are the method parameters
         */
        boolean ticketFound = false;
        Scanner input=new Scanner(System.in);
        String rownum;
        String row;
        int seat;
        int price;
        int colnum;
        while (true) {
            System.out.print("Enter the row letter you want : ");
            rownum=input.next().toUpperCase();
            row = rownum;
            if (rownum.equals("A")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 14) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-14");
                        } else {
                            seat = colnum;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-14");
                        input.nextLine();
                    }
                }
            }
            else if (rownum.equals("B")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 12) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-12");
                        } else {
                            seat = colnum;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-12");
                        input.nextLine();
                    }
                }

            }
            else if (rownum.equals("C")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 12) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-12");
                        } else {
                            seat = colnum;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-12");
                        input.nextLine();
                    }
                }
            }
            else if (rownum.equals("D")) {
                while (true) {
                    try {
                        System.out.print("Enter the seat number you want : ");
                        colnum = input.nextInt();
                        if (colnum < 1 || colnum > 12) {
                            System.out.println("The seat number is out of range.Please enter a number between 1-12");
                        } else {
                            seat = colnum;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong data type.Please enter a integer between 1-12");
                        input.nextLine();
                    }
                }
            }
            else{
                System.out.println("Invalid seat row");
                System.out.println("Please enter a valid seat Row");
                continue;
            }
        break;
        }
        for(Ticket element:arrayOfTickets) {
            if (element != null && element.getRow().equals(rownum) && element.getSeat() == colnum) {
                element.printTicketInfo();
                ticketFound = true;
                break;
            }
        }
        if(!ticketFound){
            System.out.println(rownum+colnum+" seat is available");
        }
        while(true){
            System.out.print("Please press [n] to visit to the main menu : ");
            choice= input.next().toLowerCase();
            if (choice.length() != 1) {
                System.out.println("Too much characters.Please Enter [n] only");
            }
            else if(!choice.equals("n")){
                System.out.println("Wrong character.Please enter [n] only");
            }
            else{
                break;
            }
        }

    }



}
