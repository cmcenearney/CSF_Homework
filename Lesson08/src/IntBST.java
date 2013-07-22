// TODO: try changing queue to stack in print method to do different traversal
// check the slides for more info

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

    public int countChildren(IntNode n){
        int cnt;
        if (n.getLeftChild() == null && n.getRightChild() == null)  {
            cnt = 0;
            return cnt;
        }
        else if (n.getLeftChild() != null && n.getRightChild() != null) {
            cnt = countChildren(n.getLeftChild()) + countChildren(n.getRightChild());
            return cnt;
        }
        else if (n.getLeftChild() == null && n.getRightChild() != null) {
            cnt = countChildren(n.getRightChild());
            return cnt;
        }
        else if (n.getLeftChild() != null && n.getRightChild() == null) {
            cnt = countChildren(n.getLeftChild());
            return cnt;
        }
        else {
            cnt = 0;
            return cnt;
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

    public void replaceNode(IntNode n, IntNode rep) {
        IntNode parent = n.getParent();
        if (n == parent.getLeftChild()){
            parent.setLeftChild(rep);
        }
        else {
            parent.setRightChild(rep);
        }
        simpleRemove(n);
    }

    public void remove(int value) {
        // TODO: Optional Challenge HW Question for next Monday
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
                 // decide by counting ? this might help keep tree more balanced
                if ( countChildren(n.getLeftChild()) > countChildren(n.getRightChild()) ) {
                    replaceNode(n, n.getLeftChild());
                }
                else {
                    replaceNode(n, n.getRightChild());
                }
            }
            // case 2
            else if (n.getLeftChild() != null  || n.getRightChild() != null) {
                if (n.getLeftChild() != null) {
                    // n has only left child, so attach parent to n's left child
                    replaceNode(n, n.getLeftChild());
                }
                else if (n.getRightChild() != null) {
                    // n has only right child, so attach parent to n's right child
                    replaceNode(n, n.getRightChild());
                }
            }
        }
        else {
            // throw exception ?
        }
    }
}
