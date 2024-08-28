package Stack;

import java.util.Stack;

// LC - 227
// https://leetcode.com/problems/basic-calculator-ii
public class BasicCalculator2 {

    public static void main(String[] args) {
        System.out.println(new BasicCalculator2().calculate("34+2*2"));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int number = 0;
        char sign = '+';

        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || index == s.length() - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = s.charAt(index);
                number = 0;
            }
        }
        int result = 0;
        for (int n : stack)
            result += n;

        return result;
    }
}
