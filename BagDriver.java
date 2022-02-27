public class BagDriver{

    public static void main(String[] args){

        //for testing union, intersection, difference methods on ResizableArrayBag class
        String[] firstarray = {"a","b","c","d","e"};
        String[] secondarray = {"f", "g", "h"};
        ResizableArrayBag<String> bag1 = new ResizableArrayBag(firstarray);
        ResizableArrayBag<String> bag2 = new ResizableArrayBag(secondarray);

        bag1.union(bag2);
        
        //BagInterface<String> everything = bag1.union(bag2);
    }

}