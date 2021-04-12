package shapes;
import java.awt.*;

import mainClasses.PizzaException;
/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This Square class is an object of type shape, and it has it's own specifics that 
 * differentiate it from other shapes that are handled.
 */
public class Square extends Shape implements Cloneable {
	
	private int length;
	private Color color;
	
	public Square(int nx, int ny, int lngth, Color col) {
		super.setX(nx);
		super.setY(ny);
		length = lngth;
		color = col;
	}
	
	public void setLength(int lngth) {
		length = lngth;
	}
	public int getLength() {
		return length;
	}
	
	public void setColor(Color col) {
		color = col;
	}
	
	public Color getColor() {
		return color;
	}
	
	@Override
	public Object clone() {
		try {
			return new Square(getX(), getY(), getLength(), color);
		}catch (IllegalArgumentException e){
			throw new PizzaException();
		}
	}

	@Override
	public double getArea() {
		return Math.pow(length, 2);
	}
	
	@Override
	public String toString() {
		return "Square";
	}
	
}
