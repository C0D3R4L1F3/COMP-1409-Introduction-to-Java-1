/**
 * This is a Car class for Impark.
 * 
 * @author Ronnie Manimtim
 * @version 2.0 15 October 2015
 */
public class Car {
	private static final int MINIMUM_PLATE_LENGTH = 2;
	private static final int MAXIMUM_PLATE_LENGTH = 7;
	public static final char MANUAL_TRANSMISSION = 'm';
	public static final char AUTOMATIC_TRANSMISSION = 'a';

	private static int defaultMinutesParked = 0;
	private static double defaultOdometerInKm = 50000.5;

	private String licensePlate;
	private char transmissionType;
	private double odometerInKm;
	private int minutesParked;

	/**
	 * @param newProposedLicensePlate
	 *            the license plate of the car can equal null but must be
	 *            between MINIMUM_PLATE_LENGTH and MAXIMUM_PLATE_LENGTH
	 */
	public Car(String newProposedLicensePlate) {
		setLicensePlate(newProposedLicensePlate);
		transmissionType = AUTOMATIC_TRANSMISSION;
		odometerInKm = defaultOdometerInKm;
		minutesParked = defaultMinutesParked;
	}

	/**
	 * @return the license plate of the car can equal null but must be between
	 *         MINIMUM_PLATE_LENGTH and MAXIMUM_PLATE_LENGTH
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * @return the transmission type MANUAL_TRANSMISSION or
	 *         AUTOMATIC_TRANSMISSION
	 */
	public char getTransmissionType() {
		return transmissionType;
	}

	/**
	 * @return the odometer in kilometers
	 */
	public double getOdometerInKm() {
		return odometerInKm;
	}

	/**
	 * Recieve the license plate Mutator.licensePlate.
	 * 
	 * @param proposedLicense
	 *            String Conforming to ICBC *length* guidlines:
	 *            http://www.icbc.com/vehicle-registration/license-plates/Pages/
	 *            Personalized-licence-plates.aspx May also be null. The null
	 *            represents a car without a plate If validation fails, null
	 *            will be set.
	 */
	public void setLicensePlate(String proposedLicense) {
		if (proposedLicense == null) {
			licensePlate = proposedLicense;
		} else if (proposedLicense.length() >= MINIMUM_PLATE_LENGTH
				&& proposedLicense.length() <= MAXIMUM_PLATE_LENGTH) {
			licensePlate = proposedLicense;
		} else {
			licensePlate = null;
		}
	}

	/**
	 * @param mOrA
	 *            recieve the transmission type MANUAL_TRANSMISSION or
	 *            AUTOMATIC_TRANSMISSION if invalid type of transmission is
	 *            entered then will return
	 *            "Installation failure: 'mOrA' is not a vaild transmission type"
	 */
	public void setTransmissionType(char mOrA) {
		if (mOrA == MANUAL_TRANSMISSION) {
			transmissionType = mOrA;
		} else if (mOrA == AUTOMATIC_TRANSMISSION) {
			transmissionType = mOrA;
		} else if (mOrA == mOrA) {
			System.out
					.println("Installation failure: " + ("'") + (mOrA) + ("'") + " is not a valid transmission type.");
		} else {
			transmissionType = mOrA;
		}
	}

	/**
	 * @return the value of the odometer in with the String kilometers
	 */
	public String readOdometer() {
		return odometerInKm + " kilometers";
	}

	/**
	 * @return the false if the minutesParked equals zero; otherwise true
	 */
	public boolean isParked() {
		if (minutesParked == defaultMinutesParked) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param duration
	 *            replaces any existing value in minutesParked with the value
	 *            from duration
	 */
	public void park(int duration) {
		if (duration >= defaultMinutesParked) {
			minutesParked = duration;
		}
	}

	/**
	 * @param aOdometerInKm
	 *            recieve the odometer in kilometers
	 */
	public void setOdometerInKm(double aOdometerInKm) {
		odometerInKm = aOdometerInKm;
	}

	/**
	 * @param aMinutesParked
	 *            recieve the minutes parked in the stall but can not be a
	 *            negative number if invalid number of minutes is entered then
	 *            the number of minutes will not change.
	 */
	public void setMinutesParked(int aMinutesParked) {
		if (aMinutesParked >= defaultMinutesParked) {
			minutesParked = aMinutesParked;
		} else {
			return;
		}
	}

	/**
	 * @return the minutes parked
	 */
	public int getMinutesParked() {
		return minutesParked;
	}

}