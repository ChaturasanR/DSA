// T.C: O(N), S.C: O(1)
public class RemoveDuplicatesFromSortedList {
    public LinkedListNode removeDuplicates(LinkedListNode head) {
        LinkedListNode prev = head, curr = head.getNext();

        while (curr != null) {
            while (curr != null && curr.getData() == prev.getData())
                curr = curr.getNext();

            // no more elements to process so setting to null
            if (curr == null) {
                prev.setNext(null);
                break;
            }

            prev.setNext(curr);
            prev = prev.getNext();
            curr = curr.getNext();
        }
        return prev;
    }
}
