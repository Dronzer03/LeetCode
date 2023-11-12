import java.util.Arrays;

class MergeSortedArrays {
    // Approach 1
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0)
            return;
        int counter1 = 0;
        int counter2 = 0;
        int[] result = new int[m+n];
        int cnt = 0;
        while (counter1 < m && counter2 < n) {
            if (nums1[counter1] <= nums2[counter2]) {
                result[cnt++] = nums1[counter1++];
            }
            else {
                result[cnt++] = nums2[counter2++];
            }
        }
        if (counter1 < m || counter2 < n) {
            while (counter1 < m)
                result[cnt++] = nums1[counter1++];
            while (counter2 < n)
                result[cnt++] = nums2[counter2++];
        }
        int res = 0;
        while(res < m+n) {
            nums1[res] = result[res++];
        } 
    }

    // Approach 2
    public void mergeTwoPointersApproach(int[] nums1, int m, int[] nums2, int n) {
        if (n==0)
            return;
        int k = m + n - 1;
        m--; //Last index of array 1
        n--; //Last index of array 2
        
        while (n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[k--] = nums1[m--];
            } else {
                nums1[k--] = nums2[n--];
            }
        }
    }

    public void mergeTwoPointersApproachDiffCondition(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = m + n - 1;
        m--;
        n--;
        while (lastIndex >= 0) {
            if (m>=0 && (n<0 || nums1[m] >= nums2[n])) {
                nums1[lastIndex--] = nums1[m--];
            } else {
                nums1[lastIndex--] = nums2[n--];
            }
        }
        // 1 2 4
        // 1 2 5
        // 5 4 2 2 1 1
    }

    //Place the elements back in both arrays instead of one
    public static void mergeAndPlaceBack(int[] nums1, int m, int[] nums2, int n) {
        if (nums1[m-1] <= nums2[0])
            return;

        m--;
        n = 0;
        int k;
        while (m>=0 && nums1[m] > nums2[n]) {
            k = nums2[n];
            nums2[n++] = nums1[m];
            nums1[m--] = k;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public static void main(String[] args) {
        int[] a = {9, 10, 11, 12};
        int[] b = {2, 3, 7, 8};
        mergeAndPlaceBack(a, 4, b, 4);
    }
}