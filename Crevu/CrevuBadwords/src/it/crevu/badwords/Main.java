package it.crevu.badwords;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean outcome=false;
		String sentence="fascismomerda";
		CheckSentence check= new CheckSentence();
		outcome=check.check_string(sentence);
		if (outcome)
			System.out.print(sentence+" - OK");
		else
			System.out.print(sentence+" - KO");

	}
	

}
