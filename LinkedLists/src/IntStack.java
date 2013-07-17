public class IntStack {

    IntListNode first_node;
    IntListNode last_node;

    public IntStack(IntListNode first_node) {
        this.first_node = first_node;
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

    public void enqueue(int value){
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

    public void push(int value){
        //add to 'front' of the list, if value is not already in list
        if (!inList(value)) {
            IntListNode new_node = new IntListNode(value);
            new_node.setNext(this.first_node);
            this.first_node = new_node;
        }
    }

    public int popFromEnd(){
        IntListNode lag_behind = this.first_node; //just needs an initial val
        IntListNode node = this.first_node;
        while (node.getNext() != null) {
            lag_behind = node;
            node = node.getNext();
        }
        lag_behind.setNext(null); //pop! ...floating through space...
        return node.getValue();
    }

    public int pop(){
        this.first_node.setNext(null); //pop! ...floating through space...
        return this.first_node.getValue();
    }

    public void print(){
        IntListNode node = this.first_node;
        while (node.getNext() != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
        System.out.println(node.getValue());
    }

    public int count(){
        int i = 0;
        IntListNode node = this.first_node;
        while (node.getNext() != null) {
            i++;
            node = node.getNext();
        }
        return i;
    }

    public IntListNode getLast_node() {
        return last_node;
    }

}

