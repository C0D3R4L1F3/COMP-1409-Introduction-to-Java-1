
/**
 * This is a description HistoricalMoment class.
 * 
 * @author Ronnie Manimtim
 * @version 27 October 2015
 */

public class HistoricalMoment {

	private String eventName;
	private ClockDisplay timeOfEvent;

	public static final String EQUINOX = "March 2013 Equinox!";
	public static final String TITANIC = "Titanic hit an iceberg!";
	public static final String HALIFAX = "Halifax Explosion";

	public static final int MIDNIGHT_HOUR = 00;
	public static final int MINUTE_ZERO = 00;

	public static final int ELVENTH_HOUR = 11;
	public static final int TWO_MINUTES = 02;
	public static final int FORTY_MINUTES = 40;
	public static final int NINTH_HOUR = 9;
	public static final int FOUR_MINUTES = 04;

	/**
	 * Default Constructor
	 */
	public HistoricalMoment() {
		eventName = "untitled event";
		timeOfEvent = new ClockDisplay(MIDNIGHT_HOUR, MINUTE_ZERO);

	}

	/**
	 * @param nameOfTheEvent
	 *            the name of the event; "untitled event" if the name of the
	 *            event is null or ""
	 */
	public HistoricalMoment(String nameOfTheEvent) {
		if ((nameOfTheEvent == null) || (nameOfTheEvent.equals(""))) {
			eventName = "untitled event";
			timeOfEvent = new ClockDisplay(MIDNIGHT_HOUR, MINUTE_ZERO);
		} else {
			eventName = nameOfTheEvent;
			timeOfEvent = new ClockDisplay(MIDNIGHT_HOUR, MINUTE_ZERO);
		}

	}

	/**
	 * @param the
	 *            name and time of the event
	 */
	public HistoricalMoment(String nameOfTheEvent, ClockDisplay theTime) {
		if ((nameOfTheEvent == null) || (nameOfTheEvent.equals(""))) {
			eventName = "untitled event";
			timeOfEvent = new ClockDisplay(MIDNIGHT_HOUR, MINUTE_ZERO);
		} else {
			eventName = nameOfTheEvent;
			timeOfEvent = theTime;
		}
	}

	/**
	 * @return the time of the event incremented
	 */
	public void addMinuteToTimeOfEvent() {
		timeOfEvent.timeTick();
	}

	/**
	 * the print details of time and event
	 */
	public void printDetails() {
		System.out.println("At " + timeOfEvent.getTime() + ", " + eventName);
	}

}
