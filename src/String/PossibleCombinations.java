package String;

import java.util.*;

public class PossibleCombinations {

    static void decode(String num , ArrayList<String> comb , int index , ArrayList<ArrayList<String>> ans){
        if(index >= num.length()) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        int onedigit = (num.charAt(index) - '0');
        if(onedigit >= 0 && onedigit <= 9){
            comb.add(String.valueOf(onedigit));
            decode(num , comb , index+1,ans);
            comb.removeLast();
        }

        if(index + 1 < num.length()){
            int twoDigit = Integer.parseInt(num.substring(index , index + 2));
            if(twoDigit >= 10 && twoDigit <= 26){
                comb.add(String.valueOf(twoDigit));
                decode(num , comb , index + 2,ans);
                comb.removeLast();
            }
        }
    }
    public static void main(String[] args) {
        Map<Character , Integer> map = new HashMap<>();
        for (int i = 0; i < 26 ; i++) {
            map.put((char)('a' + i),i + 1);
        }

        String num = "1123";
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        decode(num , new ArrayList<String>() , 0 , ans);

        System.out.println(ans);
     }
}
