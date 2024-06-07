// T.C: O(N), S.C: O(1)
public class ReverseLinkedList {
    public LinkedListNode reverseList(LinkedListNode head) {
        // One node for tracking reverse LL and one for traversing the original LL
        LinkedListNode reverseHead = null, temp = head;
        while (temp != null) {
            // get the next node to traverse further
            LinkedListNode node = temp.getNext();

            // break and set the next pointer to previous pointer
            temp.setNext(reverseHead);
            reverseHead = temp;

            // move forward to next pointer
            temp = node;
        }
        return reverseHead;
    }
}
