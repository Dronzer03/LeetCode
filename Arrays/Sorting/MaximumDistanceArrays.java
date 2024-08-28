package Arrays.Sorting;

import java.util.List;

public class MaximumDistanceArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        int secondSmallest = Integer.MAX_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        int smallestIndex = -1;
        int largestIndex = -1;

        for (int index = 0; index < arrays.size(); index++) {
            List<Integer> current = arrays.get(index);
            if (current.get(0) < smallest) {
                secondSmallest = smallest;
                smallest = current.get(0);
                smallestIndex = index;
            } else if (current.get(0) < secondSmallest) {
                secondSmallest = current.get(0);
            }

            if (current.get(current.size() - 1) > largest) {
                secondLargest = largest;
                largest = current.get(current.size() - 1);
                largestIndex = index;
            } else if (current.get(current.size() - 1) > secondLargest) {
                secondLargest = current.get(current.size() - 1);
            }
        }

        if (smallestIndex != largestIndex)
            return Math.abs(largest - smallest);
        return Math.max(Math.abs(smallest - secondLargest), Math.abs(largest - secondSmallest));
    }
}
