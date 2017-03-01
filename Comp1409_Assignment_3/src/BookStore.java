

/**
 * This is a description of BookStore class.
 * 
 * @author Ronnie Manimtim
 * @version 12/04/2015
 */
public class BookStore {
	private String storeName; // e.g. "Jason's New Books"
	private Book[] inventory; // Array of Book objects

	private static final int YEAR_BORN = 2013;
	private static final int MONTH_BORN = 1;
	private static final int DAY_BORN = 1;

	private static final int YEAR_DIED = 2013;
	private static final int MONTH_DIED = 1;
	private static final int DAY_DIED = 1;

	private static final int YEAR_PUBLISHED = 2013;
	private static final int MONTH_PUBLISHED = 1;
	private static final int DAY_PUBLISHED = 1;

	private static int DEFAULT_COUNT = 0;
	private static int DEFAULT_LENGTH = 0;
	private static int DEFUALT_I = 0;
	private static int DEFUALT_J = 0;

	private static final String DEFAULT_STORE_NAME = "Jason's Used Books";
	private static final String CAN_NOT_BE_THIS_STORE_NAME = "Taylor's Used Books";

	/**
	 * This constructor creates the inventory of one hundred Book objects.
	 */
	public BookStore() {
		inventory = new Book[100];

		inventory[0] = new Book(new Author("James", "Joyce", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "James", "Joyce", null), new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED),
				"ULYSSES");
		inventory[1] = new Book(
				new Author("F.", "Fitzgerald", "Scott", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "F.", "Fitzgerald", "Scott"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE GREAT GATSBY");
		inventory[2] = new Book(
				new Author("James", "Joyce", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Joyce", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A PORTRAIT OF THE ARTIST AS A YOUNG MAN");
		inventory[3] = new Book(
				new Author("Vladimir", "Nabokov", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Vladimir", "Nabokov", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "LOLITA");
		inventory[4] = new Book(
				new Author("Aldous", "Huxley", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Aldous", "Huxley", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "BRAVE NEW WORLD");
		inventory[5] = new Book(
				new Author("William", "Faulkner", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "William", "Faulkner", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE SOUND AND THE FURY");
		inventory[6] = new Book(
				new Author("Joseph", "Heller", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Joseph", "Heller", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "CATCH-22");
		inventory[7] = new Book(
				new Author("Arthur", "Koestler", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Arthur", "Koestler", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "DARKNESS AT NOON");
		inventory[8] = new Book(
				new Author("D.H.", "Lawrence", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"D.H.", "Lawrence", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "SONS AND LOVERS");
		inventory[9] = new Book(
				new Author("John", "Steinbeck", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"John", "Steinbeck", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE GRAPES OF WRATH");
		inventory[10] = new Book(
				new Author("Malcolm", "Lowry", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Malcolm", "Lowry", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "UNDER THE VOLCANO");
		inventory[11] = new Book(
				new Author("Samuel", "Butler", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Samuel", "Butler", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE WAY OF ALL FLESH");
		inventory[12] = new Book(new Author("George", "Orwell", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "George", "Orwell", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "1984");
		inventory[13] = new Book(
				new Author("Robert", "Graves", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Robert", "Graves", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "I, CLAUDIUS");
		inventory[14] = new Book(
				new Author("Virginia", "Woolf", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Virginia", "Woolf", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "TO THE LIGHTHOUSE");
		inventory[15] = new Book(
				new Author("Theodore", "Dreiser", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Theodore", "Dreiser", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "AN AMERICAN TRAGEDY");
		inventory[16] = new Book(
				new Author("Carson", "McCullers", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Carson", "McCullers", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE HEART IS A LONELY HUNTER");
		inventory[17] = new Book(
				new Author("Kurt", "Vonnegut", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Kurt", "Vonnegut", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "SLAUGHTERHOUSE-FIVE");
		inventory[18] = new Book(
				new Author("Ralph", "Ellison", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Ralph", "Ellison", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "INVISIBLE MAN");
		inventory[19] = new Book(
				new Author("Richard", "Wright", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Richard", "Wright", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "NATIVE SON");
		inventory[20] = new Book(
				new Author("Saul", "Bellow", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Saul", "Bellow", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "HENDERSON THE RAIN KING");
		inventory[21] = new Book(
				new Author("John", "O'Hara", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"John", "O'Hara", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "APPOINTMENT IN SAMARRA");
		inventory[22] = new Book(
				new Author("John", "Dos Passos", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"John", "Dos Passos", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "U.S.A.trilogy)");
		inventory[23] = new Book(
				new Author("Sherwood", "Anderson", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Sherwood", "Anderson", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "WINESBURG, OHIO");
		inventory[24] = new Book(
				new Author("E.M.", "Forster", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"E.M.", "Forster", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A PASSAGE TO INDIA");
		inventory[25] = new Book(
				new Author("Henry", "James", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Henry", "James", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE WINGS OF THE DOVE");
		inventory[26] = new Book(
				new Author("Henry", "James", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Henry", "James", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE AMBASSADORS");
		inventory[27] = new Book(
				new Author("F.", "Fitzgerald", "Scott", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "F.", "Fitzgerald", "Scott"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "TENDER IS THE NIGHT");
		inventory[28] = new Book(
				new Author("James", "Farrell", "T.", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Farrell", "T."),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE STUDS LONIGAN TRILOGY");
		inventory[29] = new Book(
				new Author("Ford", "Madox", "Ford", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Ford", "Madox", "Ford"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE GOOD SOLDIER");
		inventory[30] = new Book(
				new Author("George", "Orwell", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"George", "Orwell", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "ANIMAL FARM");
		inventory[31] = new Book(
				new Author("Henry", "James", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Henry", "James", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE GOLDEN BOWL");
		inventory[32] = new Book(
				new Author("Theodore", "Dreiser", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Theodore", "Dreiser", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "SISTER CARRIE");
		inventory[33] = new Book(
				new Author("Evelyn", "Waugh", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Evelyn", "Waugh", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A HANDFUL OF DUST");
		inventory[34] = new Book(
				new Author("William", "Faulkner", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "William", "Faulkner", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "AS I LAY DYING");
		inventory[35] = new Book(
				new Author("Robert", "Warren", "Penn", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Robert", "Warren", "Penn"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "ALL THE KING'S MEN");
		inventory[36] = new Book(
				new Author("Thornton", "Wilder", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Thornton", "Wilder", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE BRIDGE OF SAN LUIS REY");
		inventory[37] = new Book(
				new Author("E.M.", "Forster", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"E.M.", "Forster", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "HOWARDS END");
		inventory[38] = new Book(
				new Author("James", "Baldwin", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Baldwin", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "GO TELL IT ON THE MOUNTAIN");
		inventory[39] = new Book(
				new Author("Graham", "Greene", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Graham", "Greene", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE HEART OF THE MATTER");
		inventory[40] = new Book(
				new Author("William", "Golding", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"William", "Golding", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "LORD OF THE FLIES");
		inventory[41] = new Book(
				new Author("James", "Dickey", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Dickey", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "DELIVERANCE");
		inventory[42] = new Book(
				new Author("Anthony", "Powell", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Anthony", "Powell", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A DANCE TO THE MUSIC OF TIME (series)");
		inventory[43] = new Book(
				new Author("Aldous", "Huxley", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Aldous", "Huxley", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "POINT COUNTER POINT");
		inventory[44] = new Book(
				new Author("Ernest", "Hemingway", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Ernest", "Hemingway", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE SUN ALSO RISES");
		inventory[45] = new Book(
				new Author("Joseph", "Conrad", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Joseph", "Conrad", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE SECRET AGENT");
		inventory[46] = new Book(
				new Author("Joseph", "Conrad", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Joseph", "Conrad", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "NOSTROMO");
		inventory[47] = new Book(
				new Author("D.H.", "Lawrence", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"D.H.", "Lawrence", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE RAINBOW");
		inventory[48] = new Book(
				new Author("D.H.", "Lawrence", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"D.H.", "Lawrence", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "WOMEN IN LOVE");
		inventory[49] = new Book(
				new Author("Henry", "Miller", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Henry", "Miller", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "TROPIC OF CANCER");
		inventory[50] = new Book(
				new Author("Norman", "Mailer", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Norman", "Mailer", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE NAKED AND THE DEAD");
		inventory[51] = new Book(
				new Author("Philip", "Roth", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Philip", "Roth", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "PORTNOY'S COMPLAINT");
		inventory[52] = new Book(
				new Author("Vladimir", "Nabokov", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Vladimir", "Nabokov", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "PALE FIRE");
		inventory[53] = new Book(
				new Author("William", "Faulkner", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "William", "Faulkner", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "LIGHT IN AUGUST");
		inventory[54] = new Book(
				new Author("Jack", "Kerouac", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Jack", "Kerouac", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "ON THE ROAD");
		inventory[55] = new Book(
				new Author("Dashiell", "Hammett", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Dashiell", "Hammett", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE MALTESE FALCON");
		inventory[56] = new Book(
				new Author("Ford", "Ford", "Madox", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Ford", "Ford", "Madox"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "PARADE'S END");
		inventory[57] = new Book(
				new Author("Edith", "Wharton", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Edith", "Wharton", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE AGE OF INNOCENCE");
		inventory[58] = new Book(
				new Author("Max", "Beerbohm", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Max", "Beerbohm", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "ZULEIKA DOBSON");
		inventory[59] = new Book(
				new Author("Walker", "Percy", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Walker", "Percy", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE MOVIEGOER");
		inventory[60] = new Book(
				new Author("Willa", "Cather", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Willa", "Cather", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "DEATH COMES FOR THE ARCHBISHOP");
		inventory[61] = new Book(
				new Author("James", "Jones", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Jones", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "FROM HERE TO ETERNITY");
		inventory[62] = new Book(
				new Author("John", "Cheever", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"John", "Cheever", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE WAPSHOT CHRONICLES");
		inventory[63] = new Book(
				new Author("J.D.", "Salinger", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"J.D.", "Salinger", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE CATCHER IN THE RYE");
		inventory[64] = new Book(
				new Author("Anthony", "Burgess", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Anthony", "Burgess", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A CLOCKWORK ORANGE");
		inventory[65] = new Book(
				new Author("W.", "Maugham", "Somerset", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "W.", "Maugham", "Somerset"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "OF HUMAN BONDAGE");
		inventory[66] = new Book(
				new Author("Joseph", "Conrad", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Joseph", "Conrad", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "HEART OF DARKNESS");
		inventory[67] = new Book(
				new Author("Sinclair", "Lewis", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Sinclair", "Lewis", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "MAIN STREET");
		inventory[68] = new Book(
				new Author("Edith", "Wharton", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Edith", "Wharton", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE HOUSE OF MIRTH");
		inventory[69] = new Book(
				new Author("Lawrence", "Durell", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Lawrence", "Durell", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE ALEXANDRIA QUARTET");
		inventory[70] = new Book(
				new Author("Richard", "Hughes", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Richard", "Hughes", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A HIGH WIND IN JAMAICA");
		inventory[71] = new Book(
				new Author("V.S.", "Naipaul", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"V.S.", "Naipaul", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A HOUSE FOR MR BISWAS");
		inventory[72] = new Book(
				new Author("Nathanael", "West", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Nathanael", "West", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE DAY OF THE LOCUST");
		inventory[73] = new Book(
				new Author("Ernest", "Hemingway", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Ernest", "Hemingway", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A FAREWELL TO ARMS");
		inventory[74] = new Book(new Author("Evelyn", "Waugh", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "Evelyn", "Waugh", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "SCOOP");
		inventory[75] = new Book(
				new Author("Muriel", "Spak", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Muriel", "Spak", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE PRIME OF MISS JEAN BRODIE");
		inventory[76] = new Book(
				new Author("James", "Joyce", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Joyce", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "FINNEGANS WAKE");
		inventory[77] = new Book(new Author("Rudyard", "Kipling", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "Rudyard", "Kipling", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "KIM");
		inventory[78] = new Book(
				new Author("E.M.", "Forster", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"E.M.", "Forster", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A ROOM WITH A VIEW");
		inventory[79] = new Book(
				new Author("Evelyn", "Waugh", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Evelyn", "Waugh", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "BRIDESHEAD REVISITED");
		inventory[80] = new Book(
				new Author("Saul", "Bellow", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Saul", "Bellow", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE ADVENTURES OF AUGIE MARCH");
		inventory[81] = new Book(
				new Author("Wallace", "Stegner", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Wallace", "Stegner", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "ANGLE OF REPOSE");
		inventory[82] = new Book(
				new Author("V.S.", "Naipaul", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"V.S.", "Naipaul", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A BEND IN THE RIVER");
		inventory[83] = new Book(
				new Author("Elizabeth", "Bowen", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Elizabeth", "Bowen", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE DEATH OF THE HEART");
		inventory[84] = new Book(
				new Author("Joseph", "Conrad", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Joseph", "Conrad", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "LORD JIM");
		inventory[85] = new Book(new Author("E.L.", "Doctorow", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "E.L.", "Doctorow", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "RAGTIME");
		inventory[86] = new Book(
				new Author("Arnold", "Bennett", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Arnold", "Bennett", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE OLD WIVES' TALE");
		inventory[87] = new Book(
				new Author("Jack", "London", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Jack", "London", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE CALL OF THE WILD");
		inventory[88] = new Book(new Author("Henry", "Green", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "Henry", "Green", null), new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED),
				"LOVING");
		inventory[89] = new Book(
				new Author("Salman", "Rushdie", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Salman", "Rushdie", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "MIDNIGHT'S CHILDREN");
		inventory[90] = new Book(
				new Author("Erskine", "Caldwell", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Erskine", "Caldwell", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "TOBACCO ROAD");
		inventory[91] = new Book(
				new Author("William", "Kennedy", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"William", "Kennedy", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "IRONWEED");
		inventory[92] = new Book(new Author("John", "Fowles", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "John", "Fowles", null), new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED),
				"THE MAGUS");
		inventory[93] = new Book(
				new Author("Jean", "Rhys", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Jean", "Rhys", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "WIDE SARGASSO SEA");
		inventory[94] = new Book(
				new Author("Iris", "Murdoch", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Iris", "Murdoch", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "UNDER THE NET");
		inventory[95] = new Book(
				new Author("William", "Styron", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"William", "Styron", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "SOPHIE'S CHOICE");
		inventory[96] = new Book(
				new Author("Paul", "Bowles", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Paul", "Bowles", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE SHELTERING SKY");
		inventory[97] = new Book(
				new Author("James", "Cain", "M.", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Cain", "M."),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE POSTMAN ALWAYS RINGS TWICE");
		inventory[98] = new Book(
				new Author("J.P.", "Donleavy", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"J.P.", "Donleavy", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE GINGER MAN");
		inventory[99] = new Book(
				new Author("Booth", "Tarkington", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Booth", "Tarkington", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE MAGNIFICENT AMBERSONS");
	}

	/**
	 * This constructor stores the store name and creates the inventory Array of
	 * one hundred Book objects.
	 * 
	 * @param storeName
	 *            the name of the store.
	 */
	public BookStore(String storeName) {
		if (storeName.equals(CAN_NOT_BE_THIS_STORE_NAME)) {
			this.storeName = DEFAULT_STORE_NAME;
		} else {
			this.storeName = storeName;
		}

		inventory = new Book[100];

		inventory[0] = new Book(new Author("James", "Joyce", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "James", "Joyce", null), new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED),
				"ULYSSES");
		inventory[1] = new Book(
				new Author("F.", "Fitzgerald", "Scott", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "F.", "Fitzgerald", "Scott"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE GREAT GATSBY");
		inventory[2] = new Book(
				new Author("James", "Joyce", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Joyce", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A PORTRAIT OF THE ARTIST AS A YOUNG MAN");
		inventory[3] = new Book(
				new Author("Vladimir", "Nabokov", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Vladimir", "Nabokov", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "LOLITA");
		inventory[4] = new Book(
				new Author("Aldous", "Huxley", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Aldous", "Huxley", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "BRAVE NEW WORLD");
		inventory[5] = new Book(
				new Author("William", "Faulkner", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "William", "Faulkner", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE SOUND AND THE FURY");
		inventory[6] = new Book(
				new Author("Joseph", "Heller", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Joseph", "Heller", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "CATCH-22");
		inventory[7] = new Book(
				new Author("Arthur", "Koestler", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Arthur", "Koestler", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "DARKNESS AT NOON");
		inventory[8] = new Book(
				new Author("D.H.", "Lawrence", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"D.H.", "Lawrence", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "SONS AND LOVERS");
		inventory[9] = new Book(
				new Author("John", "Steinbeck", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"John", "Steinbeck", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE GRAPES OF WRATH");
		inventory[10] = new Book(
				new Author("Malcolm", "Lowry", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Malcolm", "Lowry", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "UNDER THE VOLCANO");
		inventory[11] = new Book(
				new Author("Samuel", "Butler", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Samuel", "Butler", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE WAY OF ALL FLESH");
		inventory[12] = new Book(new Author("George", "Orwell", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "George", "Orwell", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "1984");
		inventory[13] = new Book(
				new Author("Robert", "Graves", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Robert", "Graves", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "I, CLAUDIUS");
		inventory[14] = new Book(
				new Author("Virginia", "Woolf", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Virginia", "Woolf", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "TO THE LIGHTHOUSE");
		inventory[15] = new Book(
				new Author("Theodore", "Dreiser", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Theodore", "Dreiser", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "AN AMERICAN TRAGEDY");
		inventory[16] = new Book(
				new Author("Carson", "McCullers", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Carson", "McCullers", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE HEART IS A LONELY HUNTER");
		inventory[17] = new Book(
				new Author("Kurt", "Vonnegut", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Kurt", "Vonnegut", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "SLAUGHTERHOUSE-FIVE");
		inventory[18] = new Book(
				new Author("Ralph", "Ellison", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Ralph", "Ellison", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "INVISIBLE MAN");
		inventory[19] = new Book(
				new Author("Richard", "Wright", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Richard", "Wright", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "NATIVE SON");
		inventory[20] = new Book(
				new Author("Saul", "Bellow", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Saul", "Bellow", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "HENDERSON THE RAIN KING");
		inventory[21] = new Book(
				new Author("John", "O'Hara", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"John", "O'Hara", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "APPOINTMENT IN SAMARRA");
		inventory[22] = new Book(
				new Author("John", "Dos Passos", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"John", "Dos Passos", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "U.S.A.trilogy)");
		inventory[23] = new Book(
				new Author("Sherwood", "Anderson", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Sherwood", "Anderson", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "WINESBURG, OHIO");
		inventory[24] = new Book(
				new Author("E.M.", "Forster", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"E.M.", "Forster", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A PASSAGE TO INDIA");
		inventory[25] = new Book(
				new Author("Henry", "James", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Henry", "James", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE WINGS OF THE DOVE");
		inventory[26] = new Book(
				new Author("Henry", "James", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Henry", "James", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE AMBASSADORS");
		inventory[27] = new Book(
				new Author("F.", "Fitzgerald", "Scott", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "F.", "Fitzgerald", "Scott"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "TENDER IS THE NIGHT");
		inventory[28] = new Book(
				new Author("James", "Farrell", "T.", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Farrell", "T."),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE STUDS LONIGAN TRILOGY");
		inventory[29] = new Book(
				new Author("Ford", "Madox", "Ford", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Ford", "Madox", "Ford"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE GOOD SOLDIER");
		inventory[30] = new Book(
				new Author("George", "Orwell", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"George", "Orwell", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "ANIMAL FARM");
		inventory[31] = new Book(
				new Author("Henry", "James", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Henry", "James", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE GOLDEN BOWL");
		inventory[32] = new Book(
				new Author("Theodore", "Dreiser", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Theodore", "Dreiser", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "SISTER CARRIE");
		inventory[33] = new Book(
				new Author("Evelyn", "Waugh", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Evelyn", "Waugh", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A HANDFUL OF DUST");
		inventory[34] = new Book(
				new Author("William", "Faulkner", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "William", "Faulkner", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "AS I LAY DYING");
		inventory[35] = new Book(
				new Author("Robert", "Warren", "Penn", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Robert", "Warren", "Penn"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "ALL THE KING'S MEN");
		inventory[36] = new Book(
				new Author("Thornton", "Wilder", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Thornton", "Wilder", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE BRIDGE OF SAN LUIS REY");
		inventory[37] = new Book(
				new Author("E.M.", "Forster", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"E.M.", "Forster", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "HOWARDS END");
		inventory[38] = new Book(
				new Author("James", "Baldwin", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Baldwin", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "GO TELL IT ON THE MOUNTAIN");
		inventory[39] = new Book(
				new Author("Graham", "Greene", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Graham", "Greene", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE HEART OF THE MATTER");
		inventory[40] = new Book(
				new Author("William", "Golding", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"William", "Golding", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "LORD OF THE FLIES");
		inventory[41] = new Book(
				new Author("James", "Dickey", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Dickey", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "DELIVERANCE");
		inventory[42] = new Book(
				new Author("Anthony", "Powell", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Anthony", "Powell", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A DANCE TO THE MUSIC OF TIME (series)");
		inventory[43] = new Book(
				new Author("Aldous", "Huxley", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Aldous", "Huxley", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "POINT COUNTER POINT");
		inventory[44] = new Book(
				new Author("Ernest", "Hemingway", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Ernest", "Hemingway", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE SUN ALSO RISES");
		inventory[45] = new Book(
				new Author("Joseph", "Conrad", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Joseph", "Conrad", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE SECRET AGENT");
		inventory[46] = new Book(
				new Author("Joseph", "Conrad", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Joseph", "Conrad", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "NOSTROMO");
		inventory[47] = new Book(
				new Author("D.H.", "Lawrence", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"D.H.", "Lawrence", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE RAINBOW");
		inventory[48] = new Book(
				new Author("D.H.", "Lawrence", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"D.H.", "Lawrence", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "WOMEN IN LOVE");
		inventory[49] = new Book(
				new Author("Henry", "Miller", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Henry", "Miller", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "TROPIC OF CANCER");
		inventory[50] = new Book(
				new Author("Norman", "Mailer", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Norman", "Mailer", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE NAKED AND THE DEAD");
		inventory[51] = new Book(
				new Author("Philip", "Roth", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Philip", "Roth", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "PORTNOY'S COMPLAINT");
		inventory[52] = new Book(
				new Author("Vladimir", "Nabokov", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Vladimir", "Nabokov", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "PALE FIRE");
		inventory[53] = new Book(
				new Author("William", "Faulkner", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "William", "Faulkner", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "LIGHT IN AUGUST");
		inventory[54] = new Book(
				new Author("Jack", "Kerouac", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Jack", "Kerouac", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "ON THE ROAD");
		inventory[55] = new Book(
				new Author("Dashiell", "Hammett", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Dashiell", "Hammett", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE MALTESE FALCON");
		inventory[56] = new Book(
				new Author("Ford", "Ford", "Madox", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Ford", "Ford", "Madox"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "PARADE'S END");
		inventory[57] = new Book(
				new Author("Edith", "Wharton", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Edith", "Wharton", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE AGE OF INNOCENCE");
		inventory[58] = new Book(
				new Author("Max", "Beerbohm", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Max", "Beerbohm", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "ZULEIKA DOBSON");
		inventory[59] = new Book(
				new Author("Walker", "Percy", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Walker", "Percy", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE MOVIEGOER");
		inventory[60] = new Book(
				new Author("Willa", "Cather", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Willa", "Cather", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "DEATH COMES FOR THE ARCHBISHOP");
		inventory[61] = new Book(
				new Author("James", "Jones", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Jones", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "FROM HERE TO ETERNITY");
		inventory[62] = new Book(
				new Author("John", "Cheever", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"John", "Cheever", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE WAPSHOT CHRONICLES");
		inventory[63] = new Book(
				new Author("J.D.", "Salinger", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"J.D.", "Salinger", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE CATCHER IN THE RYE");
		inventory[64] = new Book(
				new Author("Anthony", "Burgess", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Anthony", "Burgess", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A CLOCKWORK ORANGE");
		inventory[65] = new Book(
				new Author("W.", "Maugham", "Somerset", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "W.", "Maugham", "Somerset"),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "OF HUMAN BONDAGE");
		inventory[66] = new Book(
				new Author("Joseph", "Conrad", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Joseph", "Conrad", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "HEART OF DARKNESS");
		inventory[67] = new Book(
				new Author("Sinclair", "Lewis", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Sinclair", "Lewis", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "MAIN STREET");
		inventory[68] = new Book(
				new Author("Edith", "Wharton", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Edith", "Wharton", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE HOUSE OF MIRTH");
		inventory[69] = new Book(
				new Author("Lawrence", "Durell", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Lawrence", "Durell", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE ALEXANDRIA QUARTET");
		inventory[70] = new Book(
				new Author("Richard", "Hughes", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Richard", "Hughes", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A HIGH WIND IN JAMAICA");
		inventory[71] = new Book(
				new Author("V.S.", "Naipaul", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"V.S.", "Naipaul", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A HOUSE FOR MR BISWAS");
		inventory[72] = new Book(
				new Author("Nathanael", "West", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Nathanael", "West", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE DAY OF THE LOCUST");
		inventory[73] = new Book(
				new Author("Ernest", "Hemingway", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Ernest", "Hemingway", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A FAREWELL TO ARMS");
		inventory[74] = new Book(new Author("Evelyn", "Waugh", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "Evelyn", "Waugh", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "SCOOP");
		inventory[75] = new Book(
				new Author("Muriel", "Spak", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Muriel", "Spak", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE PRIME OF MISS JEAN BRODIE");
		inventory[76] = new Book(
				new Author("James", "Joyce", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Joyce", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "FINNEGANS WAKE");
		inventory[77] = new Book(new Author("Rudyard", "Kipling", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "Rudyard", "Kipling", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "KIM");
		inventory[78] = new Book(
				new Author("E.M.", "Forster", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"E.M.", "Forster", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A ROOM WITH A VIEW");
		inventory[79] = new Book(
				new Author("Evelyn", "Waugh", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Evelyn", "Waugh", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "BRIDESHEAD REVISITED");
		inventory[80] = new Book(
				new Author("Saul", "Bellow", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Saul", "Bellow", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE ADVENTURES OF AUGIE MARCH");
		inventory[81] = new Book(
				new Author("Wallace", "Stegner", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Wallace", "Stegner", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "ANGLE OF REPOSE");
		inventory[82] = new Book(
				new Author("V.S.", "Naipaul", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"V.S.", "Naipaul", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "A BEND IN THE RIVER");
		inventory[83] = new Book(
				new Author("Elizabeth", "Bowen", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Elizabeth", "Bowen", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE DEATH OF THE HEART");
		inventory[84] = new Book(
				new Author("Joseph", "Conrad", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Joseph", "Conrad", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "LORD JIM");
		inventory[85] = new Book(new Author("E.L.", "Doctorow", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "E.L.", "Doctorow", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "RAGTIME");
		inventory[86] = new Book(
				new Author("Arnold", "Bennett", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Arnold", "Bennett", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE OLD WIVES' TALE");
		inventory[87] = new Book(
				new Author("Jack", "London", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Jack", "London", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE CALL OF THE WILD");
		inventory[88] = new Book(new Author("Henry", "Green", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "Henry", "Green", null), new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED),
				"LOVING");
		inventory[89] = new Book(
				new Author("Salman", "Rushdie", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Salman", "Rushdie", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "MIDNIGHT'S CHILDREN");
		inventory[90] = new Book(
				new Author("Erskine", "Caldwell", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Erskine", "Caldwell", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "TOBACCO ROAD");
		inventory[91] = new Book(
				new Author("William", "Kennedy", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"William", "Kennedy", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "IRONWEED");
		inventory[92] = new Book(new Author("John", "Fowles", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED,
				MONTH_DIED, DAY_DIED, "John", "Fowles", null), new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED),
				"THE MAGUS");
		inventory[93] = new Book(
				new Author("Jean", "Rhys", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Jean", "Rhys", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "WIDE SARGASSO SEA");
		inventory[94] = new Book(
				new Author("Iris", "Murdoch", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Iris", "Murdoch", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "UNDER THE NET");
		inventory[95] = new Book(
				new Author("William", "Styron", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"William", "Styron", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "SOPHIE'S CHOICE");
		inventory[96] = new Book(
				new Author("Paul", "Bowles", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"Paul", "Bowles", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE SHELTERING SKY");
		inventory[97] = new Book(
				new Author("James", "Cain", "M.", YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"James", "Cain", "M."),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE POSTMAN ALWAYS RINGS TWICE");
		inventory[98] = new Book(
				new Author("J.P.", "Donleavy", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED, DAY_DIED,
						"J.P.", "Donleavy", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE GINGER MAN");
		inventory[99] = new Book(
				new Author("Booth", "Tarkington", null, YEAR_BORN, MONTH_BORN, DAY_BORN, YEAR_DIED, MONTH_DIED,
						DAY_DIED, "Booth", "Tarkington", null),
				new Date(YEAR_PUBLISHED, MONTH_PUBLISHED, DAY_PUBLISHED), "THE MAGNIFICENT AMBERSONS");
	}

	/**
	 * @return the name of the store.
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * @param storeName 
	 * @param storeName
	 *            the name of the book store.
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * @return the Array of inventory.
	 */
	public Book[] getInventory() {
		return inventory;
	}

	/**
	 * @param inventory 
	 * @param inventory
	 *            stores the inventory.
	 */
	public void setInventory(Book[] inventory) {
		this.inventory = inventory;
	}

	/**
	 * @param authorLastName
	 *            the last name of the author.
	 * @return the number of book the author wrote that matches the last name
	 *         parameter.
	 */
	public int howManyBooksDidThisAuthorWrite(String authorLastName) {
		int howManyBooks = DEFAULT_COUNT;

		if ((inventory == null) || (inventory.length == DEFAULT_LENGTH)) {
			return DEFAULT_COUNT;
		}

		for (int i = DEFUALT_I; i < inventory.length; i++) {
			if (inventory[i].getAuthor().getName().getLastName().equalsIgnoreCase(authorLastName)) {
				howManyBooks++;
			}
		}

		Book[] matches = new Book[howManyBooks];
		int indexInNewArray = DEFAULT_COUNT;

		for (int j = DEFUALT_J; j < inventory.length; j++) {
			if (inventory[j].getAuthor().getName().getLastName().equalsIgnoreCase(authorLastName)) {
				matches[indexInNewArray] = inventory[j];
				indexInNewArray++;
			}
		}
		return matches.length;
	}

	/**
	 * @param title
	 *            the title of the book.
	 * @return the full name of the author.
	 */
	public String getAuthorFullName(String title) {
		String authorFullName = null;

		if ((inventory == null) || (inventory.length == DEFAULT_LENGTH)) {
			return null;
		}

		for (int i = DEFUALT_I; i < inventory.length; i++) {
			if (inventory[i].getTitle().equalsIgnoreCase(title)) {
				authorFullName = inventory[i].getAuthor().getName().getFullName();
			}

			if ((title.equals(null)) || (title.equals(""))) {
				return null;
			}
		}
		return authorFullName;
	}

	/**
	 * @param authorLastName
	 *            the last name of the author.
	 * @return null if there is no book written by authors last name otherwise
	 *         returns the Book object(s) of the author with the last name
	 *         parameter.
	 */
	public Book[] getBooksWrittenBy(String authorLastName) {
		int writtenBy = DEFAULT_COUNT;

		if ((inventory == null) || (inventory.length == DEFAULT_LENGTH)) {
			return null;
		}

		for (int i = DEFUALT_I; i < inventory.length; i++) {
			if (inventory[i].getAuthor().getName().getLastName().equalsIgnoreCase(authorLastName)) {
				writtenBy++;
			}
		}

		Book[] matches = new Book[writtenBy];
		int indexInNewArray = DEFAULT_COUNT;

		for (int j = DEFUALT_J; j < inventory.length; j++) {
			if (inventory[j].getAuthor().getName().getLastName().equalsIgnoreCase(authorLastName)) {
				matches[indexInNewArray] = inventory[j];
				indexInNewArray++;
			}
		}

		if ((matches == null) || (matches.length == DEFAULT_LENGTH)) {
			return null;
		}
		return matches;
	}

	/**
	 * @param firstName
	 *            the first name of the author.
	 * @return the first Book object written by an author.
	 */
	public Book getBookWrittenBy(String firstName) {
		if ((inventory == null) || (inventory.length == DEFAULT_LENGTH)) {
			return null;
		}

		for (int i = DEFUALT_I; i < inventory.length; i++) {
			if (inventory[i].getAuthor().getName().getFirstName().equalsIgnoreCase(firstName)) {
				return inventory[i];
			}
		}
		return null;
	}

	/**
	 * @param wordInTitle
	 *            the titles of all the books that contain a worid in title.
	 * @return null if there is not books or if wordInTitle equals null or ""
	 *         otherwise returns an Array of Strings.
	 */
	public String[] getBookTitlesContaining(String wordInTitle) {
		int booksContaining = DEFAULT_COUNT;

		if ((inventory == null) || (inventory.length == DEFAULT_LENGTH)) {
			return null;
		}

		for (int i = DEFUALT_I; i < inventory.length; i++) {
			if ((wordInTitle.equals(null)) || (wordInTitle.equals(""))) {
				return null;
			}

			if (inventory[i].getTitle().contains(wordInTitle)) {
				booksContaining++;
			}
		}

		String[] matches = new String[booksContaining];
		int indexInNewArray = DEFAULT_COUNT;

		for (int j = DEFUALT_J; j < inventory.length; j++) {
			if ((wordInTitle.equals(null)) || (wordInTitle.equals(""))) {
				return null;
			}

			if (inventory[j].getTitle().contains(wordInTitle)) {
				matches[indexInNewArray] = wordInTitle;
				indexInNewArray++;
			}
		}
		return matches;
	}
}