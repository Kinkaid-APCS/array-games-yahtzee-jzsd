import java.util.Arrays;

/**
 * The scorecard is a class that keeps track of how many points the player
 * has accumulated in each category, as well as subtotals, bonuses and totals.
 */
public class ScoreCard {
    // you might find this handy - strings for the category, all of the same length.
	// The "final" keyword means that this variable is a constant - you can't change 
	//     it while the program is running.
	private final String[] categories = {"ONES       ",
										 "TWOS       ",
										 "THREES     ",
										 "FOURS      ",
										 "FIVES      ",
										 "SIXES      ",
										 "3 OF A KIND",
										 "4 OF A KIND",
										 "FULL HOUSE ",
										 "SM STRAIGHT",
										 "LG STRAIGHT",
										 "CHANCE     ",
										 "YAHTZEE    "};
	/* these "public static final" variables are constants I think you might find handy, 
		since the numbers for the categories in the list above aren't really intuitive!
		In this class, you can refer to the variable directly, e.g. "categoryIsEmpty(TWOS)".
		In other classes, you'll need to put the name of the class first, as in 
		theScoreCard.getScoreForCategory(ScoreCard.YAHTZEE);
		See the ScoreCardTest for an example.
		TL;DNR: these are CODE NUMBERS for the various categories.
	*/
	public static final int ONES = 0;
	public static final int TWOS = 1;
	public static final int THREES = 2;
	public static final int FOURS = 3;
	public static final int FIVES = 4;
	public static final int SIXES = 5;
	public static final int THREE_OF_A_KIND = 6;
	public static final int FOUR_OF_A_KIND = 7;
	public static final int FULL_HOUSE = 8;
	public static final int SMALL_STRAIGHT = 9;
	public static final int LARGE_STRAIGHT = 10;
	public static final int CHANCE = 11;
	public static final int YAHTZEE = 12;
	
	
	// TODO: decide which private member variables ScoreCard should have and create them here.

	private int[] scoreholder;
	/**
	 * constructor - set up an empty scorecard.
     * Suggestion: start all scores as -1, since it is possible that the user
     * might choose to put a zero in a category as his/her move.
 	 */
	public ScoreCard()
	{
		//--------------------
		// TODO: insert your code here.
		scoreholder = new int[13];
		ScoreCard initial = new ScoreCard();
		for (int i = 0;i<13;i++)
		{
			scoreholder[i] = -1;
		}


		//--------------------
	}
	
	/** 
	 * categoryIsEmpty - returns whether the user can choose this category.
	 * @param category - which category (number?) we want
	 * @return whether (true/false) this category can be chosen by the user to enter a number. 
	 */
	public boolean categoryIsEmpty(int category)
	{
		boolean empty = true;
		//--------------------
		// TODO: insert your code here.
		if (category != -1)
		{
			empty = false;
		}

		//--------------------
		return empty;
	}
	
	/**
	 * setScoreForCategory - put the given score into the given category
	 * @param score
	 * @param category - which category (number?) to put this score into
	 */
	//use array here to create a space for where the scores live?
	public void setScoreForCategory(int score, int category)
	{
		//--------------------
		// TODO: insert your code here.
		scoreholder[category] = score;

		//--------------------
	}
	
	/**
	 * getScoreForCategory - returns the score currently listed in the given category
	 *  @param category - which category (number?) we want
	 *  @return the score stored in that category
	 */
	public int getScoreForCategory(int category)
	{
		int response = -1;
		//--------------------
		// TODO: insert your code here.
		response = scoreholder[category];
		//--------------------
		return response;
	}
	/**
	 * accessor for the subtotal of all the numbered fields (without the bonus).
	 * (Note: -1 counts as zero!)
	 * @return the subtotal of ones, twos, threes, fours, fives, and sixes. 
	 */
	public int getTopSubtotal()
	{
		int topsubtotal = 0;
		//--------------------
		// TODO: insert your code here.
		for (int i = 0;i<=5;i++)
		{
			topsubtotal+= scoreholder[i];
		}
		//--------------------
		return topsubtotal;
	}
	/**
	 * accessor for the subtotal of all the poker-hand fields
	 * (Note: -1 counts as zero!)
	 * @return the subtotal of threeOfKind, fourOfKind, fullHouse, smallStr, lrgStr, chance, yahtzee
	 */
	public int getBottomSubtotal()
	{
		int bottomsubtotal = 0;
		//--------------------
		// TODO: insert your code here.
		for (int i = 6;i<=13;i++)
		{
			bottomsubtotal+= scoreholder[i];
		}
		//--------------------
		return bottomsubtotal;
	}
	/**
	 * determines the bonus found in the top section.
	 * @return 35, if top >= 63; zero otherwise.
	 */
	public int getTopBonus()
	{
		int bonus = 0;
		//--------------------
		// TODO: insert your code here.
		if (getTopSubtotal() >=63)
		{
			bonus = 35;
		}
		//--------------------
		return bonus;
	}
	
	public int getTotal()
	{
		int total = 0;
		//--------------------
		// TODO: insert your code here.
		total = getTopSubtotal() + getBottomSubtotal() +getTopBonus();
		//--------------------
		return total;
	}
	

	
	/**
	 * toString - returns a listing of the card, as it would appear in the
	 * game.
	 * @return a string containing the card to display.
	 * Suggested: Precede the categories with letters, so that the user can
	 * easily choose them:
	 * A ONES           3
	 * B TWOS           -
	 * C THREES         12
	 * D FOURS          -
	 * E FIVES          0
	 * etc.
	 */

	public String toString()
	{
		String result = "";
		//--------------------
		// TODO: insert your code here.
		result = "(0) ONES           "+scoreholder[0]+"\r"+
				 "(1) TWOS           "+scoreholder[1]+"\r"+
				 "(2) THREES         "+scoreholder[2]+"\r"+
				 "(3) FOURS          "+scoreholder[3]+"\r"+
				 "(4) FIVES          "+scoreholder[4]+"\r"+
				 "----------------------------------------"+ "\r"+
		         "(5) 3 of a kind    "+scoreholder[5]+"\r"+
				 "(6) 4 of a kind    "+scoreholder[6]+"\r"+
				 "(7) Full House     "+scoreholder[7]+"\r"+
				 "(8) Small Straight "+ scoreholder[8]+"\r"+
				 "(9) Large Straight "+ scoreholder[9]+"\r"+
				 "(10) Yahtzee       "+ scoreholder[10]+"\r"+
				"(11) Chance         "+ scoreholder[11]+"\r"+
				"------------------------------------------";

		//--------------------
		return result;
	}
	
}
