package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlices2 {

    public static int numberOfArithmeticSlices(int[] nums) {
        return findSlices(nums, 0, new ArrayList<>());
    }

    private static int findSlices(int[] nums, int index, ArrayList<Integer> currList) {
        if (index == nums.length)
            return currList.size() >= 3 ? 1 : 0;

        //take case
        int take = 0;
        if (currList.size() < 2 || currList.get(1) - currList.get(0) == nums[index] - currList.get(currList.size() - 1)) {
            currList.add(nums[index]);
            take = findSlices(nums, index + 1, currList);
            currList.remove(currList.size()-1);
        }

        return take + findSlices(nums, index + 1, currList);

    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
