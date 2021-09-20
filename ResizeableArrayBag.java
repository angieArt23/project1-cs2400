public class ResizeableArrayBag<T> 
{
    private T[] bag;
    private int numberOfEntries = 0;
    private static final int default_capacity = 50;
    public ResizeableArrayBag(){
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[]) new Object[default_capacity];
        bag = tempbag;
    }
    public ResizeableArrayBag(int capacity){
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
    public ResizeableArrayBag<T> Union(ResizeableArrayBag<T> bag2){
        ResizeableArrayBag<T> newBag = new ResizeableArrayBag<>(bag2.numberOfEntries + this.numberOfEntries);
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
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }
    public ResizeableArrayBag<T> Difference(ResizeableArrayBag<T> array2){
        ResizeableArrayBag<T> bagCopy = new ResizeableArrayBag<>(this.numberOfEntries+array2.numberOfEntries);
        if(this.numberOfEntries < array2.numberOfEntries){
            for(int i =0; i<this.numberOfEntries; i++){
                if(array2.contains(this.bag[i])){
                    array2.remove(this.bag[i]);
                }
                else{
                    bagCopy.add(this.bag[i]);
                }
            }
            for(int i =0; i<array2.numberOfEntries; i++){
                bagCopy.add(array2.bag[i]);
            }
        }
        else{
            for(int i =0; i<array2.numberOfEntries; i++){
                if(this.contains(array2.bag[i])){
                    this.remove(array2.bag[i]);
                }
                else{
                    bagCopy.add(array2.bag[i]);
                }
            }
            for(int i =0; i<this.numberOfEntries; i++){
                bagCopy.add(this.bag[i]);
            }
        }
        return bagCopy;
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
