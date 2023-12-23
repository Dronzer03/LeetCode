package DynamicProgramming;

import java.util.Arrays;

// LC - 55
// https://leetcode.com/problems/jump-game/
public class JumpGame {
    public boolean canJump(int[] nums) {
        return jump(0, nums);
    }

    private boolean jump(int index, int[] nums) {
        if (index == nums.length - 1)
            return true;

        if (index >= nums.length)
            return false;

        for (int i = 1; i <= nums[index]; i++) {
            if (jump(index + i, nums))
                return true;
        }

        return false;
    }

    public boolean canJumpDp(int[] nums) {
        boolean[] reachable = new boolean[nums.length];
        Arrays.fill(reachable, true);
        return jumpDp(0, reachable, nums);
    }

    private boolean jumpDp(int index, boolean[] reachable, int[] nums) {
        if (index == nums.length - 1)
            return true;

        if (index >= nums.length)
            return false;

        if (!reachable[index])
            return false;

        for (int i = nums[index]; i >= 1; i--) {
            if (jumpDp(index + i, reachable, nums))
                return true;
        }

        return reachable[index] = false;
    }

    public boolean canJumpOptimal(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
