/**
 * This is a CellPhone class.
 * 
 * @author Ronnie Manimtim
 * @version 1.0
 */
class CellPhone {
	private String brandOfPhone;
	private String modelOfPhone;
	private double weightGrams;
	private int memoryMegabytes;
	private int numberOfLinesText;
	private boolean camera;
	private boolean alarmClock;
	private boolean games;
	private boolean vibrateMode;

	/**
	 * @param theBrandOfPhone
	 *            the brand name of the cell phone
	 * @param theModelOfPhone
	 *            the model of the cell phone
	 * @param theWeightGrams
	 *            the cell phones weight in grams
	 * @param theMemoryMegabytes
	 *            the cell phones memory capacity in megabytes
	 * @param theNumberOfLinesText
	 *            the amount of lines of text
	 * @param isCamera
	 *            true if cell phone has camera; otherwise false
	 * @param isAlarmClock
	 *            true if the cell phone has alarm clock; otherwise false
	 * @param isGames
	 *            true if the cell phone has games; otherwise false
	 * @param isVibrateMode
	 *            true if cell phone has vibrate mode; otherwise false
	 */
	public CellPhone(String theBrandOfPhone, String theModelOfPhone, double theWeightGrams, int theMemoryMegabytes,
			int theNumberOfLinesText, boolean isCamera, boolean isAlarmClock, boolean isGames, boolean isVibrateMode) {
		brandOfPhone = theBrandOfPhone;
		modelOfPhone = theModelOfPhone;
		weightGrams = theWeightGrams;
		memoryMegabytes = theMemoryMegabytes;
		numberOfLinesText = theNumberOfLinesText;
		camera = isCamera;
		alarmClock = isAlarmClock;
		games = isGames;
		vibrateMode = isVibrateMode;
	}

	/**
	 * @return the brand of cell phone
	 */
	public String getBrandOfPhone() {
		return brandOfPhone;
	}

	/**
	 * @return the model of the cell phone
	 */
	public String getModelOfPhone() {
		return modelOfPhone;
	}

	/**
	 * @return the weight of cell phone in grams
	 */
	public double getWeightGrams() {
		return weightGrams;
	}

	/**
	 * @return the memory capacity of cell phone in megabytes
	 */
	public int getMemoryMegabytes() {
		return memoryMegabytes;
	}

	/**
	 * @return the number of lines of text
	 */
	public int getNumberOfLinesText() {
		return numberOfLinesText;
	}

	/**
	 * @return true if cell phone has camera; otherwise false
	 */
	public boolean isCamera() {
		return camera;
	}

	/**
	 * @return true if cell phone has alarm clock: otherwise false
	 */
	public boolean isAlarmClock() {
		return alarmClock;
	}

	/**
	 * @return true if cell phone has games: otherwise false
	 */
	public boolean isGames() {
		return games;
	}

	/**
	 * @return true if cell phone had vibrate mode: otherwise false
	 */
	public boolean isVibrateMode() {
		return vibrateMode;
	}
}
