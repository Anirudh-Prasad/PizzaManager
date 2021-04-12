package ingredients;
import mainClasses.Money;
/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This Marinara class represents the Marinara sauce ingredient of the pizza class. 
 *  Extends the Base class to be used as a Base ingredient
 */
public class Marinara extends Base{
	
	public Marinara() {
		super("Marinara", new Money(1), 85);
	}
	
}
