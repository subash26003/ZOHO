package TollManagement;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int n = 6;
        Toll.initailize(n);

        Scanner scan = new Scanner(System.in);

        Vechicle vechicle1 = new Vechicle(123 , "CAR"  , true);
        Vechicle vechicle2 = new Vechicle(1234 , "Bike" , false);
        vechicle1.startJourny( 3);
        vechicle1.startJourny(  4);

        vechicle2.startJourny(2);
        vechicle2.startJourny(3);

        Vechicle.displayVechileData();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        Toll.displayTollDetails();
    }
}
