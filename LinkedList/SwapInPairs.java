package LinkedList;

// LC - 24
// https://leetcode.com/problems/swap-nodes-in-pairs
public class SwapInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp1 = head;
        ListNode temp2 = head.next;
        ListNode next = temp2.next;
        ListNode newHead = temp2;

        while (temp1 != null && temp2 != null) {
            temp2.next = temp1;
            ListNode nextToNext = null;
            if (next != null) {
                nextToNext = next.next;
            }
            if (nextToNext != null)
                temp1.next = nextToNext;
            else
                temp1.next = next;

            temp1 = next;
            temp2 = nextToNext;
            if (temp2 != null)
                next = temp2.next;
            else
                next = null;
        }

        return newHead;
    }
}
