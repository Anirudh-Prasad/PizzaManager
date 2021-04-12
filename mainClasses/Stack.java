package mainClasses;

/*
 * This class was made to demonstrate a last-in-first-out list system. The Stack class stores
 * objects and primitives in an array-like formats by pushing them to the left, retrieves the last 
 * item in the list, and shifts the array to the right to place the next-to-last element in the 
 * array in a position to be retrieved next. This next-to-last element will become the last element
 * in the array once the array is shifted.
 * 
 * Author: Anirudh Prasad
 * Date: 4/29/2019
 */
public class Stack<TBA> {
	
	private Object[] data = new Object[100];
	private int numElements;
	
	/*
	 * Default constructor
	 */
	public Stack() {
		numElements = 0;
	}
	
	/*
	 * Copy constructor for the Stack class that copies another Stack's data without creating 
	 * a privacy leak
	 */
	public Stack(Stack other) {
		this.numElements = other.numElements;
		Object temp;
		for(int i = 0; i < other.data.length; i++) {
			temp = other.data[i];
			this.data[i] = temp;
		}
	}

	/*
	 * Returns the last element in the array, and decrements numElements to reflect this
	 */
	public TBA pop() {
		if(size() == 0) {
			throw new RuntimeException("Cannot pop from empty list");
		}
		return (TBA) data[--numElements];
	}
	
	/*
	 * Adds the specified item to the end of the stack and increments numElements to account for it
	 */
	public void push(Object item) {
		data[numElements++] = item;
	}
	
	/*
	 * Returns the number of elements currently being used by the array
	 */
	public int size() {
		return numElements;
	}
	
	/*
	 * Returns a boolean value signifying whether or not the stack has any values in it
	 * If it has no values, returns true. If it has at least one value, returns false
	 */
	public boolean isEmpty() {
		if(numElements == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	/*
	 * Returns a String that represents all the values in the stack
	 */
	public String toString() {
		String total = "";
		for(int i = 0; i < numElements; i++) {
			total += data[i];
		}
		return total;
	}
	
	@Override
	/*
	 * Tests to see if two Stack objects are equal to each other
	 */
	public boolean equals(Object other) {
		if((other == null) || !(other instanceof Stack<?>)) {
			return false;
		}
		Stack<TBA> that = (Stack<TBA>) other;
		boolean listBool = true;
		for(int i = 0; i < data.length; i++) {
			if(this.data[i] != that.data[i]) {
				listBool = false;
			}
		}
		return (listBool) && (this.size() == that.size());
	}
}
