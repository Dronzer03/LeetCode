import java.util.ArrayList;
import java.util.List;

public class ScratchPad {

    public static int fact(int n) {
        if (n == 0)
            return 1;
        return n * fact(n - 1);
    }

    public static int[] reverse(int[] nums, int start, int end) {
        if (start > end)
            return nums;

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        return reverse(nums, ++start, --end);
    }

    public static int[] reverse(int[] nums, int n) {
        if (n == nums.length / 2)
            return nums;

        int temp = nums[n];
        nums[n] = nums[nums.length - 1 - n];
        nums[nums.length - 1 - n] = temp;
        return reverse(nums, ++n);
    }

    public static boolean palindrome(String s, int i) {
        if (i == s.length() / 2)
            return true;

        if (s.charAt(i) == s.charAt(s.length() - i - 1))
            return palindrome(s, ++i);
        return false;
    }

    public static int fibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void subSequence(int i, List<Integer> numList, int[] nums) {
        if (i >= nums.length) {
            System.out.println(numList.toString());
            return;
        }

        numList.add(nums[i]);
        subSequence(i + 1, numList, nums);
        numList.remove(Integer.valueOf(nums[i]));
        subSequence(i + 1, numList, nums);
    }

    public static void main(String[] args) {
        System.out.println(fact(4));
        int[] nums = { 1, 2, 3, 4 };
        // System.out.println(Arrays.toString(reverse(nums, 0)));
        System.out.println(palindrome("bbaabb", 0));
        System.out.println(fibo(9));
        subSequence(0, new ArrayList<>(), nums);
        // 3 1 2 2 1 5
        // 0 0 0 0 0 1
    }
}
