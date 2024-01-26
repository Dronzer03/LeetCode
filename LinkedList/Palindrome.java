package LinkedList;

import java.util.Stack;

// LC - 234
// https://leetcode.com/problems/palindrome-linked-list
public class Palindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop())
                return false;
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
        System.out.println(isPalindrome(head));
    }
}
