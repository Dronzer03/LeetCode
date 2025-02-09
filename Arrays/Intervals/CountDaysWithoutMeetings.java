package Arrays.Intervals;

import java.util.Arrays;

// LC - 3169
// https://leetcode.com/problems/count-days-without-meetings
public class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);

        int result = 0;
        int start = 1;
        for (int[] meeting : meetings) {
            if (meeting[0] > start) {
                result += meeting[0] - start;
            }
            start = Math.max(start, meeting[1] + 1);
        }
        if (start <= days)
            result += days - start + 1;
        return result;
    }
}
