package LinkedList;

// LC - 25
// https://leetcode.com/problems/merge-k-sorted-lists
public class MergeKSortedLL {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode temp = lists[i];
            head = mergeTwoLists(head, temp);
        }
        return head;
    }

    private ListNode mergeTwoLists(ListNode temp1, ListNode temp2) {
        if (temp1 == null && temp2 == null)
            return null;
        if (temp1 == null)
            return temp2;
        if (temp2 == null)
            return temp1;

        ListNode head = null;
        if (temp1.val <= temp2.val) {
            head = temp1;
            temp1 = temp1.next;
        } else {
            head = temp2;
            temp2 = temp2.next;
        }
        ListNode temp = head;
        while (temp1 != null || temp2 != null) {
            if (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp = temp.next;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp = temp.next;
                    temp2 = temp2.next;
                }
            } else if (temp1 != null) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        return head;
    }
}
