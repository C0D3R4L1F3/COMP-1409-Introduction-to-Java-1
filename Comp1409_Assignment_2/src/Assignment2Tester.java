import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import java.util.Stack;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Assignment1Tester.
 *
 * @author James Pede
 * @version Sep20'15,1200h
 */
public class Assignment2Tester {
	// These data members are the most common information in all tests we could
	// write.
	// NEWLINE consists of the symbols that the manufacturer (IBM / Apple) chose
	// to represent the end of a line of code and the start of a new one.
	// stdOut, outContent, and ps are leveraged to hijack console output
	// so that we can squeeze it through a String and evaluate it.
	// NOTE: It's super important to use stdOut to preserve System.out before
	// hijacking
	// and to always restore stdOut after hijacking.
	// If you don't, BlueJ projects stop println()ing.
	private static final Object[] NO_PARAMETERS = new Object[] {};
	private static final String NEWLINE = System.getProperty("line.separator");
	private static PrintStream stdOut = System.out;
	private static ByteArrayOutputStream outContent;
	private static boolean forbidConsole;
	private PrintStream ps;
	private java.util.Random rng = new java.util.Random();

	// Every data member after this line is particular to the assignment being
	// tested.
	// In order, you will see: ints that index each of the classes being tested,
	// the names of those same classes
	// Strings that represent the names of methods, or the output that methods
	// produce
	private static final int CAR = 0;
	private static final int METER = 1;
	private static final int TICKET = 2;
	private static final String[] CLASSNAME_OF = { "Car", "ParkingMeter", "ParkingTicket" }; // end
																								// array
	private static final String LICENSE = "licensePlate";
	private static final String TRANSMISSION = "transmissionType";
	private static final String ODOMETER = "odometerInKm";
	private static final String PARK_DURATION = "minutesParked";
	private static final String PARK_PAID = "minutesPaid";
	private static final String DEFAULT_LICENSE = "t0p d0g";
	private static Object THIRTEENTH_TICKET = null;

	// This group of data members varies a little bit with each assignment,
	// but in general, they represent parameters that aren't parameters.
	// That is to say, they would normally be passed into test functions
	// as parameters, but in order to keep parameter lists short,
	// we store the information in class variables instead.
	// This kind of practice is admittedly dodgey -- if you ever create a
	// project
	// that uses "parallelization", DON'T USE THIS TECHNIQUE in that project.
	// The variables are followed by what is known as a "static initializer";
	// sort of a constructor that runs once for the entire Tester class..
	private static final Class<?> NOT_IMPLEMENTED = Object.class;
	private static Class<?> lastClass = NOT_IMPLEMENTED;
	private static String lastReflection = null;
	private static Method currentSubtest = null;
	private static String subtestResults = null;
	private static boolean constructorWasAccessible = true;
	private static Class<?>[] CLASS_OF = new Class<?>[CLASSNAME_OF.length];
	private static final Object[] STANDARD_TEST_SUBJECT = new Object[CLASS_OF.length];
	static {
		for (int classIndex = CLASS_OF.length; 0 != classIndex--;)
			try {
				CLASS_OF[classIndex] = Class.forName(CLASSNAME_OF[classIndex]);

			} catch (ClassNotFoundException studentDidNotImplement) {
				CLASS_OF[classIndex] = NOT_IMPLEMENTED;
			} // end try
	} // end static initializer

	/**
	 * Every jUnit module could feature one of these setUp methods. It is run
	 * immediately before every test. We're using setUp to hijack console output
	 * and reset the STANDARD_TEST_SUBJECTs.
	 */
	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		ps = new PrintStream(outContent);
		System.setOut(ps);

		subtestResults = "";
		forbidConsole = true;

		constructCar(DEFAULT_LICENSE);
		STANDARD_TEST_SUBJECT[METER] = worryFreeNew(METER, NO_PARAMETERS);
	} // end preTest

	/**
	 * Like setUp, tearDown occurs for every test -- immediately after them,
	 * that is. Since we hijacked console output in setUp, it is vital that we
	 * reroute output back to the system standard [stdOut]. If we omit this
	 * step, the project will seemingly not produce output until BlueJ is closed
	 * and reopened.
	 * 
	 * We're also doing an interesting this with subtestResults here. This
	 * instance variable works in cooperation with subtest() and process() to
	 * split any one @Test into several tests, each of which can fail() without
	 * preventing another subtest in the group from occuring.
	 */
	@After
	public void tearDown() {
		ps.flush();
		System.setOut(stdOut);
		lastClass = null;
		lastReflection = null;
		currentSubtest = null;

		if (!"".equals(subtestResults))
			fail(subtestResults);
	} // end postTest

	/**
	 * worryFreeNew is the core idea of James Pede designed testing modules. It
	 * uses class INDEXES to replace class names as code. Why do that? Well, if
	 * I were to create your project's objects by naming those classes directly,
	 * the classes would definitely have to exist first. Normally, invocation of
	 * a non-existant class causes a compiler error. However, this tester does
	 * everything possible to avoid compiler-based dependencies. This allows a
	 * larger percentage of projects to be evaluated while incomplete ... which
	 * is not only awesome as a side-by-side development tool, but ensures that
	 * students don't get zero if they wrote and submitted *something*.
	 */
	private static Object worryFreeNew(int classIndex, Object... initargs) {
		lastClass = CLASS_OF[classIndex];
		lastReflection = CLASSNAME_OF[classIndex] + "(" + java.util.Arrays.asList(initargs) + ")";

		for (Constructor<?> c : CLASS_OF[classIndex].getDeclaredConstructors()) {
			try {
				constructorWasAccessible = Modifier.isPublic(c.getModifiers());
				c.setAccessible(true);
				return c.newInstance(initargs);
			} catch (InstantiationException | IllegalAccessException | NoClassDefFoundError
					| IllegalArgumentException localInstantiationException) {
				// No reaction: These are allowed to fail.

			} catch (InvocationTargetException e) {
				// Exceptions of this type are wrappers that are created
				// when a constructor produces an exception of its own.
				// We don't want the 'natural' exception to be wrapped.
				// We want it to escape this process and halt whatever test is
				// in progress.
				if ((e.getTargetException() instanceof RuntimeException))
					throw ((RuntimeException) e.getTargetException());
			} finally {
				c.setAccessible(constructorWasAccessible);
			} // end try
		}

		System.err.println(String.format(
				"Unable to construct %s object.\nI am attempting parameters of a specific type and order." + NEWLINE,
				CLASSNAME_OF[classIndex]));

		CLASS_OF[classIndex] = NOT_IMPLEMENTED;

		return NOT_IMPLEMENTED;
	} // end method

	/**
	 * Where worryFreeNew() allows me to create objects without encoding their
	 * classnames, runMethodVarArgVersion() allows me to run objects' methods
	 * without the requirement that those methods actually exist. Again, this is
	 * so that the tester doesn't gain a dependency on testable classes that may
	 * not be complete.
	 * 
	 * @param classIndex
	 *            a numerical ID for a class, unique to this test module
	 * @param methodName
	 *            a behavior in the identified class, which we wish to invoke
	 * @param parameters
	 *            boundless array of inputs into the method we wish to invoke
	 * @return whatever value the invoked method would normally return
	 */
	private static Object runMethodVarArgVersion(int classIndex, String methodName, Object... parameters) {
		lastClass = CLASS_OF[classIndex];
		lastReflection = methodName + "()";

		if (NOT_IMPLEMENTED == lastClass)
			fail(String.format(
					"%s  This test failed because %s could not be constructed." + NEWLINE
							+ "The most likely explanation is that its constructors have the wrong quantity of parameters.",
					"-1 mark.", CLASSNAME_OF[classIndex], CLASSNAME_OF[classIndex]));

		for (Method m : lastClass.getDeclaredMethods())
			if (m.getName().equals(methodName))
				try {
					Object result = m.invoke(STANDARD_TEST_SUBJECT[classIndex], parameters);
					if (forbidConsole)
						verifyNoOutput();
					return result;

				} catch (ReflectiveOperationException notTheRightSignature) {
					// If all of these fail, then we'll exit the loop eventually
					// and go through the last resort* at the end of this
					// process.
				}

		// * Last Resort: If the method couldn't be identified or run, then we
		// Assert.fail().
		fail(String.format("%s  %s.%s couldn't be used for some reason." + NEWLINE, "-1 mark.",
				CLASSNAME_OF[classIndex], lastReflection));

		return null; // in theory, never happens -- since Assert.fail() is
						// overbearing
	} // end method

	/**
	 * Overloaded version of runMethodVarArgVersion() that runs a parameter-less
	 * method. This is kind of a hack. Java produces warnings when one tries to
	 * use variable-length parameter lists, and I don't want students to be
	 * troubled with messages that are way beyond their learning curriculum.
	 */
	private static Object runMethod(int classIndex, String methodName) {
		return runMethodVarArgVersion(classIndex, methodName, NO_PARAMETERS);
	} // end method

	/**
	 * Overloaded version of runMethodVarArgVersion() that runs a
	 * single-parameter method. I guess you can see the pattern here. If we had
	 * reason to believe your project has two- or three-parameter methods in it,
	 * we'd need a few more versions of runMethod().
	 */
	private static Object runMethod(int classIndex, String methodName, Object parameter) {
		return runMethodVarArgVersion(classIndex, methodName, new Object[] { parameter });
	} // end method

	/**
	 * Overloaded version of runMethodVarArgVersion() that runs a
	 * double-parameter method. Looks like my prediction came true.
	 */
	private static Object runMethod(int classIndex, String methodName, Object param1, Object param2) {
		return runMethodVarArgVersion(classIndex, methodName, new Object[] { param1, param2 });
	} // end method

	/**
	 * This feature of James Pede designed testers works in cooperation with
	 * subtestResults and process() to split a regular @Test into several
	 * subtests. This normally can't be done because any Assert.failure that
	 * occurs within a subtest aborts the whole test. The usage syntax of
	 * subtest() is as follows: subtest("nameOfMethodAppearingInTheTestModule)
	 * .process(parameter1OfSubTest, parameter2OfSubTest, etc)
	 */
	private Assignment2Tester subtest(String methodName) {
		for (Method m : this.getClass().getDeclaredMethods())
			if (m.getName().equals(methodName)) {
				currentSubtest = m;
				break;
			}

		return this;
	} // end method

	/**
	 * This method is called AFTER subtest() to specify a set of parameters to
	 * the prepared subtest. The subtest then calls your project's methods, and
	 * any exceptions in the project, or failures of tests, become caught and
	 * examined here. Any caught failure is stored to a String and revisited
	 * when the overarching test concludes.
	 */
	private Assignment2Tester process(Object... parameters) {
		try {
			currentSubtest.invoke(this, parameters);

		} catch (InvocationTargetException failureWithinSubtest) {
			subtestResults += failureWithinSubtest.getTargetException().getMessage() + NEWLINE;

		} catch (ReflectiveOperationException notTheRightSignature) {
			System.err.println(
					"The author of the testing module has made a horrible error!\nPlease inform them of this problem when you can.");

		}

		return this;
	} // end method

	/**
	 * Call this function to assert that a student's method did not produce
	 * console output (standard screen text).
	 */
	private static void verifyNoOutput() {
		String actual = outContent.toString();
		outContent.reset();
		verifyResult("", actual, "used System.out.print() when it wasn't allowed to");
	} // end method

	/**
	 * Call this function to assert that a student's method DID produce console
	 * output, and that output is exactly the same as an expected String.
	 */
	private void verifyOutput(String expected) {
		String actual = outContent.toString();
		outContent.reset();
		verifyResult(expected, actual, "did not System.out.print() the expected value");
	} // end method

	/**
	 * This function will read an instance variable's contained value even if
	 * that variable is normally shielded from outside observation (with the
	 * 'private' access keyword. Okay, that may defeat one of the purposes of
	 * class structure, but we need some empirical means to determine your
	 * object state. How could I possibly trust that your getters will return
	 * the underlying value? Everything other than the value itself can be
	 * impersonated or misrepresented.
	 */
	private static Object getFieldValue(int classIndex, String fieldName) {
		lastClass = CLASS_OF[classIndex];
		lastReflection = fieldName;

		if (NOT_IMPLEMENTED == lastClass)
			fail(String.format(
					"%s  This test failed because %s could not be constructed." + NEWLINE
							+ "The most likely explanation is that its constructors have the wrong quantity of parameters.",
					"-1 mark.", CLASSNAME_OF[classIndex], CLASSNAME_OF[classIndex]));

		try {
			Field field = lastClass.getDeclaredField(fieldName);

			boolean fieldWasAccessible = field.isAccessible();
			field.setAccessible(true);
			Object result = field.get(STANDARD_TEST_SUBJECT[classIndex]);
			field.setAccessible(fieldWasAccessible);

			return result;

		} catch (ReflectiveOperationException studentMadeImpossible) {
			fail(String.format("%s  %s.%s does not exist." + NEWLINE, "-1 mark.", CLASSNAME_OF[classIndex], fieldName));
		} // end try

		return null; // in theory, never happens -- since Assert.fail() is
						// overbearing
	} // end method

	/**
	 * Change an object's instance variable to hold a desired test value.
	 * Normally constructors or setters would do this, but again, tests need a
	 * means to establish a "control" condition. (That's one that you know
	 * cannot be corrupted from other coders' efforts.)
	 */
	private static void setFieldValue(int classIndex, String fieldName, Object proposedValue) {
		lastClass = CLASS_OF[classIndex];

		try {
			Field field = lastClass.getDeclaredField(fieldName);

			boolean fieldWasAccessible = field.isAccessible();
			field.setAccessible(true);
			field.set(STANDARD_TEST_SUBJECT[classIndex], proposedValue);
			if (!fieldWasAccessible)
				field.setAccessible(false);

		} catch (ReflectiveOperationException studentMadeImpossible) {
			// This method doesn't produce a failure,
			// since it is likely that a subsequent test will fail.
		} // end try
	} // end method

	/**
	 * A common means to perform an assertion that works in our grading, class
	 * name, and method or field name. #lastClass and #lastReflection are set by
	 * runMethod() and getFieldValue().
	 * 
	 * @param expectedValue
	 *            a standard, fixed content to check against
	 * @param actualValue
	 *            value generated by the student to compare to expectedValue
	 * @param failReason
	 *            if expectedValue != actualValue, this is the asserted
	 *            explanation
	 */
	private static void verifyResult(Object expectedValue, Object actualValue, String failReason) {
		assertEquals(
				String.format("%s mark.  %s.%s %s.%s", -1, lastClass.getName(), lastReflection, failReason, NEWLINE),
				expectedValue, actualValue);
	} // end method

	private static void verifyResult(Object expectedValue, Object actualValue) {
		verifyResult(expectedValue, actualValue, "does not have the expected value");
	} // end method

	/**
	 * This function is an attempt to make a common test into a repeatable,
	 * consistent behavior. It checks to see if an object's instance variable
	 * matches an expectation and deducts a fixed amount of points when the test
	 * is failed.
	 */
	private static void verifyFieldValue(int classIndex, String fieldName, Object expectedValue) {
		verifyResult(expectedValue, getFieldValue(classIndex, fieldName));
	} // end method

	/**
	 * Validating a field, in this context, is different from validating its
	 * value. I'm ensuring that the instance variable has the expected variable
	 * type, and above all, that the field exists in the first place.
	 */
	private static Field validateMember(int classIndex, String fieldName, Class<?> expectedType,
			int mandatoryModifiers) {
		lastClass = CLASS_OF[classIndex];
		lastReflection = fieldName;

		if (NOT_IMPLEMENTED == lastClass)
			fail(String.format(
					"%s  This test failed because %s could not be constructed." + NEWLINE
							+ "The most likely explanation is that its constructors have the wrong quantity of parameters.",
					"-1 mark.", CLASSNAME_OF[classIndex], CLASSNAME_OF[classIndex]));

		Field field = null;
		try {
			field = lastClass.getDeclaredField(fieldName);
		} catch (NoSuchFieldException studentMisnamedAField) {
			verifyResult("", studentMisnamedAField.getMessage(), "does not exist");
		} // end try

		verifyResult(expectedType, field.getType(), "does not have the expected variable-type");

		verifyResult(mandatoryModifiers, mandatoryModifiers & field.getModifiers(),
				"did not have the right combination of modifiers");

		return field;
	} // end method

	/**
	 * Most field validations will not include the mandatoryModifiers parameter.
	 * 
	 * @see #validateField(int, String, Class<?>, int)
	 */
	private static Field validateMember(int classIndex, String fieldName, Class<?> expectedType) {
		return validateMember(classIndex, fieldName, expectedType, 0);
	} // end method

	/**
	 * In addition to validating a field (see previous function), it is
	 * important to establish that it was given a non-public access keyword. If
	 * a person does not put the word "private" or "protected" before an
	 * instance variable, that variable gains "package-private" status, which
	 * means that if a new class is written into the same folder, then the new
	 * class can see into your project as if your variables were public. That's
	 * very insecure.
	 */
	@SuppressWarnings("unused")
	private static void validateField(int classIndex, String fieldName, Class<?> expectedType) {
		final int EXPECTED_FLAGS = Modifier.PRIVATE | Modifier.PROTECTED;
		final int ACTUAL_FLAGS = validateMember(classIndex, fieldName, expectedType).getModifiers();
		verifyResult(true, 0 != (ACTUAL_FLAGS & EXPECTED_FLAGS), "is not private or protected");
	} // end method

	/**
	 * Constants are essentially the same as fields, but they belong to the
	 * class (are 'static') and they usually aren't protected. A private
	 * constant is used descriptive purposes, and a public one is used as a
	 * potential parameter from the outside, but what would protected mean? It
	 * makes no sense.
	 */
	@SuppressWarnings("unused")
	private static void validateConstant(int classIndex, String fieldName, Class<?> expectedType,
			Object expectedValue) {
		int settings = validateMember(classIndex, fieldName, expectedType).getModifiers();

		assertTrue(String.format("%s  %s.%s is not private or public." + NEWLINE, "-1 mark.", CLASSNAME_OF[classIndex],
				fieldName), Modifier.isPrivate(settings) || Modifier.isPublic(settings));

		verifyFieldValue(classIndex, fieldName, expectedValue);
	} // end method

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
	private Stack<String> scanIntoStack(Scanner s, String pattern) {
		Stack<String> result = new Stack<String>();

		java.util.regex.Matcher m = java.util.regex.Pattern.compile(pattern, java.util.regex.Pattern.DOTALL)
				.matcher(s.next());

		while (m.find())
			result.push(m.group().replaceAll(NEWLINE, " ").replaceAll("\\s+", " ").trim());

		return result;
	} // end method

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
	@SuppressWarnings("unused")
	private void parseJavadoc(java.io.File file) {
		final String DEFAULT_CLASS_HEADER = "Write a description of class %s here.";
		final String DEFAULT_CLASS_HEADER_PENALTY = "-1 mark.  The class header for '%s' has been left as the BlueJ-generated default."
				+ NEWLINE;
		final String NO_CLASS_HEADER_PENALTY = "-1 mark.  The class header for '%s' is missing." + NEWLINE;
		final String UNDOCUMENTED_PARAM_PENALTY = "-1 mark.  Incorrect javadoc for parameter '%s', before %s.%s()."
				+ NEWLINE;
		final String UNDOCUMENTED_RETURN_PENALTY = "-1 mark.  %s.%s() has an undocumented return value." + NEWLINE;

		// @version Jul8'15,2139h Without the ISO specification, "curly quotes",
		// such as those just used, cause Scanner to parse the file as blank.
		// @ref
		// http://stackoverflow.com/questions/18901316/curly-quotes-causing-java-scanner-hasnextline-to-be-false-why
		Scanner reader = null;
		try {
			reader = new Scanner(file, "ISO-8859-1");
		} catch (java.io.FileNotFoundException e) {
			/* technically impossible */}

		reader.useDelimiter("\\{\\s?[\n\r]+");

		// Obtain a class declaration statement and the javadoc preceding it.
		// The following Regular Expression includes these statements:
		// (?<= \\* ) match some lines that begin space-asterisk-space;
		// this would seem to be the most common indicator
		// of a comment block, where javadoc is expected to be found
		// [\\w\\s]+ a set of words, allowing for punctuation, potentially
		// including spaces or tab-stops, or other kinds of whitespace;
		// this should be the actual human language in a class header
		// | a vertical bar is an OR operator;
		// either the stuff to the left of it, or the right
		// can produce a match, but not both sides together
		// (?<=class )\\w+ match a word following 'class', but don't match
		// 'class' itself;
		// the word is the name of a class, and does not allow whitespace
		//
		// (?<=interface )\\w+ same explanation as previous, but for an
		// interface
		// -- not a class; interfaces must be processed differently
		java.util.Stack<String> text = scanIntoStack(reader,
				"(?<= \\* )[\\w\\s]+|(?<=class )\\w+|(?<=interface )\\w+|(?<=enum )\\w+");
		// @version Jun24'15,????h Enumerated types were a structure that I did
		// not anticipate
		// in my first drafts of this tool.

		if (0 == text.size())
			fail(String.format("You did not declare a class or interface in %s.", file.getName()));

		String testedClassName = text.pop();
		Class<?> testedModule = null;
		try {
			testedModule = Class.forName(testedClassName);

		} catch (java.lang.ClassNotFoundException e) {
			fail(String.format("The tester is unable to assess %s." + NEWLINE
					+ "> This is OK is it's an interface or abstract class." + NEWLINE
					+ "> This is BAD if it's a class file." + NEWLINE, file.getName()));
		} // end catch

		{
			// @version May18'15,1457h Former versions of this code block would
			// crash with an ArrayIndexOutOfBoundsException if the student
			// omitted
			// a class header entirely.
			if (text.isEmpty())
				subtestResults += String.format(NO_CLASS_HEADER_PENALTY, testedClassName);
			else if (String.format(DEFAULT_CLASS_HEADER, testedClassName).equals(text.get(0)))
				subtestResults += String.format(DEFAULT_CLASS_HEADER_PENALTY, testedClassName);
		} // end subroutine: validateClassHeader

		// Identify all the methods that are public members of the subject
		// class. These are the ones we will test.
		java.util.HashSet<String> validMethodNames = new java.util.HashSet<String>();
		validMethodNames.add(testedClassName);
		for (java.lang.reflect.Method method : testedModule.getMethods())
			validMethodNames.add(method.getName());

		while (reader.hasNext()) {
			// Obtain all javadoc for params and returns, or method signatures
			// that could include generics.
			// The following Regular Expression includes these statements:
			// ((?<=\\*)\\s+ match comment lines by their leading asterisk
			// and any quantity of whitespace
			// @(param|return) the javadoc that we evaluate always begins with
			// an ampersand followed by one of these keywords
			// \\s+\\w+ there will be at least one space, potentially more,
			// followed by an unbroken parameterName [a.k.a. 'the symbol']
			//
			// public the presence of this 'access keyword'
			// is the usual giveaway of a method declaration
			// [a.k.a. 'the signature']
			// We do not judge methods that are not public.
			//
			// [\\s0-z]* any number of spaces, letters, or punctuation
			// which will mostly be ignored, but generally constitutes
			// 'the return type'; irrelevant in a constructor
			//
			// \\w+\\([^\\)]*\\) the name of the method, and the round
			// parentheses that likely enclose parameters
			text = scanIntoStack(reader, "((?<=\\*)\\s+@(param|return)\\s+\\S+)|(public[\\s0-z]* \\w+\\([^\\)]*\\))");

			// Unlikely case. Should only occur if the student has included a
			// 'static initializer'.
			if (0 == text.size())
				continue;

			// Separate the method name from its parameter list, using the
			// opening bracket as a delimiter.
			String methodName = text.pop();
			String[] params = methodName.split("\\(\\s?");

			boolean hasReturnValue = true;
			{
				int symbolIndex = params.length - 2;
				// Not sure how this could happen, but I suspect it's possible.
				if (0 > symbolIndex)
					continue;

				// Here, we strip the rest of the signature from the method's
				// name.
				methodName = params[symbolIndex];
				if (methodName.contains(" void "))
					hasReturnValue = false;
				methodName = methodName.substring(methodName.lastIndexOf(" ") + 1);
				if (methodName.equals(testedClassName))
					hasReturnValue = false;

				// Don't process any method that isn't a member of the subject
				// class.
				if (!validMethodNames.contains(methodName))
					continue;

				// Make the types of the parameters into delimiters so the
				// parameter names become isolated.
				// This RegEx contains the following phrases:
				// ? optional whitespace
				// (,|^) has a comma or start-of-input
				// [^\\s\\<]+ some stuff that isn't whitespace; corresponds to
				// parameter type
				// (\\<.+\\>)? optional parameterization of the parameter type;
				// e.g. ArrayList<String>
				params = params[++symbolIndex].split("( ?(,|^) ?[^\\s\\<]+(\\<.+\\>)? )|\\)");
			} // end subroutine: break signature into pieces

			// Match each parameter to a @param statement in the javadoc
			// preceding the method.
			boolean skipFirst = true;
			paramLoop: for (String param : params) {
				// The following once-per-loop case was necessitated by the
				// split() command's unwillingness
				// to omit leading empty-string elements. It'll exclude tailing
				// ones.
				if (skipFirst) {
					skipFirst = false;
					continue;
				}

				param = param.trim();
				java.util.Iterator<String> i = text.iterator();
				while (i.hasNext())
					// This condition is true whenever the inspected parameter
					// was documented correctly.
					if (i.next().startsWith("@param " + param)) {
						i.remove();
						continue paramLoop;
					}

				// If any parameter lacks proper javadocumentation, then the
				// following will occur.
				subtestResults += String.format(UNDOCUMENTED_PARAM_PENALTY, param, testedClassName, methodName);
			} // end loop: all actual parameters of this method

			if (hasReturnValue)
				if (1 == text.size() && text.get(0).startsWith("@return "))
					text.pop();
				else {
					subtestResults += String.format(UNDOCUMENTED_RETURN_PENALTY, testedClassName, methodName);
					continue;
				}

			/*
			 * if (0 != text.size()) subtestResults += String.format(
			 * "-1: %1s.%2s() has at least one @param or @return statement that is incorrect."
			 * +
			 * "\nThe first word after @param must be the parameter name being described,"
			 * + "\nand there can only be one @return statement per method.",
			 * testedClassName, methodName) + NEWLINE_CHAR;
			 */
		} // end loop: method signatures, appearing before block opening-braces
	} // end method

	/**
	 * Include the word "bonus" in code commentary, and explain why you earned
	 * extra marks. If the evaluator agrees with this solicitation, percentage
	 * points -- independent of the assignment's distributed grade -- will be
	 * added to the score. One nice side effect of this offer is that the
	 * seeking mechanism discovers and highlights this comment block right here!
	 * :-D
	 */
	@SuppressWarnings("unused")
	private void seekBonusRequest(java.io.File file) {
		Scanner reader = null;
		try {
			reader = new Scanner(file, "ISO-8859-1");
		} catch (java.io.FileNotFoundException e) {
			/* technically impossible */}

		reader.useDelimiter(NEWLINE);

		int lineNumber = 0;
		String fileName = file.getName();
		boolean thisFileAppearsOnce = (this.getClass().getName() + ".java").equals(fileName);
		String line;
		while (reader.hasNext()) {
			line = reader.next();
			++lineNumber;
			if (line.toUpperCase().contains("BONUS")) {
				stdOut.println(
						String.format("Line %s of %s contains the word \"bonus\":\n%s\n", lineNumber, fileName, line));

				if (thisFileAppearsOnce)
					break;
			} // end if: bonus request discovered!
		} // end loop
	} // end method

	/**
	 * I needed something that condensed the clunky worryFreeNew() creation
	 * technique into something easier to read. The newly created Car is stored
	 * in the STANDARD_TEST_SUBJECT.
	 */
	private static void constructCar(String license) {
		STANDARD_TEST_SUBJECT[CAR] = worryFreeNew(CAR, new Object[] { license });
	} // end method

	/**
	 * Same as previous, but for tickets. We don't want the result to be stored
	 * in STANDARD_TEST_SUBJECT.
	 * 
	 * @return newly created ParkingTicket
	 */
	private static Object constructTicket() {
		return worryFreeNew(TICKET, DEFAULT_LICENSE, 0, 0);
	} // end method

	/**
	 * The STANDARD_TEST_SUBJECT for TICKET couldn't be set in the static
	 * initializer. Not sure why, really. Some timing thing. This method is
	 * called by all tests that will be using a ParkingTicket to ensure that a
	 * live object of this type is available. THIRTEENTH_TICKET is created here
	 * as well. Also, if all the tickets have been prepared previously, it's
	 * still important to establish that lastReflection would have been
	 * "checkParking()".
	 */
	private void initializeTicketsIfNecessary() {
		if (null != THIRTEENTH_TICKET) {
			lastClass = CLASS_OF[TICKET];
			lastReflection = "checkParking()";
			return;
		} // end if

		STANDARD_TEST_SUBJECT[TICKET] = constructTicket();

		for (int i = 12; i-- != 0;)
			THIRTEENTH_TICKET = constructTicket();
	} // end method

	// ------------------------------------
	// ACTUAL JUNIT TEST METHODS BEGIN HERE
	// ------------------------------------

	@Test
	public void javadocJAVADOCjavadoc() {
		subtest("parseJavadoc");
		(new ProjectFileVisitor()).processWorkSubfolders();

		if (!"".equals(subtestResults))
			subtestResults += "\nSome of your javadoc is incomplete, according to coding standards."
					+ "\n\n> Every public method should be preceded by a /**multi-line comment block*/."
					+ "\n\n> In the comment block, describe every parameter with a separate line of this format:"
					+ "\n       @param nameOfParameter      description of the parameter" + "\n  Example:"
					+ "\n       @param message              text that will be displayed to the user;"
					+ "\n                                   must be at least 3 characters long"
					+ "\n\n> If the method returns a value, include exactly one line of this format:"
					+ "\n       @return                     description of the value returned" + "\n  Example:"
					+ "\n       @return                     number of NobelPrizeWinners for the specified year" + "\n";
	} // end method

	@Test
	public void didSomeoneSayBONUS() {
		stdOut.println("\u000c"); // clear the console window (may only work in
									// Windows BlueJ)

		subtest("seekBonusRequest");
		(new ProjectFileVisitor()).processWorkSubfolders();
	} // end method

	public void allFieldsExist() {
		subtest("validateField").process(CAR, LICENSE, String.class).process(CAR, TRANSMISSION, char.class)
				.process(CAR, ODOMETER, double.class).process(CAR, PARK_DURATION, int.class)
				.process(METER, PARK_PAID, int.class);
	} // end test

	public void allConstantsExist() {
		subtest("validateConstant").process(CAR, "MINIMUM_PLATE_LENGTH", int.class, 2)
				.process(CAR, "MAXIMUM_PLATE_LENGTH", int.class, 7).process(CAR, "MANUAL_TRANSMISSION", char.class, 'm')
				.process(CAR, "AUTOMATIC_TRANSMISSION", char.class, 'a');
	} // end test

	public void carConstructorSetsDefaults() {
		subtest("verifyFieldValue").process(CAR, TRANSMISSION, 'a').process(CAR, ODOMETER, 50000.5).process(CAR,
				PARK_DURATION, 0);
	} // end test

	public void carConstructorAcceptsGoodData() {
		constructCar("ok");
		verifyFieldValue(CAR, LICENSE, "ok");

		constructCar("HER BIE");
		verifyFieldValue(CAR, LICENSE, "HER BIE");
	} // end test

	public void carConstructorAcceptsNullLicense() {
		constructCar(null);
		verifyFieldValue(CAR, LICENSE, null);
	} // end test

	public void carConstructorRejectsBadLicense() {
		constructCar("");
		verifyFieldValue(CAR, LICENSE, null);

		constructCar("precious");
		verifyFieldValue(CAR, LICENSE, null);
	} // end test

	public void carLicenseAcceptsGoodData() {
		runMethod(CAR, "setLicensePlate", "TJ");
		verifyFieldValue(CAR, LICENSE, "TJ");

		runMethod(CAR, "setLicensePlate", "2gud4U");
		verifyFieldValue(CAR, LICENSE, "2gud4U");
	} // end test

	public void carLicenseAcceptsNull() {
		runMethod(CAR, "setLicensePlate", null);
		verifyFieldValue(CAR, LICENSE, null);

		runMethod(CAR, "setLicensePlate", "2gud4U");
		verifyFieldValue(CAR, LICENSE, "2gud4U");
	} // end test

	public void carLicenseRejectsBadData() {
		verifyFieldValue(CAR, LICENSE, DEFAULT_LICENSE);

		runMethod(CAR, "setLicensePlate", "x");
		verifyFieldValue(CAR, LICENSE, null);

		runMethod(CAR, "setLicensePlate", "eat at Arby's");
		verifyFieldValue(CAR, LICENSE, null);
	} // end test

	public void carTransmissionAcceptsGoodData() {
		runMethod(CAR, "setTransmissionType", 'm');
		verifyFieldValue(CAR, TRANSMISSION, 'm');

		runMethod(CAR, "setTransmissionType", 'a');
		verifyFieldValue(CAR, TRANSMISSION, 'a');
	} // end test

	public void carTransmissionRejectsBadData() {
		final Object STARTING_TRANSMISSION = getFieldValue(CAR, TRANSMISSION);
		forbidConsole = false;

		runMethod(CAR, "setTransmissionType", '');
		verifyOutput("Installation failure: '' is not a valid transmission type." + NEWLINE);
		verifyFieldValue(CAR, TRANSMISSION, STARTING_TRANSMISSION);

		runMethod(CAR, "setTransmissionType", 'm');

		runMethod(CAR, "setTransmissionType", 'Z');
		verifyOutput("Installation failure: 'Z' is not a valid transmission type." + NEWLINE);
		verifyFieldValue(CAR, TRANSMISSION, 'm');
	} // end test

	public void carOdometerReads50000Point5ByDefault() {
		verifyResult("50000.5 kilometers", runMethod(CAR, "readOdometer"));
	} // end test

	public void carOdometerReads48151Point6WhenChanged() {
		setFieldValue(CAR, ODOMETER, 48151.6);
		verifyResult("48151.6 kilometers", runMethod(CAR, "readOdometer"));
	} // end test

	public void carIsNotUsuallyParked() {
		verifyResult(false, runMethod(CAR, "isParked"));
	} // end test

	public void carIsParkedWhenDurationNotZero() {
		setFieldValue(CAR, PARK_DURATION, 25);
		verifyResult(true, runMethod(CAR, "isParked"));
	} // end test

	public void carParkAcceptsGoodData() {
		runMethod(CAR, "park", 8);
		verifyFieldValue(CAR, PARK_DURATION, 8);

		runMethod(CAR, "park", 69);
		verifyFieldValue(CAR, PARK_DURATION, 69);
	} // end test

	public void carParkRejectsBadData() {
		final Object STARTING_DURATION = getFieldValue(CAR, PARK_DURATION);

		runMethod(CAR, "park", -1);
		verifyFieldValue(CAR, PARK_DURATION, STARTING_DURATION);

		runMethod(CAR, "park", 60);

		runMethod(CAR, "park", Integer.MIN_VALUE);
		verifyFieldValue(CAR, PARK_DURATION, 60);
	} // end test

	public void meterMinutesPaidWorks() {
		for (int sample : new int[] { -7, 42 }) {
			runMethod(METER, "setMinutesPaid", sample);
			verifyResult(METER, runMethod(METER, "getMinutesPaid"));
			verifyFieldValue(METER, PARK_PAID, sample);
			verifyNoOutput();
		} // end loop
	} // end test

	@Test
	public void carMinutesAccessorWorks() {
		for (int sample : new int[] { 0, 747, -32 }) {
			if (0 != sample)
				setFieldValue(CAR, PARK_DURATION, sample);

			verifyResult(sample, runMethod(CAR, "getMinutesParked"));
		} // end loop
	} // end test

	@Test
	public void meterAddMinutesPaidWorks() {
		final int[] inputs = new int[] { 1 + (new java.util.Random()).nextInt(999), -1, 15, 0 }; // end
																									// array

		final int[] outputs = new int[] { 15 + inputs[3], 15, 15, 0 }; // end
																		// array

		for (int i = inputs.length - 1; i != 0; runMethod(METER, "addMinutesPaid", inputs[--i]))
			verifyResult(outputs[i], getFieldValue(METER, PARK_PAID));
	} // end test

	@Test
	public void ticketApprovedWhenOverparked() {
		initializeTicketsIfNecessary();
		if (null == THIRTEENTH_TICKET)
			verifyResult("not null", "null");
		else
			verifyResult(CLASS_OF[TICKET], THIRTEENTH_TICKET.getClass());
	} // end test

	@Test
	public void ticketDeniedWhenExactlyParked() {
		verifyResult(null, runMethod(TICKET, "checkParking", STANDARD_TEST_SUBJECT[CAR], STANDARD_TEST_SUBJECT[METER]));
	} // end test

	@Test
	public void ticketDeniedWhenUnderparked() {
		setFieldValue(CAR, PARK_DURATION, -1);
		ticketDeniedWhenExactlyParked();
	} // end test

	private void performCalculateFineTest(int overparkMagnitude, double expectedFine) {
		initializeTicketsIfNecessary();
		setFieldValue(TICKET, "carMinutesParked", overparkMagnitude);
		verifyResult(expectedFine, runMethod(TICKET, "calculateFine"));
	} // end method

	@Test
	public void ticketCalculatesPreHour() {
		performCalculateFineTest(59, 21);
	} // end test

	@Test
	public void ticketCalculatesOnHour() {
		performCalculateFineTest(60, 31.5);
	} // end test

	@Test
	public void ticketCalculatesPostHour() {
		performCalculateFineTest(61, 31.5);
	} // end test

	@Test
	public void ticketCalculatesPiHour() {
		performCalculateFineTest(194, 52.5);
	} // end test

	@Test
	public void ticketCalculatesNegativeMeaningOfLife() {
		performCalculateFineTest(-42, 21);
	} // end test

	@Test
	public void ticketCalculatesNegativeThreeHalfHours() {
		performCalculateFineTest(-90, 10.5);
	} // end test

	@Test
	public void ticketReferenceChecksOut1Time() {
		initializeTicketsIfNecessary();
		verifyFieldValue(TICKET, "referenceNumber", "V1000");
	} // end test

	@Test
	public void ticketReferenceChecksOut13Times() {
		initializeTicketsIfNecessary();
		final Object SAVED_STANDARD = STANDARD_TEST_SUBJECT[TICKET];
		STANDARD_TEST_SUBJECT[TICKET] = THIRTEENTH_TICKET;
		try {
			verifyFieldValue(TICKET, "referenceNumber", "V1012");
		} catch (Throwable usuallyTestFailure) {
			throw usuallyTestFailure;
		} finally {
			STANDARD_TEST_SUBJECT[TICKET] = SAVED_STANDARD;
		} // end try: ensure that standard subjects are restored even when test
			// fails
	} // end test

	@Test
	public void ticketDetailsLessThanAnHourInfraction() {
		// pass a reduction on carMinutesParked to our other test method
		// via a hidden parameter (value of minutesParked in
		// STANDARD_TEST_SUBJECT).
		setFieldValue(CAR, PARK_DURATION, 1 + rng.nextInt(59));
		ticketDetailsExactlyOneHourInfraction();
	} // end test

	@Test
	public void ticketDetailsExactlyOneHourInfraction() {
		initializeTicketsIfNecessary();
		final String RANDOM_REFERENCE = String.valueOf(rng.nextInt(100000));
		final String RANDOM_LICENSE = String.valueOf(rng.nextInt(1000000));
		final int RANDOM_PAID = 0 + rng.nextInt(600);
		final int RANDOM_PARK = RANDOM_PAID + 60 - (int) getFieldValue(CAR, PARK_DURATION);
		final String CALCULATED_FINE = (60 == RANDOM_PARK - RANDOM_PAID) ? "31.50" : "21.00";
		forbidConsole = false;

		final Object SAVED_STANDARD = STANDARD_TEST_SUBJECT[TICKET];
		STANDARD_TEST_SUBJECT[TICKET] = constructTicket();
		try {
			setFieldValue(TICKET, "meterMinutesPaid", RANDOM_PAID);
			setFieldValue(TICKET, "carMinutesParked", RANDOM_PARK);
			setFieldValue(TICKET, "carLicensePlate", RANDOM_LICENSE);
			setFieldValue(TICKET, "referenceNumber", RANDOM_REFERENCE);
			runMethod(TICKET, "printDetails");
			verifyOutput(String.format(
					"Ticket Number: %s%sVehicle ID \"%s\"%sparked %s minutes, paid for %s%sFine due: $%s%s",
					RANDOM_REFERENCE, NEWLINE, RANDOM_LICENSE, NEWLINE, RANDOM_PARK, RANDOM_PAID, NEWLINE,
					CALCULATED_FINE, NEWLINE));
		} catch (Throwable usuallyTestFailure) {
			throw usuallyTestFailure;
		} finally {
			STANDARD_TEST_SUBJECT[TICKET] = SAVED_STANDARD;
		} // end try: ensure that standard subjects are restored even when test
			// fails
	} // end test

	@Test
	public void ticketClassVariablesExist() {
		validateMember(TICKET, "count", int.class, Modifier.STATIC);
	} // end test

	@Test
	public void ticketFieldsExist() {
		validateMember(TICKET, "referenceNumber", String.class, Modifier.FINAL);
		validateMember(TICKET, "carLicensePlate", String.class, Modifier.FINAL);
		validateMember(TICKET, "carMinutesParked", int.class);
		validateMember(TICKET, "meterMinutesPaid", int.class);
	} // end test

	@Test
	public void isBackwardsCompatible() {
		for (String a1TestName : new String[] { "allFieldsExist", "allConstantsExist", "carConstructorSetsDefaults",
				"carConstructorAcceptsGoodData", "carConstructorAcceptsNullLicense", "carConstructorSetsDefaults",
				"carConstructorRejectsBadLicense", "carLicenseAcceptsGoodData", "carLicenseAcceptsNull",
				"carLicenseRejectsBadData", "carTransmissionAcceptsGoodData", "carTransmissionRejectsBadData",
				"carOdometerReads50000Point5ByDefault", "carOdometerReads48151Point6WhenChanged",
				"carIsNotUsuallyParked", "carIsParkedWhenDurationNotZero", "carParkAcceptsGoodData",
				"carParkRejectsBadData", }) {
			subtest(a1TestName).process(NO_PARAMETERS);

			if (0 == subtestResults.length())
				setUp();
			else {
				subtestResults = "-2 marks.  Assignment1Tester." + a1TestName + "() failed unexpectedly!" + NEWLINE
						+ NEWLINE + subtestResults.replaceAll("-\\d marks?.  ", "");
				fail();
			}
		} // end loop: all Assignment One tests intended to succeed

		subtest("meterMinutesPaidWorks").process(NO_PARAMETERS);
		String expectedFail = subtestResults.replaceAll("-\\d marks?.  ", "");
		setUp();
		assertEquals(
				"-2 marks.  Assignment1Tester.meterMinutesPaidWorks() did not produce the expected failure message."
						+ NEWLINE,
				"ParkingMeter.setMinutesPaid() couldn't be used for some reason." + NEWLINE + NEWLINE, expectedFail);
	} // end supertest

	@Test
	public void ticketConstructorsWork() {
		for (Object[] parameterSet : new Object[][] { new Object[] { DEFAULT_LICENSE, 0, 0 },
				new Object[] { STANDARD_TEST_SUBJECT[CAR], STANDARD_TEST_SUBJECT[METER] } }) {
			verifyResult(true, NOT_IMPLEMENTED != worryFreeNew(TICKET, parameterSet), "cannot be invoked");
			verifyResult(false, constructorWasAccessible, "was public, contrary to instructions");
		}
	} // end test

	// -------------------------
	// END OF JUNIT TEST METHODS
	// -------------------------

	// According to Kolling and Barnes,
	// inner classes should always appear at the end of the class that contains
	// them:

	/**
	 * This is a tiny mechanism that qualifies the files that are given to it
	 * during Files.walkFileTree(). The Javadoc Test and Bonus Seeker want to
	 * only consider files with the .java extension, found within the working
	 * directory.
	 */
	private class ProjectFileVisitor extends java.nio.file.SimpleFileVisitor<java.nio.file.Path> {
		@Override
		public java.nio.file.FileVisitResult visitFile(java.nio.file.Path file,
				java.nio.file.attribute.BasicFileAttributes attrs) {
			if (file.toString().endsWith(".java"))
				process(file.toFile());
			return java.nio.file.FileVisitResult.CONTINUE;
		} // end FileVisitor method

		public void processWorkSubfolders() {
			try {
				java.nio.file.Files.walkFileTree(new java.io.File(".").toPath(), this);
			} catch (java.io.IOException whenDriveUnresponsive) {
				throw new RuntimeException(whenDriveUnresponsive);
			} // end try
		} // end class method
	} // end inner class
} // end class
