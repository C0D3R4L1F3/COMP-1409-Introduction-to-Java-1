/**
 * This is a Model class.
 * 
 * @author Ronnie Manimtim
 * @version 17 October 2015
 */
public class Model {
	private static final int MINIMUM_NAME_LENGTH_LETTERS = 3;
	private static final int MAXIMUM_NAME_LENGTH_LETTERS = 20;
	private static final int MINIMUM_HEIGHT = 24;
	private static final int MAXIMUM_HEIGHT = 84;
	private static final int MINIMUM_WEIGHT = 80;
	private static final int MAXIMUM_WEIGHT = 280;

	private static String occupation = "modeling";
	private static final int DEFAULT_NUMBER_ONE = 12;
	private static final int DEFAULT_NUMBER_TWO = 0;
	private static final double DEFAULT_NUMBER_THREE = 2.2;
	private static final int DEFAULT_NUMBER_FOUR = 1;

	private String firstName;
	private String lastName;
	private int heightInInches;
	private double weightInPounds;
	private boolean canTravel;
	private boolean smoker;

	/**
	 * @param newFirstName
	 *            the first name must be between MINIMUM_NAME_LENGTH_LETTERS and
	 *            MAXIMUM_NAME_LENGTH_LETTERS
	 * @param newLastName
	 *            the last name
	 * @param newHeightInInches
	 *            the height in inches
	 * @param newWeightInPounds
	 *            the weight in pounds
	 * @param IsCanTravel
	 *            true if model can travel; otherwise false
	 * @param IsSmoker
	 *            true if the model smokes; otherwise fale
	 */
	public Model(String theFirstName, String theLastName, int theHeightInInches, double theWeightInPounds,
			boolean willTravel, boolean isSmoker) {
		setFirstName(theFirstName);
		setLastName(theLastName);
		setHeightInInches(theHeightInInches);
		setWeightInPounds(theWeightInPounds);
		setCanTravel(willTravel);
		setSmoker(isSmoker);
	}

	/**
	 * @param newFirstName
	 *            the first name must be between MINIMUM_NAME_LENGTH_LETTERS and
	 *            MAXIMUM_NAME_LENGTH_LETTERS
	 * @param newLastName
	 *            the last name
	 * @param newHeightInInches
	 *            the height in inches
	 * @param newWeightInPounds
	 *            the weight in pounds
	 * @param IsCanTravel
	 *            true if model can travel; otherwise false
	 * @param IsSmokes
	 *            false if the model smokes; otherwise true
	 */
	public Model(String theFirstName, String theLastName, int theHeightInInches, double theWeightInPounds) {
		setFirstName(theFirstName);
		setLastName(theLastName);
		setHeightInInches(theHeightInInches);
		setWeightInPounds(theWeightInPounds);
		setCanTravel(true);
		setSmoker(false);
	}

	/**
	 * @return the First Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the Last Name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the height in inches
	 */
	public int getHeightInInches() {
		return heightInInches;
	}

	/**
	 * @return the weight in pounds
	 */
	public double getWeightInPounds() {
		return weightInPounds;
	}

	/**
	 * @return the model is able to travel; otherwise false
	 */
	public boolean getCanTravel() {
		return canTravel;
	}

	/**
	 * @return the true if the model is a smoker; otherwise false
	 */
	public boolean getSmoker() {
		return smoker;
	}

	/**
	 * @param firstName
	 *            the first name of model
	 */
	public final void setFirstName(String aFirstName) {
		if ((aFirstName != null) && (aFirstName.length() >= MINIMUM_NAME_LENGTH_LETTERS)
				&& (aFirstName.length() <= MAXIMUM_NAME_LENGTH_LETTERS)) {
			firstName = aFirstName;
		}
	}

	/**
	 * @param lastName
	 *            the last name of the model
	 */
	public final void setLastName(String aLastName) {
		if ((aLastName != null) && (aLastName.length() >= MINIMUM_NAME_LENGTH_LETTERS)
				&& (aLastName.length() <= MAXIMUM_NAME_LENGTH_LETTERS)) {
			lastName = aLastName;
		}
	}

	/**
	 * @param heightInInches
	 *            the height in inches must be between MINIMUM_HEIGHT and
	 *            MAXIMUM_HEIGHT
	 */
	public void setHeightInInches(int aHeightInInches) {
		if ((aHeightInInches >= MINIMUM_HEIGHT) && (aHeightInInches <= MAXIMUM_HEIGHT)) {
			heightInInches = aHeightInInches;
		} else {
			return; // do not store
		}
	}

	/**
	 * @param weightInPounds
	 *            the weight in pounds must be between MINIMUM_WEIGHT and
	 *            MAXIMUM_WEIGHT
	 */
	public void setWeightInPounds(double aWeightInPounds) {
		if ((aWeightInPounds >= MINIMUM_WEIGHT) && (aWeightInPounds <= MAXIMUM_WEIGHT)) {
			weightInPounds = aWeightInPounds;
		} else {
			return; // do not store
		}
	}

	/**
	 * @param canTravel
	 *            true if model can travel; otherwise false
	 */
	public final void setCanTravel(boolean willTravel) {
		canTravel = willTravel;
	}

	/**
	 * @param smoker
	 *            false if model smokes; otherwise true
	 */
	public void setSmoker(boolean isSmoker) {
		smoker = isSmoker;
	}

	/**
	 * @return the height in feet and inches
	 */
	public String getHeightInFeetAndInches() {
		String includeInches = "";
		int remainder = (heightInInches %= DEFAULT_NUMBER_ONE);
		int newHeight = (heightInInches % DEFAULT_NUMBER_ONE);

		if (remainder < DEFAULT_NUMBER_TWO) {
			includeInches = "";
		} else if (remainder <= DEFAULT_NUMBER_FOUR) {
			includeInches = "Inch";
		} else if (remainder > DEFAULT_NUMBER_FOUR) {
			includeInches = "Inches";
		}
		return newHeight + " feet " + remainder + " " + includeInches;
	}

	/**
	 * @return the weight in kilograms
	 */
	public long getWeightKg() {
		double poundsToKg = (weightInPounds / DEFAULT_NUMBER_THREE);

		if (weightInPounds >= DEFAULT_NUMBER_TWO) {
			poundsToKg = Math.round(poundsToKg);
		}
		return (long) poundsToKg;
	}

	/**
	 * @return the occupation
	 */
	public static String getOccupation() {
		return occupation;
	}

	/**
	 * @param weight
	 *            will change the value of weightInPounds
	 */
	public void setWeight(long kilograms) {
		double weight = kilograms;

		if (kilograms * DEFAULT_NUMBER_THREE == weight) {
			weightInPounds = weight;
		}
	}

	/**
	 * @param weight
	 *            will change the value in weightInPounds
	 */
	public void setWeight(double pounds) {
		double weight = pounds;

		if (pounds == weight) {
			weightInPounds = weight;
		}
	}

	/**
	 * @param height
	 *            the correction of height in feet and inches
	 */
	public void setHeight(int feet, int inches) {
		int height = heightInInches;

		if ((feet == (heightInInches * DEFAULT_NUMBER_ONE)) && (inches == (heightInInches *= DEFAULT_NUMBER_ONE))) {
			heightInInches = height;
		}
	}

	/**
	 * @param height
	 *            will correct the value in heightInInches
	 */
	public void setHeight(int inches) {
		int height = inches;

		if (inches == height) {
			heightInInches = height;
		}
	}

	public void printDetails() {
		System.out.println("Name: " + getFirstName() + " " + getLastName());
		System.out.println("Height: " + getHeightInInches() + " inches");
		System.out.println(" Weight: " + Math.round(getWeightInPounds()) + " pounds");
		if (canTravel == true) {
			System.out.println("Does travel ");
		} else {
			System.out.println("Does not travel ");
		}
		if (smoker == true) {
			System.out.println("Does smoke ");
		} else {
			System.out.println("Does not smoke ");
		}
	}

}