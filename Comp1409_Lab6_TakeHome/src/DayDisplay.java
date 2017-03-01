/**
 * This is a DayDisplay class.
 * 
 * @author Ronnie Manimtim
 * @version 27 October 2015
 */
public class DayDisplay {

	public static final int NUMBER_OF_DAYS_IN_WEEK = 7;
	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;

	public static final String SUNDAY_STRING = "Sunday";
	public static final String MONDAY_STRING = "Monday";
	public static final String TUESDAY_STRING = "Tuesday";
	public static final String WEDNESDAY_STRING = "Wednesday";
	public static final String THURSDAY_STRING = "Thursday";
	public static final String FRIDAY_STRING = "Friday";
	public static final String SATURDAY_STRING = "Saturday";

	private NumberDisplay dayNumber;

	/**
	 * Constructor for DayDisplay by dayNumber
	 * 
	 * @param the
	 *            dayNumber the day number must only equal the integers between
	 *            SUNDAY(0) to SATURDAY(6)
	 */
	public DayDisplay(int theDayNumber) {
		
		dayNumber = new NumberDisplay(NUMBER_OF_DAYS_IN_WEEK);
		if (theDayNumber > SUNDAY && theDayNumber < SATURDAY) {
			dayNumber.setValue(theDayNumber);
		}
		
	}

	/**
	 * Constructor for Day
	 */
	public DayDisplay(String nameOfTheDay) {
		if (nameOfTheDay != null) {
			if (nameOfTheDay.equalsIgnoreCase(SUNDAY_STRING)) {
				dayNumber = new NumberDisplay(NUMBER_OF_DAYS_IN_WEEK);
				dayNumber.setValue(SUNDAY);
			} else if (nameOfTheDay.equalsIgnoreCase(MONDAY_STRING)) {
				dayNumber = new NumberDisplay(NUMBER_OF_DAYS_IN_WEEK);
				dayNumber.setValue(MONDAY);
			} else if (nameOfTheDay.equalsIgnoreCase(TUESDAY_STRING)) {
				dayNumber = new NumberDisplay(NUMBER_OF_DAYS_IN_WEEK);
				dayNumber.setValue(TUESDAY);
			} else if (nameOfTheDay.equalsIgnoreCase(WEDNESDAY_STRING)) {
				dayNumber = new NumberDisplay(NUMBER_OF_DAYS_IN_WEEK);
				dayNumber.setValue(WEDNESDAY);
			} else if (nameOfTheDay.equalsIgnoreCase(THURSDAY_STRING)) {
				dayNumber = new NumberDisplay(NUMBER_OF_DAYS_IN_WEEK);
				dayNumber.setValue(THURSDAY);
			} else if (nameOfTheDay.equalsIgnoreCase(FRIDAY_STRING)) {
				dayNumber = new NumberDisplay(NUMBER_OF_DAYS_IN_WEEK);
				dayNumber.setValue(FRIDAY);
			} else if (nameOfTheDay.equalsIgnoreCase(SATURDAY_STRING)) {
				dayNumber = new NumberDisplay(NUMBER_OF_DAYS_IN_WEEK);
				dayNumber.setValue(SATURDAY);
			}
		} else {
			nameOfTheDay = SUNDAY_STRING;
		}
	}

	/**
	 * @param day
	 *            the dayNumber will display
	 */
	public DayDisplay(NumberDisplay day) {
		dayNumber = day;
	}

	/**
	 * @return the day of the week
	 */
	public String getDayOfTheWeek() {
		if (dayNumber.getValue() == SUNDAY) {
			return SUNDAY_STRING;
		} else if (dayNumber.getValue() == MONDAY) {
			return MONDAY_STRING;
		} else if (dayNumber.getValue() == TUESDAY) {
			return TUESDAY_STRING;
		} else if (dayNumber.getValue() == WEDNESDAY) {
			return WEDNESDAY_STRING;
		} else if (dayNumber.getValue() == THURSDAY) {
			return THURSDAY_STRING;
		} else if (dayNumber.getValue() == FRIDAY) {
			return FRIDAY_STRING;
		} else if (dayNumber.getValue() == SATURDAY) {
			return SATURDAY_STRING;
		} else if (dayNumber.getValue() == SUNDAY) {
			return SUNDAY_STRING;
		} else {
			return SUNDAY_STRING;
		}
	}

	/**
	 * @return the dayNumber incremented
	 */
	public void incrementDay() {
		dayNumber.increment();
	}

	/**
	 * @return the dayNumber of what the day is tomorrow
	 */
	public String getWhatDayIsTomorrow() {
		if (dayNumber.getValue() == SUNDAY) {
			return MONDAY_STRING;
		} else if (dayNumber.getValue() == MONDAY) {
			return TUESDAY_STRING;
		} else if (dayNumber.getValue() == TUESDAY) {
			return WEDNESDAY_STRING;
		} else if (dayNumber.getValue() == WEDNESDAY) {
			return THURSDAY_STRING;
		} else if (dayNumber.getValue() == THURSDAY) {
			return FRIDAY_STRING;
		} else if (dayNumber.getValue() == FRIDAY) {
			return SATURDAY_STRING;
		} else if (dayNumber.getValue() == SATURDAY) {
			return SUNDAY_STRING;
		} else {
			return SUNDAY_STRING;
		}
	}

	/**
	 * @param the
	 *            printDetails the print details
	 */
	public void printDetail() {
		System.out.println("Today is day " + dayNumber.getValue() + " which is " + getDayOfTheWeek() + "!");
	}
}
