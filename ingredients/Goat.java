package ingredients;
import mainClasses.Money;
/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This specific type of cheese is of type cheese and is used as an ingredient in the pizza
 * class
 */
public class Goat extends Cheese{
	
	public Goat() {
		super("Goat cheese", new Money(2, 50), 900);
	}
	
}
