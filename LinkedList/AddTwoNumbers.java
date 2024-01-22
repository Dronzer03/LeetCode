package LinkedList;

// LC - 2
// https://leetcode.com/problems/add-two-numbers
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        while (l1.next != null && l2.next != null) {
            int sum = carry + l1.val + l2.val;
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            l1.val = sum;
            l2.val = sum;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1.next == null && l2.next == null) {
            int sum = carry + l1.val + l2.val;
            l1.val = sum % 10;
            if (sum > 9) {
                ListNode c = new ListNode(1);
                l1.next = c;
            }
            return l1Head;
        }

        ListNode temp = null;
        ListNode head = null;
        if (l1.next != null) {
            temp = l1;
            head = l1Head;
        } else {
            temp = l2;
            head = l2Head;
        }
        int tempSum = l1.val + l2.val + carry;
        temp.val = tempSum % 10;
        if (tempSum > 9)
            carry = 1;
        else
            carry = 0;
        while (temp.next != null) {
            temp = temp.next;
            int sum = temp.val + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            temp.val = sum;
        }
        if (carry == 1) {
            ListNode c = new ListNode(1);
            temp.next = c;
        }
        return head;
    }
}
