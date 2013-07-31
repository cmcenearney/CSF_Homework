// change queue to stack in print method to do different traversal
// check the slides!

import java.util.LinkedList;
import java.util.ArrayList;

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
<<<<<<< HEAD
        if (this.rootNode == null) {
            this.rootNode = new IntNode(value);
        } else {
            IntNode n = rootNode;
            while (n.getValue() != value) {
                if (value < n.getValue()) {
                    if (n.getLeftChild() == null) {
                        n.setLeftChild(new IntNode(value, n));
                    }
                    n = n.getLeftChild();
                } else if (value > n.getValue()) {
                    if (n.getRightChild() == null) {
                        n.setRightChild(new IntNode(value, n));
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

    public void bulkAdd (String csv) {
        //ArrayList<String> values = new ArrayList();
        String[] values = csv.split(",");
        for (int i = 0; i < values.length; i++){
            int num = Integer.parseInt(values[i]);
            insertValue(num);
        }
    }

    public boolean search(int value) {
        // TODO: Implement search for a value for a binary search tree
        //throw new UnsupportedOperationException("Not implemented!");
        IntNode n = rootNode;
        if (n.getValue() == value) {
            return true;
        }
        while (!(n.getRightChild() == null  &&  n.getLeftChild() == null)) {
            if (value > n.getValue()) {
               if  (n.getRightChild() == null) {
                   return false;
               }
               else {
                   n = n.getRightChild();
               }
            }
            else if (value < n.getValue()) {
                if  (n.getLeftChild() == null) {
                    return false;
                }
                else {
                    n = n.getLeftChild();
                }
            }
            if (n.getValue() == value) {
                return true;
            }
        }
        return false;
=======
        if (rootNode == null) {
            rootNode = new IntNode(value);
        }
        else {
            IntNode currentNode = rootNode;

            while (currentNode.getValue() != value) {
                if (value > currentNode.getValue()) { // Right child path
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(new IntNode(value));
                    }
                    currentNode = currentNode.getRightChild();
                }
                else { // Left child path
                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftChild(new IntNode(value));
                    }
                    currentNode = currentNode.getLeftChild();
                }
            }
        }
    }

    public boolean search(int value) {
        IntNode currentNode = rootNode;

        while(currentNode != null && (currentNode.getValue() != value)) {
            if (value > currentNode.getValue()) { // Continue down the right child path
                currentNode = currentNode.getRightChild();
            }
            else { // Continue down the left child path
                currentNode = currentNode.getLeftChild();
            }
        }
        // If the current node exists and its value is equal to the input, return true, else return false
        return currentNode != null && (currentNode.getValue() == value);
>>>>>>> upstream/master
    }

    public IntNode find(int value) {
        // TODO: Implement search for a value for a binary search tree
        //throw new UnsupportedOperationException("Not implemented!");
        IntNode n = rootNode;
        if (n.getValue() == value) {
            return n;
        }
        while (n.getValue() != value) {
            if (value > n.getValue()) {
                n = n.getRightChild();
            }
            else if (value < n.getValue()) {
                n = n.getLeftChild();
            }
            if (n.getValue() == value) {
                return n;
            }
        }
        return n;  // should this throw an exception here if a value has not been found ?
    }
    public void simpleRemove(IntNode n) {
        IntNode parent = n.getParent();
        if (parent.getValue() > n.getValue()) {
            parent.setLeftChild(null);
        }
        else {
            parent.setRightChild(null);
        }
    }
    public void remove(int value) {
        // TODO: Optional Challenge HW Question for next Tuesday
        // To remove, first examine the find the node, then:
        // 1) Node N has no children? Just remove N
        // 2) Node N has one child? Just remove N and replace with the child
        // 3) Node N has two children? A little harder. Either take the in-order successor or predecessor R, swap the values of N and R, then delete R
        if (search(value)) {
            IntNode n = find(value);
            IntNode parent = n.getParent();
            // case 1
            if (n.getLeftChild() == null && n.getRightChild() == null)    {
                simpleRemove(n);
            }
            //case 3
            else if (n.getLeftChild() != null  && n.getRightChild() != null) {

            }
            // case 2
            else if (n.getLeftChild() != null  || n.getRightChild() != null) {
                if (n.getLeftChild() != null) {
                    parent.setLeftChild(n.getLeftChild());
                    simpleRemove(n);
                }
                else if (n.getRightChild() != null) {
                    parent.setRightChild(n.getRightChild());
                    simpleRemove(n);
                }
            }
        }
        else {
            // throw exception ?
        }
    }
}
