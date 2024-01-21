package LinkedList;

// LC - 328
// https://leetcode.com/problems/odd-even-linked-list
public class OddEvenLL {
    public ListNode oddEvenList(ListNode head) {
        // 1 2 3 4
        // stop - 4
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        int index = 1;
        while (temp.next.next != null) {
            temp = temp.next;
            index++;
        }
        ListNode stop = temp;
        ListNode extra = null;
        if (index % 2 == 0) {
            stop = stop.next;
            temp = temp.next;
        } else {
            extra = stop.next;
        }

        ListNode start = head;
        while (head != stop) {
            temp.next = head.next;
            temp = temp.next;
            head.next = head.next.next;
            head = head.next;
        }
        if (extra != null) {
            temp.next = extra;
            temp = temp.next;
        }
        temp.next = null;
        return start;
    }
}
