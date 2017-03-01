
/**
 * A given-name, optional middle name, and family-surname.
 * 
 * @author James Pede
 * @version Jun1'14
 */
public class Name {
	private static final String DEFAULT_FIRST = "A.";
	private static final String DEFAULT_MIDDLE = "Non";
	private static final String DEFAULT_LAST = "Ymous";
	private static final String PRETTY_DELIMITER = " ";
	private static final String INITIALS_DELIMITER = ".";

	public static final int MINIMUM_NAME_LENGTH = 1;
	public static final int MAXIMUM_NAME_LENGTH = 40;

	private String first;
	private String middle;
	private String last;

	/**
	 * Constructor for objects of class Name
	 */
	public Name() {
		setDefaults();
	} // end constructor

	/**
	 * Non-default constructor. Allows for initialization of all object
	 * attributes.
	 * 
	 * @param first
	 *            a person's given name; if null, fails validation
	 * @param middle
	 *            a person's middle name [optional: use null to declare 'no
	 *            middle name']
	 * @param last
	 *            a person's surname; if null, fails validation
	 */
	public Name(String first, String last, String middle) {
		set(first, middle, last);
	} // end constructor

	/**
	 * Modified accessor.
	 * 
	 * @return the Proper Noun version of the underlying first (name) attribute
	 */
	public String getFirstName() {
		return makeProper(first);
	} // end accessor

	/**
	 * Modified accessor.
	 * 
	 * @return the Proper Noun version of the underlying middle (name) attribute
	 */
	public String getMiddleName() {
		return (null == middle ? null : makeProper(middle));
	} // end accessor

	/**
	 * Modified accessor.
	 * 
	 * @return the Proper Noun version of the underlying last (name) attribute
	 */
	public String getLastName() {
		return makeProper(last);
	} // end accessor

	/**
	 * Exposure pattern: presents a public version of makePrettyName.
	 * 
	 * @return "first middle last" OR "first last" if middle name is null
	 */
	public String getFullName() {
		return makePrettyName();
	} // end method

	/**
	 * Abbreviate makePrettyName down to the first letters of all the component
	 * names.
	 * 
	 * @return "A. B. C." where A is the first letter of the first name, etc.
	 */
	public String getInitials() {
		return (first.charAt(0) + (null == middle ? "" : INITIALS_DELIMITER + middle.charAt(0)) + INITIALS_DELIMITER
				+ last.charAt(0) + INITIALS_DELIMITER).toUpperCase();
	} // end method

	/**
	 * This helper function was not explicitly demanded by the requirement
	 * specifications, but all attributes must be output in
	 * capital-first-letter-lowercase-all-else format, a.k.a. a Proper Noun.
	 * makeProper is called by all the attribute accessors.
	 * 
	 * @param impromptuNoun
	 *            a String literal, assumed to be non-null, non-empty; Normally,
	 *            this is a terrible assumption, but it is valid in this class
	 *            due to how makeProper is used internally AND the restrictions
	 *            placed on the 'first' and 'last' attributes.
	 * @return a String literal that is identical to impromptuNoun, except that
	 *         its first letter is capitalized with all other letters
	 *         lower-cased
	 */
	private String makeProper(String impromptuNoun) {
		// This validation isn't necessary due to the restrictions on passed
		// parameters.
		// if (null == impromptuNoun || 0 == impromptuNoun.length())
		// return impromptuNoun;

		return Character.toUpperCase(impromptuNoun.charAt(0)) + impromptuNoun.substring(1).toLowerCase();
	} // end method

	/**
	 * Concatenate all the component names, with spaces between them.
	 * 
	 * @return "first middle last" OR "first last" if middle name is null
	 */
	private String makePrettyName() {
		return getFirstName() + (null == middle ? "" : PRETTY_DELIMITER + getMiddleName()) + PRETTY_DELIMITER
				+ getLastName();
	} // end method

	/**
	 * Similar to how it was done in Date, code that is common to re-naming was
	 * moved into this mutator of all the attributes. Specifically, if any one
	 * name of the three fails validation (length restrictions), all three will
	 * be devolved into a preset default.
	 * 
	 * @param first
	 *            a person's given name; if null, fails validation
	 * @param middle
	 *            a person's middle name [optional: use null to declare 'no
	 *            middle name']
	 * @param last
	 *            a person's surname; if null, fails validation
	 */
	public void set(String first, String middle, String last) {
		this.first = first;
		this.middle = middle;
		this.last = last;

		// By assigning the given values to attributes ahead of this moment,
		// we gain the liberty of changing the middle-name parameter
		// to a 'known good' value when it is being excluded.
		// This allows us to apply the same validation to all input,
		// and in so doing, write less code.
		if (null == middle)
			middle = " ";

		int nameLength;
		for (String anyName : new String[] { first, middle, last })
			if (null == anyName || MINIMUM_NAME_LENGTH > (nameLength = anyName.length())
					|| MAXIMUM_NAME_LENGTH < nameLength) {
				setDefaults();
				return;
			} // end if: any name fails restrictions
	} // end mutator

	/**
	 * Sets the three name attributes to 'fall-back' values. Used in the case of
	 * the default constructor OR any validation failure.
	 */
	private void setDefaults() {
		first = DEFAULT_FIRST;
		middle = DEFAULT_MIDDLE;
		last = DEFAULT_LAST;
	} // end initializer

	/**
	 * Mutator.
	 * 
	 * @param first
	 *            given name of a person; null will fail validation
	 */
	public void setFirstName(String first) {
		set(first, this.middle, this.last);
	} // end accessor

	/**
	 * Mutator.
	 * 
	 * @param middle
	 *            middle name of a person [optional: use null to represent 'no
	 *            middle name']
	 */
	public void setMiddleName(String middle) {
		set(this.first, middle, this.last);
	} // end accessor

	/**
	 * Mutator.
	 * 
	 * @param last
	 *            family name (a.k.a. the 'surname') of a person
	 */
	public void setLastName(String last) {
		set(this.first, this.middle, last);
	} // end accessor
} // end class
