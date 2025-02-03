package TollManagement;

import java.util.*;

public class Vechicle {
    private int vechileNo;
    private String type;
    private int start = 1;
    private boolean VIP;
    private int TotalTollFee = 0;
    static Map<Integer,Vechicle> vechiles = new HashMap<>();
    static Map<Integer , ArrayList<Journey>> vechicleJourney = new HashMap<>();

     class Journey{
        int start;
        int destination;
        int journeyCost;
        ArrayList<Integer> tolls = new ArrayList<>();

         public Journey(int start, int destination) {
             this.start = start;
             this.destination = destination;
         }

         @Override
         public String toString() {
             return "Start from "+ start + " to " + destination + " total journeyCost is "+ journeyCost + " for crossing Tolls " + tolls;
         }
     }

    public Vechicle(int vechileNo, String type, boolean VIP) {
        this.vechileNo = vechileNo;
        this.type = type;
        this.VIP = VIP;
        vechiles.put(vechileNo , this);
        vechicleJourney.put(vechileNo , new ArrayList<>());
    }

    void startJourny( int destination){
        int forward = (destination - start + Toll.TotalTolls) % Toll.TotalTolls;
        int backward = (start - destination + Toll.TotalTolls) % Toll.TotalTolls;
        Journey journey = new Journey(start , destination);
        if(backward < forward){
            int i = start;
            journey.tolls.add(i);
            Toll.Tolls.get(i).vechiclesCrossed.add(this);
            int fee = this.tollFee(i);
            Toll.Tolls.get(i).setCollection(fee);
            do{
                i--;
                if( i == 0) i = Toll.TotalTolls;
                Toll.Tolls.get(i).vechiclesCrossed.add(this);
                journey.tolls.add(i);
                fee = this.tollFee(i);
                Toll.Tolls.get(i).setCollection(fee);
                    journey.journeyCost += fee;
                    this.TotalTollFee += fee;

            }while (i != destination);
        }else{
            int i = start;
            journey.tolls.add(i);
            Toll.Tolls.get(i).vechiclesCrossed.add(this);
            int fee = this.tollFee(i);
            Toll.Tolls.get(i).setCollection(fee);
            do{

                i++;
                journey.tolls.add(i);
                Toll.Tolls.get(i).vechiclesCrossed.add(this);


                    fee = this.tollFee(i);
                    Toll.Tolls.get(i).setCollection(fee);
                    journey.journeyCost += fee;
                    this.TotalTollFee += fee;

            }while (i != destination);
        }
        this.start = destination;
        vechicleJourney.getOrDefault(this.vechileNo, new ArrayList<>()).add(journey);
    }

    public int tollFee(int currentToll ){
        Toll toll = Toll.Tolls.get(currentToll);
        int price = toll.getFee(this.type);
         return this.VIP ? (int)((.8) * price) : price;
    }



    static void displayVechileData(){
        System.out.println("All Vechile Details");
         for (Vechicle vechicle : vechiles.values()){
             System.out.println("Vechile No: " + vechicle.vechileNo + "\nType: "+ vechicle.type );
             System.out.println("Journeys");
             for(Journey journey : vechicleJourney.get(vechicle.vechileNo)){
                 System.out.println(journey.toString());
                 System.out.println("------------------------");
             }
             System.out.println("_____________________________________");
             System.out.println("Total journey Fees " + vechicle.TotalTollFee);
         }
        System.out.println("_________________________________________________________");
        System.out.println("_________________________________________________________");
    }

    public int getVechileNo() {
        return vechileNo;
    }



    public String getType() {
        return type;
    }

    public boolean isVIP() {
        return VIP;
    }

    public int getTotalTollFee() {
        return TotalTollFee;
    }


}
