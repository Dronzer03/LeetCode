package LinkedList;

// LC - 19
// https://leetcode.com/problems/remove-nth-node-from-end-of-list
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1))
            return null;

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

        if (count == del)
            return head.next;

        if (slow.next != null)
            slow.next = slow.next.next;

        return head;
    }
}
