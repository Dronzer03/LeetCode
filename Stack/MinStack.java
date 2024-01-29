package Stack;

// LC - 155
// https://leetcode.com/problems/min-stack

//import java.util.Stack;

//public class MinStack {
//
//    public Stack<Integer> genStack;
//    public int min = Integer.MAX_VALUE;
//
//    public MinStack() {
//        genStack = new Stack<>();
//    }
//
//    public void push(int val) {
//        if (val <= min) {
//            genStack.push(min);
//            min = val;
//        }
//        genStack.push(val);
//    }
//
//    public void pop() {
//        if (genStack.pop() == min) {
//            min = genStack.pop();
//        }
//    }
//
//    public int top() {
//        return genStack.peek();
//    }
//
//    public int getMin() {
//        return min;
//    }
//}

// Faster than above
// Beats 100%
class MinStack {

    class Node {
        int val;
        int min;
        Node next, prev;
        Node(int val) {
            this.val = val;
        }
    }

    Node head = null;
    Node tail = null;

    public MinStack() {

    }

    public void push(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            head.min = val;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
            tail.min = Math.min(val, tail.prev.min);
        }
    }

    public void pop() {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    public int top() {
        return tail.val;
    }

    public int getMin() {
        return tail.min;
    }
}
