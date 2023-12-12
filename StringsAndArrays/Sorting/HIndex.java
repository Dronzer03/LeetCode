package StringsAndArrays.Sorting;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int hIndex = citations[0];
        for (int i = 1; i < len; i++) {
            int citation = citations[i];
            int currMax = Math.min(citation, len - i);
            hIndex = Math.max(hIndex, currMax);
        }
        if (hIndex > len)
            return len;
        return hIndex;
    }

    public static void main(String[] args) {
        HIndex h = new HIndex();
        int[] citations = { 4, 4, 0, 0 };

        System.out.println(h.hIndex(citations));
    }
}
