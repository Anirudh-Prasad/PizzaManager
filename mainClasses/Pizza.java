package mainClasses;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Random;

import shapes.*;
import timeStamp.*;
import ingredients.*;

/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This class implements the PizzaComparable interface, and it has a variety of tools
 * to handle objects of type Pizza. The various methods in this class all function to handle vast
 * variety of data associated with pizzas in order to better create a functioning system of pizza
 * management.
 * 
 */
public class Pizza implements PizzaComparable {
	
	private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private int calCount = 0;
	private Money price = new Money();
	private Fraction pizzaLeft = new Fraction(1, 1);
	private TimeStamp dateMade;
	private Shape myShape;
	
	/*
	 * Default-no args constructor that initialzes the instance variables using the Random class
	 * in order to randomly generate pizzas with different qualities.
	 */
	public Pizza() {
		
		//TODO:  this one makes a random pizza as far as ingredients and shape & size go
		//dateMade= new TimeStamp(PizzaManager.getCurrentDate(), PizzaManager.getCurrentTime());
		Random rand = new Random();
		
		switch(rand.nextInt(2)) {
		case 1:
			setShape(new Square(0, 0, 10, Color.yellow));
			break;
		default:
			setShape(new Circle(0, 0, 10, Color.yellow));
			break;
		}
		
		Cheese layer;
		switch(rand.nextInt(2)) {
		case 1:
			layer = new Goat();
			break;
		default:
			layer = new Mozarella();
			break;
		}
		addIngredient(layer);
		
		Base sauce;
		switch(rand.nextInt(2)) {
		case 1:
			sauce = new Marinara();
			break;
		default:
			sauce = new Alfredo();
			break;
		}
		addIngredient(sauce);
		
		Meat topping;
		switch(rand.nextInt(2)) {
		case 1:
			topping = new Sausage();
			break;
		default:
			topping = new Pepperoni();
			break;
		}
		addIngredient(topping);
		
		Vegetable veggie;
		switch(rand.nextInt(2)) {
		case 1:
			veggie = new Olive();
			break;
		default:
			veggie = new Pepper();
			break;
		}
		addIngredient(veggie);
		
		setDateMade();
	}
	
	/*
	 * returns the date the pizza was made
	 */
	public Date getMadeDate() { 
		return new Date(dateMade.getDate());
	}
	
	/*
	 * sets the day the pizza was made
	 */
	public void setDateMade() {
		dateMade = new TimeStamp(PizzaManager.getCurrentDate(), PizzaManager.getCurrentTime());
	}
	
	/*
	 * returns the price of the pizza
	 */
	public Money getPrice() {
		price =  new Money(price.getMoney() * this.getRemainingFraction().doubleVal());
		return new Money(price);
	}
	
	/*
	 * returns the shape of the pizza
	 */
	public Shape getShape() {
		return (Shape) myShape.clone();
	}
	
	/*
	 * sets the shape of the pizza
	 */
	public void setShape(Shape item) {
		myShape = (Shape) item.clone();
	}
	
	/*
	 * returns the calorie count of the pizza
	 */
	public int getCalories() {
		return calCount;
	}
	
	/*
	 * Adds ingredient objects to the ingredient ArrayList. Also adjusts calcCount and price
	 * accordingly for each addition to the list
	 */
	public void addIngredient(Ingredient item) {
		if(item == null) throw new PizzaException();
		ingredientList.add(item, 0);
		calCount += item.getCalories();
		price.add(item.getCost());
	}
	
	/*
	 * returns the amount of pizza left in the form of a fraction object
	 */
	public Fraction getRemainingFraction() {
		return new Fraction(pizzaLeft);
	}
	
	/*
	 * sets the amount of pizza left upon being given a pizza object
	 */
	public void setRemainingFraction(Fraction frac) {
		pizzaLeft = new Fraction(frac);
	}
	
	/*
	 * returns the area of the remaining portions of the pizza
	 */
	public double getRemainingArea() {
		return myShape.getArea() * pizzaLeft.doubleVal();
	}
	
	/*
	 * removes a certain portion of pizza from the pizza, and adjusts the price accordingly
	 */
	public void eatSomePizza(Fraction amt) {
		if(amt == null) throw new PizzaException("Null fraction");
		pizzaLeft = pizzaLeft.remove(amt);
	}
	
	/*
	 * Returns String representation of items in ingredient list, as well as other qualities of 
	 * the pizza that need to be defined
	 */
	@Override
	public String toString() {
		return "Pizza has a price: " + price.toString() + " and calories: " + calCount + 
				", Fraction remaining: " + pizzaLeft.toString() + " and area left: "
				+ getRemainingArea() + " and shape: " + myShape.toString();
	}
	
	/*
	 * Overrides the compareTo of Compareable and compares price between two Pizzas
	 */
	@Override
	public int compareTo(Object obj) {
		if(obj == null || !(obj instanceof Pizza)) throw new PizzaException();
		Pizza that = (Pizza) obj;
		
		return this.getPrice().compareTo(that.getPrice());
	}
	
	/*
	 * Overrides the compareTo of Compareable and compares size between two pizzas
	 */
	@Override
	public int compareToBySize(Object obj) {
		if(obj == null || !(obj instanceof Pizza)) throw new PizzaException();
		Pizza that = (Pizza) obj;
		
		if(this.getShape().getArea() > that.getShape().getArea()) return 1;
		if(this.getShape().getArea() < that.getShape().getArea()) return -1;
		else return 0;
	}
	
	/*
	 * Overrides the compareTo of Compareable and compares size between two pizzas
	 */
	@Override
	public int compareToByCalories(Object obj) {
		if(obj == null || !(obj instanceof Pizza)) throw new PizzaException();
		Pizza that = (Pizza) obj;
		
		if(this.getCalories() > that.getCalories()) return 1;
		else if(this.getCalories() < that.getCalories()) return -1;
		else return 0;
	}

}
