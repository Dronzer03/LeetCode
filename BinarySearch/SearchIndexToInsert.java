package BinarySearch;

// LC - 35
// https://leetcode.com/problems/search-insert-position
public class SearchIndexToInsert {

    public int searchInsert(int[] nums, int target) {
        int startPoint = 0;
        int endPoint =  nums.length-1;
        int mid = 0;
        while (startPoint <= endPoint) {
            mid = (startPoint + endPoint) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                endPoint = mid - 1;
            } else {
                startPoint = mid + 1;
            }
        }

        if (target > nums[mid]) {
            return mid+1;
        }
        else {
            return mid;
        }
    }
}
