package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

// https://leetcode.com/problems/finding-mk-average
public class MKAverage {
    TreeMap<Integer, Integer> count = new TreeMap<>();
    Deque<Integer> stream = new LinkedList<>();
    int m;
    int k;
    int totalSize = 0;
    int totalSum = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        stream.offer(num);
        totalSize++;
        totalSum += num;
        if (stream.size() > m) {
            Integer key = stream.removeFirst();
            count.put(key, count.get(key) - 1);
            if (count.get(key) == 0)
                count.remove(key);
            totalSum -= key;
        }
        count.put(num, count.getOrDefault(num, 0) + 1);
    }

    public int calculateMKAverage() {
        if (totalSize < m)
            return -1;

        int smallest = count.firstKey();
        int largest = count.lastKey();
        int kSmall = k;
        int kLarge = k;
        int sum = 0;

        while (kSmall > 0) {
            int toSubtract = Math.min(kSmall, count.get(smallest));
            sum += (toSubtract * smallest);
            kSmall -= toSubtract;
            if (toSubtract == count.get(smallest))
                smallest = count.higherKey(smallest);
        }

        while (kLarge > 0) {
            int toSubtract = Math.min(kLarge, count.get(largest));
            sum += (toSubtract * largest);
            kLarge -= toSubtract;
            if (toSubtract == count.get(largest))
                largest = count.lowerKey(largest);
        }

        int result = (totalSum - sum) / (m - k - k);
        return result;
    }
}