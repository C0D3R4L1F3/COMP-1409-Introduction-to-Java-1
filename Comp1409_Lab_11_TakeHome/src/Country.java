import java.util.ArrayList;

/**
 * This is a description of a Country Class.
 * 
 * @author Ronnie Manimtim
 * @version 1.0
 */
public class Country {
	private String name; // eg "United States" or "Canada"
	private State[] states;
	public static int ZERO = 0;

	/**
	 * This consturctor creates an array of United States state, capital, and
	 * population in millions details.
	 * @param name 
	 */
	public Country(String name) {

		this.setName(name);

		states = new State[50];

		states[0] = new State("Alabama", "Montgomery", 5);

		states[1] = new State("Alaska", "Juneau", 1);

		states[2] = new State("Arizona", "Phoenix", 7);

		states[3] = new State("Arkansas", "Little Rock", 3);

		states[4] = new State("California", "Sacramento", 38);

		states[5] = new State("Colorado", "Denver", 6);

		states[6] = new State("Connecticut", "Hartford", 4);

		states[7] = new State("Delaware", "Dover", 1);

		states[8] = new State("Florida", "Tallahassee", 20);

		states[9] = new State("Georgia", "Atlanta", 11);

		states[10] = new State("Hawaii", "Honolulu", 2);

		states[11] = new State("Idaho", "Boise", 2);

		states[12] = new State("Illinois", "Springfield", 13);

		states[13] = new State("Indiana", "Indianapolis", 7);

		states[14] = new State("Iowa", "Des Moines", 4);

		states[15] = new State("Kansas", "Topeka", 3);

		states[16] = new State("Kentucky", "Frankfort", 5);

		states[17] = new State("Louisiana", "Baton Rouge", 5);

		states[18] = new State("Maine", "Augusta", 2);

		states[19] = new State("Maryland", "Annapolis", 6);

		states[20] = new State("Massachusetts", "Boston", 7);

		states[21] = new State("Michigan", "Lansing", 10);

		states[22] = new State("Minnesota", "St. Paul", 6);

		states[23] = new State("Mississippi", "Jackson", 3);

		states[24] = new State("Missouri", "Jefferson City", 7);

		states[25] = new State("Montana", "Helena", 2);

		states[26] = new State("Nebraska", "Lincoln", 2);

		states[27] = new State("Nevada", "Carson City", 3);

		states[28] = new State("New Hampshire", "Concord", 2);

		states[29] = new State("New Jersey", "Trenton", 9);

		states[30] = new State("New Mexico", "Santa Fe", 3);

		states[31] = new State("New York", "Albany", 20);

		states[32] = new State("North Carolina", "Raleigh", 10);

		states[33] = new State("North Dakota", "Bismarck", 1);

		states[34] = new State("Ohio", "Columbus", 12);

		states[35] = new State("Oklahoma", "Oklahoma City", 4);

		states[36] = new State("Oregon", "Salem", 4);

		states[37] = new State("Pennsylvania", "Harrisburg", 13);

		states[38] = new State("Rhode Island", "Providence", 2);

		states[39] = new State("South Carolina", "Columbia", 5);

		states[40] = new State("South Dakota", "Pierre", 1);

		states[41] = new State("Tennessee", "Nashville", 7);

		states[42] = new State("Texas", "Austin", 27);

		states[43] = new State("Utah", "Salt Lake City", 3);

		states[44] = new State("Vermont", "Montpelier", 1);

		states[45] = new State("Virginia", "Richmond", 9);

		states[46] = new State("Washington", "Olympia", 8);

		states[47] = new State("West Virginia", "Charleston", 2);

		states[48] = new State("Wisconsin", "Madison", 6);

		states[49] = new State("Wyoming", "Cheyenne", 1);

	}

	/**
	 * @return displays all states
	 */
	public void displayAllsStates() {
		if ((states == null) || (states.length == ZERO)) {
			System.out.println("no states");
			return;
		}

		for (int i = ZERO; i < states.length; i++) {

			if (states[i] != null) {
				System.out.println(states[i].getDetails());
			}
		}
	}

	/**
	 * @return state can be added to array list
	 */
	@SuppressWarnings("unused")
	public void addState(String state) {
		int i = ZERO;
		State[] states = new State[i++];

	}

	/**
	 * @return the population within the min and max values and return the total
	 *         states that have those values
	 */
	public int howManyHaveThisPopulation(int min, int max) {
		ArrayList<State> matches = new ArrayList<State>();

		if ((states == null) || (states.length == ZERO)) {
			return ZERO;
		}

		for (int i = ZERO; i < states.length; i++) {
			State state = states[i];
			if ((state.getPopulationInMillions() >= min) && (state.getPopulationInMillions() <= max)) {
				System.out.println(state.getDetails());
				matches.add(state);
			}
		}

		if (matches.size() == ZERO) {
			return ZERO;
		}
		return matches.size();
	}

	@SuppressWarnings("unused")
	public void removeFromCountry(String StateName, int minPopulationMillions, int maxPopulationMillions) {
		int remove = ZERO;
		for (int i = ZERO; i < states.length - 1; i++) {

			if ((states[i].getState() == StateName) && (states[i].getPopulationInMillions() >= minPopulationMillions)
					&& (states[i].getPopulationInMillions() <= maxPopulationMillions)) {
				System.out.println("About to delete this State: " + states[i].getDetails());
				states[i] = states[i + 1];
				remove--;
			}

		}

	}

	public State[] getAll(String subString) {
		int howManyOfThisPopulation = ZERO;

		// count how many matches there are
		for (int i = ZERO; i < states.length; i++) {
			if ((states[i].getState().startsWith(subString)) || (states[i].getState().endsWith(subString))) {
				howManyOfThisPopulation++;
			}
		}

		State[] matches = new State[howManyOfThisPopulation];
		int indexInNewArray = ZERO;
		// count how many matches there are
		for (int j = ZERO; j < states.length; j++) {
			if ((states[j].getState().startsWith(subString)) || (states[j].getState().endsWith(subString))) {
				matches[indexInNewArray] = states[j];
				indexInNewArray++;
			}
		}
		return matches;
	}

	public State[] getAll(int minPopulationMillions, int maxPopulationMillions) {
		int populationBetweenMinMax = ZERO;
		for (int i = ZERO; i < states.length; i++) {

			if ((states[i].getPopulationInMillions() >= minPopulationMillions)
					&& (states[i].getPopulationInMillions() <= maxPopulationMillions)) {
				System.out.println(states[i].getDetails());
				populationBetweenMinMax++;
			}
		}
		State[] matches = new State[populationBetweenMinMax];
		int indexInNewArray = ZERO;
		for (int j = ZERO; j < states.length; j++) {

			if ((states[j].getPopulationInMillions() >= minPopulationMillions)
					&& (states[j].getPopulationInMillions() <= maxPopulationMillions)) {
				System.out.println(states[j].getDetails());
				matches[indexInNewArray] = states[j];
				indexInNewArray++;
			}
		}

		if (matches.length == ZERO) {
			return null;
		}
		return matches;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
