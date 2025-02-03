package String;

import java.util.Arrays;
import java.util.Stack;

public class ReverseTheFirstOccurance {
    public static void main(String[] args) {
        String s = "This is a test String only";
        String s2 = "st";
        anotherWay(s,s2);
//        s = s.trim();
//        String[] arr = s.split(" ");
//        int index = 0;
//        int k = 0;
//        int i ;
//        for( i = 0 ; i < s.length() ; i++){
//            if(k == s2.length()) break;
//            char ch = s.charAt(i);
//            if(ch == ' ') index++;
//            if(ch == s2.charAt(k)){
//                k++;
//            }else{
//                k = 0;
//            }
//
//        }
//        int n = arr.length - 1;
//        while(index <= n){
//            String temp = arr[index];
//            arr[index] = arr[n];
//            arr[n] = temp;
//            n--;
//            index++;
//        }

//        System.out.println(Arrays.toString(arr));
    }

    static  void  anotherWay(String s , String s2){
        s = s.trim();
        int i , k = 0 , index , space = 0;
        for( i = 0 ; i < s.length() ; i++){
            if(k == s2.length()) break;
            char ch = s.charAt(i);
            if(ch == ' ') space = i;
            if(ch == s2.charAt(k)){
                k++;
            }else{
                k = 0;
            }
        }

        index = space != 0 ? space + 1 : 0;
       Stack<String> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        for (int j = index; j < s.length() ; j++) {
            char ch = s.charAt(j);
            if(ch != ' '){
                curr.append(ch + "");
            }else{
                stack.push(String.valueOf(curr));
                curr.setLength(0);
            }
        }
        stack.push(curr.toString());
        s = s.substring(0 , index );
        while(!stack.isEmpty()){
            s += stack.pop() + " ";
        }
        System.out.println(s);
    }
}
