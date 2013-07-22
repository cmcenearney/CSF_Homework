public class IntLinkedList {

    IntListNode first_node;
    IntListNode last_node;

    public IntLinkedList(IntListNode first_node) {
        this.first_node = first_node;
    }

    public int count(){
        int i = 1;
        IntListNode node = this.first_node;
        while (node.getNext() != null) {
            i++;
            node = node.getNext();
        }
        return i;
    }

    public boolean inList (int value){
        IntListNode node = this.first_node;
        while (node.getNext() != null){
            if (node.getValue() == value){
                return true;
            }
            node = node.getNext();
        }
        if (node.getValue() == value){
            return true;
        }
        return false;
    }

    public void insert(int value){
        //add to end of the list, if value is not already in list
        if (!inList(value)) {
            IntListNode node = this.first_node;
            while (node.getNext() != null){
                node = node.getNext();
            }
            IntListNode next = new IntListNode(value) ;
            node.setNext(next);
            this.last_node = next;
        }
    }


    public void print(){
        IntListNode node = this.first_node;
        while (node.getNext() != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
        System.out.println(node.getValue());
    }

    public IntListNode getLast_node() {
        return last_node;
    }

}

