package DynamicProgramming;

import java.util.Arrays;

// LC - 45
// https://leetcode.com/problems/jump-game-ii
public class JumpGame2 {
    public static int jump(int[] nums) {
        boolean[] reachable = new boolean[nums.length];
        Arrays.fill(reachable, true);
        return jumpDp(0, reachable, nums, 0, Integer.MAX_VALUE);
    }

    private static int jumpDp(int index, boolean[] reachable, int[] nums, int count, int minJumps) {
        if (index >= nums.length - 1)
            return count;

        if (!reachable[index])
            return Integer.MAX_VALUE;

        for (int i = nums[index]; i >= 1; i--) {
            int jumps = jumpDp(index + i, reachable, nums, count + 1, minJumps);
            minJumps = Math.min(jumps, minJumps);
        }

        if (minJumps == Integer.MAX_VALUE)
            reachable[index] = false;

        return minJumps;
    }

    public static int jumpGreedy(int[] nums) {
        int left =0, right = 0;
        int jumps = 0;
        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(i + nums[i], farthest);
            }
            left = right + 1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 0, 4, 1};
        System.out.println(jumpGreedy(nums));
    }
}
