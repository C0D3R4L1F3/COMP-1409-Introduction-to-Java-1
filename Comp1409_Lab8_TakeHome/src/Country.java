import java.util.ArrayList;

/**
 * This is a description of a Country Class.
 * 
 * @author Ronnie Manimtim
 * @version 1.0
 */
public class Country {
	private String name; // eg "United States" or "Canada"
	private ArrayList<State> states;

	/**
	 * This consturctor creates an array of United States state, capital, and
	 * population in millions details.
	 * @param name 
	 */
	public Country(String name) {
		
		this.setName(name);

		states = new ArrayList<State>();

		State s1 = new State("Alabama", "Montgomery", 5);
		states.add(s1);

		State s2 = new State("Alaska", "Juneau", 1);
		states.add(s2);

		State s3 = new State("Arizona", "Phoenix", 7);
		states.add(s3);

		State s4 = new State("Arkansas", "Little Rock", 3);
		states.add(s4);

		State s5 = new State("California", "Sacramento", 38);
		states.add(s5);

		State s6 = new State("Colorado", "Denver", 6);
		states.add(s6);

		State s7 = new State("Connecticut", "Hartford", 4);
		states.add(s7);

		State s8 = new State("Delaware", "Dover", 1);
		states.add(s8);

		State s9 = new State("Florida", "Tallahassee", 20);
		states.add(s9);

		State s10 = new State("Georgia", "Atlanta", 11);
		states.add(s10);

		State s11 = new State("Hawaii", "Honolulu", 2);
		states.add(s11);

		State s12 = new State("Idaho", "Boise", 2);
		states.add(s12);

		State s13 = new State("Illinois", "Springfield", 13);
		states.add(s13);

		State s14 = new State("Indiana", "Indianapolis", 7);
		states.add(s14);

		State s15 = new State("Iowa", "Des Moines", 4);
		states.add(s15);

		State s16 = new State("Kansas", "Topeka", 3);
		states.add(s16);

		State s17 = new State("Kentucky", "Frankfort", 5);
		states.add(s17);

		State s18 = new State("Louisiana", "Baton Rouge", 5);
		states.add(s18);

		State s19 = new State("Maine", "Augusta", 2);
		states.add(s19);

		State s20 = new State("Maryland", "Annapolis", 6);
		states.add(s20);

		State s21 = new State("Massachusetts", "Boston", 7);
		states.add(s21);

		State s22 = new State("Michigan", "Lansing", 10);
		states.add(s22);

		State s23 = new State("Minnesota", "St. Paul", 6);
		states.add(s23);

		State s24 = new State("Mississippi", "Jackson", 3);
		states.add(s24);

		State s25 = new State("Missouri", "Jefferson City", 7);
		states.add(s25);

		State s26 = new State("Montana", "Helena", 2);
		states.add(s26);

		State s27 = new State("Nebraska", "Lincoln", 2);
		states.add(s27);

		State s28 = new State("Nevada", "Carson City", 3);
		states.add(s28);

		State s29 = new State("New Hampshire", "Concord", 2);
		states.add(s29);

		State s30 = new State("New Jersey", "Trenton", 9);
		states.add(s30);

		State s31 = new State("New Mexico", "Santa Fe", 3);
		states.add(s31);

		State s32 = new State("New York", "Albany", 20);
		states.add(s32);

		State s33 = new State("North Carolina", "Raleigh", 10);
		states.add(s33);

		State s34 = new State("North Dakota", "Bismarck", 1);
		states.add(s34);

		State s35 = new State("Ohio", "Columbus", 12);
		states.add(s35);

		State s36 = new State("Oklahoma", "Oklahoma City", 4);
		states.add(s36);

		State s37 = new State("Oregon", "Salem", 4);
		states.add(s37);

		State s38 = new State("Pennsylvania", "Harrisburg", 13);
		states.add(s38);

		State s39 = new State("Rhode Island", "Providence", 2);
		states.add(s39);

		State s40 = new State("South Carolina", "Columbia", 5);
		states.add(s40);

		State s41 = new State("South Dakota", "Pierre", 1);
		states.add(s41);

		State s42 = new State("Tennessee", "Nashville", 7);
		states.add(s42);

		State s43 = new State("Texas", "Austin", 27);
		states.add(s43);

		State s44 = new State("Utah", "Salt Lake City", 3);
		states.add(s44);

		State s45 = new State("Vermont", "Montpelier", 1);
		states.add(s45);

		State s46 = new State("Virginia", "Richmond", 9);
		states.add(s46);

		State s47 = new State("Washington", "Olympia", 8);
		states.add(s47);

		State s48 = new State("West Virginia", "Charleston", 2);
		states.add(s48);

		State s49 = new State("Wisconsin", "Madison", 6);
		states.add(s49);

		State s50 = new State("Wyoming", "Cheyenne", 1);
		states.add(s50);

	}

	/**
	 * @return displays all states
	 */
	public void displayAllsStates() {
		for (State s : states) {
			System.out.println(s.getDetails());
		}
	}

	/**
	 * @return state can be added to array list
	 */
	public void addState(State state) {
		states.add(state);
	}

	/**
	 * @return the population within the min and max values and return the total
	 *         states that have those values
	 */
	public int howManyHaveThisPopulation(int min, int max) {
		int numberOfStates = 0;
		for (State p : states) {
			if ((p.getPopulationInMillions() >= min) && (p.getPopulationInMillions() <= max)) {
				System.out.println(p.getState());
				numberOfStates++;
			}
		}
		return numberOfStates;
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
