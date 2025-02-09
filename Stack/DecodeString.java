package Stack;

import java.util.Stack;

// LC - 394
// https://leetcode.com/problems/decode-string
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num *= 10;
                num += (ch - '0');
            } else if (ch == '[') {
                numbers.push(num);
                stack.push(sb);
                sb = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                int count = numbers.pop();
                StringBuilder temp = stack.pop();
                while (count -- > 0) {
                    temp.append(sb);
                }
                sb = temp;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
