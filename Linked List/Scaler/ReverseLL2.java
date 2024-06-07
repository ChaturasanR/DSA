/**
 * Problem Description
 * Reverse a linked list A from position B to C.
 * 
 * NOTE: Do it in-place and in one-pass.
 * 
 * Solution:
 * 1. Track the previous node before point B and store point at B as pointBNode
 * 2. Reverse from B to C
 * 3. Attach next node of C to pointBNode
 * 
 * T.C: O(N + C-B+1) => O(N), S.C: O(1)
 */
public class ReverseLL2 {
    public LinkedListNode reverseBetween(LinkedListNode head, int B, int C) {
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode reversedHead = head;

        int jumps = 0;
        while (curr != null && jumps < B - 1) {
            jumps++;
            prev = curr;
            curr = curr.getNext();
        }

        if (curr == null)
            return reversedHead;

        int nodesToReverse = C - B + 1;
        LinkedListNode[] nodes = reverseKNodes(curr, nodesToReverse);

        curr.setNext(nodes[1]);
        if (prev == null) {
            reversedHead = nodes[0];
        } else {
            prev.setNext(nodes[0]);
        }
        return reversedHead;
    }

    private LinkedListNode[] reverseKNodes(LinkedListNode head, int K) {
        LinkedListNode reversedHead = null;
        LinkedListNode temp = head;

        while (temp != null && K > 0) {
            LinkedListNode next = temp.getNext();
            temp.setNext(reversedHead);
            reversedHead = temp;
            temp = next;
            K--;
        }
        return new LinkedListNode[] { reversedHead, temp };
    }
}
