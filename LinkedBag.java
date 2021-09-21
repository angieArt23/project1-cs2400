public class LinkedBag<T> {
    private Node firstNode;
    private int numberOfEntries;

    public boolean add(T newEntry){
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }
    public T remove(){
        if(firstNode != null){
            T data = firstNode.getData();
            firstNode = firstNode.getNextNode();
            return data;
        }
        return null;
    }
    public boolean remove(T entry){
        Node tracker = firstNode;
        while(tracker.getData() != entry && tracker.getNextNode() != null){
            tracker = firstNode.getNextNode();
        }
        return true;
    }
    public LinkedBag<T> Union(LinkedBag<T> bag2){
        Node nextNode1 = firstNode;
        Node nextNode2 = bag2.firstNode;
        LinkedBag<T> newBag = new LinkedBag<>();
        for(int i =0; i<this.numberOfEntries; i++){
            newBag.add(nextNode1.getData());
            nextNode1 = nextNode1.getNextNode();
        }
        for(int i =0; i<bag2.numberOfEntries; i++){
            newBag.add(nextNode2.getData());
            nextNode2 = nextNode2.getNextNode();
        }
        return newBag;
    }
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        Node currentNode = firstNode;
        for(int i=0; i<numberOfEntries && currentNode != null; i++){
            result[i] = currentNode.getData();
            currentNode = currentNode.getNextNode();
        }
        return result;
    }
    public void print(){
        Node current = firstNode;
        for(int i =0; i<numberOfEntries; i++){
            System.out.printf("%d", current.getData());
            current = current.getNextNode();
        }
    }

    private class Node{
        private T data;
        private Node next;
        private Node(T dataPortion){
            this(dataPortion, null);
        }
        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }
        private T getData(){
            return data;
        }
        private void setData(T newData){
            data = newData;
        }
        private Node getNextNode(){
            return next;
        }
        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }
}