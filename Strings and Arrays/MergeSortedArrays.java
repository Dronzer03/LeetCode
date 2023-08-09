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
}