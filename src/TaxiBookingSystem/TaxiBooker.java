package TaxiBookingSystem;

import java.util.ArrayList;

public class TaxiBooker {
    static ArrayList<Taxi> taxiList = new ArrayList<>();
    static ArrayList<Taxi> bookingHistory = new ArrayList<>();

    static int taxiLimit = 2;
    static int customerId = 1;

    public static String bookTaxi(char pickupLocation , char dropLocation , int pickupTime) throws CloneNotSupportedException {
        Taxi bookedTaxi = null;
        if(taxiList.size() < taxiLimit){
            bookedTaxi = new Taxi();
            taxiList.add(bookedTaxi);
        }else {
            int min = Integer.MAX_VALUE;
            for(Taxi T : taxiList){
                if(T.getDropTime() <= pickupTime &&  Math.abs(T.getCurrentLocation() - pickupLocation) <= min){
                    if( Math.abs(T.getCurrentLocation() - pickupLocation) == min){
                        if(bookedTaxi != null && bookedTaxi.getEarnings() > T.getEarnings()){
                            bookedTaxi = T;
                        }
                    }else{
                        bookedTaxi = T;
                        min = Math.abs(T.getCurrentLocation() - pickupLocation);
                    }

                }
            }
        }

        if(bookedTaxi != null){
            bookedTaxi.setCustomerId(customerId++);
            bookedTaxi.setPickupLocation(pickupLocation);
            bookedTaxi.setDropLocation(dropLocation);
            bookedTaxi.setPickUpTime(pickupTime);
            bookedTaxi.setDropTime(pickupTime + Math.abs(bookedTaxi.getCurrentLocation() - dropLocation));
            bookedTaxi.setCurrentLocation(dropLocation);
            bookedTaxi.setEarnings(bookedTaxi.getEarnings() + ((Math.abs(pickupLocation - dropLocation) * (100 + (10 * 10) ) )));
            bookedTaxi.setTaxiId(taxiList.indexOf(bookedTaxi) + 1);
            bookingHistory.add((Taxi)bookedTaxi.clone());
            return "Taxi number " + bookedTaxi.getTaxiId() + " is booked Successfully";
        }else{
            return "No Taxi is Available Now";
        }
    }

    static void displayBookingHistory(){
        System.out.println("-----------Booking History-------------------");
        for(Taxi T : bookingHistory){
            System.out.println("Taxi number: "+T.getTaxiId() + " Earnings is " + T.getEarnings() + " , CurrentLocation is " + T.getCurrentLocation() + " , Available from " + T.getDropTime());
            System.out.println("----------------------------------");
        }
    }

}
