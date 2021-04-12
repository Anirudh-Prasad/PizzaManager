package shapes;

import mainClasses.PizzaException;
import java.awt.*;
/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This circle class extends the shape class, and it has a variety of specifications that 
 * differentiate it from a circle.
 */
public class Circle extends Shape implements Cloneable {
	
	private int radius;
	private Color color;
	
	public Circle(int nx, int ny, int rad, Color col) {
		super.setX(nx);
		super.setY(ny);
		radius = rad;
		color = col;
	}
	
	public void setRadius(int rad) {
		radius = rad;
	}
	public int getRadius() {
		return radius;
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
			return new Circle(getX(), getY(), getRadius(), color);
		}catch (IllegalArgumentException e){
			throw new PizzaException();
		}
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public String toString() {
		return "Circular";
	}
}
