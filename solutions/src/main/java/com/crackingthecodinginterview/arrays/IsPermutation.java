package main.java.com.crackingthecodinginterview.arrays;

public class IsPermutation {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "llhio";
        System.out.println(isPermutation(s1, s2));
    }

    /**
     * 0 to 127 in decimal
     * Extended ASCII, which includes 128–255
     *
     h e l l o


     l l h e o

     int[] ascii = new int[156]

     for i in s1:
        ascii[i++]
     for i in s2
        ascii[i--]

     for i in ascii
        if ascii[i] != 0 return false

     return true


     Time Complexity O(N)
     Space Complexity O(N)

     */
    public static boolean isPermutation(String s1, String s2){

        int[] ascii = new int[126];

        for(int i = 0; i < s1.length(); i++){
            System.out.println(ascii[s1.charAt(i)]);
            ascii[s1.charAt(i)] -= 1;
        }
        for(int i = 0; i < s2.length(); i++){
            ascii[s2.charAt(i)] += 1;
        }

        for(int i = 0; i < 125; i++){
            if(ascii[i] != 0){
                return false;
            }
        }

        return true;
    }



}
