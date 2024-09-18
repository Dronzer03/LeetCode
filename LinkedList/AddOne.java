package LinkedList;

// Add One - Coding Ninjas (Leetcode Premium)
// https://www.codingninjas.com/studio/problems/add-one-to-a-number-represented-as-linked-list_920557
public class AddOne {
    public static Node addNode(Node head) {
        Node newHead = reverseLL(head);
        int carry = 0;
        Node temp = newHead;
        int sum = temp.data + 1;
        if (sum == 10) {
            temp.data = 0;
            carry = 1;
            temp = temp.next;
            while (temp != null) {
                int carrySum =  temp.data + carry;
                if (carrySum == 10) {
                    temp.data = 0;
                    temp = temp.next;
                } else {
                    temp.data = carrySum;
                    carry = 0;
                    break;
                }
            }
        } else {
            temp.data = sum;
        }
        Node currHead = reverseLL(newHead);
        if (carry == 1) {
            Node carryHead = new Node(1, currHead);
            return carryHead;
        }
        return currHead;
    }

    private static Node reverseLL(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head.next = null;
        return prev;
    }
}
