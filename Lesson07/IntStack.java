
public class IntStack {
    IntListNode firstNode;

    public IntStack() {
    }

    public void push(int value) {
        IntListNode node = new IntListNode(value);
        node.setNextNode(firstNode);
        firstNode = node;
    }

    public int pop() {
        int value = 0;
        if (firstNode != null) {
            value = firstNode.getValue();
            firstNode = firstNode.getNextNode();
        }
        return value;
    }

    public int size() {
        int size = 0;
        IntListNode node = firstNode;
        while (node != null) {
            size++;
            node = node.getNextNode();
        }
        return size;
    }
}
