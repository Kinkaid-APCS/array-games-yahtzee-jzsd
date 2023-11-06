import java.util.Scanner;

/**
 * The Referee class is in charge of keeping track of the Board (the dice)
 * and one or two ScoreCards, depending on how many players there are. It
 * handles the interactions with the player, asking the player what to do,
 * determining whether the moves are legal, displaying the board and scorecard,
 * and updating the board and scorecard.
 *
 */
public class Referee {

	private ScoreCard[] myScoreCards; // one for each player
	private Board theBoard;
	private int timesrolled;
	private boolean isPlaying;
	private ScoreCard myScoreCard;
	private int rollnumber = 0;

	
	/**
	 * constructor - set up the Referee class
	 */
	public Referee()
	{
		//--------------------
		// TODO: insert your code here.
		//myScoreCards = new ScoreCard[1];
		//myScoreCards[0] = new ScoreCard();
		myScoreCard = new ScoreCard();
		theBoard = new Board();
		timesrolled = 1;
		isPlaying = true;
		
		//--------------------
	}
	
	/**
	 * roll all the dice at once, as in the start of a new turn.
	 */
	public void rollAllDice()
	{
		// I've written this one for you. ;^)
		rollDice("ABCDE");
	}
	
	/**
	 * roll some dice, as indicated
	 * @param diceToRoll - a string that indicates which dice to roll. For instance,
	 * "ADE" would mean to roll die A, die D and die E, without changing die B or 
	 * die C.
	 */
	public void rollDice(String diceToRoll)
	{
		// I've written this one for you, too.
		theBoard.rollSelectedDice(diceToRoll);
	}
	
	/**
	 * playGame - the main game loop for the Referee.
	 */
	public void playGame()
	{
		while(isPlaying) {
			System.out.println("Game is playing");// placeholder code.
			//--------------------
			// TODO: insert your code here.
			//displayBoardAndDice();
			System.out.println();
			if (myScoreCard.win() == true)
			{
				theBoard.updateFrequencyList();
				displayBoardAndDice();
				isPlaying = false;
				System.out.println("You've won!");
				break;
			}
			rollAllDice();
			theBoard.updateFrequencyList();
			rollnumber = 1;
			displayBoardAndDice();
			rollAgain();
			theBoard.updateFrequencyList();
			System.out.println("What is the category you would like to import your score?");
			updateScore();
			rollnumber = 0;
			System.out.println("New Roll!");
		}
		//--------------------
	}

	public void updateScore()
	{
		Scanner score = new Scanner(System.in);
		int scorecategory = score.nextInt();
		if(myScoreCard.categoryIsEmpty(scorecategory)) myScoreCard.setScoreForCategory(theBoard.getScoreForCategory(scorecategory), scorecategory);
		else
		{
			System.out.println("You already have a score for that category! Please enter another category.");
			updateScore();
		}
	}


	public void rollAgain()
	{
		while(rollnumber < 3)
		{
			System.out.println("Would you like to roll again? Y/N");
			Scanner roll = new Scanner(System.in);
			String response = roll.nextLine();
			if (response.toUpperCase().equals("Y"))
			{
				System.out.println("What would you like to roll?");
				Scanner dice = new Scanner(System.in);
				String dicetoroll = dice.nextLine();
				rollDice(dicetoroll);
				timesrolled++;
				theBoard.updateFrequencyList();
				displayBoardAndDice();
				rollnumber++;
			}
			else break;
		}
		if(rollnumber>=3) System.out.println("You're out of rolls!");
	}

	/**
	 * displayBoardAndDice - does a s.o.p. to the screen, showing
	 * the score card for the current player, the dice, and ABCDE
	 * labels for the dice.
	 */
	public void displayBoardAndDice()
	{
		//--------------------
		// TODO: insert your code here.
		System.out.println(theBoard.toString());
		System.out.println(myScoreCard.toString());
		
		//--------------------
	}
	
	//-------------------------------
	// Code for debugging/testing only:
	
	public void debugSetDice(int[] inDice)
	{
		theBoard.debugSetDice(inDice[0], inDice[1], inDice[2], inDice[3], inDice[4]);
		theBoard.updateFrequencyList();
	}
	
	public int[] debugGetDice()
	{
		return theBoard.debugGetDice();
	}
	
	public int[] debugGetTotals()
	{
		return theBoard.getFrequencies();
	}
}
