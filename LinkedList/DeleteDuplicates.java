package LinkedList;

// LC - 83
// https://leetcode.com/problems/remove-duplicates-from-sorted-list
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode temp = head.next;

        while (temp != null) {
            if (temp.val == prev.val) {
                prev.next = temp.next;
                temp = temp.next;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}
