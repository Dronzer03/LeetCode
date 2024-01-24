package LinkedList;

// LC - 19
// https://leetcode.com/problems/remove-nth-node-from-end-of-list
public class DeleteKthNodeFromEnd {
    public static ListNode removeKthListNode(ListNode head, int n) {
        // Write your code here.
        ListNode slow = head;
        ListNode fast = head;

        int count = 1;
        int del = n;
        while (fast.next != null) {
            if (n > 0) {
                n--;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }

        if (del == count)
            return head.next;

        slow.next = slow.next.next;
        return head;
    }
}
