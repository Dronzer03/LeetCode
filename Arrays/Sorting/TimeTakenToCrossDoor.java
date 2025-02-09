package Arrays.Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TimeTakenToCrossDoor {
    public int[] findTime(int[] arrival, int[] state) {
        PriorityQueue<int[]> enter = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> exit = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int time = 0;
        int person = 0;
        time = arrival[person];
        int lastUsed = -1;
        int[] result = new int[arrival.length];

        while (true) {
            while (person < arrival.length && arrival[person] <= time) {
                if (state[person] == 0)
                    enter.offer(new int[]{arrival[person], person});
                else
                    exit.offer(new int[]{arrival[person], person});
                person++;
            }

            if (enter.isEmpty() && exit.isEmpty()) {
                if (person == arrival.length)
                    break;
                time = arrival[person];
                continue;
            }

            if (enter.isEmpty() || (!exit.isEmpty() && (lastUsed == -1 || lastUsed == 1))) {
                while (!exit.isEmpty()) {
                    int[] pass = exit.poll();
                    result[pass[1]] = time++;
                }
                lastUsed = 1;
            } else {
                while (!enter.isEmpty()) {
                    int[] pass = enter.poll();
                    result[pass[1]] = time++;
                }
                lastUsed = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arrival = new int[]{0,0,0};
        int[] state = new int[]{1,0,1};
        System.out.println(Arrays.toString(new TimeTakenToCrossDoor().findTime(arrival, state)));
    }
}
