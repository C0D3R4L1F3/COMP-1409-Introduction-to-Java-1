/**
 * This is a Student class.
 * 
 * @author Ronnie Manimt
 * @version 1.0
 */
class Student {
	private String firstName;
	private String lastName;
	private int studentNumber;
	private String emailAddress;
	private int numberOfCourseCompleted;
	private double gradeByPercent;
	private boolean studentInGoodStanding;

	/**
	 * @param theFirstName
	 *            the students first name
	 * @param theLastName
	 *            the students last name
	 * @param theStudentNumber
	 *            the students number
	 * @param theEmailAddress
	 *            the students email address
	 * @param theNumberOfCoursesCompleted
	 *            the number of courses student has completed
	 * @param theGradebyPercent
	 *            the students grade by percentage
	 * @param isStudentInGoodStandig
	 *            true if the student in good standing; otherwise false
	 */
	public Student(String theFirstName, String theLastName, int theStudentNumber, String theEmailAddress,
			int theNumberOfCourseCompleted, double theGradeByPercent, boolean isStudentInGoodStanding) {
		firstName = theFirstName;
		lastName = theLastName;
		studentNumber = theStudentNumber;
		emailAddress = theEmailAddress;
		numberOfCourseCompleted = theNumberOfCourseCompleted;
		gradeByPercent = theGradeByPercent;
		studentInGoodStanding = isStudentInGoodStanding;
	}

	/**
	 * @return the first name of the student
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the last name of the student
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the student numer
	 */
	public int getStudentNumber() {
		return studentNumber;
	}

	/**
	 * @return the student email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @return the number of courses completed
	 */
	public int getNumberOfCourseCompleted() {
		return numberOfCourseCompleted;
	}

	/**
	 * @return the grade by percent
	 */
	public double getGradeByPercent() {
		return gradeByPercent;
	}

	/**
	 * @return if the student is in good standing; false otherwise
	 */
	public boolean isStudentInGoodStanding() {
		return studentInGoodStanding;
	}
}