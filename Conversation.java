import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/***
 * This Conversation class creates a chatbot that asks the user how many rounds the want (how many prompts they will provide),
 * responds to each of them.
 * At the end of the conversation, the chatbot prints a transcript of the whole conversation.
 */
class Conversation {
  public int numRounds;
  private ArrayList<String> transcript = new ArrayList<>(); // typesafe array of strings to store user prompts and bot responses
  private static final String[] defResponses={"Tell me more.","Sounds thrilling!", "Interesting.", "Why do you say that?"}; // predefined set of responses to user prompts

  /**
   * constructor
   */
  public Conversation() {
    System.out.println("Welcome to the Chatbot.");
  }

  /**
   * Outputs the stored transcript of user input and chatbot responses
   */
  public void printTranscript(){
    System.out.println("TRANSCRIPT:");
      for (String s : transcript) { // iterating through the whole transcript
          System.out.println(s);
      }
  }

  /**
   * Asks user for numRounds number of rounds,
   * Takes user input numRounds times
   * Responds each time with mirrored words and canned responses
   */
  public void chat(){
    System.out.println("How many rounds?");
    numRounds = new Scanner(System.in).nextInt();
    System.out.println("Hi there! What's on your mind?");
    transcript.add("Hi there! What's on your mind?");
    for(int i = 0; i < numRounds; i++) {
      Scanner in = new Scanner(System.in);
      String prompt = in.nextLine();
      transcript.add(prompt); // adds user input to the transcript string array
      prompt=prompt.toLowerCase();
      if(prompt.equalsIgnoreCase("me")||prompt.contains("you")||prompt.equalsIgnoreCase("i am") || prompt.contains("i'm")) { // if there's any first-person pronouns in the user input
        // trial to mirror words in progress
        System.out.println("mirror signal detected");
        String[] words = prompt.split(" ");
        for (int j = 0; j < words.length; j++) {
          if (words[i].equals("me") || words[j].contains("i")) {
            words[j] = "you";
          } else if (words[j].equals("you")) {
            words[j] = "i";
          }
          System.out.println(words[j]);
        }
      }else{
        if(i!=numRounds-1) { // if it's not the last round, keep the chat going by printing a random response from the predefined set
          int resIndex = new Random().nextInt(defResponses.length);
          String res = defResponses[resIndex];
          System.out.println(res);
          transcript.add(res);
        }else{ // if it's the last round, say goodbye
          System.out.println("Mmm-hm, see ya!");
        }
      }

    }
    transcript.add("Mmm-hm, see ya!");
  }

  /**
   * Runs the chatbot by instantiating the Conversation class
   * @param arguments The command line arguments (ignored)
   **/
  public static void main(String[] arguments) {
    Conversation c = new Conversation(); // runs the conversation
    c.chat();
    c.printTranscript();
  }
}
