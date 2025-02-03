package Arrays;

public class NoofNotes {
    public static void main(String[] args) {
        int[] notes = {2000 , 1000 , 500 , 200 , 100 , 50 , 20 , 10, 5 ,1};
        int amt = 2456;

        for(int i : notes){
            if(amt / i > 0){
                System.out.println(i + " : " + (amt / i));
                amt -= (i * (amt / i));

            }
        }
    }
}
