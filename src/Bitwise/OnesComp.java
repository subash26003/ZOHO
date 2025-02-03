package Bitwise;

public class OnesComp {
    public static void main(String[] args) {
        int n = 10 , m = -5;
        System.out.println(m+n);
        System.out.println(n + (~(m) + 1));

        int  i = 1;
        int mul = 0;
        while(i <= Math.abs(m)){
            mul += Math.abs(n);
            i++;
        }
        if(m < 0 || n < 0){
            mul = ~(mul) + 1;
        }else if(m == 0 || n == 0){
            mul = 0;
        }

        System.out.println("Multiplication " + mul);


        int div = 0;

        if(m == 0){
            System.out.println("Div Not Possible");
            return;
        }

        int count= 0;
        int a = Math.abs(n) , b = Math.abs(m);
        while(b < a){
            a -= b;
            count++;
        }

        if(m < 0 && n < 0){
            div = count;
        }else{
            div = ~(count) + 1;
        }

        System.out.println(div);
    }
}
