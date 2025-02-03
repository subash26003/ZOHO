package String;

import java.util.Stack;

public class LongestSubstringBetweenSameChar {
    public static void main(String[] args) {
        String s = "abcccccbba";

        int maxLength = -1;  // To store the length of the longest substring
        int[] firstOccurrence = new int[256];  // Array to store the first occurrence of each character (ASCII size)

        // Initialize firstOccurrence array to -1 (indicating no character is visited yet)
        for (int i = 0; i < 256; i++) {
            firstOccurrence[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (firstOccurrence[currentChar] != -1) {
                // Calculate length of the substring between two same characters
                maxLength = Math.max(maxLength, i - firstOccurrence[currentChar] - 1);
            } else {
                // If it's the first time encountering the character, store its index
                firstOccurrence[currentChar] = i;
            }
        }

        System.out.println(maxLength);
    }
}
