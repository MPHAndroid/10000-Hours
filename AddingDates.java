//this is a simple Java application

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class AddingDates {
	
	public static void main(String args[]) throws ParseException {
		// Declare some dates
		Date today;
		Date first_time_date;
		Date second_time_date;
		String difference;
		long now;
		long milli_difference;
		String dateOut;
		String timeOut;
		DateFormat dateFormatter;
		DateFormat timeFormatter;
		DateFormat sdf;
		String first_time;
		String second_time;
		
		Scanner user_times = new Scanner(System.in);
		
		System.out.print("Enter the start time: ");
		first_time = user_times.next();
		
		System.out.print("Enter the second time: ");
		second_time = user_times.next();
		
		// convert these to date format
		sdf = new SimpleDateFormat("hh:mm");
		first_time_date = sdf.parse(first_time);
		second_time_date = sdf.parse(second_time);
		milli_difference = second_time_date.getTime() - first_time_date.getTime();
		difference = Long.toString(milli_difference/60000);
		// doesn't seem to work difference = second_time_date - first_time_date;
		
		System.out.println("You entered " + first_time + " and " + second_time + "as strings");
		System.out.println("These are " + first_time_date + " and " + second_time_date);
		System.out.println("The difference is " + difference + " minutes");
		
		dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
		timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
		today = new Date();
		now = System.currentTimeMillis();
		
		// try converting time in Millis to dateformat
		// difference = sdf.parse(now);
		
		dateOut = dateFormatter.format(today);
		timeOut = Long.toString(now);
		
		System.out.println(dateOut + " " + timeOut + " " + difference);
	}
}
