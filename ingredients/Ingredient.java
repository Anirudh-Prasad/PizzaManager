package ingredients;

import mainClasses.Money;
import mainClasses.PizzaException;
/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This abstract class is used to provide implementations of the various ingredients to
 * be used in the pizza class
 */
public abstract class Ingredient implements Comparable {
	
	private Money cost;
	private int calories;
	private String description;
	
	public Ingredient(String desc, Money mon, int cal) {
		cost = new Money(mon);
		calories = cal;
		description = desc;
	}
	
	public Money getCost() {
		return new Money(cost);
	}
	
	public void setCost(Money Mon) {
		cost = new Money(Mon);
	}
	
	public int getCalories() {
		return calories;
	}
	
	public void setCalories(int cal) {
		calories = cal;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		description = desc;
	}
		
	@Override
	public int compareTo(Object obj) {
		return cost.compareTo(obj);
	}
	
	public String toString() {
		return "Cost: " + cost.toString() + "\n Calories: " + getCalories() + "/n" + getDescription();
	}
	
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Ingredient)) throw new RuntimeException();
		Ingredient that = (Ingredient) obj;
		
		return (this.getCost().equals(that.getCost())) && (this.getCalories() == that.getCalories())
				&& (this.getDescription().equals(that.getDescription()));
	}

}
