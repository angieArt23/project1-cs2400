public class LinkedBag<T> {
    private Node firstNode;
    private int numberOfEntries;

    public boolean add(T newEntry){
        Node newNode = new Node(newEntry);
        firstNode = newNode.next;
        newNode = firstNode;
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