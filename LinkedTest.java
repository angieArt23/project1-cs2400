public class LinkedTest{
    public static void main(String[] args){
        LinkedBag<Integer> bag1 = new LinkedBag<>();
        LinkedBag<Integer> bag2 = new LinkedBag<>();
        for(int i=0; i<5;i++){
            bag1.add(i);
            bag2.add(i);
        }

        LinkedBag<Integer> bag3 = bag1.Union(bag2);
        bag3.print();
        
    }
}
