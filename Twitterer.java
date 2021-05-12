
//compile using this:
// javac -cp .:./twitter4j-4/lib/twitter4j-core-4.0.7.jar *.java
// java -cp .:./twitter4j-4/lib/twitter4j-core-4.0.7.jar TwitterBot

import twitter4j.Status;
import twitter4j.Twitter; //twitter object that interfaces w Twitter itself
import twitter4j.TwitterFactory; //creates a twitter object :)
import twitter4j.TwitterException; //maybe we dont have internet or twitter itself is broken??

import java.io.IOException; //input/output exception handling for file
import java.io.PrintStream; //jic we have issues with the printstream.

public class Twitterer
{
	private Twitter twitter;
	private PrintStream consolePrint;

	//CONSTRUCTOR GOES HERE!!!
	public Twitterer(PrintStream console)
	{
		//Connects to Twitter and performs authorizations.
		twitter = TwitterFactory.getSingleton();
		consolePrint = console;
	}

	//to actually tweet out a message:
	public void tweetOut(String message) throws TwitterException, IOException
	{
		Status status = twitter.updateStatus(message);
		System.out.println("Did the status update to this?: " + status.getText());
	}

}