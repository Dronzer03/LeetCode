package LinkedList;

import java.util.Stack;

// LC - 143
// https://leetcode.com/problems/reorder-list
// Can be solved using traversing half LL and then reversing the LL then fill alternatively
public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        Stack<ListNode> stack = new Stack<>();

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        ListNode currNode = head;


        while (!stack.isEmpty()) {
            ListNode nextNode = currNode.next;
            currNode.next = stack.pop();
            currNode = currNode.next;

            if (stack.isEmpty())
                currNode.next = null;
            else {
                currNode.next = nextNode;
                currNode = currNode.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(head);
    }
}
