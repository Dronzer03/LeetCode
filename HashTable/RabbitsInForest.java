package HashTable;

import java.util.HashMap;
import java.util.Map;

// LC - 781
// https://leetcode.com/problems/rabbits-in-forest
public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int ans : answers) {
            countMap.put(ans, countMap.getOrDefault(ans, 0) + 1);
        }

        int result = 0;
        for (int key : countMap.keySet()) {
            int minRequired = 0;
            if (countMap.get(key) % (key + 1) == 0) {
                minRequired = (countMap.get(key) / (key + 1));
            } else {
                minRequired = (countMap.get(key) / (key + 1)) + 1;
            }
            if (minRequired == 0)
                minRequired = 1;
            result += (minRequired) * (key + 1);
        }

        return result;
    }
}
