
public class IntNode {
    private int value;
    private IntNode leftChild;
    private IntNode rightChild;
    private IntNode parent;

    public IntNode(int value) {
        this.value = value;
    }

    public IntNode(int value, IntNode parent) {
        this.value = value;
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public IntNode getLeftChild() {
        return leftChild;
    }

    public IntNode getRightChild() {
        return rightChild;
    }

    public void setLeftChild(IntNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(IntNode rightChild) {
        this.rightChild = rightChild;
    }

    public IntNode getParent() {
        return parent;
    }

    public void setParent(IntNode parent) {
        this.parent = parent;
    }
}
