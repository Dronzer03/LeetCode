package LinkedList;

// LC - 61
// https://leetcode.com/problems/rotate-list
public class RotateLL {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode last = head;
        int len = 1;
        while (last.next != null) {
            len++;
            last = last.next;
        }
        k = k % len;
        int newHead = len - k;
        int count = 2;
        ListNode prev = head;
        ListNode curr = head.next;
        last.next = head;
        while (count <= newHead) {
            prev = prev.next;
            curr = curr.next;
            count++;
        }
        prev.next = null;
        return curr;
    }
}
