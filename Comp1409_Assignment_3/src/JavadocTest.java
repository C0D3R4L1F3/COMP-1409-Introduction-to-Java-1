import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Hello, students!
 * 
 * If you're seeing this message, you've double-clicked into the code-view of
 * this testing module. You sohuld find that when it is compiled, the BlueJ
 * 'Integrated Development Environment' turns JavadocTest into a green box. When
 * the green-box is right-clicked for contextual options, "Test All" is one such
 * option presented to you. Choose that to have the javadocumentation in your
 * code evaluated.
 * 
 * This evaluation that you will receive is delivered via the 'JUnit'
 * pass-or-fail system. It should produce a pop-up window with the name of the
 * evaluation method ("evaluateFilesInThisFolder"), preceded by a green
 * checkmark, a red X, or a grey X. An X result should be expected while you are
 * learning. The conditions for success are quite demanding.
 * 
 * In fact, when you use this module -- this one specifically -- you are welcome
 * to view the results with mistrust. JavadocTest was not meant as an ultimate
 * authority: Your final grade may be affected by the deductions this module
 * suggests, but the only true evaluators are your instructor or Teaching
 * Assistant. The tool itself is intentionally flawed; it performs some language
 * processing, which is not an area that computers currently excel at.
 * 
 * You may find that you can deceive the tool by adopting unexpected programming
 * styles, and there will be other times where the tool fails, but the reason
 * will not be apparent. It is your marker's responsibility to review all of
 * your code for mistakes, just as this is also your responsibility. If you
 * can't overcome a problem that the tool reports, send e-mail to your T.A.,
 * with the code included somehow. Together, you will learn what has to be
 * learned to produce the best results. [Just don't wait to the last minute!
 * :-D]
 * 
 * If you feel especially confident in your understanding of the Java language,
 * read ahead to the in-line commentary in this module. An effort has been made
 * to explain the operation of the JavadocTest tool, including some assumptions
 * that may not be true.
 *
 * @author James Pede [james_pede@hotmail.com]
 * @version Jul8'15,2139h Scanner.next() no longer crashes when odd character
 *          sets are employed.
 */
public class JavadocTest implements java.io.FilenameFilter {
	// Windows and Macintosh systems use their own, unique set of 'invisible
	// letters'
	// to visually create a 'carriage-return, line-feed' effect [or, if you
	// prefer, 'enter'].
	// A program needs to know the exact sequence used, and that information
	// can't be hard-coded.
	// Fortunately, this is the kind of information that the Java language
	// always knows for us.
	private final static String NEWLINE_CHAR = System.getProperties().getProperty("line.separator");

	/**
	 * The test module is, itself, a file filter -- processing only those files
	 * in the folder JavadocTest occupies ending in the file extension ".java".
	 * 
	 * @param folder
	 *            place where the filter-subjects are being found; this
	 *            parameter is ignored because I dictate elsewhere that the
	 *            location will always, always be "." [the 'working directory']
	 * @param name
	 *            the file identifier that we are filtering
	 * @return true if and only if {name} ends with ".java"
	 */
	public boolean accept(java.io.File folder, String name) {
		return name.endsWith(".java");
	} // end FileFilter method

	/**
	 * Regular Expressions are capable of returning several matches, but there's
	 * this multi-step process that doesn't produce tidy results. I've created
	 * this helper method for testJavadoc() so that the process is condensed and
	 * reusable.
	 * 
	 * @param s
	 *            a Scanner object, which is wrapping and streaming some
	 *            String-based source; this is where the {pattern} will be found
	 * @param pattern
	 *            the Regular Expression matching string; look up RegEx on the
	 *            Internet -- it's complicated, but important
	 * @return Stack of matches; it was most convenient to organize
	 *         first-in-last-out
	 */
	private java.util.Stack<String> scanIntoStack(java.util.Scanner s, String pattern) {
		java.util.Stack<String> result = new java.util.Stack<String>();

		java.util.regex.Matcher m = java.util.regex.Pattern.compile(pattern, java.util.regex.Pattern.DOTALL)
				.matcher(s.next());

		while (m.find())
			result.push(m.group().replaceAll(NEWLINE_CHAR, " ").replaceAll("\\s+", " ").trim());

		return result;
	} // end helper method

	/**
	 * This beautiful monstrosity is a file parser that finds methods and
	 * compares their parameters to preceding javadoc. Students will be advised
	 * if there is an undocumented parameter. In the case of even one mistake,
	 * the preferred style will be detailed.
	 * 
	 * Since this technology is 'in the neighborhood', it also verifies that
	 * class headers are not left as the IDE-generated default, and that return
	 * values are also documented to standard.
	 * 
	 * Assumptions/Weaknesses of algorithm: - Blocks are begun where opening
	 * braces come at the end of a line. (Could be false if a student begins
	 * code and block in the same line. This would be a practice that we'd like
	 * to discourage anyway.) - Multiline comments don't end a line with an
	 * opening brace. (The only reason I can predict this happening is if
	 * someone had a code sample in javadoc. Possible. Unlikely?) - Class names
	 * and method names don't have numbers in them.
	 */
	@Test
	public void evaluateFilesInThisFolder() {
		final String DEFAULT_CLASS_HEADER = "Write a description of class %s here.";
		final String DEFAULT_CLASS_HEADER_PENALTY = "-1: The class header for '%s' has been left as the BlueJ-generated default."
				+ NEWLINE_CHAR;
		final String NO_CLASS_HEADER_PENALTY = "-1: The class header for '%s' is missing." + NEWLINE_CHAR;
		final String UNDOCUMENTED_PARAM_PENALTY = "-1: Incorrect javadoc for parameter '%1s', before %2s.%3s()."
				+ NEWLINE_CHAR;
		final String UNDOCUMENTED_RETURN_PENALTY = "-1: %1s.%2s() has an undocumented return value." + NEWLINE_CHAR;

		String failReport = "";
		for (java.io.File f : new java.io.File(".").listFiles(this))
			try {
				// @version Jul8'15,2139h Without the ISO specification, �curly
				// quotes�,
				// such as those just used, cause Scanner to parse the file as
				// blank.
				// @ref
				// http://stackoverflow.com/questions/18901316/curly-quotes-causing-java-scanner-hasnextline-to-be-false-why
				java.util.Scanner reader = new java.util.Scanner(f, "ISO-8859-1");
				reader.useDelimiter("\\{\\s?[\n\r]+");

				// Obtain a class declaration statement and the javadoc
				// preceding it.
				// The following Regular Expression includes these statements:
				// (?<= \\* ) match some lines that begin space-asterisk-space;
				// this would seem to be the most common indicator
				// of a comment block, where javadoc is expected to be found
				// [\\w\\s]+ a set of words, allowing for punctuation,
				// potentially
				// including spaces or tab-stops, or other kinds of whitespace;
				// this should be the actual human language in a class header
				// | a vertical bar is an OR operator;
				// either the stuff to the left of it, or the right
				// can produce a match, but not both sides together
				// (?<=class )\\w+ match a word following 'class', but don't
				// match 'class' itself;
				// the word is the name of a class, and does not allow
				// whitespace
				//
				// (?<=interface )\\w+ same explanation as previous, but for an
				// interface
				// -- not a class; interfaces must be processed differently
				java.util.Stack<String> text = scanIntoStack(reader,
						"(?<= \\* )[\\w\\s]+|(?<=class )\\w+|(?<=interface )\\w+|(?<=enum )\\w+");
				// @version Jun24'15,????h Enumerated types were a structure
				// that I did not anticipate
				// in my first drafts of this tool.

				if (0 == text.size())
					fail(String.format("-1: You did not declare a class or interface in %s.", f.getName()));

				String testedClassName = text.pop();
				Class<?> testedModule = Class.forName(testedClassName);

				{
					// @version May18'15,1457h Former versions of this code
					// block would
					// crash with an ArrayIndexOutOfBoundsException if the
					// student omitted
					// a class header entirely.
					if (text.isEmpty())
						failReport += String.format(NO_CLASS_HEADER_PENALTY, testedClassName);
					else if (String.format(DEFAULT_CLASS_HEADER, testedClassName).equals(text.get(0)))
						failReport += String.format(DEFAULT_CLASS_HEADER_PENALTY, testedClassName);
				} // end subroutine: validateClassHeader

				// Identify all the methods that are public members of the
				// subject class. These are the ones we will test.
				java.util.HashSet<String> validMethodNames = new java.util.HashSet<String>();
				validMethodNames.add(testedClassName);
				for (java.lang.reflect.Method method : testedModule.getMethods())
					validMethodNames.add(method.getName());

				while (reader.hasNext()) {
					// Obtain all javadoc for params and returns, or method
					// signatures that could include generics.
					// The following Regular Expression includes these
					// statements:
					// ((?<=\\*)\\s+ match comment lines by their leading
					// asterisk
					// and any quantity of whitespace
					// @(param|return) the javadoc that we evaluate always
					// begins with
					// an ampersand followed by one of these keywords
					// \\s+\\w+ there will be at least one space, potentially
					// more,
					// followed by an unbroken parameterName [a.k.a. 'the
					// symbol']
					//
					// public|private|protected the presence of one of these
					// 'access keywords'
					// is the usual giveaway of a method declaration
					// [a.k.a. 'the signature']
					// [\\s0-z]* any number of spaces, letters, or punctuation
					// which will mostly be ignored, but generally constitutes
					// 'the return type'; irrelevant in a constructor
					//
					// \\w+\\([^\\)]*\\) the name of the method, and the round
					// parentheses that likely enclose parameters
					text = scanIntoStack(reader,
							"((?<=\\*)\\s+@(param|return)\\s+\\S+)|((public|private|protected)[\\s0-z]* \\w+\\([^\\)]*\\))");

					// Unlikely case. Should only occur if the student has
					// included a 'static initializer'.
					if (0 == text.size())
						continue;

					// Separate the method name from its parameter list, using
					// the opening bracket as a delimiter.
					String methodName = text.pop();
					String[] params = methodName.split("\\(\\s?");

					boolean hasReturnValue = true;
					{
						int symbolIndex = params.length - 2;
						// Not sure how this could happen, but I suspect it's
						// possible.
						if (0 > symbolIndex)
							continue;

						// Here, we strip the rest of the signature from the
						// method's name.
						methodName = params[symbolIndex];
						if (methodName.contains(" void "))
							hasReturnValue = false;
						methodName = methodName.substring(methodName.lastIndexOf(" ") + 1);
						if (methodName.equals(testedClassName))
							hasReturnValue = false;

						// Don't process any method that isn't a member of the
						// subject class.
						if (!validMethodNames.contains(methodName))
							continue;

						// Make the types of the parameters into delimiters so
						// the parameter names become isolated.
						// This RegEx contains the following phrases:
						// ? optional whitespace
						// (,|^) has a comma or start-of-input
						// [^\\s\\<]+ some stuff that isn't whitespace;
						// corresponds to parameter type
						// (\\<.+\\>)? optional parameterization of the
						// parameter type; e.g. ArrayList<String>
						params = params[++symbolIndex].split("( ?(,|^) ?[^\\s\\<]+(\\<.+\\>)? )|\\)");
					} // end subroutine: break signature into pieces

					// Match each parameter to a @param statement in the javadoc
					// preceding the method.
					boolean skipFirst = true;
					paramLoop: for (String param : params) {
						// The following once-per-loop case was necessitated by
						// the split() command's unwillingness
						// to omit leading empty-string elements. It'll exclude
						// tailing ones.
						if (skipFirst) {
							skipFirst = false;
							continue;
						}

						param = param.trim();
						java.util.Iterator<String> i = text.iterator();
						while (i.hasNext())
							// This condition is true whenever the inspected
							// parameter was documented correctly.
							if (i.next().startsWith("@param " + param)) {
								i.remove();
								continue paramLoop;
							}

						// If any parameter lacks proper javadocumentation, then
						// the following will occur.
						failReport += String.format(UNDOCUMENTED_PARAM_PENALTY, param, testedClassName, methodName);
					} // end loop: all actual parameters of this method

					if (hasReturnValue)
						if (1 == text.size() && text.get(0).startsWith("@return "))
							text.pop();
						else {
							failReport += String.format(UNDOCUMENTED_RETURN_PENALTY, testedClassName, methodName);
							continue;
						}

					/*
					 * if (0 != text.size()) failReport += String.format(
					 * "-1: %1s.%2s() has at least one @param or @return statement that is incorrect."
					 * +
					 * "\nThe first word after @param must be the parameter name being described,"
					 * +
					 * "\nand there can only be one @return statement per method."
					 * , testedClassName, methodName) + NEWLINE_CHAR;
					 */
				} // end loop: method signatures, appearing before block
					// opening-braces
			} // end loop: all java files
			catch (java.io.FileNotFoundException e) {
				/* technically impossible */} catch (java.lang.ClassNotFoundException e) {
				failReport += String.format(
						"The tester is unable to assess %s.\n> This is OK is it's an interface or abstract class.\n> This is BAD if it's a class file.\n",
						f.getName());
			} // end catch

		if (!"".equals(failReport))
			fail(failReport + "\nSome of your javadoc is incomplete, according to coding standards."
					+ "\n\n> Every public method should be preceded by a /**multi-line comment block*/."
					+ "\n\n> In the comment block, describe every parameter with a separate line of this format:"
					+ "\n       @param nameOfParameter      description of the parameter" + "\n  Example:"
					+ "\n       @param message              text that will be displayed to the user;"
					+ "\n                                   must be at least 3 characters long"
					+ "\n\n> If the method returns a value, include exactly one line of this format:"
					+ "\n       @return                     description of the value returned" + "\n  Example:"
					+ "\n       @return                     number of NobelPrizeWinners for the specified year" + "\n");
	} // end test
} // end class
