
/** OUTLINE
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
*/
public class LinkedBag<T> implements BagInterface<T>
{
	private Node firstNode;       // reference to first node
	private int numberOfEntries;

	public LinkedBag()
	{
		firstNode = null;
      numberOfEntries = 0;
	} // end default constructor

	
	/** 
	 * @return int
	 */
	public int getCurrentSize(){
		return numberOfEntries;
	}
	
	/** Sees whether this bag is empty.
		 @return  True if the bag is empty, or false if not. */
	public boolean isEmpty(){
		return numberOfEntries == 0;
	}
	
	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry){
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;

		firstNode = newNode;
		numberOfEntries++;

		return true;
	}

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal.
                was successful, or null. */
	public T remove(){
		T result = null;
		if (firstNode != null){
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();
			numberOfEntries--;
		}
		
		return result;
	}
   
	/** Removes one occurrence of a given entry from this bag, if possible.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
   public boolean remove(T anEntry){
	   boolean result = false;
	   Node nodeN = getReferenceTo(anEntry);

	   if (nodeN != null){
		   nodeN.setData(firstNode.getData());
		   firstNode = firstNode.getNextNode();

		   numberOfEntries--;
		   result = true;
	   }
	   return result;
   }
	
	/** Removes all entries from this bag. */
	public void clear(){
		while (!isEmpty()){
			remove();
		}
	}
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry)
	{
		int frequency = 0;
		
		int counter = 0;
		Node currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
			{
				frequency++;
			}
			
			counter++;
			currentNode = currentNode.getNextNode();
		}

		return frequency;
	}
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to find.
		 @return  True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry){
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)){
			if (anEntry.equals(currentNode.getData())){
				found = true;
			}
			else{
				currentNode = currentNode.getNextNode();
			}
		}
		return found;
		}
   
	/** Retrieves all entries that are in this bag.
		 @return  A newly allocated array of all the entries in the bag.
                Note: If the bag is empty, the returned array is empty. */
	public T[] toArray(){
		T[] result = (T[])new Object[numberOfEntries];

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)){
			result[index] = currentNode.getData();
			index++;
			currentNode = currentNode.getNextNode();
		}
		return result;
	}

	/** Combines contents of two bags into another bag.
		 @param bag2  Second bag.
		 @return  combined, Combined bag of contenets from both bags. */
	public BagInterface<T> union(BagInterface<T> bag2){
		BagInterface<T> combined = new LinkedBag<T>();
		T[] firstbag = this.toArray();
		T[] secondbag = bag2.toArray();
  
		for (int i = 0; i < numberOfEntries; i++){
		   combined.add(firstbag[i]);
		}
  
		for (int i = 0; i < bag2.getCurrentSize(); i++){
		   combined.add(secondbag[i]);
		}
  
		return combined;
	}

   /** Combines only like contents of two bags into another bag.
       @param bag2  Second bag.
       @return  combined, combined bag of like contents. */
	public BagInterface<T> intersection(BagInterface<T> bag2){
		BagInterface<T> compare = new LinkedBag<T>();
		BagInterface<T> combined = new LinkedBag<T>();
        T[] firstbag = this.toArray();
        T[] secondbag = bag2.toArray();

      for(int i = 0; i < numberOfEntries; i++){
          compare.add(firstbag[i]);
      }

      for(int i = 0; i < bag2.getCurrentSize(); i++){
        if(compare.contains(secondbag[i])){
            combined.add(secondbag[i]);
        }
      }
      return combined;
	}

/** Creates a collection of entries that would be left in one collection, after removing
 *  those that also occur in the second.
       @param bag2  Second bag.
       @return compare, new collection of entries after second bag contents are removed from first bag. */
	public BagInterface<T> difference(BagInterface<T> bag2){
		BagInterface<T> compare = new LinkedBag<T>();
		T[] firstbag = this.toArray();
		T[] secondbag = bag2.toArray();
  
		for(int i = 0; i < numberOfEntries; i++){
			compare.add(firstbag[i]);
		}
		
		for(int i = 0; i < bag2.getCurrentSize(); i++){
			if(compare.contains(secondbag[i])){
				compare.remove(secondbag[i]);
			}
		}
  
		return compare;
	}

	private Node getReferenceTo(T anEntry){
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)){
			if (anEntry.equals(currentNode.getData())){
				found = true;
			}
			else{
				currentNode = currentNode.getNextNode();
			}
		}
		return currentNode;
	}

   // . . .

	private class Node
	{
	   private T    data; // Entry in bag
	   private Node next; // Link to next node
      
		private Node(T dataPortion)
		{
			this(dataPortion, null);
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		} // end constructor

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
	} // end Node
} // end LinkedBag
