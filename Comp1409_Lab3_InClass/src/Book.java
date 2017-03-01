/**
 * This is the description for a Book Class.
 * 
 * @author Ronnie Manimtim
 * @version 0.0
 */
public class Book {
	private String title;
	private int ISBN;
	private String authorLastName;
	private String authorFirstName;
	private int yearPublished;

	/**
	 * @param title
	 *            the book title
	 * @param bookNumber
	 *            the ISBN number of the book
	 * @param authorLastName
	 *            the last name of the author
	 * @param authorFirstName
	 *            the first name of the author
	 * @param yearPublished
	 *            the year the book was published
	 */
	public Book(String newTitle, int newISBN, String newAuthorLastName, String newAuthorFirstName,
			int newYearPublished) {
		setTitle(newTitle);
		setISBN(newISBN);
		setAuthorLastName(newAuthorLastName);
		setAuthorFirstName(newAuthorFirstName);
		setYearPublished(newYearPublished);
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
	public int getNewISBN() {
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
		} else {
			System.out.println("error the year published must be between 1870 and 2015 inclusive");// the
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

}
