package Arrays.Intervals;

import java.util.ArrayList;
import java.util.List;

// LC - 228
// https://leetcode.com/problems/summary-ranges
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index + 1] != nums[index] + 1) {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(start);
                    sb.append("->");
                    sb.append(end);
                    result.add(sb.toString());
                }
                start = nums[index + 1];
            }
            end = nums[index + 1];
        }

        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(start);
            sb.append("->");
            sb.append(end);
            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = {0,1,2,4,5,7};
        new SummaryRanges().summaryRanges(num);
    }
}
