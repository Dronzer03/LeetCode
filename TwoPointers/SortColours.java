package TwoPointers;

// LC - 75
// https://leetcode.com/problems/sort-colors
public class SortColours {
    public void sortColors(int[] nums) {
        int zeros = 0, ones = 0, twos = 0;

        for (int n : nums) {
            if (n == 0)
                zeros++;
            else if (n == 1)
                ones++;
            else
                twos++;
        }

        int index = 0;

        while (zeros > 0) {
            nums[index++] = 0;
            zeros--;
        }

        while (ones > 0) {
            nums[index++] = 1;
            ones--;
        }

        while (twos > 0) {
            nums[index++] = 2;
            twos--;
        }
    }

    public void sortColours(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int n : nums) {
            if (n == 0) {
                nums[two++] = 2;
                nums[one++] = 1;
                nums[zero++] = 0;
            } else if (n == 1) {
                nums[two++] = 2;
                nums[one++] = 1;
            } else {
                nums[two++] = 2;
            }
        }
    }
}
