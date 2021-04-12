package ingredients;
import mainClasses.Money;
import java.awt.*;

public class Vegetable extends Ingredient{
	private Color color;
	
	public Vegetable(String desc, Money mon, int cal) {
		super(desc, mon, cal);
		color = new Color(0, 255, 0);
	}
	
	public Vegetable(String desc, Money mon, int cal, Color col) {
		super(desc, mon, cal);
		color = col;
	}
	
	public void setColor(Color col) {
		color = col;
	}
	
	public Color getColor() {
		return color;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n Color: " + getColor().toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Vegetable)) throw new RuntimeException();
		Vegetable that = (Vegetable) obj;
		
		return super.equals(that) && this.getColor().equals(that.getColor());
	}
	
}
