package LinkedList;

// Coding Ninjas
// https://www.codingninjas.com/studio/problems/find-length-of-loop_8160455
public class LengthOfLLCycle {
    public static int lengthOfLoop(Node head) {
        // Write your code here
        if (head == null || head.next == null)
            return 0;

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            slow = slow.next;
            int len = 1;
            while (slow != fast) {
                slow = slow.next;
                len++;
            }
            return len;
        }
        return 0;
    }
}
