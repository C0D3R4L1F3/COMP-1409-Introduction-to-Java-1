/**
 * Describes a Book-writer with Names and Dates.
 * 
 * @author James Pede
 * @version Jun1'14
 */
public class Author {
	private Name name;
	private Date born;
	private Date died;
	private Name pseudonym;

	/**
	 * Default constructor for objects of class Author.
	 */
	public Author() {
		this(null, null, new Date(), new Name());
	} // end constructor

	/**
	 * Non-default constructor for objects of class Author. This is the most
	 * verbose means of describing an Author. All the attributes of this class'
	 * components are provided here. Contrary to the other constructors, this
	 * one doesn't allow a death-date to be optional.
	 * 
	 * @param firstName
	 *            this person's given name
	 * @param lastName
	 *            this person's surname
	 * @param middleName
	 *            one middle name given to the author by their family [optional:
	 *            null means "no middle name"]
	 * @param yearBorn
	 *            their year of birth, expressed in the Common Era
	 * @param monthBorn
	 *            their month of birth, in the range Date.JANUARY to
	 *            Date.DECEMBER
	 * @param dayBorn
	 *            their day of birth, in the range 1 to (max day number of that
	 *            month and year)
	 * @param yearDied
	 *            their year of death, expressed in the Common Era
	 * @param monthDied
	 *            their month of death; same range as monthBorn
	 * @param dayDied
	 *            their day of death; same range as dayBorn
	 * @param pseudoFirst
	 *            the first name that appears in their nom de plume
	 * @param pseudoLast
	 *            the last name that appears in their nom de plume
	 * @param pseudoMiddle
	 *            one middle name for the nom de plume, if applicable Only if
	 *            all the pseudo-params are null will the pseudoname be
	 *            considered non-existent. Every other combination will be
	 *            passed on to Name() for that class' interpretation.
	 */
	public Author(String firstName, String lastName, String middleName, int yearBorn, int monthBorn, int dayBorn,
			int yearDied, int monthDied, int dayDied, String pseudoFirst, String pseudoLast, String pseudoMiddle) {
		this(new Name(firstName, lastName, middleName), new Date(yearBorn, monthBorn, dayBorn),
				new Date(yearDied, monthDied, dayDied),
				// To the observer:
				// This may be the first time you've seen what is known as "the
				// ternary operator".
				// It takes the form A ? B : C, where A is a true/false
				// evaluation,
				// B is the true consequence, and C is the false consequence.
				// It's like an if/else, except it can be used as part of
				// another operation.
				(null != pseudoFirst || null != pseudoLast || null != pseudoMiddle)
						? new Name(pseudoFirst, pseudoLast, pseudoMiddle) : null);
	} // end constructor

	/**
	 * Non-default constructor for objects of class Author. This constructor is
	 * used if all components of author have already been created.
	 * 
	 * @param name
	 *            Name object that represents the real name given to the author
	 *            at birth
	 * @param born
	 *            Date object that describes the author's recorded birthday
	 * @param died
	 *            Date the author kicked the bucket [optional: null means
	 *            "hasn't died yet"]
	 * @param pseudonym
	 *            a nom de plume that the author published works by [optional:
	 *            null if no pseudonym]
	 */
	public Author(Name name, Date born, Date died, Name pseudonym) {
		// The behavior of these ternary operators ( ? : ) is described in the
		// second constructor, above.
		this.name = (null == name ? new Name() : name);
		this.born = (null == born ? new Date() : born);
		this.died = died;
		this.pseudonym = pseudonym;
	} // end constructor

	/**
	 * Non-default constructor for objects of class Author. Similar to the
	 * preceding constructor, this one takes pre-determined info, but explicitly
	 * describes authors that were known not to have a pseudonym.
	 * 
	 * @param name
	 *            Name object that represents the real name given to the author
	 *            at birth
	 * @param born
	 *            Date object that describes the author's recorded birthday
	 * @param died
	 *            Date the author kicked the bucket [optional: null means
	 *            "hasn't died yet"]
	 */
	public Author(Name name, Date born, Date died) {
		this(name, born, died, null);
	} // end constructor

	/**
	 * A more common way of asking, "has (s)he not died yet?"
	 * 
	 * @return true: (s)he has a date of death on record; false otherwise
	 */
	public boolean isAuthorAlive() {
		return (null == died);
	} // end method

	/**
	 * Answers the question, "how old would the author be if alive today?" I
	 * guess corpses could be said to age - like a fine wine?
	 * 
	 * @return the difference of the author's birth year and this year (Never
	 *         meant to be a perfect answer. 'Today' is treated as Jan 1, 2013.)
	 */
	public int getAgeYearsOfAuthor() {
		return Date.CURRENT_YEAR - born.getYear();
	} // end method

	/**
	 * Accessor.
	 * 
	 * @return name attribute
	 */
	public Name getName() {
		return name;
	} // end accessor

	/**
	 * Accessor.
	 * 
	 * @return born attribute
	 */
	public Date getDateBorn() {
		return born;
	} // end accessor

	/**
	 * Accessor.
	 * 
	 * @return died attribute
	 */
	public Date getDateDied() {
		return died;
	} // end accessor

	/**
	 * Accessor.
	 * 
	 * @return pseudonym attribute
	 */
	public Name getPseudonym() {
		return pseudonym;
	} // end accessor

	/**
	 * Mutator. No validation necessary.
	 * 
	 * @param name
	 *            attribute
	 */
	public void setName(Name name) {
		this.name = name;
	} // end accessor

	/**
	 * Mutator. No validation performed, though in the best case, it'd be before
	 * 'died'.
	 * 
	 * @param born
	 *            attribute
	 */
	public void setDateBorn(Date born) {
		this.born = born;
	} // end accessor

	/**
	 * Mutator. No validation performed, though in the best case, it'd be after
	 * 'born'.
	 * 
	 * @param died
	 *            attribute
	 */
	public void setDateDied(Date died) {
		this.died = died;
	} // end accessor

	/**
	 * Mutator. No validation necessary.
	 * 
	 * @param pseudonym
	 *            attribute
	 */
	public void setPseudonym(Name pseudonym) {
		this.pseudonym = pseudonym;
	} // end accessor
} // end class
