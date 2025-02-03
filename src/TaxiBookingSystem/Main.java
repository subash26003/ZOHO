package TaxiBookingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        boolean loop = true;
        Scanner scan = new Scanner((System.in));

        while (loop){
            System.out.println("\n 1. Book Taxi \n 2. Booking History \n 3. Exit");
            int choice = scan.nextInt();

            switch (choice){
                case 1:
                    System.out.println("\n Enter the Pickup location, Drop Location and Pickup Time");
                    char pickupLocation = scan.next().charAt(0);
                    char dropLocation = scan.next().charAt(0);
                    int pickupTime = scan.nextInt();
                    String bookingStatus = TaxiBooker.bookTaxi(pickupLocation , dropLocation ,pickupTime);
                    System.out.println(bookingStatus);
                    break;
                case 2:
                    TaxiBooker.displayBookingHistory();
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Enter the correct input");
            }

        }
    }
}
