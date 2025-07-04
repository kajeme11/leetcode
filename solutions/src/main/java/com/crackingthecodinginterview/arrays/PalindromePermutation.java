package main.java.com.crackingthecodinginterview.arrays;

/**
 * Palindrome Permutation
 * Given a string write a function to check if it is a permutation of
 * a palindrome. A palindrome is a phrase that is the same forwards or
 * backwards.
 * A permutation is a rearrangement of letters
 */

public class PalindromePermutation {

    public static void main(String[] args) {
        String s1 = "taco cat";
        String s2 = "hello";
        String s3 = "civic";
        System.out.println(isPermutationPalindrome(s1));
        System.out.println(isPermutationPalindrome(s2));
        System.out.println(isPermutationPalindrome(s3));
    }

    /**
     *
     * A palindrome can only have 1 odd frequency of characters
     *
     *
     * "hello"
     * h = 1, e = 1, l = 2, o = 1
     * Not a palindrome
     *
     * create an array that can hold 126 ascii characters
     *
     * loop over the length of the string
     * -ignore any spaces
     * -increase the frequency of the ascii index for every s character
     *
     * initialize oddCount to zero
     * loop over ascii and check if there is any odd values
     * if there is, increase oddCount
     * if oddCount increases to 2 return false
     *
     */

    public static boolean isPermutationPalindrome(String s){

        int[] ascii = new int[126];

        for(int i = 0; i < s.length(); i++){
            if(!Character.isSpaceChar(s.charAt(i))) {
                ascii[Character.toLowerCase(s.charAt(i))]++;
            }
        }
        int oddCount = 0;
        for (int j : ascii) {
            if (j % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
