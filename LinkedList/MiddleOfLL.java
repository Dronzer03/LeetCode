package LinkedList;

// LC - 876
// https://leetcode.com/problems/middle-of-the-linked-list/description/
public class MiddleOfLL {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.next == null)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
