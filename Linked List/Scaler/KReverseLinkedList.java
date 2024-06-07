/**
 * Problem Description
 * Given a singly linked list A and an integer B, reverse the nodes of the list
 * B at a time and return the modified linked list.
 * 
 * sol:
 * 
 * 1. We need to maintain address of prev and after node of B nodes LL
 * 2. Reverse the B LL
 * 3. Attach the currNode of B LL to prev node
 * 
 * T.C: O(N + N) => O(N), S.C: O(1)
 */
public class KReverseLinkedList {

    public LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode temp = head;
        LinkedListNode reversedHead = null;
        while (temp != null) {
            LinkedListNode next = temp.getNext();
            temp.setNext(reversedHead);
            reversedHead = temp;
            temp = next;
        }
        return reversedHead;
    }

    public LinkedListNode reverseList(LinkedListNode head, int B) {
        LinkedListNode curr = head;
        LinkedListNode currBLinkedListPrev = null;
        LinkedListNode currBLinkedListHNext = null;
        LinkedListNode currBLinkedListHead = head;
        LinkedListNode reversedLLHead = null;
        int count = 1;
        while (curr != null) {
            if (count % B == 0) {
                currBLinkedListHNext = curr.getNext();
                curr.setNext(null);
                LinkedListNode reversedHead = reverse(currBLinkedListHead);
                if (reversedHead == null) {
                    reversedHead = reversedLLHead;
                } else {
                    currBLinkedListPrev.setNext(reversedHead);
                }
                curr = currBLinkedListHNext;
                currBLinkedListPrev = currBLinkedListHead;
                currBLinkedListHead = curr;
            } else {
                curr = curr.getNext();
            }
            count++;
        }
        return reversedLLHead;
    }
}