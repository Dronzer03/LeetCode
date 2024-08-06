package TwoPointers;

// LC - 42
// https://leetcode.com/problems/trapping-rain-water
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int result = 0;

        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
            }
        }

        return result;
    }
}
