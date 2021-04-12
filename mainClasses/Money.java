package mainClasses;

import java.text.DecimalFormat;

/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This class creates objects of the type Money, which is important in representing fiscal
 * balances in the pizza class and wherever money is utilized and represented. A variety of calculations
 * using money are performed within this class as well
 * 
 */
public class Money implements Comparable{
	private int dollars;
	private int cents;
	
	@Override
	public int compareTo(Object obj) {
		if(obj == null || !(obj instanceof Money)) return -1;
		
		Money that = (Money) obj;
		if(this.getDollar() > that.getDollar()) return 1;
		
		else if(this.getDollar() < that.getDollar()) return -1;
		
		else if(this.getDollar() == that.getDollar()) {
			if(this.getCent() > that.getCent()) return 1;
			else if(this.getCent() < that.getCent()) return -1;
			else return 0;
		}
		return 0;
	}
	
	public Money() {
		this.dollars = 0;
		this.cents = 0;
	}
	
	/*
	 * Constructor for Money object and initializes dollars instance variable with int parameter
	 */
	public Money(int dol) {
		setDollar(dol);
	}
	
	/*
	 * Constructor for Money object and initializes dollars and and cents instance variables with two
	 * int parameters
	 */
	public Money(int dol, int cent) {
		setDollar(dol);
		setCent(cent);
	}
	
	/*
	 * Copy constructor that takes a money object as a parameter and creates a copy of it
	 */
	public Money(Money other) {
		this.dollars = other.getDollar();
		this.cents = other.getCent();
	}
	
	  public Money(double amount)
	    {
	        setDollar((int)amount);
	        setCent((int)(amount - dollars) * 100);
	    }
	
	/*
	 * returns value of dollars instance variable
	 */
	public int getDollar() {
		return dollars;
	}
	
	/*
	 * returns value of cents instance variable
	 */
	public int getCent() {
		return cents;
	}
	
	/*
	 * takes int parameter and sends it equal to dollars instance variable
	 */
	public void setDollar(int d) {
		DollarChecker(d);
		this.dollars = d;
	}
	
	/*
	 * takes int parameter and sets it equal to cents instance variable
	 */
	public void setCent(int c) {
		this.cents = CentChecker(c);
	}
	
	/*
	 * returns total money in double format
	 */
	public double getMoney() {

		DecimalFormat nf = new DecimalFormat("#.00");

		
		double n = (double)getDollar() + (((double)getCent()) / 100);
		
		return Double.valueOf(nf.format(n));
		
	}
	
	/*
	 * sets dollars and cents instance variables according to the double money parameter
	 */
	public void setMoney(double mon) {
		int ct = (int) (mon * 100);
		//System.out.println(ct);
		//System.out.println(ct);
		int cnt = ct % 100;
		//System.out.println(cnt);
		this.cents = cnt;
		
		int mont = (int) mon;
		//System.out.println(mont);
		this.dollars = mont;
	}
	
	/*
	 * sets dollars and cents instance variables equal to the two int parameters
	 */
	public void setMoney(int d, int c) {
		DollarChecker(d);
		this.dollars = d;
		this.cents = CentChecker(c);
	}
	
	/*
	 * Tests to see if the int dollar input parameter meets class invariants
	 */
	private void DollarChecker(int d) {
		if(d < 0) {
			System.err.println("Error: dollars cannot be negative");
			System.exit(0);
		}
	}
	
	/*
	 * Tests to see if the int cent input paramter meets class invariants
	 * If c is greater than 99, increments dollar according to every 100 cents and returns the extra 
	 * cents
	 * If c is negative, crashes code
	 * If no problems, returns c
	 */
	private int CentChecker(int c) {
		if(c < 0) {
			System.err.println("Error: cents cannot be negative");
			System.exit(0);
		}
		if(c > 99) {
			int d = c / 100;
			this.dollars += d;
			int ct = c % (d * 100);
			//System.out.println(ct);
			return ct;
		}
		return c;
	}
	
	/*
	 * Adds dollars and cents input paramters to their respective instance variables
	 */
	public void add(int dol, int cent) {
		add(dol);
		this.cents += CentChecker(cent);
	}
	
	/*
	 * Adds dollar input parameter to dollar instance variable
	 */
	public void add(int dol) {
		DollarChecker(dol);
		this.dollars += dol;
	}
	
	/*
	 * Adds dollar and cents instance variables from the money object in the input parameter to the
	 * class instance variable
	 */
	public void add(Money other) {
		add(other.getDollar(), other.getCent());
	}
	
	/*
	 * Tests to see if two money objects are equal to each other
	 */
	@Override
	public boolean equals(Object other) {
		if((other == null) || !(other instanceof Money)) {
			return false;
		}
		Money that = (Money) other;
		return (this.getMoney() == that.getMoney());
	}
	
	/*
	 * returns String object representing dollars and cents, and places 0 accordingly
	 */
	@Override
	public String toString() {
		String output = "$" + getDollar() + "." + getCent();
		
//		if(cents < 9) {
//			output += ".0" + getCent();
//		}
//		else {
//			output += "." + getCent();
//		}
		return output;
	}

}
