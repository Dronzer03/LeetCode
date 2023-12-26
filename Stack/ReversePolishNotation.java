package Stack;

import java.util.Stack;

// LC - 150
// https://leetcode.com/problems/evaluate-reverse-polish-notation
public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (s.equals("+"))
                    stack.push(Integer.toString(num1 + num2));
                else if (s.equals("-"))
                    stack.push(Integer.toString(num2 - num1));
                else if (s.equals("/"))
                    stack.push(Integer.toString(num2 / num1));
                else
                    stack.push(Integer.toString(num1 * num2));
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] operations = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(operations));
    }
}
