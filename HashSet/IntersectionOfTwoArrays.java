package HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LC - 349
// https://leetcode.com/problems/intersection-of-two-arrays
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        int[] result;
        for (int num : nums1)
            nums1Set.add(num);
        for (int num : nums2){
            if (nums1Set.contains(num)) {
                res.add(num);
            }
        }
        result = new int[res.size()];
        int k=0;
        for (int num : res) {
            result[k++] = num;
        }
        return result;
    }

    public int[] intersectionOptimal(int[] nums1, int[] nums2) {
        boolean[] freq = new boolean[1001];
        for (int n : nums1) {
            freq[n]=true;
        }
        Set<Integer> res = new HashSet<>();
        for (int n : nums2) {
            if (freq[n])
                res.add(n);
        }
        int[] result = new int[res.size()];
        int k=0;
        for (int num : res)
            result[k++] = num;
        return result;
    }

    // Find all intersections including duplicates
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1)
            list1.add(num);
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (list1.contains(num)) {
                list1.remove(Integer.valueOf(num));
                resultList.add(num);
            }
        }
        int[] result = new int[resultList.size()];
        int k=0;
        for (int num : resultList)
            result[k++] = num;
        return result;
    }

    public int[] intersectUsingSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int i=0, j=0, k=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j++]) {
                result[k++] = nums1[i++];
            } else {
                if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return Arrays.copyOf(result, k);
    }
}
