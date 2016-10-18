//this is a simple Java application

import java.text.DateFormat;
import java.util.Date;
import java.time.*;
import java.util.Locale;

public class AddingDates {
	
	public static void main(String args[]) {
		// Declare some dates
		Date today;
		long now;
		String dateOut;
		String timeOut;
		DateFormat dateFormatter;
		DateFormat timeFormatter;
		
		dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
		timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
		today = new Date();
		now = System.currentTimeMillis();
		
		dateOut = dateFormatter.format(today);
		timeOut = Long.toString(now);
		
		System.out.println(dateOut + " " + timeOut);
	}
}