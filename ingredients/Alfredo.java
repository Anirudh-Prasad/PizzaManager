package ingredients;
import mainClasses.Money;
/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This Alfredo class represents the Alfredo sauce ingredient of the pizza class. 
 * Along with Marinara, this also extends the Base class to be used as an ingredient in the pizza class
 */
public class Alfredo extends Base{
	
	public Alfredo() {
		super("Alfredo", new Money(1, 20), 100);
	}
	
}
