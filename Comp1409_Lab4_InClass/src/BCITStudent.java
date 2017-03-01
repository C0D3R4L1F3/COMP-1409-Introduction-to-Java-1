/**
 * this is a description of a BCITStudent class.
 * 
 * @author Ronnie Manimtim
 * @version 0.1
 */
public class BCITStudent {
	private static final String HOME_PROVINCE = "British Columbia";
	private static String schoolMotto = "It's your career. Get it right";

	private String lastName;
	private String firstName;
	private int yearBorn;
	private String sex;

	/**
	 * @param lastName
	 *            the students last name must have more than 3 characters and
	 *            can not equal null
	 * @param firstName
	 *            the students first name can not equal null
	 * @param yearBorn
	 *            the year student is born must be between 1900 - 2000 inclusive
	 * @param sex
	 *            the gender of the student
	 * @param homeProvince
	 *            the province of student must be "British Columbia"
	 * @param schoolMotto
	 *            the school motto must be "It's your career. Get it right."
	 */
	public BCITStudent(String newLastName, String newFirstName, int newYearBorn, String newSex)

	{
		setLastName(newLastName);
		setFirstName(newFirstName);
		setYearBorn(newYearBorn);
		setSex(newSex);

	}

	/**
	 * @return homeProvince the province of student must be "British Columbia"
	 */
	public static String getHOME_PROVINCE() {
		return HOME_PROVINCE;
	}

	/**
	 * @return the school motto must be "It's your career. Get it right."
	 */
	public static String getSchoolMotto() {
		return schoolMotto;
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
	 * Recieve the last name of the student must have more than 3 characters and
	 * can not equal null
	 */
	public void setLastName(String aLastName) {
		if ((aLastName != null) && (aLastName.length() > 3)) {
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
	 * Recieve yearBorn the year student is born must be between 1900 - 2000
	 * inclusive
	 */
	public void setYearBorn(int aYearBorn) {
		if (aYearBorn >= 1900 & aYearBorn <= 2000) {
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
			return;// do not store
		}
	}

	@SuppressWarnings("unused")
	private void schoolMotto(String aSchoolMotto) {
		aSchoolMotto = schoolMotto;
	}
}
