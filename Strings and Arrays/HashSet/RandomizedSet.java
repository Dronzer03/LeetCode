import java.util.*;

public class RandomizedSet {

    private Set<Integer> randomSet;

    public RandomizedSet() {
        this.randomSet = new HashSet<>();
    }

    public boolean insert(int val) {
        if (this.randomSet.contains(val)) {
            return false;
        } else {
            this.randomSet.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (this.randomSet.contains(val)) {
            this.randomSet.remove(Integer.valueOf(val));
            return true;
        }
        return false;
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