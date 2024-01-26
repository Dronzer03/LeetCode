package LinkedList;

// LC - 203
// https://leetcode.com/problems/remove-linked-list-elements
public class RemoveAllOccurrencesOfKey {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        while (head!=null && head.val == val)
            head = head.next;
        if (head == null)
            return head;

        ListNode temp = head.next;
        ListNode prev = head;

        while (temp != null) {
            if (temp.val == val)
                temp = temp.next;
            else {
                prev.next = temp;
                prev = temp;
                temp = temp.next;
            }
        }
        prev.next = null;
        return head;
    }
}
