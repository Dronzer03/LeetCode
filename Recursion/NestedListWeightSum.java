package Recursion;

import java.util.List;

public class NestedListWeightSum {
     public interface NestedInteger {
          // Constructor initializes an empty nested list.
          // public NestedInteger();

          // Constructor initializes a single integer.
          // public NestedInteger(int value);

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();

          // Set this NestedInteger to hold a single integer.
          public void setInteger(int value);

          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni);

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return empty list if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
     }


    public int findSum(List<NestedInteger> list) {
        return findSum(list, 1);
    }

    private int findSum(List<NestedInteger> list, int depth) {
         int sum = 0;
         for (NestedInteger num : list) {
             if (num.isInteger()) {
                 sum += depth * num.getInteger();
             } else {
                 sum += findSum(num.getList(), depth + 1);
             }
         }
         return sum;
    }

    public int[] findLeafUpwardsSum(List<NestedInteger> list) {
         int sum = 0;
         int depth = -1;
         int ans = 0;
         for (NestedInteger num : list) {
             if (num.isInteger()) {
                 sum += num.getInteger();
             } else {
                 int[] res = findLeafUpwardsSum(num.getList());
                 depth = Math.max(depth, res[1]);
                 ans += res[0];
             }
         }
         depth = depth == -1 ? 1 : depth + 1;
         sum *= depth;
         return new int[]{sum + ans, depth};
    }
}
