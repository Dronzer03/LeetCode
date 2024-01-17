package StringsAndArrays.Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovingTotal {
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    Set<Integer> movingTotalSet = new HashSet<>();
    List<Integer> integerList = new ArrayList<>();
    int index = 0;
    int total = 0;

    public void append(int[] list) {

        for (int i=0 ; i < list.length; i++) {
            integerList.add(list[i]);
            total += integerList.get(index);
            if (index - 3 >= 0)
                total -= integerList.get(index - 3);
            if (index >= 2) {
                movingTotalSet.add(total);
            }
            index++;
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {

        return movingTotalSet.contains(total);
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3, 4 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

        movingTotal.append(new int[] { 5 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));
    }
}