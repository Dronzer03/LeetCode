package HashSet;

import java.util.HashMap;
import java.util.Map;

public class TwoSum3 {
    Map<Integer, Integer> numbers = new HashMap<>();
    TwoSum3() {}

    public void add(int x) {
        numbers.put(x, numbers.getOrDefault(x, 0) + 1);
    }

    public boolean find(int sum) {
        for (int n : numbers.keySet()) {
            if (n + n == sum && numbers.get(n) >= 2)
                return true;
            if (numbers.containsKey(sum - n))
                return true;
        }
        return false;
    }
}
