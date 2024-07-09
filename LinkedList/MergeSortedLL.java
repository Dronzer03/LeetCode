package LinkedList;

// LC - 21
// https://leetcode.com/problems/merge-two-sorted-lists
public class MergeSortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head = null;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode prev = head;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    prev.next = list1;
                    prev = list1;
                    list1 = list1.next;
                } else {
                    prev.next = list2;
                    prev = list2;
                    list2 = list2.next;
                }
            } else if (list1 == null) {
                prev.next = list2;
                prev = list2;
                list2 = list2.next;
            } else {
                prev.next = list1;
                prev = list1;
                list1 = list1.next;
            }
        }
        return head;
    }

    public ListNode mergeTwoListsOptimal(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return dummy.next;
    }
}
