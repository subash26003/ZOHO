package String;

import java.util.HashSet;

public class FirstOccurances {
    public static void main(String[] args) {

        String s1= "ZOHOCORPORATION", s2="PORT";
        anotherWay(s1 , s2);
        int min = s1.indexOf(s2.charAt(0));
        int max = s1.indexOf(s2.charAt(0));

//        for(char ch : s2.toCharArray()){
//            int index = s1.indexOf(ch);
//            if( index < min){
//                min = index;
//            }else if(index > max){
//                max = index;
//            }
//        }
//
//        System.out.println(s1.substring(min , max + 1));
    }

    static void anotherWay(String s1 , String s2){
        HashSet<Integer> indices = new HashSet<>();

        // Traverse s1 and store indices of characters that are in s2
        for (int i = 0; i < s1.length(); i++) {
            if (s2.indexOf(s1.charAt(i)) != -1) {
                indices.add(i);  // Add the index to the set
            }
        }

        // If no characters from s2 are found in s1
        if (indices.isEmpty()) {
            System.out.println("Not found");
        } else {
            // Get the smallest and largest index from the set
            int minIndex = Integer.MAX_VALUE;
            int maxIndex = Integer.MIN_VALUE;

            for (int index : indices) {
                if (index < minIndex) {
                    minIndex = index;
                }
                if (index > maxIndex) {
                    maxIndex = index;
                }
            }

            // Output the substring from the smallest to the largest index
            System.out.println("Substring: " + s1.substring(minIndex, maxIndex + 1));
        }
    }
}
