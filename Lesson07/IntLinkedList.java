
public class IntLinkedList {
    private IntListNode firstNode;

    // IntLinkedList stores a list of unique integers
    public IntLinkedList() {
    }

    // Add the integer, or take no action if it's already in the list
    public void insert(int value) {
        if (firstNode == null) {
            firstNode = new IntListNode(value);
        }
        else {
            IntListNode node = firstNode;
            while (node != null && node.getValue() != value) {
                if (node.getNextNode() == null) {
                    node.setNextNode(new IntListNode(value));
                }
                node = node.getNextNode();
             }
        }
    }

    // Remove the given integer from the list, or take no action if it's not in the list
    public void remove(int value) {
        IntListNode previousNode = null;
        IntListNode node = firstNode;

        while (node != null) {
            if (node.getValue() == value) {
                // Found it, now we remove and swap nodes
                if (node == firstNode) {
                    firstNode = firstNode.getNextNode();
                }
                else {
                    previousNode.setNextNode(node.getNextNode());
                }
            }
            previousNode = node;
            node = node.getNextNode();
        }
    }

    public void print() {
        IntListNode node = firstNode;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNextNode();
        }
    }
}
