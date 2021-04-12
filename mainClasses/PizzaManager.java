/*
 *  PizzaManager Superclass
 *  Final Project CSS 162
 * 
 *  (DONT EDIT)
 *  (all work goes in your MyPizzaManager subclass)
 * 
 *  This class is a Superclass for your MyPizzaManager subclass and has only partial functionality. 
 *  Start by reading the documentation(comments), and then the code.  Find the 
 *  empty stub methods you are to override in using a Top-Down approach (see the
 *  assignment for more information on this and Stepwise Refinement)
 * 
 *  Author: Rob Nash
 */

package mainClasses;
import java.util.Calendar;
import java.util.Scanner;

import timeStamp.Date;
import timeStamp.Time;


public class PizzaManager {
	
	/*
	 * Notice the one-line main function.
	 * Also notice you have no control over the next two final functions
	 */
	public final static void main(String[] args) {
		PizzaManager manager = new MyPizzaManager(); //new MyPizzaManagerSoln();  
		manager.start();
	}

	/*   
	 * The console interface to the Pizza Simulator is defined in the start method 
	 * You can exit or extend the code below to accomplish all of 
	 * the outcomes defined in the homework document
	 * 
	 * Note the use of final to block any attempt to override this method
	 */
	public final void start() {
	
		while(true) {
			displayAllPizzas();
			displayInstructions();

			switch( getNextChar() ) { //nextChar() doesn't exist for Scanner, so now what?  You do it.
				case	'A':	case	'a':    addRandomPizza();
												break;
				case	'H':    case	'h':	addOneHundredPizzas();
												break;					
				case	'E':    case	'e':	eatSomePizza();
												break;			
				case	'P':    case	'p': 	quickSortByPrice();
												break;	
				case	'S':   	case	's': 	quickSortBySize();
												break;
				case	'C':    case	'c':  	quickSortByCalories();
												break;
				case    'L':    case    'l':    System.out.println("What day are you looking for?");
												linearSearchByDay(getNextInt());
												break;
				case    'D':    case    'd':    removeDayOldPizzas();
												break;
				case	'B':	case	'b':	System.out.println("What calorie count are you looking for?");
												binarySearchByCalories(getNextInt());
												break;
				case    'R':    case 	'r':    reversePizzasWithStack();	
												break;
				case    'Q': 	case 	'q':	System.out.println("(Q)uitting...");
												System.exit(0);
												break;
				default:						System.out.println("Unrecognized input - try again");
			}
		}

	}
	/*
	 * Begin free helper methods
	 */
	protected static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nQuickSort pizzas by (P)rice\nQuickSort pizzas by (S)ize\nQuickSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(L)inear search pizzas by day\n(R)everse order of pizzas with a stack\nRemove (D)ay-old pizzas\n(Q)uit\n";
	protected void displayInstructions() {
		System.out.println(instructions);	
	}
	public static Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		return new Date(cal.getTime().getMonth(), cal.getTime().getDay(), cal.getTime().getYear());
	}
	
	public static Time getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		return new Time(cal.getTime().getHours(), cal.getTime().getMinutes(), cal.getTime().getSeconds()); 
	}
	
	public void addOneHundredPizzas() {
		System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
		for(int i = 0; i < 99; i++) {
			addRandomPizza();
		}
	}
	/*
	 * End helper methods
	 */
	
	
	
	/*
	 * Methods to Override
	 * Override the following methods your MyPizzaManager Subclass
	 * Note that you don't change any of these methods here, but just replace them in the derived class.
	 */
	protected char getNextChar() {
		char[] options = {'A','H','E','P','S','C','B','R','Q'};
		return options[(int)(Math.random() * options.length)];  //wrong   
	}
	
	protected int getNextInt() {
		return (int)(Math.random()*9+1);   			//broken
	}
	
	protected void displayAllPizzas() {
		System.out.println("BAD P!ZZAS");  			//bad
	}
	
	protected void eatSomePizza() {
		throw new RuntimeException( "eatSomePizza() not yet implemented in MyPizzaManager subclass!");
	}
   
	protected void addRandomPizza() {
		throw new RuntimeException( "addRandomPizza() not yet implemented in MyPizzaManager subclass!");
	}

	protected void quickSortByPrice() {  
		throw new RuntimeException( "quickSortByPrice() not yet implemented in MyPizzaManager subclass!");
	}

	protected void quickSortBySize() {
		throw new RuntimeException( "quickSortBySize() not yet implemented in MyPizzaManager subclass!");
	}

	protected void quickSortByCalories() {
		throw new RuntimeException( "quickSortByCalories() not yet implemented in MyPizzaManager subclass!");
	}

	protected int binarySearchByCalories(int cals) {
		
		throw new RuntimeException( "binarySearchByCalories() not yet implemented in MyPizzaManager subclass!");
	}
	
	protected int linearSearchByDay(int day) {
		throw new RuntimeException( "linearSearchByDay() not yet implemented in MyPizzaManager subclass!");
	}
	
	protected void removeDayOldPizzas() {
		throw new RuntimeException( "removeDayOldPizzas() not yet implemented in MyPizzaManager subclass!");
	}
	
	protected void reversePizzasWithStack() {
		throw new RuntimeException( "reversePizzasWithStack() not yet implemented in MyPizzaManager subclass!");
	}
}
