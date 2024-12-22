package main.java.com.problems.arrays;

/*
https://leetcode.com/problems/minimum-time-visiting-all-points/description/


Easy
On a 2D plane,
there are n points with integer coordinates points[i] = [xi, yi].
 Return the minimum time in seconds to visit all the points
 in the order given by points.

You can move according to these rules:


 */

public class MinimumTimeVisitingAllPoints1266 {
    public static void main(String[] args) {

        int[][] points = {{1,1},{3,4},{-1,0}};
//        Output: 7
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {

        /*
            1.get starting coordinates array points from points[0]
            2.create x1, and y1 from coordinates create a variable that will store time (result)
            3.traverse points from = 1 to i < points.length

            the time it will take from x1, y1 to x2, y2
            will be the maximum of (abs(x2 - x1), abs(y2- y1))

            4.make sure to swap starting coordinates with the
            next coordinates

        */
        int[] coordinates = points[0];
        int x1 = coordinates[0];
        int y1 = coordinates[1];
        int time = 0;

        for(int i = 1; i < points.length; i++){
            int[] nextCoordinates = points[i];
            int x2 = nextCoordinates[0];
            int y2 = nextCoordinates[1];
            time += Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
            x1 = x2;
            y1 = y2;
        }
        return time;
    }
    //(1 - 3)(4 -  1) = (2)(3) = 3
    //(-1-3)(4 - 0) = (4, 4) = 4 = 7
}
