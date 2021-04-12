package timeStamp;
/*
 * Author: Anirudh Prasad
 * Date: 6/5/2019
 * Description: This Date class has instance variables of month, day, and year, that gives us a specific
 * label on a period of time. This is very valuable in use many facets of programming.
 */
public class Date implements Comparable{
	
	private int month;
    private int day;
    private int year;
    
	public Date(Date other) {
		dateChecker(other.month, other.day, other.year);
    	
    	setMonth(other.month);
    	setDay(other.day);
    	setYear(other.year);
	}
	
	public Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
	}

	@Override
	public int compareTo(Object o) {
		if(o == null || !(o instanceof Date)) return -1;
		Date that = (Date) o;
		
		if(this.year == that.year) {
			if(this.month == that.month) {
				if(this.day == that.day) return 0;
				else if(this.day > that.day) return 1;
				else return -1;
			}
			else if(this.month > that.month) return 1;
			else return -1;
		}
		else if(this.year > that.year) return 1;
		else return 0;
	}
	
	/*
     * Sets date according to three int input parameters
     */
    public void setDate(int m, int d, int y) {
    	dateChecker(m, d, y);
    	
        setMonth(m);
        setDay(d);
        setYear(y);
    }
    
    /*
     * Checks to see if input parameters meet class invariants
     */
    public void dateChecker(int m, int d, int y) {
    	if((m < 1) || (m > 12)) {
    		System.err.println("Invalid month");
    		System.exit(0);
    	}
    	if((d < 1) || (d > 31)) {
    		System.err.println("Invalid day");
    		System.exit(0);
    	}
    	if(y < 0) {
    		System.err.println("Invalid year");
    		System.exit(0);
    	}
    }
    
    /*
     * Sets month according to int input parameter
     */
    public void setMonth(int m){
    	this.month = m;
    }
    
    /*
     * Sets day according to int input parameter
     */
    public void setDay(int d){
    	this.day = d;
    }
    
    /*
     * Sets year according to int input parameter
     */
 	public void setYear(int y){
 		this.year = y;
 	}
 	
 	/*
     * returns value of month instance variable
     */
 	public int getMonth() {
 		return month;
 	}
 	
 	/*
     * returns value of day instance variable
     */
 	public int getDay() {
 		return day;
 	}
 	
 	/*
     * returns value of year instance variable
     */
 	public int getYear() {
 		return year;
 	}
 	
 	/*
 	 * Tests to see if the two Date objects are equal to each other
 	 */
 	@Override
 	public boolean equals(Object other) {
 		if((other == null) || !(other instanceof Date)) {
 			return false;
 		}

 		Date that = (Date) other;
 		return (that.getMonth() == this.getMonth()) && (that.getDay() == this.getDay()) &&
 			   (that.getYear() == this.getYear());
 	}
 	
 	/*
 	 * returns String representing month, day, and year separated by forward slashes
 	 */
 	@Override
 	public String toString() {
 		return month + "/" + day + "/" + year;
 	}
	
}
