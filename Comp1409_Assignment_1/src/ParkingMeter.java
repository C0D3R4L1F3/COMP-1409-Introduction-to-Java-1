/**
 * This is a ParkingMeter class for Impark.
 * 
 * @author Ronnie Manimtim
 * @version 1.0 15 October 2015
 */
public class ParkingMeter {
	private int minutesPaid;
	private String paymentMethod;

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
	 * @return the payment method
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param aMinutesPaid
	 *            recieve the minutes paid for parking meter
	 */
	public void setMinutesPaid(int aMinutesPaid) {
		minutesPaid = aMinutesPaid;
	}

	/**
	 * @param payingBy
	 *            the payment method customer will pay by
	 */
	public void setPaymentMethod(
			String payingBy) /* BONUS for creating payment method */
	{
		if (paymentMethod == "Visa") {
			paymentMethod = payingBy;
		} else if (paymentMethod == "Master Card") {
			paymentMethod = payingBy;
		} else if (paymentMethod == "American Express") {
			paymentMethod = payingBy;
		} else if (paymentMethod == "Cash") {
			paymentMethod = payingBy;
		} else if (paymentMethod == "Debit") {
			paymentMethod = payingBy;
		} else if ((payingBy != "Cash") && (payingBy != "Visa") && (payingBy != "Master Card")
				&& (payingBy != "American Express")
				&& (payingBy != "Debit"))/* BONUS for easy to read code */ {
			System.out.println("Payment Method:" + " " + "Invalid payment type");
		} else {
			paymentMethod = payingBy;
		}
	}
}
