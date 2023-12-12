package StringsAndArrays.BinarySearch;

public class FirstOccuranceOfOne {
    public int findOccurrance(int left, int mid, int right, int[] arr) {
        if (arr[left] == 1)
            return left;

        if (arr[right] == 0)
            return right;

        if (right - left == 1)
            return right;

        if (arr[mid] == 1)
            return findOccurrance(left, (left + mid) / 2, mid, arr);
        else
            return findOccurrance(mid, (mid + right) / 2, right, arr);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 1, 1 };
        FirstOccuranceOfOne one = new FirstOccuranceOfOne();
        System.out.println(one.findOccurrance(0, 3, 5, arr));
    }

}
