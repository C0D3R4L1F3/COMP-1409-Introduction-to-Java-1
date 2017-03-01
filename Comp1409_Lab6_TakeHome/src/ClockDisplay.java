/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The range of
 * the clock is 00:00 (midnight) to 23:59 (one minute before midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute and
 * reacts by incrementing the display. This is done in the usual clock fashion:
 * the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class ClockDisplay {
	private NumberDisplay hours;
	private NumberDisplay minutes;
	private String displayString; // simulates the actual display

	public static final int FIRST_MORNING_HOUR = 0;
	public static final int LAST_MORNING_HOUR = 11;
	public static final int FIRST_EVENING_HOUR = 12;
	public static final int LAST_EVENING_HOUR = 23;
	public static final int MINUTES_PER_HOUR = 60;
	public static final int MINUTES_ZERO = 0;
	public static final String MORNING_SUFFIX = "a.m.";
	public static final String EVENING_SUFFIX = "p.m.";
	public static final int MIDNIGHT_HOUR = 0;
	public static final int HOURS_PER_DAY = 0;
	public static final int TWENTY_FOUR_HOURS = 24;

	/**
	 * Constructor for ClockDisplay objects. This constructor creates a new
	 * clock set at 00:00.
	 */
	public ClockDisplay() {
		hours = new NumberDisplay(TWENTY_FOUR_HOURS);
		minutes = new NumberDisplay(MINUTES_PER_HOUR);
		updateDisplay();
	}

	/**
	 * Constructor for ClockDisplay objects. This constructor creates a new
	 * clock set at the time specified by the parameters.
	 */
	public ClockDisplay(int hour, int minute) {
		hours = new NumberDisplay(TWENTY_FOUR_HOURS);
		minutes = new NumberDisplay(MINUTES_PER_HOUR);
		setTime(hour, minute);
	}

	/**
	 * This method should get called once every minute - it makes the clock
	 * display go one minute forward.
	 */
	public void timeTick() {
		minutes.increment();
		if (minutes.getValue() == MINUTES_ZERO) { // it just rolled over!
			hours.increment();
		}
		updateDisplay();
	}

	/**
	 * Set the time of the display to the specified hour and minute.
	 */
	public void setTime(int hour, int minute) {
		hours.setValue(hour);
		minutes.setValue(minute);
		updateDisplay();
	}

	/**
	 * @retun the time from displayString
	 */
	public String getTime() {
		return displayString;
	}

	/**
	 * the updated display
	 */
	private void updateDisplay() {
		if (hours.getValue() < FIRST_EVENING_HOUR && hours.getValue() > LAST_MORNING_HOUR) {
			displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " am";
		}

		else if (hours.getValue() > FIRST_EVENING_HOUR && hours.getValue() < LAST_EVENING_HOUR) {
			displayString = Integer.toString(hours.getValue() - FIRST_EVENING_HOUR) + ":" + minutes.getDisplayValue()
					+ " pm";
		} else if (hours.getValue() == MIDNIGHT_HOUR) {
			hours.setValue(FIRST_EVENING_HOUR);
			displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " am (midnight)";
		} else {
			hours.setValue(FIRST_EVENING_HOUR);
			displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " pm (noon)";
		}
	}
}