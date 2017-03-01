import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import java.io.FileOutputStream;
import java.io.FileDescriptor;

/**
 * This is a description of a RunTest class.
 * 
 * @author James Pede
 * @version 1.0
 */

class RunTest {
	private final static String NEWLINE_CHAR = System.getProperties().getProperty("line.separator"); // Get
																										// the
																										// println
																										// separator

	private static String expected = "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true"
			+ NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true"
			+ NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true"
			+ NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true"
			+ NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true"
			+ NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true"
			+ NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true"
			+ NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true"
			+ NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true"
			+ NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR + "true" + NEWLINE_CHAR;

	private RunTest() {
	}

	private static ArrayList<String> getLines() {
		ArrayList<String> lst = new ArrayList<String>();

		lst.add("        System.out.println(20 == carStore.howManyBetweenTheseYears(1978, 1991));");
		lst.add("        System.out.println( 0 == carStore.howManyBetweenTheseYears(1972, 1972));");
		lst.add("        System.out.println( 2 == carStore.howManyBetweenTheseYears(1973, 1974));");
		lst.add("        System.out.println(58 == carStore.howManyBetweenTheseYears(1965, 2012));");
		lst.add("        System.out.println(22 == carStore.howManyAreRearWheelDrive());");
		lst.add("        ArrayList<Lamborghini> carsFrom1971 = carStore.getCarsFromThisYear(1971);" + NEWLINE_CHAR
				+ "        for(Lamborghini l : carsFrom1971){" + NEWLINE_CHAR
				+ "            System.out.println(l.getModelName().equals(\"urraco\"));" + NEWLINE_CHAR + "        }");
		lst.add("        ArrayList<Lamborghini> carsFrom1971 = carStore.getCarsFromThisYear(1971);" + NEWLINE_CHAR
				+ "        for(Lamborghini l : carsFrom1971){" + NEWLINE_CHAR
				+ "            System.out.println(l.getModelName().equals(\"urraco\"));" + NEWLINE_CHAR + "        }");
		lst.add("        ArrayList<Lamborghini> carsFrom1981 = carStore.getCarsFromThisYear(1981);" + NEWLINE_CHAR
				+ "        for(Lamborghini l : carsFrom1981){" + NEWLINE_CHAR
				+ "            System.out.println(l.getModelName().equals(\"jalpa\"));" + NEWLINE_CHAR + "        }");
		lst.add("        ArrayList<Lamborghini> carsFrom1981 = carStore.getCarsFromThisYear(1981);" + NEWLINE_CHAR
				+ "        for(Lamborghini l : carsFrom1981){" + NEWLINE_CHAR
				+ "            System.out.println(l.getModelName().equals(\"jalpa\"));" + NEWLINE_CHAR + "        }");
		lst.add("        ArrayList<Lamborghini> carsFrom1972 = carStore.getCarsFromThisYear(1972);" + NEWLINE_CHAR
				+ "        System.out.println(0 == carsFrom1972.size());");
		lst.add("        System.out.println(carStore.getCarsWithHorsepowerRange(300.0,400.0).length == 24);");

		lst.add("        System.out.println(carStore.getCarsWithHorsepowerRange(599.0,600.0).length == 2);");
		lst.add("        System.out.println(carStore.getCarsWithHorsepowerRange(1.0,2.0).length == 0);");
		lst.add("        System.out.println(carStore.hasCarModel(\"COuNtaCHe\"));");
		lst.add("        System.out.println(carStore.hasCarModel(\"tayLoR\") == false);");
		lst.add("        System.out.println(carStore.hasCarModel(null) == false);");
		lst.add("        System.out.println(carStore.getAverageHorsepowerOfYear(1991) == 516.3);");
		lst.add("        System.out.println(carStore.getAverageHorsepowerOfYear(0) == 0.0);");

		lst.add("        System.out.println(2 == bookStore.howManyBooksDidThisAuthorWrite(\"orWell\"));");
		lst.add("        System.out.println(3 == bookStore.howManyBooksDidThisAuthorWrite(\"lawrEnce\"));      ");
		lst.add("        System.out.println(0 == bookStore.howManyBooksDidThisAuthorWrite(\"BCIT\"));");
		lst.add("        System.out.println(bookStore.getAuthorFullName(\"1984\").equals(\"George Orwell\"));              ");
		lst.add("        System.out.println(bookStore.getAuthorFullName(\"of HUMAN bondage\").equals(\"W. Somerset Maugham\"));              ");
		lst.add("        Book[] books = bookStore.getBooksWrittenBy(\"BCIT\");" + NEWLINE_CHAR
				+ "        System.out.println(null == books);");
		lst.add("        Book[] books2 = bookStore.getBooksWrittenBy(\"orWEll\");" + NEWLINE_CHAR
				+ "        System.out.println(books2[0].getTitle().equals(\"1984\"));");
		lst.add("        Book[] books2 = bookStore.getBooksWrittenBy(\"orWEll\");" + NEWLINE_CHAR
				+ "        System.out.println(books2[1].getTitle().equals(\"ANIMAL FARM\"));");

		lst.add("        Book b3 = bookStore.getBookWrittenBy(\"geoRge\");" + NEWLINE_CHAR
				+ "        System.out.println(b3.getAuthorName().equals(\"George Orwell\"));");
		lst.add("        Book b3 = bookStore.getBookWrittenBy(\"geoRge\");" + NEWLINE_CHAR
				+ "        System.out.println(b3.getTitle().equals(\"1984\"));");
		lst.add("        Book b4 = bookStore.getBookWrittenBy(\"aa\");        " + NEWLINE_CHAR
				+ "        System.out.println(b4 == null);");

		lst.add("        Book b5 = bookStore.getBookWrittenBy(\"vladimiR\");        " + NEWLINE_CHAR
				+ "        System.out.println(b5.getAuthorName().equals(\"Vladimir Nabokov\"));");

		lst.add("        Book b5 = bookStore.getBookWrittenBy(\"vladimiR\");        " + NEWLINE_CHAR
				+ "        System.out.println(b5.getTitle().equals(\"LOLITA\"));        ");
		lst.add("        String[] titles = bookStore.getBookTitlesContaining(\"THE\");" + NEWLINE_CHAR
				+ "        System.out.println(47 == titles.length);");

		lst.add("        String[] titles2 = bookStore.getBookTitlesContaining(\"SON\");" + NEWLINE_CHAR
				+ "        System.out.println(5 == titles2.length);");
		lst.add("        System.out.println(group.getTotalInventoryCount() == 20);");
		lst.add("        System.out.println(group.getTotalInventoryCount() == 20);");
		lst.add("        System.out.println(group.hasModelName(\"Taylor\") == false);");
		lst.add("        System.out.println(group.hasModelName(\"jALpA\"));");
		lst.add("        System.out.println(group.getAllCarLotsWithAverageHorsepowerInRangeForYear(1971,370,372).length == 1);  ");
		lst.add("        System.out.println(group.getAllCarLotsWithAverageHorsepowerInRangeForYear(1971,400,500).length == 0);  ");

		return lst;
	}

	public static void run() {
		PrintStream originalOut = new PrintStream(new FileOutputStream(FileDescriptor.out));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(outContent);
		System.setOut(ps);

		ArrayList<String> lst = getLines();

		// Run test assignment
		@SuppressWarnings("unused")
		TestAssignment3 t = new TestAssignment3();
		// read in lines of each file

		String actual = outContent.toString();
		System.setOut(originalOut);
		String[] exp = expected.split("\n");
		String[] act = actual.split("\n");

		// number of lines of each file
		int expected_length = exp.length;
		int actual_length = act.length;

		int issues_found = 0;
		if (expected_length != actual_length) {
			System.out.println("Line mismatch. Found: " + actual_length + ". Expected: " + expected_length);
			return;
		}

		for (int i = 0; i < expected_length; i++) {
			if (!exp[i].equals(act[i])) {
				System.out.println("Expected: \t" + exp[i] + "\nFound: \t\t" + act[i]);
				System.out.println("Test line(s) in error: \n" + lst.get(i));

				System.out.println("========================================================================");
				issues_found++;
			}
		}

		System.out.println("Done! Total Issues Found: " + issues_found);
		System.out.println("========================================================================");
		System.out.println("Remember to have proper style outlined in class!");
		System.out.println("\nGood luck on the final and in COMP 1451, \n -Taylor Dixon");
	}
}