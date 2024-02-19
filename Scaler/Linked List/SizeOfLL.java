// T.C: O(N), S.C: O(1)
public class SizeOfLL {
    public int getSize(LinkedListNode head) {
        LinkedListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.getNext();
            size++;
        }
        return size;
    }
}