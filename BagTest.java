public class BagTest{

    public static void main(String[] args){
        ResizeableArrayBag<Integer> bag1 = new ResizeableArrayBag<>(9);
        ResizeableArrayBag<Integer> bag2 = new ResizeableArrayBag<>(9);
        for(int i=0; i<7; i++){
            bag1.add(i);
        }
        for(int i =0; i<7; i++){
            bag2.add(i);
        }
        ResizeableArrayBag<Integer> bag3 = bag1.Union(bag2);
        bag3.print();

        

        
    }
}