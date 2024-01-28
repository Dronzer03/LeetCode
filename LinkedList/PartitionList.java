package LinkedList;

// LC - 86
// https://leetcode.com/problems/partition-list
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode temp1 = dummy1;
        ListNode temp2 = dummy2;

        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                temp1.next = temp;
                temp1 = temp1.next;
            } else {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
            temp1.next = null;
            temp2.next = null;
        }

        if (dummy1.next == null)
            return dummy2.next;

        temp1.next = dummy2.next;
        return dummy1.next;
    }
}
