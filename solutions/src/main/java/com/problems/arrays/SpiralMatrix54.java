package main.java.com.problems.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        Output: [1,2,3,6,9,8,7,4,5]
        System.out.println(spiralOrder(matrix));

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        /*
    int n = m.[0]length;
    int m = m.length;
    row_start = 0
    col_start = 0               col_end = n - 1

                  1 | 2 | 3 | 4
                  5 | 6 | 7 | 8
                  9 | 10|11| 12
    row_end = m - 1

    1.we keep looping while row_start <= row_end && col_start <= col_end

    2. The first iteration should start from (0, 0) to (0, n)
        adding to result matrix[row_start][i]
        we increase row_start since there is nothing to iterate over first array
    3.The second iteration should start from (row_start, col_end) to (col_end, row_end)
        adding to result matrix[i][col_end]
        we decrease col_end since we there are no more elements on that last column

    4. The third iteration should start from (row_end, col_end) to (row_end, col_start)
        adding to result matrix[row_end][i]
        we decrease row_end since there is nothing to iterate over bottom array
    5. The fourth and last iteration should start from (row_end, col_start) to (row_begin, col_start)
        adding to result matrix[row_start][i]
        we increase col_start since there is nothing to iterate over first column array

        --on every for loop check if size of result is less than n * m
        once it reaches n * m, we have found the full spiral
    */

        int n = matrix[0].length;
        int m = matrix.length;
        int row_start = 0;
        int col_start = 0;
        int row_end = m - 1;
        int col_end = n - 1;
        List<Integer> result = new ArrayList<>();
        while(row_start <= row_end && col_start <= col_end){
            for(int i = row_start; (result.size() < n * m) &&  i <= col_end; i++){
                result.add(matrix[row_start][i]);
            }
            row_start++;
            for(int i = row_start; (result.size() < n * m) &&  i <= row_end; i++){
                result.add(matrix[i][col_end]);
            }
            col_end--;
            for(int i = col_end; (result.size() < n * m) &&  i >= col_start; i--){
                result.add(matrix[row_end][i]);
            }
            row_end--;
            for(int i = row_end; (result.size() < n * m) &&  i >= row_start; i--){
                result.add(matrix[i][col_start]);
            }
            col_start++;

        }
        return result;

    }
}
