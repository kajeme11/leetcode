package main.java.com.crackingthecodinginterview.arrays;

/*

    Write a method to replace all spaces in a string with '%20'
    The string has sufficient space at the end to hold the additional characters
    you are given the true length of the string
    use a character array and do an in place solution
 */

import java.util.Arrays;

public class Urilify {

    public static void main(String[] args) {
        String s1 = "Mr John Smith    ";
        int trueLength = 13;
        s1 = urilify(s1.toCharArray(), trueLength);
        System.out.println(s1);
    }

    /**
     *
     * find how many blank spaces there is in the true len
     *
     * then create find how many actual indeces we will need
     * int actualLen = trueLen + emptySpaces * 2  - 1;
     *
     * traverse from end of array
     * if
     *
     */

    public static String urilify(char[] c, int trueLen){

        int emptySpaces = 0;
        for(int i = 0; i < trueLen; i++){
            if(Character.isSpaceChar(c[i])){
                emptySpaces++;
            }
        }

        int actualLen = trueLen + emptySpaces * 2 - 1;

//        "M,r, ,J,o,h,n, ,S,m,i,t,h, , , , "

        for(int i = trueLen - 1; i >= 0; i--){
            if(Character.isSpaceChar(c[i])){
                c[actualLen--] = '0';
                c[actualLen--] = '2';
                c[actualLen--] = '%';
            }else{
                c[actualLen--] = c[i];
            }
        }


        return Arrays.toString(c);
    }

}
