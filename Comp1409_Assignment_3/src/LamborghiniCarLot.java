import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is a description of LamborghiniCarLot class.
 * 
 * @author Ronnie Manimtim
 * @version 12/04/2015
 */
public class LamborghiniCarLot {
	private String lotName; // e.g "Jason's Used Lambos"
	private ArrayList<Lamborghini> inventory; // Collection of Lamborghini
												// objects

	private static final int DEFAULT_COUNT = 0;
	private static final double DEFAULT_HP = 0.0;
	private static final double DEFAULT_TOTAL_HP = 0.0;
	private static final String DEFAULT_LOT_NAME = "Jason's Used Lambos";
	private static final String CAN_NOT_BE_THIS_LOT_NAME = "Taylor's Used Lambos";

	private static final double GT_HP_ONE = 365.3;
	private static final double GT_HP_TWO = 366.3;
	private static final double MIURA_HP_ONE = 367.3;
	private static final double ESPADA_HP_ONE = 368.3;
	private static final double ISLERO_HP_ONE = 369.3;
	private static final double JARAMA_HP_ONE = 370.3;
	private static final double URRACO_HP_ONE = 371.3;
	private static final double COUNTACHE_HP_ONE = 373.3;
	private static final double SILHOUETTE_HP_ONE = 374.3;
	private static final double JALPA_HP_ONE = 375.3;
	private static final double SILHOUETTE_HP_TWO = 476.3;
	private static final double SILHOUETTE_HP_THREE = 377.3;
	private static final double COUNTACHE_HP_TWO = 478.3;
	private static final double COUNTACHE_HP_THREE = 578.3;
	private static final double COUNTACHE_HP_FOUR = 378.3;
	private static final double SILHOUETTE_HP_FOUR = 479.3;
	private static final double COUNTACHE_HP_FIVE = 580.3;
	private static final double JALPA_HP_TWO = 381.3;
	private static final double JALPA_HP_THREE = 481.3;
	private static final double COUNTACHE_HP_SIX = 582.3;
	private static final double COUNTACHE_HP_SEVEN = 383.3;
	private static final double COUNTACHE_HP_EIGHT = 484.3;
	private static final double COUNTACHE_HP_NINE = 585.3;
	private static final double LMZEROZEROTWO_HP_ONE = 386.3;
	private static final double JALPA_HP_FOUR = 487.3;
	private static final double COUNTACHE_HP_TEN = 588.3;
	private static final double COUNTACHE_HP_ELEVEN = 389.3;
	private static final double DIABLO_HP_ONE = 490.3;
	private static final double LMZEROZEROTWO_HP_TWO = 591.3;
	private static final double LMZEROZEROTWO_HP_THREE = 391.3;
	private static final double LMZEROZEROTWO_HP_FOUR = 491.3;
	private static final double LMZEROZEROTWO_HP_FIVE = 392.3;
	private static final double LMZEROZEROTWO_HP_SIX = 493.3;
	private static final double DIABLO_HP_TWO = 594.3;
	private static final double DIABLO_HP_THREE = 394.3;
	private static final double DIABLO_HP_FOUR = 495.3;
	private static final double DIABLO_HP_FIVE = 596.3;
	private static final double DIABLO_HP_SIX = 397.3;
	private static final double DIABLO_HP_SEVEN = 498.3;
	private static final double DIABLO_HP_EIGHT = 599.3;
	private static final double DIABLO_HP_NINE = 400.3;
	private static final double DIABLO_HP_TEN = 500.3;
	private static final double MURCIELAGO_HP_ONE = 501.3;
	private static final double MURCIELAGO_HP_TWO = 502.3;
	private static final double GALLARDO_HP_ONE = 303.3;
	private static final double MURCIELAGO_HP_THREE = 404.3;
	private static final double MURCIELAGO_HP_FOUR = 505.3;
	private static final double GALLARDO_HP_TWO = 506.3;
	private static final double GALLARDO_HP_THREE = 507.3;
	private static final double REVENTON_HP_ONE = 308.3;
	private static final double REVENTON_HP_TWO = 508.3;
	private static final double GALLARDO_HP_FOUR = 409.3;
	private static final double MURCIELAGO_HP_FIVE = 310.3;
	private static final double AVENTADOR_HP_ONE = 411.3;
	private static final double SESTO_ELEMENTO_HP_ONE = 512.3;

	private static final int YEAR_ONE = 1965;
	private static final int YEAR_TWO = 1966;
	private static final int YEAR_THREE = 1967;
	private static final int YEAR_FOUR = 1968;
	private static final int YEAR_FIVE = 1969;
	private static final int YEAR_SIX = 1970;
	private static final int YEAR_SEVEN = 1971;
	private static final int YEAR_EIGHT = 1973;
	private static final int YEAR_NINE = 1974;
	private static final int YEAR_TEN = 1975;
	private static final int YEAR_ELEVEN = 1976;
	private static final int YEAR_TWELVE = 1977;
	private static final int YEAR_THIRTEEN = 1978;
	private static final int YEAR_FOURTEEN = 1980;
	private static final int YEAR_FIFTEEN = 1981;
	private static final int YEAR_SIXTEEN = 1979;
	private static final int YEAR_SEVENTEEN = 1982;
	private static final int YEAR_EIGHTEEN = 1983;
	private static final int YEAR_NINETEEN = 1984;
	private static final int YEAR_TWENTY = 1985;
	private static final int YEAR_TWENTY_ONE = 1986;
	private static final int YEAR_TWENTY_THREE = 1987;
	private static final int YEAR_TWENTY_FOUR = 1988;
	private static final int YEAR_TWENTY_FIVE = 1989;
	private static final int YEAR_TWENTY_SIX = 1990;
	private static final int YEAR_TWENTY_SEVEN = 1991;
	private static final int YEAR_TWENTY_EIGHT = 1992;
	private static final int YEAR_TWENTY_NINE = 1993;
	private static final int YEAR_THIRTY = 1994;
	private static final int YEAR_THIRTY_ONE = 1995;
	private static final int YEAR_THIRTY_TWO = 1996;
	private static final int YEAR_THIRTY_THREE = 1997;
	private static final int YEAR_THIRTY_FOUR = 1998;
	private static final int YEAR_THIRTY_FIVE = 1999;
	private static final int YEAR_THIRTY_SIX = 2000;
	private static final int YEAR_THIRTY_SEVEN = 2001;
	private static final int YEAR_THIRTY_EIGHT = 2002;
	private static final int YEAR_THIRTY_NINE = 2003;
	private static final int YEAR_FOURTY = 2004;
	private static final int YEAR_FOURTY_ONE = 2005;
	private static final int YEAR_FOURTY_TWO = 2006;
	private static final int YEAR_FOURTY_THREE = 2007;
	private static final int YEAR_FOURTY_FOUR = 2008;
	private static final int YEAR_FOURTY_FIVE = 2009;
	private static final int YEAR_FOURTY_SIX = 2010;
	private static final int YEAR_FOURTY_SEVEN = 2011;
	private static final int YEAR_FOURTY_EIGHT = 2012;

	/**
	 * This constructor creates the inventory ArrayList the inventory reamains
	 * empty no Lamborghini objects are added when this constructor is called.
	 */
	public LamborghiniCarLot() {
		inventory = new ArrayList<Lamborghini>();
	}

	/**
	 * This constructor creates the inventory ArrayList object and stores the
	 * lotName only if it is does not equalt to "Taylor's Used Lambos", if so
	 * then it will be stored as "Jason's Used Lambos" instead.
	 * 
	 * @param lotName
	 *            the name of the lot.
	 */
	public LamborghiniCarLot(String lotName) {
		if (lotName.equals(CAN_NOT_BE_THIS_LOT_NAME)) {
			this.lotName = DEFAULT_LOT_NAME;
		} else {
			this.lotName = lotName;
		}

		inventory = new ArrayList<Lamborghini>();

		inventory.add(new Lamborghini(YEAR_ONE, "350GT", GT_HP_ONE, true));
		inventory.add(new Lamborghini(YEAR_TWO, "400GT 2+2", GT_HP_TWO, false));
		inventory.add(new Lamborghini(YEAR_THREE, "MIURA", MIURA_HP_ONE, true));
		inventory.add(new Lamborghini(YEAR_FOUR, "espada", ESPADA_HP_ONE, false));
		inventory.add(new Lamborghini(YEAR_FIVE, "islero", ISLERO_HP_ONE, true));
		inventory.add(new Lamborghini(YEAR_SIX, "jarama", JARAMA_HP_ONE, false));
		inventory.add(new Lamborghini(YEAR_SEVEN, "urraco", URRACO_HP_ONE, false));
		inventory.add(new Lamborghini(YEAR_SEVEN, "urraco", URRACO_HP_ONE, false));
		inventory.add(new Lamborghini(YEAR_EIGHT, "countache", COUNTACHE_HP_ONE, false));
		inventory.add(new Lamborghini(YEAR_NINE, "silhouette", SILHOUETTE_HP_ONE, false));
		inventory.add(new Lamborghini(YEAR_TEN, "jalpa", JALPA_HP_ONE, true));
		inventory.add(new Lamborghini(YEAR_ELEVEN, "silhouette", SILHOUETTE_HP_TWO, false));
		inventory.add(new Lamborghini(YEAR_TWELVE, "silhouette", SILHOUETTE_HP_THREE, true));
		inventory.add(new Lamborghini(YEAR_THIRTEEN, "countache", COUNTACHE_HP_TWO, false));
		inventory.add(new Lamborghini(YEAR_THIRTEEN, "countache", COUNTACHE_HP_THREE, false));
		inventory.add(new Lamborghini(YEAR_THIRTEEN, "countache", COUNTACHE_HP_FOUR, true));
		inventory.add(new Lamborghini(YEAR_SIXTEEN, "silhouette", SILHOUETTE_HP_FOUR, false));
		inventory.add(new Lamborghini(YEAR_FOURTEEN, "countache", COUNTACHE_HP_FIVE, false));
		inventory.add(new Lamborghini(YEAR_FIFTEEN, "jalpa", JALPA_HP_TWO, true));
		inventory.add(new Lamborghini(YEAR_FIFTEEN, "jalpa", JALPA_HP_THREE, true));
		inventory.add(new Lamborghini(YEAR_SEVENTEEN, "countache", COUNTACHE_HP_SIX, true));
		inventory.add(new Lamborghini(YEAR_EIGHTEEN, "countache", COUNTACHE_HP_SEVEN, false));
		inventory.add(new Lamborghini(YEAR_NINETEEN, "countache", COUNTACHE_HP_EIGHT, false));
		inventory.add(new Lamborghini(YEAR_TWENTY, "countache", COUNTACHE_HP_NINE, false));
		inventory.add(new Lamborghini(YEAR_TWENTY_ONE, "lm002", LMZEROZEROTWO_HP_ONE, true));
		inventory.add(new Lamborghini(YEAR_TWENTY_THREE, "jalpa", JALPA_HP_FOUR, false));
		inventory.add(new Lamborghini(YEAR_TWENTY_FOUR, "countache", COUNTACHE_HP_TEN, false));
		inventory.add(new Lamborghini(YEAR_TWENTY_FIVE, "countache", COUNTACHE_HP_ELEVEN, true));
		inventory.add(new Lamborghini(YEAR_TWENTY_SIX, "diablo", DIABLO_HP_ONE, false));
		inventory.add(new Lamborghini(YEAR_TWENTY_SEVEN, "lm002", LMZEROZEROTWO_HP_TWO, false));
		inventory.add(new Lamborghini(YEAR_TWENTY_SEVEN, "lm002", LMZEROZEROTWO_HP_THREE, true));
		inventory.add(new Lamborghini(YEAR_TWENTY_SEVEN, "lm002", LMZEROZEROTWO_HP_FOUR, false));
		inventory.add(new Lamborghini(YEAR_TWENTY_SEVEN, "lm002", LMZEROZEROTWO_HP_TWO, true));
		inventory.add(new Lamborghini(YEAR_TWENTY_EIGHT, "lm002", LMZEROZEROTWO_HP_FIVE, false));
		inventory.add(new Lamborghini(YEAR_TWENTY_NINE, "lm002", LMZEROZEROTWO_HP_SIX, false));
		inventory.add(new Lamborghini(YEAR_THIRTY, "diablo", DIABLO_HP_TWO, false));
		inventory.add(new Lamborghini(YEAR_THIRTY, "diablo", DIABLO_HP_THREE, true));
		inventory.add(new Lamborghini(YEAR_THIRTY_ONE, "diablo", DIABLO_HP_FOUR, false));
		inventory.add(new Lamborghini(YEAR_THIRTY_TWO, "diablo", DIABLO_HP_FIVE, false));
		inventory.add(new Lamborghini(YEAR_THIRTY_THREE, "diablo", DIABLO_HP_SIX, false));
		inventory.add(new Lamborghini(YEAR_THIRTY_FOUR, "diablo", DIABLO_HP_SEVEN, false));
		inventory.add(new Lamborghini(YEAR_THIRTY_FIVE, "diablo", DIABLO_HP_EIGHT, false));
		inventory.add(new Lamborghini(YEAR_THIRTY_FIVE, "diablo", DIABLO_HP_EIGHT, false));
		inventory.add(new Lamborghini(YEAR_THIRTY_SIX, "diablo", DIABLO_HP_NINE, false));
		inventory.add(new Lamborghini(YEAR_THIRTY_SIX, "diablo", DIABLO_HP_TEN, false));
		inventory.add(new Lamborghini(YEAR_THIRTY_SEVEN, "murcielago", MURCIELAGO_HP_ONE, false));
		inventory.add(new Lamborghini(YEAR_THIRTY_EIGHT, "murcielago", MURCIELAGO_HP_TWO, false));
		inventory.add(new Lamborghini(YEAR_THIRTY_NINE, "gallardo", GALLARDO_HP_ONE, true));
		inventory.add(new Lamborghini(YEAR_FOURTY, "murcielago", MURCIELAGO_HP_THREE, true));
		inventory.add(new Lamborghini(YEAR_FOURTY_ONE, "murcielago", MURCIELAGO_HP_FOUR, true));
		inventory.add(new Lamborghini(YEAR_FOURTY_TWO, "gallardo", GALLARDO_HP_TWO, true));
		inventory.add(new Lamborghini(YEAR_FOURTY_THREE, "gallardo", GALLARDO_HP_THREE, true));
		inventory.add(new Lamborghini(YEAR_FOURTY_FOUR, "reventon", REVENTON_HP_ONE, false));
		inventory.add(new Lamborghini(YEAR_FOURTY_FOUR, "reventon", REVENTON_HP_TWO, true));
		inventory.add(new Lamborghini(YEAR_FOURTY_FIVE, "gallardo", GALLARDO_HP_FOUR, true));
		inventory.add(new Lamborghini(YEAR_FOURTY_SIX, "murcielago", MURCIELAGO_HP_FIVE, false));
		inventory.add(new Lamborghini(YEAR_FOURTY_SEVEN, "aventador", AVENTADOR_HP_ONE, false));
		inventory.add(new Lamborghini(YEAR_FOURTY_EIGHT, "sesto elemento", SESTO_ELEMENTO_HP_ONE, true));
	}

	/**
	 * @return the inventory of Lamborghini's.
	 */
	public ArrayList<Lamborghini> getInventory() {
		return inventory;
	}

	/**
	 * @param inventory
	 *            the inventory of Lamborghini's
	 */
	public void setInventory(ArrayList<Lamborghini> inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the lot name.
	 */
	public String getLotName() {
		return lotName;
	}

	/**
	 * @param lotName
	 *            the name of the lot.
	 */
	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

	/**
	 * @param newLamborghini
	 *            a Lamborghini will be added to the inventory, if
	 *            newLamborghini is null it will not be added to the inventory.
	 */
	public void addLamborghini(Lamborghini newLamborghini) {
		if (newLamborghini != null) {
			inventory.add(newLamborghini);
		}
	}

	/**
	 * @param startYear
	 *            the start year of howManyBetweenTheseYears
	 * @param endYear
	 *            the end year of howManyBetweenTheseYears
	 * @return the number of Lamborghini's in the invenotry whose model year is
	 *         between startYear and endYear inclusive.
	 */
	public int howManyBetweenTheseYears(int startYear, int endYear) {
		int numberOfLambo = DEFAULT_COUNT;

		for (Lamborghini l : inventory) {
			if ((l.getModelYear() >= startYear) && (l.getModelYear() <= endYear)) {
				numberOfLambo++;
			}
		}
		return numberOfLambo;
	}

	/**
	 * @return the number of Lamborghini's in the inventory that are rear wheel
	 *         drive.
	 */
	public int howManyAreRearWheelDrive() {
		int numberOfLambo = DEFAULT_COUNT;
		Iterator<Lamborghini> it = inventory.iterator();

		while (it.hasNext()) {
			Lamborghini lamborghini = it.next();

			if (lamborghini.getIsRearWheelDrive() == true) {
				numberOfLambo++;
			}
		}
		return numberOfLambo;
	}

	/**
	 * @param year
	 *            the year of Lamorghini to get fromt the ArrayList
	 * @return an empty ArrayList if there are no Lamborghini objects for the
	 *         year specified in the parameter otherwise; returns an ArrayList
	 *         of Lamborghini objects if within the years specified.
	 */
	public ArrayList<Lamborghini> getCarsFromThisYear(int year) {
		ArrayList<Lamborghini> fromYear = new ArrayList<Lamborghini>();

		for (Lamborghini l : inventory) {
			if (l.getModelYear() == year) {
				fromYear.add(l);
			}
		}
		return fromYear;
	}

	/**
	 * @param lowHP
	 *            the lowest Lamborghini horsepower
	 * @param highHP
	 *            the highest Lmborghini horsepower
	 * @return an array of all the Lamborghini objects that have horsepower in
	 *         the range passed in as parameters, if there are no cars that
	 *         match the range it return an empty Lamborghini array. The array
	 *         retured from this method is to be the exact size of how many
	 *         matches there are.
	 */
	public Lamborghini[] getCarsWithHorsepowerRange(double lowHP, double highHP) {
		int numberOfLambo = DEFAULT_COUNT;

		for (Lamborghini l : inventory) {
			if ((l.getHorsepower() >= lowHP) && (l.getHorsepower() <= highHP)) {
				numberOfLambo++;
			}
		}

		Lamborghini[] horsepower = new Lamborghini[numberOfLambo];
		int indexInNewArray = DEFAULT_COUNT;

		for (Lamborghini j : inventory) {
			if ((j.getHorsepower() >= lowHP) && (j.getHorsepower() <= highHP)) {
				horsepower[indexInNewArray] = j;
				indexInNewArray++;
			}
		}
		return horsepower;
	}

	/**
	 * @param modelName
	 *            the model of Lamborghini
	 * @return true if modelName exists in carLot; otherwise false if modelName
	 *         is not found, or if carLot ArrayList is null.
	 */
	public boolean hasCarModel(String modelName) {
		for (Lamborghini l : inventory) {
			if (l.getModelName() == null) {
				continue;
			}

			if (l.getModelName().equalsIgnoreCase(modelName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param modelYear
	 *            the model year of Lamborghini
	 * @return the average horsepower of all Lamborghini objects that match the
	 *         modelYear specified as the parameter, DEFAULT_HP is returned if
	 *         no Lamborghini cars match.
	 */
	public double getAverageHorsepowerOfYear(int modelYear) {
		double TotalHP = DEFAULT_TOTAL_HP;
		double avgHP = DEFAULT_HP;
		int count = DEFAULT_COUNT;

		for (Lamborghini l : inventory) {
			if (l.getModelYear() == modelYear) {
				count++;
				TotalHP = TotalHP + l.getHorsepower();
				avgHP = TotalHP / count;
			}
		}
		return avgHP;
	}
}
