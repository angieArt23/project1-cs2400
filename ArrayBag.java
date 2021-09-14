public class ResizeableArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private int numberOfEntries = 0;
    private static final int default_capacity = 50;
    public ArrayBag(){
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[]) new Object[default_capacity];
        bag = tempbag;
    }
    public ArrayBag(int capacity){
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[]) new Object[capacity];
        bag = tempbag;
    }
    public boolean add(T entry){
        if(isFull()){
            @SuppressWarnings("unchecked")
            T[] tempbag = (T[]) new Object[bag.length*2];
            for(int i =0; i<numberOfEntries;i++){
                tempbag[i] = bag[i];
            }
            bag = tempbag;
            bag[numberOfEntries++] = entry;
            return true;
        }
        else {
            bag[numberOfEntries++] = entry;
            return true;
        }
    }
    public ArrayBag<T> Union(ArrayBag<T> bag2){
        ArrayBag<T> newBag = new ArrayBag(bag2.numberOfEntries + this.numberOfEntries);
        for(int i =0; i<bag2.numberOfEntries+this.numberOfEntries; i++){
            if(i<this.numberOfEntries)
                newBag.add(this.bag[i]);
            else    
                newBag.add(bag2.bag[i-this.numberOfEntries]);           
        }
        newBag.toArray();
        return newBag;
    }
    public boolean remove(T entry){
        for(int i =0; i<numberOfEntries; i++){
            if(bag[i] == entry){
                bag[i] = bag[numberOfEntries-1];
                bag[numberOfEntries-1] = null;
                return true;
            }
        }
        return false;
    }
    public ArrayBag<T> Intersection(ArrayBag<T> bag2){
        ArrayBag<T> newBag = new ArrayBag(bag2.numberOfEntries + this.numberOfEntries);
        if(this.numberOfEntries<bag2.numberOfEntries){
            T[] copy1 = bag2.toArray();
            for(int i =0; i<this.bag.length; i++){
                if(this.bag[i] == copy1[i]){
                    newBag.add(copy1[i]);
                    copy1[i] = copy1[copy1.length-1];
                    copy1[copy1.length-1] = null;
                }
            }
        }
        else{
            T[] copy1 = this.toArray();
        }
        return newBag;
    }
    public boolean contains(T item){
        for(int i =0; i<numberOfEntries; i++){
            if(bag[i] == item)
                return true;
        }
        return false;
    }
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] copybag = (T[]) new Object[numberOfEntries];
        for(int i =0; i<numberOfEntries; i++){
            copybag[i] = bag[i];
        }
        return copybag;
    }
    public void print(){
        for(int i=0;i<numberOfEntries;i++){
            System.out.println(bag[i]);
        }
    }
    public boolean isFull(){
        return numberOfEntries == bag.length;
    }
}
