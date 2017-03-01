
/**
 * A physical object containing the printed word, described in terms of the
 * person who wrote it, the title it was given, and its date of publication.
 * 
 * @author James Pede
 * @version Jun1'14
 */
public class Book {
	private static final String DEFAULT_TITLE = "Untitled";

	private Author author;
	private Date published;
	private String title;

	/**
	 * Default constructor for objects of class Book.
	 */
	public Book() {
		this.author = new Author();
		this.published = new Date();
		this.title = DEFAULT_TITLE;
	} // end constructor

	/**
	 * Non-default constructor for objects of class Book. Assumes the prior
	 * existence of all components, but each may optionally be null.
	 * 
	 * @param author
	 *            person who wrote the book; null defaults to "A. Non Ymous"
	 * @param published
	 *            date of publication; null defaults to whatever the default
	 *            Date is
	 * @param title
	 *            primary identification of the book that appears on the cover;
	 *            null is replaced with a default
	 */
	public Book(Author author, Date published, String title) {
		setAuthor(author);
		setDatePublished(published);
		setTitle(title);
	} // end constructor

	/**
	 * Accessor.
	 * 
	 * @return author attribute
	 */
	public Author getAuthor() {
		return author;
	} // end accessor

	/**
	 * Accessor.
	 * 
	 * @return published attribute
	 */
	public Date getDatePublished() {
		return published;
	} // end accessor

	/**
	 * Accessor.
	 * 
	 * @return title attribute
	 */
	public String getTitle() {
		return title;
	} // end accessor

	/**
	 * Mutator. Enforces a default if null.
	 * 
	 * @param author
	 *            attribute
	 */
	public void setAuthor(Author author) {
		this.author = (null == author ? new Author() : author);
	} // end accessor

	/**
	 * Mutator. Enforces a default if null.
	 * 
	 * @param published
	 *            attribute
	 */
	public void setDatePublished(Date published) {
		this.published = (null == published ? new Date() : published);
	} // end accessor

	/**
	 * Mutator. Enforces a default if null.
	 * 
	 * @param title
	 *            attribute
	 */
	public void setTitle(String title) {
		this.title = (null == title ? DEFAULT_TITLE : title);
	} // end accessor

	/**
	 * Pass-through function that obtains a full String interpretation of all
	 * the author's names.
	 * 
	 * @return concatenated name-String
	 */
	public String getAuthorName() {
		return author.getName().getFullName();
	} // end method

	/**
	 * Pass-through function that asks the publication date to identify what
	 * week day it was when the book was released.
	 * 
	 * @return one of "Monday", "Tuesday", etc..
	 */
	public String getDayOfTheWeekBookWasPublished() {
		return published.getDayOfTheWeek();
	} // end method

	/**
	 * Uses standard-out to display a little blurb about the Book details. No
	 * input or output to this method. It operates entirely on attributes.
	 */
	public void printDetails() {
		System.out.print(getAuthorName());
		System.out.print("(");
		System.out.print(author.getName().getInitials());
		System.out.print(") wrote ");
		System.out.print(title);
		System.out.print(" on ");
		System.out.print(getDayOfTheWeekBookWasPublished());
		System.out.print(", ");
		System.out.print(Date.getMonthName(published.getMonth()));
		System.out.print(" ");
		System.out.print(published.getDay());
		System.out.print(", ");
		System.out.print(published.getYear());

		Name pseudonym = author.getPseudonym();
		if (null != pseudonym) {
			System.out.print(", under the pseudonym ");
			System.out.print(pseudonym.getFullName());
		}

		System.out.println();
	} // end method
} // end class
