package mainClasses;
import java.util.Scanner;
import timeStamp.*;
import shapes.*;
import ingredients.*;

/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This class extends PizzaManager, which contains a variety of helper methods to assist
 * in calculation in the body of the class. It also contain various abstract classes that this 
 * class overrides.
 * 
 */
public class MyPizzaManager extends PizzaManager{
	private ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
	
	/*
	 * Adds a random pizza to the list
	 */
	@Override
	protected void addRandomPizza() {
		Pizza pz = new Pizza();
		pizzaList.add(pz, 0);
	}
	
	/*
	 * Displays all the pizzas in the list and their data
	 */
	@Override
	protected void displayAllPizzas() {
		System.out.println(pizzaList.toString());
	}
	
	/*
	 * Receives the next user input in the form of a char to perform various tasks for the user
	 */
	@Override
	protected char getNextChar() {
		char[] cList = {'A', 'a', 'H', 'h', 'E', 'e', 'P', 'p', 'S',
				        's', 'C', 'c', 'L', 'l', 'D', 'd', 'B', 'b', 'R', 'r', 'Q', 'q'};
		Scanner console = new Scanner(System.in);
		String input = console.next();
		
		char item = input.charAt(0);
		
		for(int i = 0; i < cList.length; i++) {
			if(item == cList[i]) {
				return item;
			}
		}
		throw new PizzaException("Menu selection invalid");
	}
	
	/*
	 * returns the next int value from user input
	 */
	@Override
	protected int getNextInt() {
		Scanner kb = new Scanner(System.in);
		int intVal = kb.nextInt();
		return intVal;
	}
	
	/*
	 * Eats a fraction of pizza and adjusts the amount left, removes pizza if none is remaining
	 */
	@Override
	protected void eatSomePizza() {
		
		Scanner console = new Scanner(System.in);
		System.out.println("Eating a fraction of a pizza. Which index?");
		int idx = console.nextInt();
		System.out.println("How much, as a fraction?");
		String input = console.next();
		
		String[] fracMake = input.split("/");
		int nm = Integer.parseInt(fracMake[0]);
		int dn = Integer.parseInt(fracMake[1]);
		
		Pizza pz;
		
		try { //tries to call and retrieve PizzaList item at index
			pz = pizzaList.get(idx);
			pz.eatSomePizza(new Fraction(nm, dn));
			
			if(pz.getRemainingFraction().getNumerator() == 0) {
				System.out.println("All gone.");
				pizzaList.remove(idx);
			}
			else {
				System.out.println("Served. Amount remaining: " + pz.getRemainingFraction().toString());
			}
		}
		catch(PizzaException e) { //if there is negative pizza/no pizza
			throw new PizzaException();
		}
		
	}
	
	/*
	 * public facade of calorie quicksort
	 */
	@Override
	protected void quickSortByCalories() {
		quickSortByCalories(0, pizzaList.size() - 1);
	}
	
	/*
	 * Recursive quicksort function that sorts by calories
	 */
	private void quickSortByCalories(int first, int last) {
		if(pizzaList.size() < 1) {
			throw new PizzaException("Empty Array");
		}
		int split = selectPivotCal(first, last);
		if(first < split) {
			quickSortByCalories(first, split - 1);
		}
		if(last > split) {
			quickSortByCalories(split, last);
		}
	}
	
	/*
	 * sets the pivot point for the calorie quicksort
	 */
	private int selectPivotCal(int first, int last) {
		int pivot = pizzaList.get(first).getCalories();
		
		while((last - first) + 1 > 1) { //checks from the middle
			
			while(((Pizza)pizzaList.get(last)).getCalories() < pivot) {
				first++;
			}
			
			while(((Pizza)pizzaList.get(last)).getCalories() > pivot) {
				last--;
			}
			
			if(first <= last) {
				pizzaList.swap(first++, last--);
			}
		}
		
		return first; //returns value to be used as pivot
	}
	
	/*
	 * public price quicksort facade
	 */
	@Override
	protected void quickSortByPrice() {
		quickSortByPrice(0, pizzaList.size() - 1);
	}
	
	/*
	 * recursive quicksort function for the price quicksort
	 */
	private void quickSortByPrice(int first, int last) {
		if(pizzaList.size() < 1) {
			throw new PizzaException("Empty Array");
		}
		int split = selectPivotPrice(first, last);
		if(first < split) {
			quickSortByPrice(first, split - 1);
		}
		if(last > split) {
			quickSortByPrice(split, last);
		}
	}
	
	/*
	 * selects pivot point for the price quicksort
	 */
	private int selectPivotPrice(int first, int last) {
		double pivot = pizzaList.get(first).getPrice().getMoney();
		
		while((last - first) + 1 > 1) { //checks from the middle
			
			while(((Pizza)pizzaList.get(last)).getPrice().getMoney() < pivot) {
				first++;
			}
			
			while(((Pizza)pizzaList.get(last)).getPrice().getMoney() > pivot) {
				last--;
			}
			
			if(first <= last) {
				pizzaList.swap(first++, last--);
			}
		}
		
		return first; //returns value to be used as pivot
	}
	
	/*
	 * size quicksort outer facade
	 */
	@Override
	protected void quickSortBySize() {
		quickSortBySize(0, pizzaList.size() - 1);
	}
	
	/*
	 * recursive quicksort by size
	 */
	private void quickSortBySize(int first, int last) {
		if(pizzaList.size() < 1) {
			throw new PizzaException("Empty Array");
		}
		int split = selectPivotSize(first, last);
		if(first < split) {
			quickSortBySize(first, split - 1);
		}
		if(last > split) {
			quickSortBySize(split, last);
		}
	}
	
	/*
	 * sets the pivot point for the size quicksort
	 */
	private int selectPivotSize(int first, int last) {
		double pivot = pizzaList.get(first).getRemainingArea();
		
		while((last - first) + 1 > 1) { //checks from the middle
			
			while(((Pizza)pizzaList.get(last)).getRemainingArea() < pivot) {
				first++;
			}
			
			while(((Pizza)pizzaList.get(last)).getRemainingArea() > pivot) {
				last--;
			}
			
			if(first <= last) {
				pizzaList.swap(first++, last--);
			}
		}
		
		return first; //returns value to be used as pivot
	}
	
	/*
	 * outer facade for the binary search by calorie count
	 */
	@Override
	protected int binarySearchByCalories(int targetCal) {
		return binarySearchByCalories(targetCal, 0, pizzaList.size() - 1);
	}
	
	/*
	 * recursive binary search for the target calorie count
	 */
	private int binarySearchByCalories(int targetCal, int low, int high) {
		if(low > high) { //base case: fail
			return -1;
		}
		
		int mid = (low + high) / 2;
		
		if(pizzaList.get(mid).getCalories() == targetCal) { //base case: success
			return mid;
		}
		else if(pizzaList.get(mid).getCalories() > targetCal) {
			return binarySearchByCalories(targetCal, low, mid-1);
		}
		else if (pizzaList.get(mid).getCalories() < targetCal) {
			return binarySearchByCalories(targetCal, mid + 1, high);
		}
		
		return binarySearchByCalories(targetCal, mid + 1, high);
	}
	
	/*
	 * removes day+ old pizzas from list
	 */
	protected void removeDayOldPizzas() {
		Pizza temp = null;
		for(int i = 0; i < pizzaList.size(); i++) {
			temp = pizzaList.get(i);
			if(temp.getMadeDate().compareTo(super.getCurrentDate()) == -1) {
				System.out.println("Pizza " + pizzaList.indexOf(i) + " is one day old. Removing now.");
				pizzaList.remove(i);
			}
		}
	}
	
	/*
	 * Searches for pizza produced on a specific day
	 */
	protected int linearSearchByDay(int day) {
		for(int i = 0; i < pizzaList.size(); i++) {
			if(((Pizza)pizzaList.get(i)).getMadeDate().getDay() == day) {
				System.out.println("Pizza " + pizzaList.indexOf(i) + " was made on day " + day);
				return i;
			}
		}
		System.out.println("No pizzas made that day.");
		return -1;
	}
	
	/*
	 * Uses a stack and a new arrayList to reverse the order of the items in the previous Pizza
	 * arrayList
	 */
	protected void reversePizzasWithStack() {
		Stack<Pizza> reverser = new Stack<Pizza>();
		
		for(int i = 0; i < pizzaList.size(); i++) {
			reverser.push(pizzaList.get(i));
		}
		
		ArrayList<Pizza> newList = new ArrayList<Pizza>();
		while(!reverser.isEmpty()) {
			newList.add(reverser.pop(), newList.size());
		}
		
		pizzaList = new ArrayList<Pizza>(newList);
	}
	
}