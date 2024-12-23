package main.java.com.problems.arrays;


/*
    https://leetcode.com/problems/number-of-islands/description/
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands
horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

 */
public class NumberOfIslands200 {
    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
//        Output: 1
        char[][]  grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
//        Output: 3
        System.out.println(numIslands(grid));
        System.out.println(numIslands(grid2));
    }

    /*
      1.create a variable that will store the count of islands
      2.traverse matrix and if we found a '1', we have found an island
      increase count of islands and do a depth first search(dfs)
      to cover any part of the island horizontaly or verticaly

      Time complexity O(m * n) - rows * columns
      Space Complexity O(1)
  */
    public static int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    numberOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    /*
        recursively change any '1' to '0' so we can avoid counting the
        island all over again
        return once we have exceeded all posible ways
    */
    private static void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length
                || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
