package TrainBooking;

import java.util.*;

public class TicketBooker {
    static int availabeUpperBerth = 1;
    static int availabeMiddleBerth = 1;
    static int availabeLowerBerth = 1;
    static int availabeRAC = 1;
    static int availableWaitingList = 1;

    static List<Integer> bookedTicketList = new ArrayList<>();
    static Queue<Integer> RACBookedList = new LinkedList<>();
    static Queue<Integer> waitingList = new LinkedList<>();

    static List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> upperBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> RACPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));

    static Map<Integer , Passenger> passengers = new HashMap<>();


    void bookTicktet(Passenger p , String allotedBerth , int seatNo){
        p.seatNo = seatNo;
        p.alloted = allotedBerth;
        passengers.put(p.passengerId , p);
        bookedTicketList.add(p.passengerId);
        System.out.println("-----------------------------------------Ticket Booked Successfully");
    }

    void bookWaitingTicket(Passenger p , String allotedBerth , int num){
        p.seatNo = num;
        p.alloted = allotedBerth;
        waitingList.add(p.passengerId);
        passengers.put(p.passengerId , p);
        System.out.println("-----------------------------------------Waiting List Ticket Booked");

    }



    void bookRacTicket(Passenger p , String allotedBerth ,  int num ){
        p.seatNo = num;
        p.alloted = allotedBerth;
        RACBookedList.add(p.passengerId);
        TicketBooker.passengers.put(p.passengerId , p);
        System.out.println("-----------------------------------------RAC Ticket Booked");

    }

    void cancelTicket(int passengerID){
        Passenger p = passengers.get(passengerID);
        String status = p.alloted;
        passengers.remove(passengerID);
        if(status.equals("L")){
            availabeLowerBerth++;
            lowerBerthPositions.add(p.seatNo);
        }else if(status.equals("U")){
            availabeUpperBerth++;
            upperBerthPositions.add(p.seatNo);
        }else if(status.equals("M")){
            availabeMiddleBerth++;
            middleBerthPositions.add(p.seatNo);
        }

        if(RACBookedList.size() > 0){
            Passenger passengerFromRAC = passengers.get(RACBookedList.poll());
            RACPositions.add(passengerFromRAC.seatNo);
            availabeRAC++;

            if(waitingList.size() > 0){
                Passenger passengerFromWL = passengers.get(waitingList.poll());
                waitingListPositions.add(passengerFromWL.seatNo);
                availableWaitingList++;

                passengerFromWL.alloted = "RAC";
                passengerFromWL.seatNo = RACPositions.get(0);
                RACPositions.remove(0);
                availabeRAC--;
            }

            Main.bookTicket(passengerFromRAC);
        }
    }

    static void displayALLTicket(){
        System.out.println("\t----------Booked Ticket List-------");
        for(int i : passengers.keySet()){
            Passenger p = passengers.get(i);

            System.out.println("Name : " + p.name);
            System.out.println("Seat No : " + p.seatNo + p.alloted);
            System.out.println("ID : " + p.passengerId);
            System.out.println("-------------");
        }
        System.out.println("\t----------End of Booked Ticket List-------");
    }

    static void availableTickets(){
        System.out.println("Lower Berth : " + availabeLowerBerth);
        System.out.println("Upper Berth : " + availabeUpperBerth);
        System.out.println("Middle Berth : " + availabeMiddleBerth);
        System.out.println("Total : " + ( availabeMiddleBerth + availabeLowerBerth + availabeUpperBerth) + " seats are available");
    }


}
