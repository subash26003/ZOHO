package TrainBooking;

import java.util.Scanner;

public class Main {
    static void bookTicket(Passenger p){
        if(TicketBooker.availableWaitingList == 0) {
            System.out.println("No Tickets Available");
            return;
        }
        TicketBooker booker = new TicketBooker();
        String berth = p.berthPreferance;

        if(berth.equals("L") && TicketBooker.availabeLowerBerth > 0 ||
                berth.equals("U") && TicketBooker.availabeUpperBerth > 0 ||
                berth.equals("M") && TicketBooker.availabeUpperBerth > 0
            ){
            if(berth.equals("L") && TicketBooker.availabeLowerBerth > 0){
                System.out.println("Lower Berth is Given");
                booker.bookTicktet(p ,"L" , TicketBooker.lowerBerthPositions.get(0));
                TicketBooker.availabeLowerBerth--;
                TicketBooker.lowerBerthPositions.remove(0);
            }else if(berth.equals("U") && TicketBooker.availabeUpperBerth > 0){
                System.out.println("Upper Berth is Given");
                booker.bookTicktet(p ,"U" , TicketBooker.upperBerthPositions.get(0));
                TicketBooker.availabeUpperBerth--;
                TicketBooker.upperBerthPositions.remove(0);
            }else if(berth.equals("M") && TicketBooker.availabeMiddleBerth > 0){
                System.out.println("Middle Berth is Given");
                booker.bookTicktet(p ,"M" , TicketBooker.middleBerthPositions.get(0));
                TicketBooker.availabeMiddleBerth--;
                TicketBooker.middleBerthPositions.remove(0);
            }
        }else{
            if(TicketBooker.availabeLowerBerth > 0){
                System.out.println("Lower Berth is Given");
                booker.bookTicktet(p ,"L" , TicketBooker.lowerBerthPositions.get(0));
                TicketBooker.availabeLowerBerth--;
                TicketBooker.lowerBerthPositions.remove(0);
            }else if(TicketBooker.availabeUpperBerth > 0){
                System.out.println("Upper Berth is Given");
                booker.bookTicktet(p ,"U" , TicketBooker.upperBerthPositions.get(0));
                TicketBooker.availabeUpperBerth--;
                TicketBooker.upperBerthPositions.remove(0);
            }else if(TicketBooker.availabeMiddleBerth > 0){
                System.out.println("Middle Berth is Given");
                booker.bookTicktet(p ,"M" , TicketBooker.middleBerthPositions.get(0));
                TicketBooker.availabeMiddleBerth--;
                TicketBooker.middleBerthPositions.remove(0);
            }else if(TicketBooker.availabeRAC > 0){
                System.out.println("RAC is Given");
                booker.bookRacTicket(p ,"RAC", TicketBooker.RACPositions.get(0));
                TicketBooker.availabeRAC--;
                TicketBooker.RACPositions.remove(0);
            }else if(TicketBooker.availableWaitingList > 0){
                booker.bookWaitingTicket(p ,"WL", TicketBooker.waitingListPositions.get(0) );
                TicketBooker.waitingListPositions.remove(0);
                TicketBooker.availableWaitingList--;
            }
        }
    }

    static void cancelTicket(int id){
        TicketBooker booker = new TicketBooker();
        boolean available = !TicketBooker.passengers.containsKey(id);
        if(available){
            System.out.println("Unkown Passenger");
        }else booker.cancelTicket(id);


    }

    public static void main(String[] args) {
        boolean loop = true;
        Scanner scan = new Scanner(System.in);
        while (loop){
            System.out.println(" 1. Book Ticket \n 2. Cancel Ticket \n 3. Available Ticket \n 4. All Ticket Details \n 5. exit");
            int choice = scan.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the passenger name , age and berth Preference(L , M and U)");
                    String name = scan.next();
                    int age = scan.nextInt();
                    String berthPreference = scan.next();
                    Passenger p = new Passenger(name , age , berthPreference);
                    bookTicket(p);
                    break;
                case 2:
                    int id = scan.nextInt();
                    cancelTicket(id);
                    break;
                case 3:
                    TicketBooker.availableTickets();
                    break;
                case 4:
                    TicketBooker.displayALLTicket();
                    System.out.println("Dispplayesd");
                    break;
                case 5:
                    loop = false;
                    break;
                default:
                    System.out.println("Enter the correct choice");
                    break;
            }
        }

        System.out.println(TicketBooker.RACBookedList);
        System.out.println(TicketBooker.waitingList);
    }
}
