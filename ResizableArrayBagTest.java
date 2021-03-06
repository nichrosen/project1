import java.util.Arrays;

public class ResizableArrayBagTest{

    public static void main(String[] args){

        BagInterface<String> bag_1 = new ResizableArrayBag<>();
        BagInterface<String> bag_2 = new ResizableArrayBag<>();

        bag_1.add("A");
        bag_1.add("Q");
        bag_1.add("Q");
        bag_1.add("R");
        bag_1.add("X");
        bag_1.add("Z");

        bag_2.add("A");
        bag_2.add("A");
        bag_2.add("U");
        bag_2.add("X");
        bag_2.add("Y");
        bag_2.add("Y");
        bag_2.add("Y");
        bag_2.add("Y");
        bag_2.add("Z");

        System.out.println("Bag1 uses a resizable array bag and contains the following: [A, Q, Q, R, X, Z]");
        System.out.println("Bag2 uses a resizable array bag and contains the following: [A, A, U, X, Y, Y, Y, Y, Z]");
        System.out.println("Applying the union method with Bag2 as the parameter: " + Arrays.toString(bag_1.union(bag_2).toArray()));
        System.out.println("Applying the intersection method with Bag2 as the parameter: " + Arrays.toString(bag_1.intersection(bag_2).toArray()));
        System.out.println("Applying the difference method with Bag2 as the parameter: " + Arrays.toString(bag_1.difference(bag_2).toArray()));

    }

}