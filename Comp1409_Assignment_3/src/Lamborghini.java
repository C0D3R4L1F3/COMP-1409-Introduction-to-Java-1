/**
 * Lamborghini Class Solution for COMP 1409 Assignment 1
 * 
 * @author Taylor Dixon
 * @version 1.0
 */
class Lamborghini {

	private static final String MANUFACTURER = "Lamborghini";

	private static final int MODEL_NAME_MIN_LENGTH = 1;
	private static final int MODEL_YEAR_MIN_VALUE = 1963;

	private static final int CURRENT_YEAR = 2013;

	private static final double HORSEPOWER_MIN_VALUE = 300;
	private static final double HORSEPOWER_MAX_VALUE = 600;

	private static String webpage = "http://www.lamborghini.com/en/home";

	private int modelYear;
	private String modelName;
	private double horsepower;
	private boolean isRearWheelDrive;

	/**
	 * Default constructor
	 */
	public Lamborghini() {

	}

	/**
	 * Constructor for Lamborghini Class
	 * 
	 * @param modelYear
	 *            The model year of the lamborghini
	 * @param modelName
	 *            The model name of the lamborghini
	 * @param horsepower
	 *            The horsepower of the lamborghini
	 * @param isRearWheelDrive
	 *            If the lamborgini is rear wheel drive
	 */
	public Lamborghini(int modelYear, String modelName, double horsepower, boolean isRearWheelDrive) {
		setModelYear(modelYear);
		setModelName(modelName);
		setHorsepower(horsepower);
		setIsRearWheelDrive(isRearWheelDrive);
	}

	/**
	 * Set a new model year. Must be between MODEL_YEAR_MIN_VALUE and
	 * MODEL_YEAR_MAX_VALUE
	 * 
	 * @param modelYear
	 *            The new model year.
	 */
	public final void setModelYear(int modelYear) {
		if (modelYear < MODEL_YEAR_MIN_VALUE) {
			printErrorString(modelYear, "early");
		} else if (modelYear > CURRENT_YEAR) {
			printErrorString(modelYear, "late");
		} else {
			this.modelYear = modelYear;
		}
	}

	/**
	 * Set a new model name. Must not be null, and larger than
	 * MODEL_NAME_MIN_LENGTH
	 * 
	 * @param modelName
	 *            The new model name.
	 */
	public final void setModelName(String modelName) {
		if (null != modelName && modelName.length() > MODEL_NAME_MIN_LENGTH) {
			this.modelName = modelName;
		} else {
			System.out.println("a model name was not provided, sorry");
		}

	}

	/**
	 * Set new horsepower. Must be between HORSEPOWER_MIN_VALUE and
	 * HORSEPOWER_MAX_VALUE
	 * 
	 * @param horsepower
	 *            The new horsepower.
	 */
	public final void setHorsepower(double horsepower) {
		int horsepowerWhole = (int) Math.round(horsepower);
		if (horsepower < HORSEPOWER_MIN_VALUE) {
			printErrorString(horsepowerWhole, "little");
		} else if (horsepower > HORSEPOWER_MAX_VALUE) {
			printErrorString(horsepowerWhole, "much");
		} else {
			this.horsepower = horsepower;
		}
	}

	/**
	 * Set if rear wheel drive.
	 * 
	 * @param isRearWheelDrive
	 *            If rear wheel drive.
	 */
	public final void setIsRearWheelDrive(boolean isRearWheelDrive) {
		this.isRearWheelDrive = isRearWheelDrive;
	}

	/**
	 * Set the webpage of the manufacturer.
	 * 
	 * @param webpage
	 *            The new webpage.
	 */
	public final static void setWebpage(String webpage) {
		Lamborghini.webpage = webpage;
	}

	/**
	 * Get the webpage of the manufacturer.
	 * 
	 * @return The webpage of the manufacturer
	 */
	public static String getWebpage() {
		return webpage;
	}

	/**
	 * Get the manufacturer.
	 * 
	 * @return The manufacturer.
	 */
	public static String getManufacturer() {
		return MANUFACTURER;
	}

	/**
	 * Get the car's model year.
	 * 
	 * @return The car's model year.
	 */
	public int getModelYear() {
		return modelYear;
	}

	/**
	 * Get the car's model name.
	 * 
	 * @return The car's model name.
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * Get the car's horsepower.
	 * 
	 * @return The car's horsepower.
	 */
	public double getHorsepower() {
		return horsepower;
	}

	/**
	 * Get if the car is wheel rear drive.
	 * 
	 * @return true if the car is rear wheel drive, false if not.
	 */
	public boolean getIsRearWheelDrive() {
		return isRearWheelDrive;
	}

	/*
	 * Format a string with the first letter upper-cased, and the rest
	 * lower-cased
	 */
	private String makePrettyString(String str) {
		if (str != null && !str.isEmpty()) {
			String firstChar = str.substring(0, 1);
			String rest = str.substring(1);
			return firstChar.toUpperCase() + rest.toLowerCase();
		}

		return str;
	}

	/*
	 * Print an error string with an int, and a verb
	 */
	private void printErrorString(int value, String verb) {
		printErrorString(new Integer(value).toString(), verb);
	}

	/*
	 * Print an error string with an string, and a verb
	 */
	private void printErrorString(String value, String verb) {
		System.out.println(value + " is too " + verb + ", sorry");
	}

	/*
	 * Print an error string with a string.
	 */
	private void printDisplayErrorString(String name) {
		System.out.println("Sorry. There is an error with this car's " + name + ".");
	}

	/**
	 * Print all the car's details to System.out. NOTE: If any value is invalid,
	 * or has default data-type value, the details will not be printed.
	 */
	public void getCarDetails() {
		if (modelYear == 0) {
			printDisplayErrorString("model year");
			return;
		}
		if (horsepower == 0.0) {
			printDisplayErrorString("horsepower");
			return;
		}
		if (modelName == null) {
			printDisplayErrorString("model name");
			return;
		}

		String detailString = "This car is a " + getModelYear() + " " + makePrettyString(getModelName()) + " with "
				+ Math.round(getHorsepower()) + "hp and is " + ((getIsRearWheelDrive()) ? "" : "not ")
				+ "rear-wheel drive. It is manufactured by " + getManufacturer() + " and you can read more at "
				+ getWebpage();

		System.out.println(detailString);

	}

}