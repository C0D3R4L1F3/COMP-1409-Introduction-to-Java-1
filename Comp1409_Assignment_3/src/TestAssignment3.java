import java.util.ArrayList;

/**
 * This is a description of a TestAssignment3 class.
 * 
 * @author James Pede
 * @version 1.0
 */
public class TestAssignment3 {
	private LamborghiniCarLot carStore;
	private BookStore bookStore;

	public TestAssignment3() {
		carStore = new LamborghiniCarLot("");
		bookStore = new BookStore();

		/* test the cars */
		System.out.println(20 == carStore.howManyBetweenTheseYears(1978, 1991));
		System.out.println(0 == carStore.howManyBetweenTheseYears(1972, 1972));
		System.out.println(2 == carStore.howManyBetweenTheseYears(1973, 1974));
		System.out.println(58 == carStore.howManyBetweenTheseYears(1965, 2012));

		System.out.println(22 == carStore.howManyAreRearWheelDrive());

		ArrayList<Lamborghini> carsFrom1971 = carStore.getCarsFromThisYear(1971);
		for (Lamborghini l : carsFrom1971) {
			System.out.println(l.getModelName().equals("urraco"));
		}

		ArrayList<Lamborghini> carsFrom1981 = carStore.getCarsFromThisYear(1981);
		for (Lamborghini l : carsFrom1981) {
			System.out.println(l.getModelName().equals("jalpa"));
		}

		ArrayList<Lamborghini> carsFrom1972 = carStore.getCarsFromThisYear(1972);
		System.out.println(0 == carsFrom1972.size());

		System.out.println(carStore.getCarsWithHorsepowerRange(300.0, 400.0).length == 24);
		System.out.println(carStore.getCarsWithHorsepowerRange(599.0, 600.0).length == 2);
		System.out.println(carStore.getCarsWithHorsepowerRange(1.0, 2.0).length == 0);
		System.out.println(carStore.hasCarModel("COuNtaCHe"));
		System.out.println(carStore.hasCarModel("tayLoR") == false);
		System.out.println(carStore.hasCarModel(null) == false);
		System.out.println(carStore.getAverageHorsepowerOfYear(1991) == 516.3);
		System.out.println(carStore.getAverageHorsepowerOfYear(0) == 0.0);

		/* test the books */
		System.out.println(2 == bookStore.howManyBooksDidThisAuthorWrite("orWell"));
		System.out.println(3 == bookStore.howManyBooksDidThisAuthorWrite("lawrEnce"));
		System.out.println(0 == bookStore.howManyBooksDidThisAuthorWrite("BCIT"));

		System.out.println(bookStore.getAuthorFullName("1984").equals("George Orwell"));
		System.out.println(bookStore.getAuthorFullName("of HUMAN bondage").equals("W. Somerset Maugham"));

		Book[] books = bookStore.getBooksWrittenBy("BCIT");
		System.out.println(books == null);

		Book[] books2 = bookStore.getBooksWrittenBy("orWEll");
		System.out.println(books2[0].getTitle().equals("1984"));
		System.out.println(books2[1].getTitle().equals("ANIMAL FARM"));

		Book b3 = bookStore.getBookWrittenBy("geoRge");
		System.out.println(b3.getAuthorName().equals("George Orwell"));
		System.out.println(b3.getTitle().equals("1984"));

		Book b4 = bookStore.getBookWrittenBy("aaa");
		System.out.println(b4 == null);

		Book b5 = bookStore.getBookWrittenBy("vladimiR");
		System.out.println(b5.getAuthorName().equals("Vladimir Nabokov"));
		System.out.println(b5.getTitle().equals("LOLITA"));

		String[] titles = bookStore.getBookTitlesContaining("THE");
		System.out.println(47 == titles.length);

		String[] titles2 = bookStore.getBookTitlesContaining("SON");
		System.out.println(5 == titles2.length);

		LamborghiniDealershipGroup group = new LamborghiniDealershipGroup();
		ArrayList<Lamborghini> inventory1 = new ArrayList<Lamborghini>();
		ArrayList<Lamborghini> inventory2 = new ArrayList<Lamborghini>();

		inventory1.add(new Lamborghini(1965, "350GT", 365.3, true));
		inventory1.add(new Lamborghini(1966, "400GT 2+2", 366.3, false));
		inventory1.add(new Lamborghini(1967, "MIURA", 367.3, true));
		inventory1.add(new Lamborghini(1968, "espada", 368.3, false));
		inventory1.add(new Lamborghini(1969, "islero", 369.3, true));
		inventory1.add(new Lamborghini(1970, "jarama", 370.3, false));
		inventory1.add(new Lamborghini(1971, "urraco", 371.3, false));
		inventory1.add(new Lamborghini(1971, "urraco", 371.3, false));
		inventory1.add(new Lamborghini(1973, "countache", 373.3, false));
		inventory1.add(new Lamborghini(1974, "silhouette", 374.3, false));
		inventory1.add(new Lamborghini(1975, "jalpa", 375.3, true));

		inventory2.add(new Lamborghini(2005, "murcielago", 505.3, true));
		inventory2.add(new Lamborghini(2006, "gallardo", 506.3, true));
		inventory2.add(new Lamborghini(2007, "gallardo", 507.3, true));
		inventory2.add(new Lamborghini(2008, "reventon", 308.3, false));
		inventory2.add(new Lamborghini(2008, "reventon", 508.3, true));
		inventory2.add(new Lamborghini(2009, "gallardo", 409.3, true));
		inventory2.add(new Lamborghini(2010, "murcielago", 310.3, false));
		inventory2.add(new Lamborghini(2011, "aventador", 411.3, false));
		inventory2.add(new Lamborghini(2012, "sesto elemento", 512.3, true));

		LamborghiniCarLot carlot1 = new LamborghiniCarLot();
		LamborghiniCarLot carlot2 = new LamborghiniCarLot();

		carlot1.setInventory(inventory1);
		carlot2.setInventory(inventory2);

		group.addCarLot(carlot1);
		group.addCarLot(carlot2);

		System.out.println(group.getTotalInventoryCount() == 20);
		System.out.println(group.getTotalInventoryCount() == 20);
		System.out.println(group.hasModelName("Taylor") == false);
		System.out.println(group.hasModelName("jALpA"));

		System.out.println(group.getAllCarLotsWithAverageHorsepowerInRangeForYear(1971, 370, 372).length == 1);
		System.out.println(group.getAllCarLotsWithAverageHorsepowerInRangeForYear(1971, 400, 500).length == 0);

	}
}
