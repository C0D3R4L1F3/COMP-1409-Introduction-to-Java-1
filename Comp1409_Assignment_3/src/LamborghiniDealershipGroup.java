import java.util.ArrayList;

/**
 * This is a description of LamborghiniDealershipGroup class.
 * 
 * @author Ronnie Manimtim
 * @version 12/04/2015
 */
public class LamborghiniDealershipGroup {
	private String dealershipGroupName; // e.g. Taylor's Auto Group
	private ArrayList<LamborghiniCarLot> carLots;

	private static final int DEFAULT_COUNT = 0;
	private static final String DEFUALT_LOT_NAME = "Jason's vintage lambos.";

	private static final double THREEFIFTYGT_HP_ONE = 365.3;
	private static final double FOURHUNDREDGT_HP_ONE = 366.3;
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
	private static final double GALLARDO_HP_ONE = 506.3;
	private static final double GALLARDO_HP_TWO = 507.3;
	private static final double REVENTON_HP_ONE = 308.3;
	private static final double REVENTON_HP_TWO = 508.3;
	private static final double GALLARDO_HP_THREE = 409.3;
	private static final double MURCIELAGO_HP_ONE = 310.3;
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
	private static final int YEAR_TWELEVE = 1977;
	private static final int YEAR_THIRTEEN = 1978;
	private static final int YEAR_FOURTEEN = 1979;
	private static final int YEAR_FIFTEEN = 2006;
	private static final int YEAR_SIXTEEN = 2007;
	private static final int YEAR_EIGHTEEN = 2008;
	private static final int YEAR_NINETEEN = 2009;
	private static final int YEAR_TWENTY = 2010;
	private static final int YEAR_TWENTY_ONE = 2011;
	private static final int YEAR_TWENTY_TWO = 2012;

	/**
	 * This constructor creates carLots ArrayList objects but does not add any
	 * LamborghiniCarLot objects to carLot ArrayList.
	 */
	public LamborghiniDealershipGroup() {
		carLots = new ArrayList<LamborghiniCarLot>();
	}

	/**
	 * @param dealershipGroupName
	 *            the name of the dealership. This constructor creates an
	 *            ArrayList of Lamborghini's.
	 */
	public LamborghiniDealershipGroup(String dealershipGroupName) {
		LamborghiniCarLot carlot1 = new LamborghiniCarLot();

		carlot1.setLotName(DEFUALT_LOT_NAME);

		carlot1.addLamborghini(new Lamborghini(YEAR_ONE, "350GT", THREEFIFTYGT_HP_ONE, true));
		carlot1.addLamborghini(new Lamborghini(YEAR_TWO, "400GT 2+2", FOURHUNDREDGT_HP_ONE, false));
		carlot1.addLamborghini(new Lamborghini(YEAR_THREE, "MIURA", MIURA_HP_ONE, true));
		carlot1.addLamborghini(new Lamborghini(YEAR_FOUR, "espada", ESPADA_HP_ONE, false));
		carlot1.addLamborghini(new Lamborghini(YEAR_FIVE, "islero", ISLERO_HP_ONE, true));
		carlot1.addLamborghini(new Lamborghini(YEAR_SIX, "jarama", JARAMA_HP_ONE, false));
		carlot1.addLamborghini(new Lamborghini(YEAR_SEVEN, "urraco", URRACO_HP_ONE, false));
		carlot1.addLamborghini(new Lamborghini(YEAR_SEVEN, "urraco", URRACO_HP_ONE, false));
		carlot1.addLamborghini(new Lamborghini(YEAR_EIGHT, "countache", COUNTACHE_HP_ONE, false));
		carlot1.addLamborghini(new Lamborghini(YEAR_NINE, "silhouette", SILHOUETTE_HP_ONE, false));
		carlot1.addLamborghini(new Lamborghini(YEAR_TEN, "jalpa", JALPA_HP_ONE, true));
		carlot1.addLamborghini(new Lamborghini(YEAR_ELEVEN, "silhouette", SILHOUETTE_HP_TWO, false));
		carlot1.addLamborghini(new Lamborghini(YEAR_TWELEVE, "silhouette", SILHOUETTE_HP_THREE, true));
		carlot1.addLamborghini(new Lamborghini(YEAR_THIRTEEN, "countache", COUNTACHE_HP_TWO, false));
		carlot1.addLamborghini(new Lamborghini(YEAR_THIRTEEN, "countache", COUNTACHE_HP_THREE, false));
		carlot1.addLamborghini(new Lamborghini(YEAR_THIRTEEN, "countache", COUNTACHE_HP_FOUR, true));
		carlot1.addLamborghini(new Lamborghini(YEAR_FOURTEEN, "silhouette", SILHOUETTE_HP_FOUR, false));

		// Create the second car lot
		LamborghiniCarLot carlot2 = new LamborghiniCarLot();

		carlot2.setLotName(DEFUALT_LOT_NAME);

		carlot2.addLamborghini(new Lamborghini(YEAR_FIFTEEN, "gallardo", GALLARDO_HP_ONE, true));
		carlot2.addLamborghini(new Lamborghini(YEAR_SIXTEEN, "gallardo", GALLARDO_HP_TWO, true));
		carlot2.addLamborghini(new Lamborghini(YEAR_EIGHTEEN, "reventon", REVENTON_HP_ONE, false));
		carlot2.addLamborghini(new Lamborghini(YEAR_EIGHTEEN, "reventon", REVENTON_HP_TWO, true));
		carlot2.addLamborghini(new Lamborghini(YEAR_NINETEEN, "gallardo", GALLARDO_HP_THREE, true));
		carlot2.addLamborghini(new Lamborghini(YEAR_TWENTY, "murcielago", MURCIELAGO_HP_ONE, false));
		carlot2.addLamborghini(new Lamborghini(YEAR_TWENTY_ONE, "aventador", AVENTADOR_HP_ONE, false));
		carlot2.addLamborghini(new Lamborghini(YEAR_TWENTY_TWO, "sesto elemento", SESTO_ELEMENTO_HP_ONE, true));

		// Add them to the arraylist
		carLots.add(carlot1);
		carLots.add(carlot2);
	}

	/**
	 * @return the car lots.
	 */
	public ArrayList<LamborghiniCarLot> getCarLots() {
		return carLots;
	}

	/**
	 * @param carLots
	 *            the ArrayList of car lots.
	 */
	public void setCarLots(ArrayList<LamborghiniCarLot> carLots) {
		this.carLots = carLots;
	}

	/**
	 * @return the dealerships group name.
	 */
	public String getDealershipGroupName() {
		return dealershipGroupName;
	}

	/**
	 * @param dealershipGroupName 
	 * @param dealershipGrouName
	 *            the dealerships group name is stored.
	 */
	public void setDealershipGroupName(String dealershipGroupName) {
		this.dealershipGroupName = dealershipGroupName;
	}

	/**
	 * @param carLot
	 *            adds a car lot to ArrayList but can not equal null.
	 */
	public void addCarLot(LamborghiniCarLot carLot) {
		if (carLot != null) {
			carLots.add(carLot);
		}
	}

	/**
	 * @return the total inventory count but return zero if inventory count is
	 *         null.
	 */
	@SuppressWarnings("unused")
	public int getTotalInventoryCount() {
		int inventoryNumber = DEFAULT_COUNT;

		for (LamborghiniCarLot l : carLots) {
			if (carLots != null) {
				for (Lamborghini c : l.getInventory()) {
					inventoryNumber++;
				}
			}

			if (carLots == null) {
				return DEFAULT_COUNT;
			}
		}
		return inventoryNumber;
	}

	/**
	 * @param modelName
	 *            the name of the model Lamborghini.
	 * @return true if the model name exist in any of the car lots otherwise
	 *         false if the model name cannot be found.
	 */
	@SuppressWarnings("unused")
	public boolean hasModelName(String modelName) {
		boolean found = false;

		for (LamborghiniCarLot l : carLots) {
			if (modelName == null) {
				continue;
			}

			if (l.hasCarModel(modelName) == true) {
				return l.hasCarModel(modelName);
			}
		}
		return false;
	}

	/**
	 * @param modelYear
	 *            the year of the Lamborghini.
	 * @param lowHP
	 *            the lowest horespower of a Lamborghini set.
	 * @param highHP
	 *            the highest horespower of the Lamborghini set.
	 * @return an array of all the car lots whose average horsepower for a given
	 *         year within the specified range.
	 */
	public LamborghiniCarLot[] getAllCarLotsWithAverageHorsepowerInRangeForYear(int modelYear, double lowHP,
			double highHP) {
		int matches = DEFAULT_COUNT;

		for (LamborghiniCarLot c : carLots) {
			if ((c.getAverageHorsepowerOfYear(modelYear)) > (lowHP)
					&& (c.getAverageHorsepowerOfYear(modelYear)) < (highHP)) {
				matches++;
			}
		}

		LamborghiniCarLot[] search = new LamborghiniCarLot[matches];
		int index = DEFAULT_COUNT;

		for (LamborghiniCarLot l : carLots) {
			if ((l.getAverageHorsepowerOfYear(modelYear)) > (lowHP)
					&& (l.getAverageHorsepowerOfYear(modelYear)) < (highHP)) {
				search[index] = l;
				index++;
			}
		}
		return search;
	}
}