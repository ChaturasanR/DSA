import java.util.HashMap;
import java.util.Map;

public class CopyList {

    class RandomListNode {
        int label;
        RandomListNode next;
        RandomListNode random;

        public RandomListNode(int label) {
            this.label = label;
            this.next = null;
            this.random = null;
        }
    }

    // T.C: O(N), s.C: O(N)
    public RandomListNode deepCopyUsingMap(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode temp = head;
        // Make a copy of each node and store in a map with original node ref being the
        // key
        while (temp != null) {
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }

        // Assign the next and random pointers for copy nodes
        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            RandomListNode originalNode = entry.getKey();
            RandomListNode copyNode = entry.getValue();
            if (originalNode.random != null)
                copyNode.random = map.get(originalNode.random);

            if (originalNode.next != null)
                copyNode.next = map.get(originalNode.next);
        }

        // get the copy head
        return map.get(head);
    }

    // T.C: O(N), S.C: O(1)
    public RandomListNode deepCopyWithOutExtraSpace(RandomListNode head) {
        RandomListNode temp = head;

        // Idea is to create the copy node and attach that as next node to original node
        while (temp != null) {
            RandomListNode copyNode = new RandomListNode(temp.label);
            RandomListNode nextNode = temp.next;
            temp.next = copyNode;
            copyNode.next = nextNode;
            temp = nextNode;
        }

        // assign the random pointer
        temp = head;
        RandomListNode temp1 = temp.next;
        while (temp != null) {
            if (temp.random != null)
                temp1.random = temp.random.next;
            temp = temp.next.next;

            if (temp == null)
                break;
            temp1 = temp1.next.next;
        }

        // break the list into original and copy lists
        temp = head;
        RandomListNode copyHead = temp.next;
        temp1 = copyHead;
        while (temp != null) {
            temp.next = temp.next.next;
            temp = temp.next;

            if (temp == null)
                break;
            temp1.next = temp1.next.next;
            temp1 = temp1.next;
        }
        return copyHead;
    }
}
