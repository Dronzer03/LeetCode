package HashSet;

import java.util.*;

// LC - 380
// https://leetcode.com/problems/insert-delete-getrandom-o1
public class RandomizedSet {

    private Set<Integer> randomSet;

    public RandomizedSet() {
        this.randomSet = new HashSet<>();
    }

    public boolean insert(int val) {
        return randomSet.add(val);
    }

    public boolean remove(int val) {
        return randomSet.remove(val);
    }

    public int getRandom() {
        int random = new Random().nextInt(this.randomSet.size());
        int i = 0;
        for (int ele : this.randomSet) {
            if (i == random)
                return ele;
            i++;
        }
        return -1;
    }
}