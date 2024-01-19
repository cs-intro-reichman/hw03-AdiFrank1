/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.

	    int debugDaysCounter = 0;
	    int selectYear = Integer.parseInt(args[0]);

		// #feedback: bad indentations
	    while (selectYear > year) {
		    advance();
	    }

	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
	 	while (selectYear == year)
	 	{
	 		if ((dayOfWeek == 1) && (dayOfMonth == 1))
			{
				debugDaysCounter++;
	 			System.out.println (dayOfMonth+ "/"+ month + "/" + year + " Sunday");
			}
	 		else {
	 			if ((dayOfWeek == 1) && (dayOfMonth != 1)) {
	 	 			System.out.println (dayOfMonth+ "/"+ month + "/" + year + " Sunday");
				}
	 			else {
	 				System.out.println (dayOfMonth+ "/"+ month + "/" + year );
				}
	 		}
	 		advance();
	 	}
	 
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		
	 	//// Write the necessary ending code here
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		// Replace this comment with your code

	 		if(dayOfMonth == nDaysInMonth)
	 			{dayOfMonth = 1;}

	 		else
	 		{	dayOfMonth++;}

	 		if (dayOfMonth == 1)
	 			if (month == 12)
	 					{month = 1;}
	 			else 
	 					{month++;}

	    	 
	    	if (month == 1 && dayOfMonth == 1)
	    		{year++;}

	    	if (dayOfWeek==7)
	    		{dayOfWeek=1;}
	    	else 
	    		{dayOfWeek++;}	
	 					 
	 		if (nDaysInMonth!= nDaysInMonth (month,year))
	 			{nDaysInMonth= nDaysInMonth(month, year);}
	 	}
	  
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    // Replace the following statement with your code
	    	boolean isLeap = false;
	   		isLeap= ((year%400)==0) ;
	   		isLeap= isLeap || (year % 4 ==0 && year % 100 != 0);

		return isLeap;
	}

	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		// Replace the following statement with your code
		// #feedback: give meaningful name
		int days = 0;

		if (month==4 || month==6 || month== 11 || month == 9) {
			days = 30;
		}
		// #feedback: make your condition orders more clear
		else if (month == 2)
		{
			// #feedback: that way you avoid computing isLeapYear twice
			if (isLeapYear(year))
			{
				days = 29;
			}
			else {
				days = 28;
			}
		}				
		else {
			days = 31;
		}
		return days;	
	}
}


