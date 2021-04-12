package mainClasses;
/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This ArrayList class holds generics as well, which allow it to be far more specific
 * with the data items that it can hold within itself. Can be used for a variety of purposes befitting
 * a data structure as useful as an ArrayList
 */
public class ArrayList<TBA extends Comparable> {
	
	private Object[] aList = new Object[100];
	private int numElements;
	
	/*
	 * Default constructor
	 */
	public ArrayList() {
		this.numElements = 0;
	}
	
	/*
	 * Copy constructor for the ArrayList class that copies another ArrayList's data without creating 
	 * a privacy leak
	 */
	public ArrayList(ArrayList<TBA> other) {
		Object temp;
		for(int i = 0; i < other.aList.length; i++){
			temp =other.aList[i];
			this.aList[i] = temp;
		}
		this.numElements = other.numElements;
	}
	
	/*
	 * Adds an object next to the array at the specified index, and shifts the array to the right at
	 * the index. Also accounts for numElements being greater than the length of the list by calling
	 * resize()
	 */
	public void add(TBA next, int index) {
		if(index < 0) {
			System.err.println("Error: invalid index");
			System.exit(0);
		}

		if(numElements + 1 >= aList.length) {
			resize();
		}
		this.numElements++;
		shiftRight(index);
		this.aList[index] = next;
	}
	
	/*
	 * Creates a new array that has a greater length to replace the current private array
	 */
	private void resize() {
		Object[] newAList = new Object[aList.length * 2];
		for(int i = 0; i < aList.length; i ++) {
			Object tempVal = aList[i];
			newAList[i] = tempVal;
		}
		
		this.aList = newAList;
	}
	
	/*
	 * Removes the element at the specified index as long as the array isn't empty
	 * Then shifts the array to the left
	 */
	public Object remove(int index) {
		if(!isEmpty()) {
			Object retVal = this.aList[index];
			shiftLeft(index);
			numElements--;
			return retVal;
		}
		else {
			throw new PizzaException("Cannot remove from an empty list bucko");
		}
	}
	
	/*
	 * Shifts all the elements of the array to the left
	 */
	public void shiftLeft(int end) {
		for(int i = end; i < numElements; i++) {
			aList[i] = aList[i + 1];
		}
	}
	
	/*
	 * Shifts all the elements of the array to the right
	 */
	public void shiftRight(int start) {
		for(int i = numElements - 2; i >= start; i--) {
			aList[i + 1] = aList[i];
		}
	}
	
	/*
	 * Returns the element at the specified index
	 */
	public TBA get(int index) {
		return (TBA) aList[index];
	}
	
	/*
	 * returns the amount of elements in the ArrayList
	 */
	public int size() {
		return numElements;
	}
	
	public void swap(int idx1, int idx2) {
		Object temp = aList[idx1];
		aList[idx1] = aList[idx2];
		aList[idx2] = temp;
	}
	
	/*
	 * Takes an object as an input parameter and returns the index of the first instance of the 
	 * object in the list
	 */
	public int indexOf(Object obj) {
		for(int i = 1; i < aList.length; i++) {
			if(aList[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * Returns a boolean value to indicate whether or not the ArrayList is empty
	 * Returns true if empty, false if containing values
	 */
	public boolean isEmpty() {
		if(numElements == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * Returns a String containing all of the elements of the ArrayList
	 */
	@Override
	public String toString() {
		String total = "";
		for(int i = 0; i < numElements; i++) {
			total += aList[i].toString() + "\n";
		}
		return total;
	}
	
	/*
	 * Tests to see if two ArrayList object are equal to each other
	 */
	@Override
	public boolean equals(Object other) {
		if((other == null) || !(other instanceof ArrayList<?>)) {
			return false;
		}
		ArrayList<TBA> that = (ArrayList<TBA>) other;
		boolean listBool = true;
		for(int i = 0; i < aList.length; i++) {
			if(this.aList[i] != that.aList[i]) {
				listBool = false;
			}
		}
		return (listBool) && (this.size() == that.size());
	}
	
}
