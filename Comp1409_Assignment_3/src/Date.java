
/**
 * Represents a year, month, day triplet.
 * 
 * @author James Pede
 * @version Jun20'14,1344h
 */
public class Date {
	// indices and literals visible from outside the class
	public static final int JANUARY = 1;
	public static final int FEBRUARY = 2;
	public static final int MARCH = 3;
	public static final int APRIL = 4;
	public static final int MAY = 5;
	public static final int JUNE = 6;
	public static final int JULY = 7;
	public static final int AUGUST = 8;
	public static final int SEPTEMBER = 9;
	public static final int OCTOBER = 10;
	public static final int NOVEMBER = 11;
	public static final int DECEMBER = 12;

	public static final String JANUARY_STRING = "January";
	public static final String FEBRUARY_STRING = "February";
	public static final String MARCH_STRING = "March";
	public static final String APRIL_STRING = "April";
	public static final String MAY_STRING = "May";
	public static final String JUNE_STRING = "June";
	public static final String JULY_STRING = "July";
	public static final String AUGUST_STRING = "August";
	public static final String SEPTEMBER_STRING = "September";
	public static final String OCTOBER_STRING = "October";
	public static final String NOVEMBER_STRING = "November";
	public static final String DECEMBER_STRING = "December";
	protected static final String[] MONTH_OF_INDEX = { JANUARY_STRING, FEBRUARY_STRING, MARCH_STRING, APRIL_STRING,
			MAY_STRING, JUNE_STRING, JULY_STRING, AUGUST_STRING, SEPTEMBER_STRING, OCTOBER_STRING, NOVEMBER_STRING,
			DECEMBER_STRING, };

	public static final int SATURDAY = 0;
	public static final int SUNDAY = 1;
	public static final int MONDAY = 2;
	public static final int TUESDAY = 3;
	public static final int WEDNESDAY = 4;
	public static final int THURSDAY = 5;
	public static final int FRIDAY = 6;

	public static final String SATURDAY_STRING = "Saturday";
	public static final String SUNDAY_STRING = "Sunday";
	public static final String MONDAY_STRING = "Monday";
	public static final String TUESDAY_STRING = "Tuesday";
	public static final String WEDNESDAY_STRING = "Wednesday";
	public static final String THURSDAY_STRING = "Thursday";
	public static final String FRIDAY_STRING = "Friday";
	protected static final String DAY_FOR_INDEX[] = { SATURDAY_STRING, SUNDAY_STRING, MONDAY_STRING, TUESDAY_STRING,
			WEDNESDAY_STRING, THURSDAY_STRING, FRIDAY_STRING, };

	// constants used for attribute validation
	public static final int CURRENT_YEAR = 2013;
	protected static final int DEFAULT_YEAR = CURRENT_YEAR;
	protected static final int DEFAULT_DAY = 1;
	protected static final int MIN_DAY = 1;
	protected static final int MIN_YEAR = 0;
	protected static final int MAX_YEAR = CURRENT_YEAR;

	// constants used in getDayOfTheWeek()
	protected static final int YEAR_SUFFIX_DIVISOR = 100;
	protected static final int NUMBER_OF_YEARS_IN_A_LEAP = 4;
	protected static final int MONTH_CODE[] = { 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6 };
	protected static final int MONTH_COUNT = MONTH_CODE.length;
	protected static final int WEEKDAY_COUNT = DAY_FOR_INDEX.length;
	protected static final int STEP5_LEAP_MONTH_OFFSET = -1;
	protected static final int ERA1 = 1600;
	protected static final int ERA2 = 1700;
	protected static final int ERA3 = 1800;
	protected static final int ERA5 = 2000;
	protected static final int ERA6 = 2100;
	protected static final int ERA1_OFFSET = 6;
	protected static final int ERA2_OFFSET = 4;
	protected static final int ERA3_OFFSET = 2;
	protected static final int ERA5_OFFSET = 6;
	protected static final int ERA6_OFFSET = 4;

	// constants used in getFormattedDate() and its helpers
	protected static final short PADDED_DIGIT_COUNT = 2;
	protected static final String FORMAT_DELIMITER = "-";

	// constants used in getMonthNumber()
	protected static final int UNKNOWN_MONTH = 0;

	// constants used in getNumberOfDaysInThisMonth()
	protected static final short LEAPING_DAY_COUNT = 29;
	protected static final short[] MONTHLY_DAY_COUNT = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// constants used in isLeapYear()
	protected static final int LEAP_CRITERION1 = 400;
	protected static final int LEAP_CRITERION2 = 100;
	protected static final int LEAP_CRITERION3 = 4;
	protected static final int DIVIDES_EVENLY = 0;

	// Years measured in the Common Era (Gregorian Calendar).
	private int year;
	// Month number, in the range 1=JANUARY to 12=DECEMBER.
	private int month;
	// Day number, in the range 1 to 31.
	// Validation prevents this number from exceeding
	// getNumberOfDaysInThisMonth().
	private int day;

	/**
	 * Constructor for objects of class Date
	 */
	public Date() {
		setDefaults();
	} // end constructor

	/**
	 * Non-default constructor. Institutes a starting Y-M-D combination.
	 * 
	 * @param year
	 *            measured in the Gregorian Calendar, or Common Era, and
	 *            validated to a min and max
	 * @param month
	 *            a whole number ranging between (the constants) JANUARY and
	 *            DECEMBER
	 * @param day
	 *            ranges between 1 and a varying monthly max; validated by
	 *            getNumberOfDaysInThisMonth()
	 */
	public Date(int year, int month, int day) {
		set(year, month, day);
	} // end constructor

	/**
	 * Due to the fact that a day's validity hinges on both the month and year,
	 * this common mutator was developed for all three attributes. You will find
	 * that each of the individual mutators just defer to this one, often by
	 * treating old, unchanged data as new data.
	 * 
	 * @param year
	 *            measured in the Gregorian Calendar, or Common Era, and
	 *            validated to a min and max
	 * @param month
	 *            a whole number ranging between (the constants) JANUARY and
	 *            DECEMBER
	 * @param day
	 *            ranges between 1 and a varying monthly max; validated by
	 *            getNumberOfDaysInThisMonth()
	 */
	public void set(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;

		if (MIN_YEAR > year || MAX_YEAR < year || JANUARY > month || DECEMBER < month || MIN_DAY > day
				|| getNumberOfDaysInThisMonth() < day)
			setDefaults();
	} // end mutator

	/**
	 * This is a common consequence of the default constructor OR a set()
	 * operation that was given an invalid combination of year, month, day.
	 */
	private void setDefaults() {
		year = DEFAULT_YEAR;
		month = JANUARY;
		day = DEFAULT_DAY;
	} // end initializer

	/**
	 * Accessor.
	 * 
	 * @return year attribute
	 */
	public int getYear() {
		return year;
	} // end accessor

	/**
	 * Accessor.
	 * 
	 * @return month attribute
	 */
	public int getMonth() {
		return month;
	} // end accessor

	/**
	 * Accessor.
	 * 
	 * @return day attribute
	 */
	public int getDay() {
		return day;
	} // end accessor

	/**
	 * Mutator.
	 * 
	 * @param year
	 *            a whole number representing a span of ~365 days in the
	 *            Gregorian Calendar
	 */
	public void setYear(int year) {
		set(year, this.month, this.day);
	} // end mutator

	/**
	 * Mutator.
	 * 
	 * @param month
	 *            a whole number ranging between JANUARY and DECEMBER, inclusive
	 */
	public void setMonth(int month) {
		set(this.year, month, this.day);
	} // end mutator

	/**
	 * Mutator.
	 * 
	 * @param day
	 *            a whole number ranging between 1 and
	 *            getNumberOfDaysInThisMonth()
	 */
	public void setDay(int day) {
		set(this.year, this.month, day);
	} // end mutator

	/**
	 * Judging solely from the year attribute, leaps (29 days in February, as
	 * opposed to the usual 28) occur on year numbers evenly divisible by 4,
	 * with some exceptions.
	 * 
	 * @return true, only if the year number meets the criteria
	 */
	private boolean isLeapYear() {
		if (DIVIDES_EVENLY == this.year % LEAP_CRITERION1)
			return true;

		if (DIVIDES_EVENLY == this.year % LEAP_CRITERION2)
			return false;

		return (DIVIDES_EVENLY == this.year % LEAP_CRITERION3);
	} // end method

	/**
	 * Working only from the data in the attributes, a day, month, and year is
	 * interpreted into one of the seven days of the week. Assumption: this.year
	 * shouldn't be lower than ERA1 or higher than ERA6's top end. The
	 * assumption isn't actually valid, when MIN_YEAR = 0, but hey, we'll roll
	 * with it.
	 * 
	 * @return a weekday literal, e.g. "Saturday"
	 */
	public String getDayOfTheWeek() {
		int theMonth = this.getMonth();

		final int step0Result = this.year % YEAR_SUFFIX_DIVISOR;
		final int step1Result = step0Result / MONTH_COUNT;
		final int step2Result = step0Result % MONTH_COUNT;
		final int step3Result = step2Result / NUMBER_OF_YEARS_IN_A_LEAP;
		final int step4Result = this.getDay();
		int step5Result = MONTH_CODE[theMonth - JANUARY];

		if (this.isLeapYear() && (JANUARY == theMonth || FEBRUARY == theMonth))
			step5Result += STEP5_LEAP_MONTH_OFFSET;

		switch (this.year - step0Result) {
		case ERA1:
			step5Result += ERA1_OFFSET;
			break;

		case ERA2:
			step5Result += ERA2_OFFSET;
			break;

		case ERA3:
			step5Result += ERA3_OFFSET;
			break;

		case ERA5:
			step5Result += ERA5_OFFSET;
			break;

		case ERA6:
			step5Result += ERA6_OFFSET;
			break;

		default:
			// do nothing - Other eras are too early or late for us to consider,
			// or in the case of the 1900s, they're not modified.
		} // end switch: era offsets

		return DAY_FOR_INDEX[(step1Result + step2Result + step3Result + step4Result + step5Result) % WEEKDAY_COUNT];
	} // end method

	/**
	 * The number of days in a month is dependent entirely on what the month is.
	 * The sole exception to this rule is FEBRUARY, whose count goes +1 on leap
	 * years.
	 * 
	 * @return some number between 28 and 31; used as an upper bound on this.day
	 */
	public int getNumberOfDaysInThisMonth() {
		if (FEBRUARY == this.month && isLeapYear())
			return LEAPING_DAY_COUNT;

		return MONTHLY_DAY_COUNT[this.month - JANUARY];
	} // end method

	/**
	 * This helper function provides code that is common to getPaddedMonth() and
	 * getPaddedDay(). A padded number is the String expression of that number.
	 * The length of the String is forced to a specified number of digits, by
	 * prepending zeroes.
	 * 
	 * @param numeral
	 *            the number that is being padded and converted into a String
	 * @param digitCount
	 *            the intended length of the returned String; Note that
	 *            digitCount is not validated. It is possible to specify
	 *            numeral=10 and digitCount=1, for example.
	 * @return a literal expression of a number, padded to digitCount digits
	 */
	private String getPaddedNumeral(int numeral, short digitCount) {
		String result = String.valueOf(numeral);

		for (digitCount -= result.length(); 0 != digitCount--;)
			result = "0" + result;

		return result;
	} // end method

	/**
	 * Prepend as many zeroes as are necessary to produce a MM String.
	 * 
	 * @return said MM String
	 */
	private String getPaddedMonth() {
		return getPaddedNumeral(this.month, PADDED_DIGIT_COUNT);
	} // end method

	/**
	 * Prepend as many zeroes as are necessary to produce a DD String.
	 * 
	 * @return said DD String
	 */
	private String getPaddedDay() {
		return getPaddedNumeral(this.day, PADDED_DIGIT_COUNT);
	} // end method

	/**
	 * Translate attribute information into a YYYY-MM-DD date-String.
	 * 
	 * @return year-padded(month)-padded(day)
	 */
	public String getFormattedDate() {
		return this.year + FORMAT_DELIMITER + getPaddedMonth() + FORMAT_DELIMITER + getPaddedDay();
	} // end method

	/**
	 * Convert a month index, such as 7, into the corresponding month word, such
	 * as "August".
	 * 
	 * @param monthNumber
	 *            a month index; validated to the range JANUARY to DECEMBER
	 * @return a literal containing the name of a month OR null, when validation
	 *         fails
	 */
	public static String getMonthName(int monthNumber) {
		if (JANUARY > monthNumber || DECEMBER < monthNumber)
			return null;

		return MONTH_OF_INDEX[monthNumber - JANUARY];
	} // end method

	/**
	 * Convert a month word, such as "September", into the corresponding month
	 * index, such as 9.
	 * 
	 * @param monthName
	 *            a literal containing the name of a month; matched
	 *            case-insensitive
	 * @return a month index OR the 'error index' (UNKNOWN_MONTH), when no match
	 */
	public static int getMonthNumber(String monthName) {
		if (null == monthName)
			return UNKNOWN_MONTH;

		int index = JANUARY;

		for (String monthConstant : MONTH_OF_INDEX)
			if (monthConstant.equalsIgnoreCase(monthName))
				return index;
			else
				index++;

		return UNKNOWN_MONTH;
	}
} // end class
