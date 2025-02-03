package TollManagement;

import java.util.*;

public class Toll {
    private int bikeFee = 100;
    private int carFee = 100;
    private int collection = 0;
    static int TotalTolls;
    public Toll(int tollN0) {
        this.tollN0 = tollN0;
    }

    private int tollN0;
    static Map<Integer , Toll> Tolls = new HashMap<>();

    ArrayList<Vechicle> vechiclesCrossed = new ArrayList<>();

    static void initailize(int n){
        TotalTolls = n;
        for (int i = 1; i <= n; i++) {
            Toll toll = new Toll(i);
            Tolls.put(toll.tollN0 ,toll);
        }
    }


    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection += collection;
    }

    public int getFee(String type){
        if(type == "CAR") return this.carFee;
        return this.bikeFee;
    }

    public static void displayTollDetails(){
        for(int i : Tolls.keySet()){
            Toll toll = Tolls.get(i);
            System.out.println("Toll Number " + i);
            System.out.println("Vehicle Crossedd ");
            for(Vechicle vehicle : toll.vechiclesCrossed){
                System.out.println("Vehicle No : " + vehicle.getVechileNo() +"\nType: " + vehicle.getType()+"\nFee Paid: " + vehicle.tollFee(i));
                System.out.println("___________________________________________________________");
            }

            System.out.println("Total Toll Collection: " + toll.getCollection());
        }
    }
}
