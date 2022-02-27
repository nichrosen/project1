import java.util.*;

public class BagDriver{

    public static void main(String[] args){

        //for testing union, intersection, difference methods on ResizableArrayBag class

        BagInterface<String> bag_1 = new ResizableArrayBag<>();
        BagInterface<String> bag_2 = new ResizableArrayBag<>();

        bag_1.add("A");
        bag_1.add("A");
        bag_1.add("B");
        bag_1.add("C");
        bag_1.add("D");

        bag_2.add("A");
        bag_2.add("B");
        bag_2.add("X");
        bag_2.add("Y");
        bag_2.add("Z");

        System.out.println(Arrays.toString(bag_1.union(bag_2).toArray()));
    }

}