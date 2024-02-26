package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// GFG
// https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
public class MinimumMultiplications {
    public int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end)
            return 0;
        Queue<Integer> queue = new LinkedList<>();
        int mod = 100000;
        int[] dist = new int[mod];
        Arrays.fill(dist, (int)1e9);

        queue.offer(start);
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int number = queue.poll();
                for (int n : arr) {
                    int res = (n * number) % mod;
                    if (res == end)
                        return 1 + distance;
                    if (1 + distance < dist[res]) {
                        dist[res] = 1 + distance;
                        queue.offer(res);
                    }
                }
            }
            distance++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,65};
        System.out.println(new MinimumMultiplications().minimumMultiplications(arr, 7, 66175));
    }
}
