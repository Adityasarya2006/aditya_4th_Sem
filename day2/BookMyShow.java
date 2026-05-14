package day2;

import java.util.Scanner;

public class BookMyShow {

    String userName;
    String movieName;
    String theaterName;
    String paymentMode;
    String showDate;

    int totalSeats = 100;
    int seatsBooked = 20;      // Already booked seats for that day
    int availableSeats = totalSeats - seatsBooked;

    double ticketPrice = 200;
    double totalAmount;

    // Method to display seat status BEFORE booking
    void showSeatStatus() {

        System.out.println("\n========== SEAT STATUS ==========");
        System.out.println("Movie           : " + movieName);
        System.out.println("Theater         : " + theaterName);
        System.out.println("Show Date       : " + showDate);

        System.out.println("---------------------------------");

        System.out.println("Total Seats     : " + totalSeats);
        System.out.println("Already Booked  : " + seatsBooked);
        System.out.println("Available Seats : " + availableSeats);

        System.out.println("=================================");
    }

    // Method to book tickets
    void bookTickets(int seats) {

        if (seats <= 0) {

            System.out.println("[ERROR] Invalid seat count!");

        }
        else if (seats > availableSeats) {

            System.out.println("[ERROR] Only " + availableSeats + " seats available!");

        }
        else {

            seatsBooked += seats;
            availableSeats -= seats;

            totalAmount += seats * ticketPrice;

            System.out.println("\n========== BOOKING SUCCESS ==========");
            System.out.println("Customer        : " + userName);
            System.out.println("Movie           : " + movieName);
            System.out.println("Theater         : " + theaterName);
            System.out.println("Show Date       : " + showDate);
            System.out.println("Booked Seats    : " + seats);
            System.out.println("Remaining Seats : " + availableSeats);
            System.out.println("Amount Paid     : Rs. " + (seats * ticketPrice));
            System.out.println("Payment Mode    : " + paymentMode);
            System.out.println("=====================================");
        }
    }

    // Method to cancel tickets
    void cancelTickets(int seats) {

        if (seats <= 0) {

            System.out.println("[ERROR] Invalid cancellation count!");

        }
        else if (seats > seatsBooked) {

            System.out.println("[ERROR] Cannot cancel more than booked seats!");

        }
        else {

            seatsBooked -= seats;
            availableSeats += seats;

            totalAmount -= seats * ticketPrice;

            System.out.println("\n========== CANCELLATION SUCCESS ==========");
            System.out.println("Cancelled Seats : " + seats);
            System.out.println("Refund Amount   : Rs. " + (seats * ticketPrice));
            System.out.println("Available Seats : " + availableSeats);
            System.out.println("==========================================");
        }
    }

    // Booking History
    void bookingHistory() {

        System.out.println("\n========== BOOKING HISTORY ==========");

        System.out.println("Customer Name   : " + userName);
        System.out.println("Movie Name      : " + movieName);
        System.out.println("Theater Name    : " + theaterName);
        System.out.println("Show Date       : " + showDate);

        System.out.println("--------------------------------------");

        System.out.println("Total Seats     : " + totalSeats);
        System.out.println("Booked Seats    : " + seatsBooked);
        System.out.println("Available Seats : " + availableSeats);

        System.out.println("--------------------------------------");

        System.out.println("Ticket Price    : Rs. " + ticketPrice);
        System.out.println("Total Amount    : Rs. " + totalAmount);
        System.out.println("Payment Mode    : " + paymentMode);

        System.out.println("======================================");
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookMyShow user = new BookMyShow();

        System.out.println("===== WELCOME TO BOOK MY SHOW =====");

        // Customer Name
        System.out.print("Enter Customer Name : ");
        user.userName = sc.nextLine();

        // Show Date
        System.out.print("Enter Show Date (DD/MM/YYYY): ");
        user.showDate = sc.nextLine();

        // Movie Selection
        boolean validMovie = false;

        while (!validMovie) {

            System.out.println("\n------ AVAILABLE MOVIES ------");
            System.out.println("1. Leo");
            System.out.println("2. Jailer");
            System.out.println("3. Salaar");
            System.out.println("4. KGF Chapter 2");
            System.out.println("5. Pushpa 2");

            System.out.print("Choose Movie Number: ");
            int movieChoice = sc.nextInt();
            sc.nextLine();

            switch (movieChoice) {

                case 1:
                    user.movieName = "Leo";
                    validMovie = true;
                    break;

                case 2:
                    user.movieName = "Jailer";
                    validMovie = true;
                    break;

                case 3:
                    user.movieName = "Salaar";
                    validMovie = true;
                    break;

                case 4:
                    user.movieName = "KGF Chapter 2";
                    validMovie = true;
                    break;

                case 5:
                    user.movieName = "Pushpa 2";
                    validMovie = true;
                    break;

                default:
                    System.out.println("[ERROR] Invalid movie selection!");
            }
        }

        // Theater Selection
        boolean validTheater = false;

        while (!validTheater) {

            System.out.println("\n------ AVAILABLE THEATERS ------");
            System.out.println("1. PVR Cinemas");
            System.out.println("2. INOX");
            System.out.println("3. Cinepolis");
            System.out.println("4. Sri Balaji Theater");
            System.out.println("5. Asian Multiplex");

            System.out.print("Choose Theater Number: ");
            int theaterChoice = sc.nextInt();
            sc.nextLine();

            switch (theaterChoice) {

                case 1:
                    user.theaterName = "PVR Cinemas";
                    validTheater = true;
                    break;

                case 2:
                    user.theaterName = "INOX";
                    validTheater = true;
                    break;

                case 3:
                    user.theaterName = "Cinepolis";
                    validTheater = true;
                    break;

                case 4:
                    user.theaterName = "Sri Balaji Theater";
                    validTheater = true;
                    break;

                case 5:
                    user.theaterName = "Asian Multiplex";
                    validTheater = true;
                    break;

                default:
                    System.out.println("[ERROR] Invalid theater selection!");
            }
        }

        // Payment Mode Selection
        boolean validPayment = false;

        while (!validPayment) {

            System.out.println("\n------ PAYMENT OPTIONS ------");
            System.out.println("1. UPI");
            System.out.println("2. Credit Card");
            System.out.println("3. Debit Card");
            System.out.println("4. Net Banking");
            System.out.println("5. Cash");

            System.out.print("Choose Payment Option: ");
            int paymentChoice = sc.nextInt();
            sc.nextLine();

            switch (paymentChoice) {

                case 1:
                    user.paymentMode = "UPI";
                    validPayment = true;
                    break;

                case 2:
                    user.paymentMode = "Credit Card";
                    validPayment = true;
                    break;

                case 3:
                    user.paymentMode = "Debit Card";
                    validPayment = true;
                    break;

                case 4:
                    user.paymentMode = "Net Banking";
                    validPayment = true;
                    break;

                case 5:
                    user.paymentMode = "Cash";
                    validPayment = true;
                    break;

                default:
                    System.out.println("[ERROR] Invalid payment option!");
            }
        }

        // Show seat status BEFORE booking
        user.showSeatStatus();

        boolean running = true;

        while (running) {

            System.out.println("\n----------- MENU -----------");
            System.out.println("1. Book Tickets");
            System.out.println("2. Cancel Tickets");
            System.out.println("3. View Booking History");
            System.out.println("5. Exit");

            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter number of seats to book: ");
                    int seats = sc.nextInt();

                    user.bookTickets(seats);
                    break;

                case 2:

                    System.out.print("Enter number of seats to cancel: ");
                    int cancelSeats = sc.nextInt();

                    user.cancelTickets(cancelSeats);
                    break;

                case 3:

                    user.bookingHistory();
                    break;

                case 4:

                    user.showSeatStatus();
                    break;

                case 5:

                    running = false;
                    System.out.println("\nThank you for using Book My Show!");
                    break;

                default:

                    System.out.println("[ERROR] Invalid Choice!");
            }
        }

        sc.close();
    }
}