package LinkedList;

// LC - 2095
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list
public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow.next != null)
            slow.next = slow.next.next;
        return head;
    }
}
