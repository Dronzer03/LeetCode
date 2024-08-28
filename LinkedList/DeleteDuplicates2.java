package LinkedList;

// LC - 82
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;

        while (head != null) {
            ListNode next = head.next;
            boolean deleteHead = false;
            while (next != null && next.val == head.val) {
                next = next.next;
                deleteHead = true;
            }
            if (deleteHead) {
                head = next;
            } else {
                temp.next = head;
                temp = temp.next;
                head = head.next;
            }
        }

        if (temp != null)
            temp.next = null;

        return dummy.next;
    }
}
