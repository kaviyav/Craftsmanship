package main;

public class DateUtils {
	private final static int JANUARY = 31;
	private final static int FEBRUARY = 28;
	private final static int MARCH = 31;
	private final static int APRIL = 30;
	private final static int MAY = 31;
	private final static int JUNE= 30;
	private final static int JULY= 31;
	private final static int AUGUST = 31;
	private final static int SEPTEMBER = 30;
	private final static int OCTOBER = 31;
	private final static int NOVEMBER = 30;
	private final static int DECEMBER = 31;
	public static int getDuration(Date startDate, Date EndDate){
		int NoOfDays;
		if(sameYearAndSameMonth(startDate, EndDate)){
			NoOfDays = EndDate.date - startDate.date;
			System.out.println(NoOfDays);
			return NoOfDays;
		}
		if(sameYearDifferentMonth(startDate, EndDate)){
			NoOfDays = remainingDaysInMonth(startDate)
			+ getTotalDaysInInterveningMonth(startDate, EndDate)
			+ leadingDaysInMonth(EndDate);
			System.out.println(NoOfDays);
			return NoOfDays;
		}
		return 0;
	}

	private static boolean sameYearDifferentMonth(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		if(startDate.year == endDate.year && startDate.month != endDate.month){
			return true;
		}
		return false;
	}

	private static boolean sameYearAndSameMonth(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		if(startDate.year == endDate.year && startDate.month == endDate.month){
			return true;
		}
		return false;
	}
	
	
	private static int remainingDaysInMonth(Date Startdate){
		int totalDaysInMonth = getTotalDaysInMonth(
				Startdate.month, Startdate.year);
		return totalDaysInMonth - Startdate.date;
	}
	
	
	private static int getTotalDaysInMonth(int month, int year) {
		// TODO Auto-generated method stub
		int monthDays[] = new int[]{
				31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
		};
		int totalDaysInMonth = monthDays[month-1];
		if(isLeapYear(year) && month == 2){
			totalDaysInMonth+=1;
		}
		return totalDaysInMonth;
	}
	
	private static int leadingDaysInMonth(Date Enddate){
		return Enddate.date;
	}
	private static int getTotalDaysInInterveningMonth(Date Startdate,Date Enddate){
		int totalDaysInMonth = 0;
		for ( int i = Startdate.month + 1; i < Enddate.month; i++){
			totalDaysInMonth += getTotalDaysInMonth(
					i, Enddate.year);
		}
		return totalDaysInMonth;
	}
	

	private static boolean isLeapYear(int year) {
		// TODO Auto-generated method stub
		if(year%400 == 0)
			return true;
		if(year%100 == 0)
			return false;
		if(year%4 == 0)
			return true;
		return false;
	}

	public static int getDuration1(Date startDate, Date EndDate){
		int duration;
		int monthDays[] = new int[]{
				31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
		};
		if(EndDate.year >= startDate.year){
			// initialize count using years and day
			int daysCount1 = startDate.year*365 + startDate.date;


			// Add days for months in given date
			for (int i=0; i<startDate.month - 1; i++)
				daysCount1 += monthDays[i];

			// Since every leap year is of 366 days,
			// Add a day for every leap year
			daysCount1 += countLeapYears(startDate);

			// SIMILARLY, COUNT TOTAL NUMBER OF DAYS BEFORE 'EndDate'

			int daysCount2 = EndDate.year*365 + EndDate.date;
			for (int i=0; i<EndDate.month - 1; i++)
				daysCount2 += monthDays[i];
			daysCount2 += countLeapYears(EndDate);
			int numberOfDays = daysCount2 - daysCount1;
			System.out.println(numberOfDays);
			// return difference between two counts
			return (numberOfDays);

		}
		return 0;
	}

	// given date
	public static int countLeapYears(Date d)
	{
		int years = d.year;

		// Check if the current year needs to be considered
		// for the count of leap years or not
		if (d.month <= 2)
			years--;

		// An year is a leap year if it is a multiple of 4,
		// multiple of 400 and not a multiple of 100.
		return years / 4 - years / 100 + years / 400;
	}

public static void main(String args[]){
	Date startDate = new Date(19,03,2018);
	getDuration(startDate,new Date(28,5,2018));
	getDuration(startDate,new Date(28,6,2018));
	getDuration(startDate,new Date(28,7,2018));
}
}
