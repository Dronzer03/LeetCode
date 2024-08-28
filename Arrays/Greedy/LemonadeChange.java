package Arrays.Greedy;

// LC - 860
// https://leetcode.com/problems/lemonade-change
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveBills = 0;
        int tenBills = 0;

        for (int bill : bills) {
            if (bill == 5)
                fiveBills++;
            else if (bill == 10) {
                fiveBills--;
                tenBills++;
            }
            else if (tenBills > 0) {
                tenBills--;
                fiveBills--;
            } else {
                fiveBills -= 3;
            }

            if (fiveBills < 0)
                return false;
        }
        return true;
    }
}
