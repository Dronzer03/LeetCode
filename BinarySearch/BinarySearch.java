package BinarySearch;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int startPoint = 0;
        int endPoint =  nums.length-1;

        while (startPoint <= endPoint) {
            int mid = (startPoint + endPoint) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                endPoint = mid - 1;
            } else {
                startPoint = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 5;
        System.out.println(search(nums,target));
    }
}
