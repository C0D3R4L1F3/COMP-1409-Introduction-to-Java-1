/**
 * This is a ParkingMeter class for Impark.
 * 
 * @author Ronnie Manimtim
 * @version 2.0 15 October 2015
 */
public class ParkingMeter {
	private int minutesPaid;

	/**
	 * @param newMinutesPaid
	 *            the minutes paid for parking meter
	 */
	public ParkingMeter() {
	}

	/**
	 * @return the minutes paid
	 */
	public int getMinutesPaid() {
		return minutesPaid;
	}

	/**
	 * @param quantity
	 *            the added minutes paid must not have a negative number
	 */
	public void addMinutesPaid(int quantity) {
		if (quantity >= 0) {
			minutesPaid += quantity;
		}
	}

}