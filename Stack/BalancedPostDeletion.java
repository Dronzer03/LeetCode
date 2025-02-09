package Stack;

import java.util.Stack;

/*
You are given a string containing only parentheses ('(' and ')') and digits (0-9). At the index of a digit,
you must delete a number of parentheses to the left of the index equal to the digit's value.
Return true if it is possible to balance the parenthesis of the input.

Example 1 Input: ((2)) Output: False Reason: Only possible string is unbalanced: "))"
Example 2 Input: ((((2)) Output: True Reason: Only possible string is balanced: "(())"
Example 3 Input: (()1(1)) Output: True Reason: Multiple possible strings and one is balanced: ")())", "(())", "()))".

Background:
1.Digits should not be included in the result string, although that doesn't matter for calculating the boolean result.
2.If a digit doesn't have enough characters to the left to delete, then return false.
 */
public class BalancedPostDeletion {
    public boolean balance(String input) {
        Stack<Character> stack = new Stack<>();

        int toDelete = 0;
        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                stack.push('(');
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    toDelete++;
                    continue;
                }
                stack.pop();
            } else {
                int n = ch - '0';
                if (n - toDelete >= 0) {
                    n -= toDelete;
                    toDelete = 0;
                } else {
                    n = 0;
                    toDelete -= n;
                }
                while (n-- > 0) {
                    if (stack.isEmpty())
                        return false;
                    stack.pop();
                }
            }
        }

        return stack.isEmpty() && toDelete == 0;
    }

    public static void main(String[] args) {
        System.out.println(new BalancedPostDeletion().balance("((2))"));
        System.out.println(new BalancedPostDeletion().balance("((((2))"));
        System.out.println(new BalancedPostDeletion().balance("(()1(1))"));
        System.out.println(new BalancedPostDeletion().balance("())1(((1))"));
    }
}
