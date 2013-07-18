// change queue to stack in print method to do different traversal
// check the slides!

import java.util.LinkedList;


public class IntBST {
    private IntNode rootNode;

    public void printTree() {
        LinkedList<IntNode> queue = new LinkedList<IntNode>();
        queue.add(rootNode);
        System.out.print("BFS of BST:");

        while (!queue.isEmpty()) {
            IntNode node = queue.remove();
            System.out.print(node.getValue() + " ");

            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
                queue.add(node.getRightChild());
        }
    }

    public void insertValue(int value) {
        if (this.rootNode == null) {
            this.rootNode = new IntNode(value);
        } else {
            IntNode n = rootNode;
            while (n.getValue() != value) {
                if (value < n.getValue()) {
                    if (n.getLeftChild() == null) {
                        n.setLeftChild(new IntNode(value));
                    }
                    n = n.getLeftChild();
                } else if (value > n.getValue()) {
                    if (n.getRightChild() == null) {
                        n.setRightChild(new IntNode(value));
                    }
                    n = n.getRightChild();
                } else if (value == n.getValue()) {
                    throw new UnsupportedOperationException("This value already exists!");
                } else {
                    //case where root is not defined yet
                    //rootNode = new IntNode(value);
                }
            }
        }
    }


    public void insertValue_CRAZEE(int value) {
        if (this.rootNode == null) {
            this.rootNode = new IntNode(value);
        } else if (this.rootNode.getValue() < value) {
            if (rootNode.getRightChild() == null) {
                rootNode.setRightChild(new IntNode(value));
            } else {
                IntNode next_node = rootNode.getRightChild();
                while (!(next_node.getLeftChild() == null && next_node.getRightChild() == null)) {
                    if (next_node.getValue() < value) {
                        if (!(next_node.getRightChild() == null)) {
                            next_node = next_node.getRightChild();
                        } else {
                            next_node.setRightChild(new IntNode(value));
                            next_node = next_node.getRightChild();
                        }

                    } else if (next_node.getValue() > value) {
                        if (!(next_node.getLeftChild() == null)) {
                            next_node = next_node.getLeftChild();
                        } else {
                            next_node.setLeftChild(new IntNode(value));
                            next_node = next_node.getLeftChild();
                        }
                    } else {
                        //There are duplicates in input!!!!!
                        throw new UnsupportedOperationException("This value already exists!");
                    }
                }
                // if we got here  we are done - we have added the value and its node has no children
            }
        } else if (this.rootNode.getValue() > value) {
            if (rootNode.getLeftChild() == null) {
                rootNode.setLeftChild(new IntNode(value));
            } else {
                IntNode next_node = rootNode.getLeftChild();
                while ((next_node.getLeftChild() != null && next_node.getRightChild() != null)) {
                    if (next_node.getValue() < value) {
                        if (!(next_node.getRightChild() == null)) {
                            next_node = next_node.getRightChild();
                        } else {
                            next_node.setRightChild(new IntNode(value));
                            next_node = next_node.getRightChild();
                        }

                    } else if (next_node.getValue() > value) {
                        if (!(next_node.getLeftChild() == null)) {
                            next_node = next_node.getLeftChild();
                        } else {
                            next_node.setLeftChild(new IntNode(value));
                            next_node = next_node.getLeftChild();
                        }
                    } else {
                        //There are duplicates in input!!!!!
                        throw new UnsupportedOperationException("This value already exists!");
                    }
                }
                // if we got here  we are done - we have added the value and its node has no children
            }
        }
        // TODO: Implement insert value for a binary search tree
        //throw new UnsupportedOperationException("Not implemented!");
    }

    public boolean search(int value) {
        // TODO: Implement search for a value for a binary search tree
        //throw new UnsupportedOperationException("Not implemented!");
        return false;
    }

    public void remove(int value) {
        // TODO: Optional Challenge HW Question for next Monday
        // To remove, first examine the find the node, then:
        // 1) Node N has no children? Just remove N
        // 2) Node N has one child? Just remove N and replace with the child
        // 3) Node N has two children? A little harder. Either take the in-order successor or predecessor R, swap the values of N and R, then delete R

    }
}
