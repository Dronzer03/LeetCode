package Stack;

import java.util.Stack;

public class MinStack {

    public Stack<Integer> genStack;
    public int min = Integer.MAX_VALUE;

    public MinStack() {
        genStack = new Stack<>();
    }

    public void push(int val) {
        if (val <= min) {
            genStack.push(min);
            min = val;
        }
        genStack.push(val);
    }

    public void pop() {
        if (genStack.pop() == min) {
            min = genStack.pop();
        }
    }

    public int top() {
        return genStack.peek();
    }

    public int getMin() {
        return min;
    }
}
