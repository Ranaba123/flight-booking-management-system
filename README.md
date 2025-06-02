# Flight Seats Management System

## Overview
The Plane Management System is a Java-based console application developed for the Software Development II coursework at the Informatics Institute of Technology, University of Westminster. This system allows users to manage airplane seat bookings through a command-line interface. It supports functionalities such as buying and canceling seats, finding available seats, displaying the seating plan, printing ticket information, and searching for specific tickets.

## Features
- **Buy a Seat**: Allows users to book a seat by providing a row letter (A-D) and seat number, along with personal information (name, surname, email). The seat is marked as booked, and a ticket is created and saved to a file.
- **Cancel a Seat**: Enables users to cancel a booked seat, freeing it up and deleting the associated ticket file.
- **Find First Available Seat**: Identifies and displays the first available seat in the plane.
- **Show Seating Plan**: Displays the current seating arrangement, marking available seats with 'O' and booked seats with 'X'.
- **Print Ticket Information**: Shows details of all sold tickets, including personal information and total sales for the session.
- **Search Ticket**: Allows users to check if a specific seat is booked and view the associated ticket details.
- **Save Ticket Information**: Saves ticket and personal information to a text file named after the seat (e.g., A1.txt).
- **Exit Program**: Terminates the application.

## Project Structure
The project is organized into the following Java classes under the `w2052777_PlaneManagement` package:
- **Person.java**: Represents a person with attributes `name`, `surname`, and `email`. Includes methods to get/set these attributes and print personal information.
- **Ticket.java**: Represents a ticket with attributes `row`, `seat`, `price`, and a `Person` object. Includes methods to get/set attributes, print ticket information, and save ticket details to a file.
- **Main Class**: Contains the main program logic, including a 2D array to represent the seating plan, a menu-driven interface, and methods for all functionalities listed above.

## Setup and Installation
1. **Prerequisites**:
   - Java Development Kit (JDK) 8 or higher.
   - A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with command-line compilation tools.

2. **Steps**:
   - Clone or download the project files to your local machine.
   - Ensure the project is structured under the `w2052777_PlaneManagement` package.
   - Compile and run the main class using your IDE or via the command line:
     ```bash
     javac w2052777_PlaneManagement/*.java
     java w2052777_PlaneManagement.MainClassName
     ```
     Replace `MainClassName` with the actual name of the main class (not provided in the document but typically something like `PlaneManagement`).

## Usage
1. Run the program to display the main menu:
   ```
   1) Buy a seat
   2) Cancel a seat
   3) Find first available seat
   4) Show seating plan
   5) Print ticket and information and total sales
   6) Search Ticket
   0) Quit
   ```
2. Enter a number (0-6) to select an option.
3. Follow the prompts to provide required inputs (e.g., row letter, seat number, personal information).
4. The program validates inputs (e.g., row letters A-D, seat numbers within valid ranges) and provides appropriate feedback.
5. Ticket information is saved to text files (e.g., `A1.txt`) when a seat is booked and deleted when canceled.

## Seating Plan
- The plane has 4 rows (A, B, C, D).
- Rows A and D have 14 seats each; rows B and C have 12 seats each.
- Seats are represented in a 2D array where `0` indicates an available seat and `1` indicates a booked seat.

## Input Validation
- Row letters must be A, B, C, or D (case-insensitive).
- Seat numbers must be within the valid range for the selected row (1-14 for A and D, 1-12 for B and C).
- Invalid inputs (e.g., non-integer seat numbers, invalid row letters) prompt error messages and request re-entry.

## File Handling
- When a ticket is purchased, details are saved to a text file named `<row><seat>.txt` (e.g., `A1.txt`).
- The file includes personal information (name, surname, email), row, seat, and price.
- Canceling a ticket deletes the corresponding file.

## Testing
The system includes a comprehensive test plan covering:
- Buying and canceling seats.
- Attempting to book already reserved seats.
- Handling invalid inputs (e.g., non-numeric seat numbers, invalid row letters).
- Displaying the seating plan and ticket information.
- Searching for booked and unbooked seats.
- Saving and deleting ticket files.
- Exiting the program.

Refer to the self-assessment form and test plan in the coursework report for detailed test cases and results.

## Known Issues
- The document does not include the complete main class code, so some method implementations (e.g., `buy_seat`) are partially missing.
- The `save` method in the `Ticket` class assumes file I/O operations work without network dependencies, but error handling for file operations could be enhanced.
- The seating plan assumes a fixed number of seats per row; dynamic seat configurations are not supported.

## Future Improvements
- Add support for dynamic seat configurations.
- Implement a graphical user interface (GUI) for better user experience.
- Enhance file handling with more robust error checking and backup mechanisms.
- Add support for multiple sessions or flights.

## Author
- **Name**: Sembu Kuttige Nemsara Ranaba
- **Student ID**: IIT No: 20221241 / UOW No: w2052777
- **Course**: Software Development II (4COSC010C.2)
- **Submission Date**: 03/25/2024

## License
This project is for educational purposes and submitted as part of coursework requirements. Unauthorized distribution or use is prohibited.
