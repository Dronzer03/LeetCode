package SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Part 1 :
You are getting the readings of server latencies. You need to return the avg latency for the last K values.
For example -
Latencies - 10, 20, 30, 80, 30, 20, 80, 80
K = 5
O/P - 34 , 36, 48, 58
You can assume you start your output after once you have K values.

Part 2 :
You still have the same latencies coming in, but now you have window size of K and there is a value X.
You need to ignore the top X values when calculating the avg.
For ex -
Latencies - 60, 70, 30, 100, 30, 20, 40, 80
K = 5
X = 2
O/p - 36 [60+30+30+20+40], 38 [70+30+30+20+40]
*/
public class LatencyAverage {
    public List<Integer> findAverage(int[] input, int k) {
        if (input.length < k)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = 0;

        int current = 0;
        while (right < input.length) {
            if (right < k - 1) {
                current += input[right++];
                continue;
            }

            current += input[right++];
            result.add(current / k);
            current -= input[left++];
        }

        return result;
    }

     public static void main(String[] args) {
         int[] input = {10, 20, 30, 80, 30, 20, 80, 80};
         System.out.println(new LatencyAverage().findAverage(input, 5));
     }
}
