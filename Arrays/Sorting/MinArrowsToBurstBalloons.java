package Arrays.Sorting;

import java.util.Arrays;

// LC - 452
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
public class MinArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));

        int result = 1;
        int previous = 0;

        for(int current = 1; current < points.length; current++){

            if(points[current][0] > points[previous][1]){
                result++;
                previous = current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{1,2},{2,3},{3, 4},{4,5}};
        System.out.println(new MinArrowsToBurstBalloons().findMinArrowShots(points));
    }
}
