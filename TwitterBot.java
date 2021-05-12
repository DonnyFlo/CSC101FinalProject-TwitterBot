/*
* TwitterBot
* Created By: Donny Flores
* Created In: May 2021

I used this youtube vid to figure out the ins and outs of the Twitter API
https://www.youtube.com/watch?v=kgj3mjclAsM
*/

//Here's how to get this to run using the command line:
// javac -cp .:./twitter4j-4/lib/twitter4j-core-4.0.7.jar *.java
// java -cp .:./twitter4j-4/lib/twitter4j-core-4.0.7.jar TwitterBot

import twitter4j.Twitter; //twitter object that interfaces w Twitter itself
import twitter4j.TwitterException; //in case no internet or Twitter itself is broken
import java.io.PrintStream; //exception w PrintStream
import java.io.IOException; //bad file, input/output mismatch exception handling

import java.util.Random;

public class TwitterBot
{
	//A PrintStream adds functionality to another output stream, 
	//namely the ability to print representations of various data 
	//values conveniently. Two other features are provided as well. 
	//Unlike other output streams, a PrintStream never throws an IOException; 
	//instead, exceptional situations merely set an internal flag that can
	//be tested via the checkError method.
	private static PrintStream consolePrint;
	//this stays out of main due to properties of the object.

	public static void main(String[] args) throws TwitterException, IOException
	{
		//set up classpath and properties file
		Twitterer ourTweet = new Twitterer(consolePrint);

		//initialize message that gets tweeted out:
		String message = "";

		//create message:
		Random rand = new Random();
		int choice = rand.nextInt(70);

		//add the greek bits:
		GreekWords theWord = new GreekWords();
		theWord.setWord(choice);
		message += theWord.getWord();

		//tweet out the completed message
		ourTweet.tweetOut(message);
	}
}