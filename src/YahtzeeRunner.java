
public class YahtzeeRunner {

	public static void main(String[] args) {

		boolean testingMode = false;


		Board test = new Board();
		if (testingMode)
		{
			System.out.println("Start tests");
			// enter test code here.
			test.debugSetDice(1,2,3,4,3);
			System.out.println(test);
			test.updateFrequencyList();
			System.out.println(test.getScoreForCategory(10));


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
