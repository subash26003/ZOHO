package String;

public class Reverse {
    static    void  swap(StringBuilder s , int i  , int j){
        char temp = s.charAt(i);
        s.setCharAt(i ,s.charAt(j));
        s.setCharAt(j , temp);
    }
    public static void main(String[] args) {
        String a = "subashu";
        StringBuilder s = new StringBuilder(a);
        int n = a.length();
        for(int i = 0 ; i < n / 2 ; i++){
            swap(s,i,n-i-1);
        }
        System.out.println(s);
    }
}
