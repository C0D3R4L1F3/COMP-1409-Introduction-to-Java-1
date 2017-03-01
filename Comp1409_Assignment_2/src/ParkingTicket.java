/**
 * This is a ParkingTicket class for Impark.
 * 
 * @author Ronnie Manimtim
 * @version 1.0 10 November 2015
 */
public class ParkingTicket {
	private final String referenceNumber;
	private final String carLicensePlate;

	private int carMinutesParked;
	private int meterMinutesPaid;

	private static int count = 1000;
	private static String PREFIX = "V";

	private static final long TWENTY = 20;
	private static final long TEN = 10;
	private static final double FIVE_PERCENT = 0.05;
	private static final long SIXTY = 60;
	private static final int ZERO = 0;

	/**
	 * Constructor for ParkingTicket object. This constructor records the
	 * license plate, the Car class minutesParked, and the Meter clas
	 * paidMinutes
	 */
	private ParkingTicket(String recordedLicense, int newCarMinutesParked, int newMeterPaidMinutes) {
		referenceNumber = PREFIX + count++;
		carMinutesParked = newCarMinutesParked;
		meterMinutesPaid = newMeterPaidMinutes;
		carLicensePlate = recordedLicense;
	}

	/**
	 * Constructor for ParkingTicket object. This constructor is an overloaded
	 * version of the previous constructor.
	 */
	private ParkingTicket(Car parker, ParkingMeter parkee) {
		this(parker.getLicensePlate(), parker.getMinutesParked(), parkee.getMinutesPaid());
	}

	/**
	 * @param parker
	 *            the minutes parked
	 * @param parkee
	 *            the minutes paid
	 * @return the parking ticket for overparked; otherwise null if not
	 *         overparked
	 */
	public static ParkingTicket checkParking(Car parker, ParkingMeter parkee) {
		int carMinutesParked = parker.getMinutesParked();
		int meterMinutesPaid = parkee.getMinutesPaid();

		if ((parker == null) || (parkee == null))/* BONUS sanity check */ {
			return null;
		}

		if (carMinutesParked > meterMinutesPaid) {
			return new ParkingTicket(parker, parkee);
		} else {
			return null;
		}
	}

	/**
	 * @return the calculated fine
	 */
	public double calculateFine() {
		int minutesParked = carMinutesParked;
		int minutesPaid = meterMinutesPaid;
		long flatRateFine = TWENTY;
		long penalties = TEN;
		double surcharge = FIVE_PERCENT;
		long minOver = minutesParked - minutesPaid;
		long extraFine = penalties * (minOver / SIXTY);
		double fine;

		fine = (flatRateFine * surcharge) + flatRateFine;
		fine = (flatRateFine + penalties) * surcharge + flatRateFine + penalties;
		fine = ((flatRateFine + (extraFine)) * surcharge) + (flatRateFine + (extraFine));

		return fine;
	}

	/**
	 * Prints the details of the fine.
	 */
	public void printDetails() {
		System.out.println("Ticket Number: " + referenceNumber);
		System.out.println("Vehicle ID " + "\"" + carLicensePlate + "\"");
		System.out.println("parked " + carMinutesParked + " minutes, paid for " + meterMinutesPaid);
		System.out.println("Fine due: " + "$" + calculateFine() + ZERO);
	}
}