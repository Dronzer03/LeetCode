package LinkedList;

// Find intersection point of LL
// LC - 160
// https://leetcode.com/problems/intersection-of-two-linked-lists
public class IntersectionPointOfLL {
    public static ListNode findIntersection(ListNode firstHead, ListNode secondHead) {
        //Write your code here
        ListNode temp1 = firstHead;
        ListNode temp2 = secondHead;

        while (temp1 != temp2) {
            if (temp1.next == null && temp2.next == null)
                break;

            if (temp1.next == null) {
                temp1 = secondHead;
                temp2 = temp2.next;
            } else if (temp2.next == null) {
                temp2 = firstHead;
                temp1 = temp1.next;
            } else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        if (temp1 == temp2)
            return temp1;
        return null;
    }
}
