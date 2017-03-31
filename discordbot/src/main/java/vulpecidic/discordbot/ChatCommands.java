package vulpecidic.discordbot;

import java.util.Random;

public class ChatCommands {

	private static Random random = new Random();

	//Returns list of working chat commands so far, as long as I remember to update it. Good luck with that.
	public static String getListOfCommands() {
		String listOfCommands = "!help -> Gives a list of the possible commands.\n\n"
				+ "!coin -> flips a coin and returns either heads or tails.\n\n"
				+ "!roll (amountOfDice)d(sidesOfDice) -> rolls specified amount of rolls with specified amount of sides.\n\t Ex. \"!roll 4d20\" would roll 4 D20's and return [1,20] for each roll.";
		return listOfCommands;
	}
	
	//Flips a "coin" -> true = Heads, false = Tails. Returns String result
	//example: !coinFlip -> returns "Heads."
	public static String coinFlipper() {
		boolean coinResult = random.nextBoolean();
		String result = "ERROR";
		if (coinResult == true) { result = "Heads.";}
		else { result = "Tails."; }
		return result;
	}

	//Rolls specified amount of dice with specified number of sides each, returns String with rolls separated by whitespace
	//example: !roll 2D6 -> rolls 2 6-sided dice, returns String "Your roll(s): 4 6"
	//decodedMessage[0] is the amount of rolls, and decodedMessage[1] is the sides of the dice
	public static String diceRoll(String message) {
		String diceRollValues = "Your Roll(s): ";
		int decodedMessage[] = decodeDiceRoll(message);
		for (int i=0; i<decodedMessage[0]; i++){
			int randomNumber = random.nextInt(decodedMessage[1]) + 1;		//random generator makes 0->n-1, the +1 makes the value 1->n
			diceRollValues = diceRollValues + randomNumber + " ";			//appends the roll to the string of rolls
		}
		return diceRollValues;
	}
	
	//helper function for diceRoll
	//takes the String message and converts it to an array of 2 integers
	//rollInformation[0] is the amount of rolls, and rollInformation[1] is the sides of the dice
	private static int[] decodeDiceRoll(String message) {
		String[] words = new String[2];
		words = message.split(" ");
		String[] rollInformation = new String[1];
		rollInformation = words[1].split("d");
		try {
			return new int[] {Integer.parseInt((rollInformation[0])), Integer.parseInt((rollInformation[1]))};
		}  catch (NumberFormatException e) {
			return new int[] {-1, -1};
		}
	}
}
