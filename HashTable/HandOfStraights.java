package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// LC - 846
// LC - 1296
// https://leetcode.com/problems/hand-of-straights
// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Arrays.sort(hand);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : hand) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        for (int n : hand) {
            if (countMap.containsKey(n)) {
                int count = countMap.get(n);
                countMap.remove(n);
                for (int i = 1; i < groupSize; i++) {
                    if (countMap.containsKey(n + i)) {
                        if (countMap.get(n + i) < count) {
                            return false;
                        } else {
                            countMap.put(n + i, countMap.get(n + i) - count);
                            if (countMap.get(n + i) == 0)
                                countMap.remove(n + i);
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8,9,10,12};
        System.out.println(new HandOfStraights().isNStraightHand(hand, 3));
    }
}
