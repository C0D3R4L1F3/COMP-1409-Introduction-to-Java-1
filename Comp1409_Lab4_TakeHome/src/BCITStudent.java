/**
 * this is a description of a BCITStudent class.
 * 
 * @author Ronnie Manimtim
 * @version 0.1
 */
public class BCITStudent {
	private static final String HOME_PROVINCE = "British Columbia";
	private static String schoolMotto = "It's your career. Get it right.";
	private static final int MINIMUM_NAME_LENGTH_LETTERS = 3;
	private static final int MINIMUM_YEAR = 1900;
	private static final int MAXIMUM_YEAR = 2000;

	private String lastName;
	private String firstName;
	private int yearBorn;
	private String sex;

	/**
	 * @param lastName
	 *            the students last name must have more than
	 *            MINIMUM_NAME_LENGTH_LETTERS characters and can not equal null
	 * @param firstName
	 *            the students first name can not equal null
	 * @param yearBorn
	 *            the year student is born must be between MINIMUM_YEAR -
	 *            MAXIMUM_YEAR inclusive
	 * @param sex
	 *            the gender of the student
	 * @param homeProvince
	 *            the province of student must be "British Columbia"
	 * @param schoolMotto
	 *            the school motto must be "It's your career. Get it right."
	 */
	public BCITStudent(String newLastName, String newFirstName, int newYearBorn, String newSex) {
		setLastName(newLastName);
		setFirstName(newFirstName);
		setYearBorn(newYearBorn);
		setSex(newSex);

	}

	/**
	 * @return homeProvince the province of student must be "British Columbia"
	 */
	public String getHOME_PROVINCE() {
		return "British Columbia";
	}

	/**
	 * @return the school motto must be "It's your career. Get it right."
	 */
	public String getSchoolMotto() {
		return "It's your career. Get it right.";
	}

	/**
	 * @return the last name of the student
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the first name of the student
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the year born of the the student
	 */
	public int getYearBorn() {
		return yearBorn;
	}

	/**
	 * @return the sex gender of the student
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Recieve the students last name must have more than
	 * MINIMUM_NAME_LENGTH_LETTERS characters and can not equal null
	 */
	public void setLastName(String aLastName) {
		if ((aLastName != null) && (aLastName.length() > MINIMUM_NAME_LENGTH_LETTERS)) {
			lastName = aLastName;
			return; // do not store
		}
	}

	/**
	 * Recieve the first name of the student can not equal null
	 */
	public void setFirstName(String aFirstName) {
		if (aFirstName != null) {
			firstName = aFirstName;
			return; // do not store
		}
	}

	/**
	 * Recieve yearBorn the year student is born must be between MINIMUM_YEAR -
	 * MAXIMUM_YEAR inclusive
	 */
	public void setYearBorn(int aYearBorn) {
		if (aYearBorn >= MINIMUM_YEAR & aYearBorn <= MAXIMUM_YEAR) {
			yearBorn = aYearBorn;
			return; // do not store
		}
	}

	/**
	 * Recieve sex the gender of the student
	 */
	public void setSex(String aSex) {
		if (aSex == "male") {
			sex = aSex;
			return; // do not store
		} else if (aSex == "female") {
			sex = aSex;
			return; // do not store
		}
	}

	public void schoolMotto(String aSchoolMotto) {
		schoolMotto = "It's your career. Get it right.";
		System.out.println(schoolMotto.toUpperCase());
	}

	/**
	 * Returns the print details of BCITStudent class
	 */
	public void printDetails() {
		if (sex == "male") {
			System.out.println((firstName + " " + lastName + " ") + ("(male)" + " ")
					+ (MAXIMUM_YEAR - yearBorn + " " + "years old." + " ") + ("His home province is") + " "
					+ (HOME_PROVINCE) + " " + ("and his school's motto is:") + (schoolMotto.toUpperCase()));
		} else if (sex == "female") {
			System.out.println((firstName + " " + lastName + " ") + ("(female)" + " ")
					+ (MAXIMUM_YEAR - yearBorn + " " + "years old." + " ") + ("Her home province is") + " "
					+ (HOME_PROVINCE) + " " + ("and her school's motto is:") + (schoolMotto.toUpperCase()));
		}
	}
}
