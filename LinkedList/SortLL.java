package LinkedList;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/sort-linked-list_625193
// LC - 148
// https://leetcode.com/problems/sort-list
// Another way is to take into array, sort it and put it back
public class SortLL {
    public static ListNode sortList(ListNode head) {
        //Write your code here
        if (head == null || head.next == null)
            return head;

        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeTwoLists(leftHead, rightHead);
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode mergeTwoLists(ListNode temp1, ListNode temp2) {
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
