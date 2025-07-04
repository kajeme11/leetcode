package main.java.com.crackingthecodinginterview.arrays;

/**
 *
 * Implement an algorithm to determine if a string has all unique characters
 * What if you cannot use additional data structure ?
 */

class UniqueElement{

    public static void main(String[] args) {

        String s = "hello";
        String s1 = "heloa";
        System.out.println(uniqueElementsInString(s));
        System.out.println(uniqueElementsInString(s1));

    }

    /*
        h e l l o
            l
              r

Time Complexity O(n^2)
Space Complexity O(1)

     */

    public static boolean uniqueElementsInString(String s){

        for(int i = 0; i < s.length() - 1; i++){
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    System.out.println(i + " : " + j);
                    return false;
                }
            }
        }
        return true;
    }

}