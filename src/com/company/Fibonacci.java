package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Fibonacci {
    private static Integer[] cache = new Integer[31];
    public static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize(n);
    }
    private static int memoize(int n) {
        if(cache[n] != null) {
            return cache[n];
        }
        cache[n] = memoize(n - 1) + memoize(n - 2);
        return memoize(n);
    }

    public static ArrayList<String> merge(String[] words, String[] more) {
        ArrayList<String> sentence = new ArrayList<String>();
        for(String w : words) sentence.add(w);
        for(String w : more) sentence.add(w);
        return sentence;
    }

    public static boolean isUniqueChars(String str) {
        if(str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for(int i=0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static boolean isPermutationStr(String str1, String str2) {
        int sum1, sum2;
        sum1 = sum2 = 0;

        for(int i = 0; i < str1.length(); i++) {
            int val = str1.charAt(i);
            sum1 = sum1 + val;
        }

        for(int i = 0; i < str2.length(); i++) {
            int val = str2.charAt(i);
            sum2 = sum2 + val;
        }

        if(sum1 == sum2) {
            return true;
        } else {
            return false;
        }
    }

    public static char[] replaceSpaces(String str, int targetLength) {
        char[] charArray = str.toCharArray();
        int spaces = 0;

        for(int i = 0; i < targetLength; i++) {
            if(charArray[i] == ' ') {
                spaces++;
            }
        }

        int index = targetLength + spaces * 2;
        if(targetLength < str.length()) charArray[targetLength] = '\0';
        for(int i = targetLength - 1; i >= 0; i--) {
            if(charArray[i] == ' ') {
                charArray[index - 1] = '0';
                charArray[index - 2] = '2';
                charArray[index - 3] = '%';
                index = index - 3;
            } else {
                charArray[index - 1] = charArray[i];
                index--;
            }
        }

        return charArray;
    }

    public static boolean isPalindromePermutation(String str) {
        String clean = str.replaceAll("\\s+", "").toLowerCase();
        char[] charClean = clean.toCharArray();
        HashMap<Character, Integer> countTable = new HashMap<Character, Integer>();
        int count = 0;
        for(char c : charClean) {
            if(countTable.containsKey(c)) {
                countTable.put(c, countTable.get(c) + 1);
            }
            else {
                countTable.put(c, 1);
            }
        }

        if(countTable.size() == 1) {
            return true;
        }

        for( int i : countTable.values()) {
            if(i == 1) {
                count++;
            }
            if(i != 1 && i % 2 == 1) {
                return false;
            }
        }

        if(count > 1) {
            return false;
        }

        return true;
    }

    public static boolean isZeroOrOneEditsAway(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int edits = 0;
        for(char c1 : charArray1) {
            for(char c2 : charArray2) {
                if(c1 != c2) {
                    edits++;
                    if(edits > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int consecutiveCount = 0;
        for(int i = 0; i < str.length(); i++) {
            consecutiveCount++;
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(consecutiveCount);
                consecutiveCount = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        // Fibonacci a = new Fibonacci();
        System.out.println(fibonacci(3));

        String[] words = {"Pradeep", "Panga"};
        String[] more = {"Oklahoma", "State"};

        ArrayList<String> merged = merge(words, more);

        for(String w : merged) System.out.println(w);

        //System.out.println("String is: " + merged);

        System.out.println("String in unique: " + isUniqueChars("pradep"));
        System.out.println("Strings tadap and aadtp are permutation: " + isPermutationStr("tadap", "aadtp"));

        System.out.println(replaceSpaces("Mr Pradeep Panga    ", 16));

        System.out.println("is palindrome permutation: " + isPalindromePermutation("aabbccc"));

        System.out.println("is zero or 1 edits away: " + isZeroOrOneEditsAway("pale", "bale"));

        System.out.println("compressed out: " + compress("aabbcceeaaa"));

        int[][] matrix = { {1, 3, 5, 6}, {1, 3, 0, 5}, {3, 6, 3, 1}, {4, 6, 8, 1} };

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                matrix[1][j] = 0;
                matrix[i][2] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        LinkedList<String> llStr = new LinkedList<>();
        llStr.add("Pradeep");
        llStr.addFirst("Panga");
        llStr.addLast("Kumar");
        System.out.println(llStr.indexOf("Panga"));
        System.out.println(Arrays.toString(llStr.toArray()));

    }
}
