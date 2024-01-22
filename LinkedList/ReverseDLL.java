package LinkedList;

import java.util.Stack;

// Reverse a DLL - Coding Ninjas
// https://www.codingninjas.com/studio/problems/reverse-a-doubly-linked-list_1116098
public class ReverseDLL {
    // Using a stack
    public static Node reverseDLL(Node head) {
        // Write your code here.
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    public static Node reverseDLLWithoutStack(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        Node temp = head;
        while (temp.next != null) {
            Node next = temp.next;
            temp.next = temp.prev;
            temp.prev = next;
            temp = temp.prev;
        }
        temp.next = temp.prev;
        temp.prev = null;
        return temp;
    }
}
