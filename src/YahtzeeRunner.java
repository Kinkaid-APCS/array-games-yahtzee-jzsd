
public class YahtzeeRunner {

	public static void main(String[] args) {

		boolean testingMode = true;


		Board test = new Board();
		if (testingMode)
		{
			System.out.println("Start tests");
			// enter test code here.
			test.debugSetDice(1,1,1,1,1);
			System.out.println(test);
			test.rollSelectedDice("ABC");
			System.out.println(test);

			System.out.println("End tests");
		}
		else
		{
			Referee ref = new Referee();
			System.out.println("Start game");
			ref.playGame();
			System.out.println("End game");
		}





	}

}
