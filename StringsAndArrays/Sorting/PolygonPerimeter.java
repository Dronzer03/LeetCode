package StringsAndArrays.Sorting;

import java.util.Arrays;

// LC - 2971
// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter
public class PolygonPerimeter {
    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long previousSum = 0;
        long ans = -1;
        for (int i=0; i<nums.length; i++) {
            if (i >= 2 && nums[i] < previousSum) {
                ans = previousSum + nums[i];
            }
            previousSum += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,1,2,5,50,3};
        System.out.println(largestPerimeter(nums));
    }
}