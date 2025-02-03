package Arrays;

import java.util.ArrayList;

public class PossibleSubsets {
    static void getSubsets(int[] arr , ArrayList<ArrayList<Integer>> list , ArrayList<Integer> comb , int sum , int value , int start){
        if(sum >= value){
            if(sum == value){
                list.add(new ArrayList<>(comb));
            }
            return;
        }

        for(int i = start ; i < arr.length ; i++){
            sum += arr[i];
            comb.add(arr[i]);
            getSubsets(arr , list , comb , sum , value , i+1);
            comb.remove(comb.size() - 1);
            sum -= arr[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = 6;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        getSubsets(arr , list , new ArrayList<Integer>(), 0 , n , 0);
        System.out.println(list);
    }
}
