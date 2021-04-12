package mainClasses;
/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: this class creates fraction objects that can handle a variety of tasks that need to
 * be taken for fraction data objects. Very useful in calculations, such as with the pizza class that
 * this class is extensively used in
 * 
 */
public class Fraction implements Comparable, Cloneable{
	private int num; //numerator
	private int den; //denominator
	
	public Fraction() { //constructor for no parameters
		setNumerator(1);
		setDenominator(1);
	}
	
	public Fraction(int n, int d) { //Constructor for two int parameters
		setNumerator(n);
		setDenominator(d);
		simplify(num, den);
		
	}
	
	/*
	 * Copy constructor for Fraction objects
	 */
	public Fraction(Fraction that) {
		this.setNumerator(that.getNumerator());
		this.setDenominator(that.getDenominator());
	}

	public int getNumerator(){ //returns numerator
		return num;
	}
	
	public void setNumerator(int n) { //sets numerator
		this.num = n;
	}
	
	public int getDenominator() { //returns denominator
		return den;
	}
	
	public void setDenominator(int d) { //sets denominator, and crashes if denominator = 0
		if(d == 0) {
			throw new PizzaException("Error: Cannot set denominator to zero");
		}
		this.den = d;
	}
	
	public Fraction remove(Fraction other) {
		int nm = 0;
		int dn = 0;
		
		if(this.getDenominator() != other.getDenominator()) {
			dn = this.getDenominator() * other.getDenominator();
			nm = (this.getNumerator() * other.getDenominator()) - (other.getNumerator() * 
				  this.getDenominator());
		}
		else {
			dn = this.getDenominator();
			nm = this.getNumerator() - other.getNumerator();
		}
		
		simplify(nm, dn);
		return new Fraction(nm, dn);
	}
	
	/*
	 * simplifies the fraction using a loop to divide num and den by the gcd, if possible
	 */
	public void simplify(int n, int d) {
		for(int i = 1; i <= Math.min(n, d); i++) {
			if((this.num % i == 0) && (this.den % i == 0)){
				this.num /= i;
				//System.out.println(this.num);
				this.den /= i;
				//System.out.println(this.den);
			}
		}
	}
	
	/*
	 * returns the value of the fraction as a double
	 */
	public double doubleVal() {
		return ((double) getNumerator()) / ((double) getDenominator());
	}
	
	/*
	 * Tests if a fraction object is equal to another fraction object
	 */
	public boolean equals(Fraction other){
		if(other == null) {
			return false;
		}
		if(!(other instanceof Fraction)) {
			return false;
		}
		return ((this.num == other.num) && (this.den == other.den));
	}
	
	public String toString() { //returns a String output if called by instance
		String retVal = "";
		if(num % den == 0) {
			retVal += (num / den);
			return retVal;
		}
		return num + "/" + den;
	}
	
	/*
	 * Overrides Compareable's compareTo method and tests to see how the two Fraction objects 
	 * compare to each other
	 */
	@Override
	public int compareTo(Object obj) {
		if(obj == null || !(obj instanceof Fraction)) throw new PizzaException();
		Fraction that = (Fraction) obj;
		
		if(that.doubleVal() > that.doubleVal()) return 1;
		else if(that.doubleVal() < that.doubleVal()) return -1;
		else return 0;
	}
	
}
