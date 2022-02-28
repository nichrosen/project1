import java.util.*;

public class BagDriver{

    public static void main(String[] args){

        //for testing union, intersection, difference methods on ResizableArrayBag class

        BagInterface<String> bag_1 = new LinkedBag<>();
        BagInterface<String> bag_2 = new ResizableArrayBag<>();

        bag_1.add("A");
        bag_1.add("A");
        bag_1.add("B");
        bag_1.add("C");
        bag_1.add("D");
        bag_1.add("D");

        bag_2.add("A");
        bag_2.add("B");
        bag_2.add("X");
        bag_2.add("X");
        bag_2.add("Y");
        bag_2.add("Y");
        bag_2.add("Y");
        bag_2.add("Y");
        bag_2.add("Z");

        System.out.println("Bag1 uses a linked bag and contains the following: [A, A, B, C, D, D]");
        System.out.println("Bag2 uses a resizable array bag and contains the following: [A, B, X, X, Y, Y, Y, Y, Z]");
        System.out.println("Applying the union method with Bag2 as the parameter: " + Arrays.toString(bag_1.union(bag_2).toArray()));
        System.out.println("Applying the intersection method with Bag2 as the parameter: " + Arrays.toString(bag_1.intersection(bag_2).toArray()));
        System.out.println("Applying the difference method with Bag2 as the parameter: " + Arrays.toString(bag_1.difference(bag_2).toArray()));
       
       // System.out.println(Arrays.toString(bag_1.union(bag_2).toArray()));

        //System.out.println(Arrays.toString(bag_1.intersection(bag_2).toArray()));

       // System.out.println(Arrays.toString(bag_1.difference(bag_2).toArray()));

        //System.out.println(Arrays.toString(bag_1.difference2(bag_2).toArray()));
    }
}