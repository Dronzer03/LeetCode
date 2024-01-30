package LinkedList;

// LC - 725
// https://leetcode.com/problems/split-linked-list-in-parts
public class SplitLLInParts {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        if (head == null)
            return result;

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int parts = count / k;
        if (parts == 0)
            parts++;
        int extra = count % k;

        result[0] = head;

        temp = head;
        int nodes = 0;
        int i = 0;
        while (temp != null) {
            nodes++;
            ListNode front = temp.next;
            if (nodes == parts) {
                if (extra > 0 && k < count) {
                    temp = temp.next;
                    front = temp.next;
                    extra--;
                }
                nodes = 0;
                if (front != null)
                    result[++i] = front;
                temp.next = null;
            }
            temp = front;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6
        , new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        splitListToParts(head, 3);
    }
}
