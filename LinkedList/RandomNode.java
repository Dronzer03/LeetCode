package LinkedList;

import java.util.Random;

// LC - 382
// https://leetcode.com/problems/linked-list-random-node
// Convert into array to optimise even further
// Most optimal solution has lots of math, not worth it - becomes more of a math problem
public class RandomNode {
    ListNode head;
    int size = 0;
    Random random = new Random();
    public RandomNode(ListNode head) {
        this.head = head;
        ListNode temp = head;
        int nodes = 0;
        while (temp != null) {
            nodes++;
            temp = temp.next;
        }
        this.size = nodes;
    }

    public int getRandom() {
        int random = this.random.nextInt(size);
        int curr = 0;
        ListNode temp = head;
        while (curr != random) {
            curr++;
            temp = temp.next;
        }
        return temp.val;
    }
}
