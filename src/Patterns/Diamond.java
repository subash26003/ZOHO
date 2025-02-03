package Patterns;

public class Diamond {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < 2*n; i++) {
            int k = i < n ? n - i - 1 : i - n ;
            for (int j = 0; j < n; j++) {
                if(j >= k ){
                    System.out.print("* ");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
