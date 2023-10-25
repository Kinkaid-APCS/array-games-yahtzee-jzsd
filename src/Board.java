// bruh
// bruh2
// btuh3
//bruh4
/**
 *  This class represents the dice on the board. It allows the user to
 *  reroll certain dice, and it calculates the score for a given category.
 *  It keeps two lists - one list of the five dice, and 
 *  one that keeps track of how many of each die value are showing.
 *  In the statistics biz, this is called a "frequency count."
 *  For instance, if the dice are {1, 1, 4, 1, 4} then the second array 
 *  would have 3 in the slot for (1) and 2 in the slot for (4). The easiest
 *  way to do this might be to have a seven-element array, and ignore index
 *  0. (I'll put in a -1 so I remember it doesn't count.) This would then look 
 *  like {-1, 3, 0, 0, 2, 0, 0}. - such a secondary array will make it MUCH 
 *  easier to find things like four of a kind, a bunch of 3's, or a full house.
 */
public class Board {

	// TODO: decide which private member variables Board needs and declare them here. 
	//          HINT: See the note above!

	private int[] myDice;
	private int[] frequencyChart;
	private int scoreAwarded = 0;
	/**
	 * constructor - set up initial values for the board.
	 */
	// TODO: write the Board's constructor

	public Board()
	{
		myDice = new int[5];
		frequencyChart = new int[7];
		frequencyChart[0] = -1;

	}
	/**
	 * toString - creates a string depicting the dice on the board.
	 * @return a string depicting the dice.
	 * I suggest that you also put letters to label which die is which, for example:
	 * +---+---+---+---+---+
	 * | A | B | C | D | E |
	 * +---+---+---+---+---+
	 * | 1 | 1 | 4 | 1 | 4 |
	 * +---+---+---+---+---+
	 */
	// TODO: write the Board's toString method
	public String toString()
	{
		String finalresult = "";

		String diceresult = "";
		diceresult+="| ";

		for(int i = 0;i<myDice.length;i++)
		{
			diceresult += myDice[i]+" | ";
		}

		finalresult = "+---+---+---+---+---+\n" +
				"| A | B | C | D | E |\n" +
				"+---+---+---+---+---+\n"+diceresult+"\n+---+---+---+---+---+";

	return finalresult;

	}
	
	/**
	 * rollSelectedDice - takes a string and goes letter by letter; if a
	 * letter is in the range A-E, it randomizes the corresponding die.
	 * e.g., if the string is "ABE," then you would roll dice 0, 1, and 4.
	 * To roll all the dice, send it "ABCDE."
	 * I suggest you call updateFrequencyList at the end of this method.
	 * 
	 * @param - a string to parse. (e.g., "CE")
	 * no return value - only internal variables are changed.
	 */
	public void rollSelectedDice(String stringToParse)
	{
		// I'm starting this one for you, since we haven't been splitting strings yet.
		for (int i=0; i<stringToParse.length(); i++) // loop one letter at a time....
		{
			String letter = stringToParse.substring(i, i+1);
			// so now "letter" is one of the letters in the string.
			// TODO: write code here to look at "letter" and based on it, 
			//       decide whether to re-roll one of the dice.
			int lettertomatch=-1;

			switch (letter)
			{
				case "A":
				{
					lettertomatch = 0;
					break;
				}

				case "B":
				{
					lettertomatch = 1;
					break;
				}

				case "C":
				{
					lettertomatch = 2;
					break;
				}
				case "D":
				{
					lettertomatch = 3;
					break;
				}
				case "E":
				{
					lettertomatch = 4;
					break;
				}
			}

			myDice[lettertomatch] = (int)(Math.random()*(6)+1);

		}
	
	}
	
	/**
	 * recalculates the frequency list - how many 1s are showing on the dice? 
	 *    How many 2s are showing? 3s? 4s? 5s? 6s?
	 * postcondition: the frequency list now reflects the current state of the dice.
	 * No return value - only internal variables are changed.
	 */
	public void updateFrequencyList()
	{
		// ---------------------------
		// TODO: write your code here.


		for (int i = 0; i<myDice.length;i++)
		{
			switch (myDice[i])
			{
				case 1:
				{
					frequencyChart[1]++;
					break;
				}
				case 2:
				{
					frequencyChart[2]++;
					break;
				}

				case 3:
				{
					frequencyChart[3]++;
					break;
				}

				case 4:
				{
					frequencyChart[4]++;
					break;
				}
				case 5:
				{
					frequencyChart[5]++;
					break;
				}
				case 6:
				{
					frequencyChart[6]++;
					break;
				}
			}


		}



		
		// ---------------------------
	}
	
	
	/**
	 * getScoreForCategory - considers the current set of dice and calculates
	 * what score would be awarded if the player picks the given category.
	 * Although some simple categories can be handled here, I'd suggest you write a
	 * sub-method for each of the complicated ones (or write separate methods for every one of them) to
	 * perform this calculation, rather than a single, 100+ line method! 
	 * @param - category. This is an integer. However, rather than putting code numbers 
	 *   in your code, it will be more readable if you use well-named constants.
	 *   I would refer you to the public final variables in the ScoreCard class (e.g., ScoreCard.ONES) - it
	 *   will be easier to read than the code numbers, themselves. (See the example below.)
	 * @return how many points should be awarded, based on the dice and the
	 *   category selected.
	 *   For example: 
	 *   Consider the dice as {1,1,4,1,4}; then 
	 *    •this would correspond to the frequencies list: {0, 3, 0, 0, 2, 0}  
	 *    •getScoreForCategory(ScoreCard.ONES) would return 3.
	 *    •getScoreForCategory(ScoreCard.TWOS) would return 0.
	 *    •getScoreForCategory(ScoreCard.FOURS) would return 8.
	 *    •getScoreForCategory(ScoreCard.THREE_OF_A_KIND) would return 11.
	 *    •getScoreForCategory(ScoreCard.FULL_HOUSE) would return 25.
	 *    •getScoreForCategory(ScoreCard.LARGE_STRAIGHT) would return 0.
	 */
	// TODO: Write Board's getScoreForCategory method.
	// polite suggestion... break this into smaller methods for the various categories. Some of these methods, like the
	//    ones at the top of the card might work for more than one category. Others, like for full house, might be more
	//    specialized....

	public int getScoreForCategory(int category)
	{
		switch (category) {
			case ScoreCard.ONES:
			{
				return ONES();

			}

			case ScoreCard.TWOS:
			{
			 return TWOS();
			}

			case ScoreCard.THREES:
			{
				return THREES();
			}

			case ScoreCard.FOURS:
			{
				return FOURS();
			}

			case ScoreCard.FIVES:
			{
				return FIVES();
			}

			case ScoreCard.SIXES:
			{
				return SIXES();
			}

			case ScoreCard.THREE_OF_A_KIND:
			{
				return THREE_OF_KIND();

			}

			case ScoreCard.FOUR_OF_A_KIND:
			{
				return FOUR_OF_A_KIND();
			}

			case ScoreCard.FULL_HOUSE:
			{

				return FULL_HOUSE();

			}

			case ScoreCard.SMALL_STRAIGHT:
			{
				return SMALL_STRAIGHT();
			}

			case ScoreCard.LARGE_STRAIGHT:
			{
				return LARGE_STRAIGHT();
			}

			case ScoreCard.CHANCE:
			{
				return CHANCE();
			}

			case ScoreCard.YAHTZEE:
			{
				return YAHTZEE();
			}

		}

		return -1;

	}

	public int ONES ()
	{
		return frequencyChart[1];

	}

	public int TWOS ()
	{

		return frequencyChart[2];
	}

	public int THREES ()
	{

		return frequencyChart[3];
	}

	public int FOURS ()
	{

		return frequencyChart[4];
	}

	public int FIVES ()
	{

		return frequencyChart[5];
	}

	public int SIXES ()
	{

		return frequencyChart[6];
	}

	public int THREE_OF_KIND()
	{
		int scorethreeofakind=0;
		for (int i = 0; i<frequencyChart.length;i++)
		{
			if (frequencyChart[i]==3)
			{
				scorethreeofakind = frequencyChart[i]*i;
			}

		}

		return scorethreeofakind;
	}


	public int FOUR_OF_A_KIND()
	{
		int fourofakind=0;
		for (int i = 0; i<frequencyChart.length;i++)
		{
			if (frequencyChart[i]==4)
			{
				fourofakind = frequencyChart[i]*i;
			}

		}

		return fourofakind;
	}

	public int FULL_HOUSE()
	{
		int j = 0;
		int scorefullhouse= 0;

		for (int i = 0; i<frequencyChart.length;i++)
		{
			if (frequencyChart[i]==3)
			{
				j++;

			}

			else if (frequencyChart[i]==2)
			{
				j++;

			}

		}

		if (j==2)
		{
			scorefullhouse = 25;
		}

		return scorefullhouse;


	}

	public int SMALL_STRAIGHT()
	{
		int scoresmallstraight = 0;
		for (int i= 1; i<3;i++)
		{
			if (frequencyChart[i]!=0 && frequencyChart[i+1]!=0&& frequencyChart[i+2]!=0&&frequencyChart[i+3]!=0)
			{
				scoresmallstraight = 30;
			}

		}

		return scoresmallstraight;

	}

	public int LARGE_STRAIGHT()
	{
		int scorelargestraight=0;
		if (frequencyChart[1]!=0&&frequencyChart[2]!=0&&frequencyChart[3]!=0&&frequencyChart[4]!=0&&frequencyChart[5]!=0)
		{
			scorelargestraight=40;
		}

		return scorelargestraight;
	}


	public int CHANCE()
	{
		int scorechance = 0;
		for(int i =0;i<frequencyChart.length;i++)
		{
			scorechance+=frequencyChart[i]*i;
		}


		return scorechance;

	}

	public int YAHTZEE()
	{

		int scoreyahtzee = 0;

		for(int i =0;i<frequencyChart.length;i++)
		{
			if (frequencyChart[i] == 5)
			{
				scoreyahtzee = 50;
			}

		}
		return scoreyahtzee;
	}

	/**
	 * gets the list of die frequencies calculated in the updateFrequencies() method.
	 * @return the list of frequencies.
	 */
	public int[] getFrequencies()
	{
		int [] result = null; // I just put this in here to compile - you can replace it.
		// ---------------------------
		// TODO: write your code here.
		
		// ---------------------------
		return result;
	}

	//----------------------------------- Debugging methods
	// I think you'll find the following methods handy to test how your game scores dice combinations without
	//    having to play the game and wait for the random number generator to give you the hand you're interested in.
	// These next two methods should NEVER be called during normal game play.

	/**
	 * sets the 5 dice to specific values - this should be used for debugging purposes only.
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 */
	public void debugSetDice(int a, int b, int c, int d, int e)
	{
		// ---------------------------
		// TODO: write your code here.
		
		// ---------------------------		
	}
	
	public int[] debugGetDice()
	{
		int[] result = null; // temporary, so this compiles
		// ---------------------------
		// TODO: write your code here.
		
		// ---------------------------
		return result;
	}
}
