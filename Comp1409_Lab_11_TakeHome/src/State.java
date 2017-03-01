import java.util.ArrayList;

/**
 * This is a description of a Country Class.
 * 
 * @author Ronnie Manimtim
 * @version 1.0
 */
public class State {
	private String state;
	private String capital;
	private int populationInMillions;

	private ArrayList<String> stateList;
	private ArrayList<String> capitalList;
	private static final int DEFAULT_POPULATION_MILLIONS = 38;
	private static final String DEFAULT_STATE = "California";
	private static final String DEFAULT_CAPITAL = "Sacramento";

	/**
	 * This constructor sets the valid states, capital, and populations if
	 * errors are entered then all values result to deafualt
	 */

	public State(String state, String capital, int populationInMillions) {

		if (isValidPopulation(populationInMillions) && isValidState(state) && isValidCapitalCity(capital)) {
			this.populationInMillions = populationInMillions;
			this.state = state;
			this.capital = capital;
		} else { // if there is any error; create the default data, shown below
			this.populationInMillions = DEFAULT_POPULATION_MILLIONS; // 38
			this.state = DEFAULT_STATE; // “California”
			this.capital = DEFAULT_CAPITAL; // “Sacramento”
		}

	}

	/**
	 * This constructor sets the population to default state to California,
	 * capital to Sacramento, and population to 38 million
	 */
	public State() {
		this.state = DEFAULT_STATE;
		this.capital = DEFAULT_CAPITAL;
		this.populationInMillions = DEFAULT_POPULATION_MILLIONS;
	}

	/**
	 * @return true if valid state is provided; otherwise false
	 */
	private boolean isValidState(String state) {

		stateList = new ArrayList<String>();

		stateList.add("Alabama");

		stateList.add("Alaska");

		stateList.add("Arizona");

		stateList.add("Arkansas");

		stateList.add("California");

		stateList.add("Colorado");

		stateList.add("Connecticut");

		stateList.add("Delaware");

		stateList.add("Florida");

		stateList.add("Georgia");

		stateList.add("Hawaii");

		stateList.add("Idaho");

		stateList.add("Illinois");

		stateList.add("Indiana");

		stateList.add("Iowa");

		stateList.add("Kansas");

		stateList.add("Kentucky");

		stateList.add("Louisiana");

		stateList.add("Maine");

		stateList.add("Maryland");

		stateList.add("Massachusetts");

		stateList.add("Michigan");

		stateList.add("Minnesota");

		stateList.add("Mississippi");

		stateList.add("Missouri");

		stateList.add("Montana");

		stateList.add("Nebraska");

		stateList.add("Nevada");

		stateList.add("New Hampshire");

		stateList.add("New Jersey");

		stateList.add("New Mexico");

		stateList.add("New York");

		stateList.add("North Carolina");

		stateList.add("North Dakota");

		stateList.add("Ohio");

		stateList.add("Oklahoma");

		stateList.add("Oregon");

		stateList.add("Pennsylvania");

		stateList.add("Rhode Island");

		stateList.add("South Carolina");

		stateList.add("South Dakota");

		stateList.add("Tennessee");

		stateList.add("Texas");

		stateList.add("Utah");

		stateList.add("Vermont");

		stateList.add("Virginia");

		stateList.add("Washington");

		stateList.add("West Virginia");

		stateList.add("Wisconsin");

		stateList.add("Wyoming");

		if (state.contains(state)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return true if valid capital is provided; otherwise false
	 */
	private boolean isValidCapitalCity(String capital) {
		capitalList = new ArrayList<String>();

		capitalList.add("Montgomery");

		capitalList.add("Juneau");

		capitalList.add("Phoenix");

		capitalList.add("Little Rock");

		capitalList.add("Sacramento");

		capitalList.add("Denver");

		capitalList.add("Hartford");

		capitalList.add("Dover");

		capitalList.add("Tallahassee");

		capitalList.add("Atlanta");

		capitalList.add("Honolulu");

		capitalList.add("Boise");

		capitalList.add("Springfield");

		capitalList.add("Indianapolis");

		capitalList.add("Des Moines");

		capitalList.add("Topeka");

		capitalList.add("Frankfort");

		capitalList.add("Baton Rouge");

		capitalList.add("Augusta");

		capitalList.add("Annapolis");

		capitalList.add("Boston");

		capitalList.add("Lansing");

		capitalList.add("St. Paul");

		capitalList.add("Jackson");

		capitalList.add("Jefferson City");

		capitalList.add("Helena");

		capitalList.add("Lincoln");

		capitalList.add("Carson City");

		capitalList.add("Concord");

		capitalList.add("Trenton");

		capitalList.add("Santa Fe");

		capitalList.add("Albany");

		capitalList.add("Raleigh");

		capitalList.add("Bismarck");

		capitalList.add("Columbus");

		capitalList.add("Oklahoma City");

		capitalList.add("Salem");

		capitalList.add("Harrisburg");

		capitalList.add("Providence");

		capitalList.add("Columbia");

		capitalList.add("Pierre");

		capitalList.add("Nashville");

		capitalList.add("Austin");

		capitalList.add("Salt Lake City");

		capitalList.add("Montpelier");

		capitalList.add("Richmond");

		capitalList.add("Olympia");

		capitalList.add("Charleston");

		capitalList.add("Madison");

		capitalList.add("Cheyenne");

		if (capital.contains(capital)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return true if valid population is within 4 to 38 population in
	 *         millions; otherwise false and returns the values to default
	 *         constructor
	 */
	private boolean isValidPopulation(int populationInMillions) {
		if (populationInMillions >= 4 && populationInMillions <= 38) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * @return the population in millions
	 */
	public int getPopulationInMillions() {
		return populationInMillions;
	}

	/**
	 * @return the details of the state, population, and capital
	 */
	public String getDetails() {
		return ("The capital of " + getState() + "(pop. " + getPopulationInMillions() + " million) is " + getCapital()
				+ ".");
	}
}