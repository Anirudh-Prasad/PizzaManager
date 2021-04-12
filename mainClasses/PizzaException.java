package mainClasses;
/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This PizzaException class extends runtime exception and is thrown in the pizza class in
 * place of runtime exceptions
 */
public class PizzaException extends RuntimeException {
	
	public PizzaException() {
		System.err.println("Bad Pizza");
	}
	
	public PizzaException(String msg) {
		System.err.println(msg);
	}
	
}
