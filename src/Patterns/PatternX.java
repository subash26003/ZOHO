package Patterns;

public class PatternX {
    public static void main(String[] args) {
        String s = "PROGRAM";
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(i == j || j == s.length() - i - 1){
                    System.out.print(s.charAt(k));
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            k++;
        }
    }
}
