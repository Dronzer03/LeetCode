package Stack;

import java.util.Arrays;
import java.util.Stack;

// LC - 739
// https://leetcode.com/problems/daily-temperatures
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int index = 0; index < temperatures.length ; index++) {
            if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[index]) {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[index]) {
                    int prev = stack.pop();
                    result[prev] = index - prev;
                }
                stack.push(index);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temp = {30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }
}
