package main.java.com.problems.backtrack;
import java.util.ArrayList;
import java.util.List;
public class LetterCasePermutation784 {

    public static void main(String[] args) {

        String s = "a1b2";
//        Output: ["a1b2","a1B2","A1b2","A1B2"]
        System.out.println(letterCasePermutation(s));
    }
    /*
   permutations:
       -The number of ways to arrange things
       -Order matters

   backtracking approach
   variables needed
   -index to keep track of length
   -List to hold final permutations
   1.Base Case, if index == length of string
   - then we have found a result, added to list
   2.Check if current index in string is a letter
   3.Make 2 recursive calls
   -1 with a lowercase index
   -the other uppercase, increase index in each
   4.else is a number, recursive call, increment index

   Time Complexity O(2^n)
   Space Complexity O(n * 2^m)
   n = string, length, m = number of permutation

   */
    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        permutations(s.toCharArray(), result, 0);
        return result;
    }

    public static void permutations(char[] chars, List<String> res, int index){
        if(index == chars.length){
            res.add(new String(chars));
            return;
        }

        if(Character.isLetter(chars[index])){
            chars[index] = Character.toLowerCase(chars[index]);
            permutations(chars, res, index + 1);
            chars[index] = Character.toUpperCase(chars[index]);
            permutations(chars, res, index + 1);
        }else{
            permutations(chars, res, index + 1);
        }
    }
}
