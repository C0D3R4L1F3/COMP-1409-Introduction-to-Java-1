/**
 * This is the description for a Book Class.
 * 
 * @author Ronnie Manimtim
 * @version 1.0
 */
public class Book {
	private String title;
	private int ISBN;
	private String authorLastName;
	private String authorFirstName;
	private int yearPublished;
	private int monthPublished;

	/**
	 * this is the default constructor
	 */
	public Book() {
	}

	/**
	 * @param title
	 *            the book title
	 * @param bookNumber
	 *            the ISBN number of the book must be between 10000 - 20000
	 * @param authorLastName
	 *            the last name of the author
	 * @param authorFirstName
	 *            the first name of the author
	 * @param yearPublished
	 *            the year the book was published must be between 1870 - 2013
	 * @param monthPublished
	 *            the month the book was published must be between 1 - 12
	 * @param fullName
	 *            the authorFirstName and the authorLastName together
	 */
	public Book(String newTitle, int newISBN, String newAuthorLastName, String newAuthorFirstName, int newYearPublished,
			int newMonthPublished) {
		setTitle(newTitle);
		setISBN(newISBN);
		setAuthorLastName(newAuthorLastName);
		setAuthorFirstName(newAuthorFirstName);
		setYearPublished(newYearPublished);
		setMonthPublished(newMonthPublished);
		setMonthPublished(newMonthPublished);
	}

	/**
	 * @return the new title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the ISBN book number
	 */
	public int getISBN() {
		return ISBN;
	}

	/**
	 * @return the aurthors last name
	 */
	public String getAuthorLastName() {
		return authorLastName;
	}

	/**
	 * @return the aurthors first name
	 */
	public String getAuthorFirstName() {
		return authorFirstName;
	}

	/**
	 * @return the year book was published
	 */
	public int getYearPublished() {
		return yearPublished;
	}

	/**
	 * @return the month published
	 */
	public int getMonthPublished() {
		return monthPublished;
	}

	/**
	 * @return the month name
	 */
	public String getMonthName() {
		if (monthPublished == 1) {
			return "January";
		} else if (monthPublished == 2) {
			return "February";
		} else if (monthPublished == 3) {
			return "March";
		} else if (monthPublished == 4) {
			return "April";
		} else if (monthPublished == 5) {
			return "May";
		} else if (monthPublished == 6) {
			return "June";
		} else if (monthPublished == 7) {
			return "July";
		} else if (monthPublished == 8) {
			return "August";
		} else if (monthPublished == 9) {
			return "September";
		} else if (monthPublished == 10) {
			return "October";
		} else if (monthPublished == 11) {
			return "November";
		} else if (monthPublished == 12) {
			return "December";
		}
		return "";
	}

	/**
	 * @return the first name and the last name of the author
	 */
	public String getFullName() {
		return authorFirstName + authorLastName;
	}

	/**
	 * Will print out the title, ISBN, authors first and last name ,month and
	 * year published
	 */
	public void printDetails() {

		if (title != null) {
			System.out.println("Title: " + title + " ");
		} else if (title == null || title.length() >= 3) {
			System.out.println("Title: " + "invalid text ");
		}

		if (ISBN >= 10000 && ISBN <= 20000) {
			System.out.println("ISBN: " + ISBN + " ");
		} else if (ISBN == 0) {
			System.out.println("ISBN: " + "invalid number ");
		}

		if (authorLastName == null || authorFirstName == null) {
			System.out.println("Author: " + "invalid text ");
		} else // changed to not= null.
		{
			System.out.println("Author: " + authorFirstName + " " + authorLastName + " ");
		}

		if (yearPublished == 0 & monthPublished == 0) {
			System.out.println("Published: " + "invalid number ");
		} else if (yearPublished != 0 & monthPublished != 0) {
			System.out.println("Published: " + getMonthName() + " " + yearPublished);
		}

	}

	/**
	 * Receive the title of the book
	 */
	public void setTitle(String aTitle) {
		if (aTitle.length() >= 3) {
			title = aTitle;
			return;// do not store
		} else {
			System.out.println("error name must have more than 3 characters");// title
																				// of
																				// book
																				// should
																				// have
																				// more
																				// than
																				// 3
																				// characters
																				// if
																				// not
																				// then
																				// error
		}
	}

	/**
	 * Recieve the ISBN book number
	 */
	public void setISBN(int aISBN) {
		if ((aISBN >= 10000) && (aISBN <= 20000)) {
			ISBN = aISBN;
			return;// do not store
		} else {
			System.out.println("error the ISBN must be between 10000 and 20000 inclusive");// the
																							// book
																							// number
																							// must
																							// be
																							// between
																							// 10000
																							// -
																							// 20000
																							// inclusive
		}
	}

	/**
	 * Recieve the authors last name
	 */
	public void setAuthorLastName(String aAuthorLastName) {
		if (aAuthorLastName != null) {
			authorLastName = aAuthorLastName;
			return;// do not store
		} else {
			System.out.println("null");
		}
	}

	/**
	 * Recieve the authors first name
	 */
	public void setAuthorFirstName(String aAuthorFirstName) {
		if (aAuthorFirstName != null) {
			authorFirstName = aAuthorFirstName;
			return; // do not store
		} else {
			System.out.println("null");
		}
	}

	/**
	 * Recieve the year the book was published
	 */
	public void setYearPublished(int aYearPublished) {
		if ((aYearPublished >= 1870) & (aYearPublished <= 2013)) {
			yearPublished = aYearPublished;
			return;// do not store
		}
		{
			System.out.println("error the year published must be between 1870 and 2013 inclusive");// the
																									// year
																									// book
																									// published
																									// must
																									// be
																									// between
																									// 1870
																									// -
																									// 2015
																									// inclusive
		}
	}

	/**
	 * Receive new month published
	 */
	public void setMonthPublished(int aMonthPublished) {
		if ((aMonthPublished >= 1) & (aMonthPublished <= 12)) {
			monthPublished = aMonthPublished;
			return;// do not store
		} else {
			System.out.println("error month published must be between 1 and 12 inclusive");
		}
	}
}
