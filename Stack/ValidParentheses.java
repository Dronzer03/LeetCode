package Stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                chars.push(ch);
            }
            else {
                if (chars.isEmpty())
                    return false;
                if (ch == ')') {
                    if (chars.pop() != '(')
                        return false;
                } else if (ch == ']') {
                    if (chars.pop() != '[')
                        return false;
                } else if (ch == '}') {
                    if (chars.pop() != '{')
                        return false;
                }
            }
        }
        return chars.isEmpty();
    }
}
