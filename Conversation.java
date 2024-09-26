import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/***
 * This Conversation class creates a chatbot that asks the user how many rounds the want (how many prompts they will provide) and responds to each of them. At the end of the conversation, the chatbot prints a transcript of the whole conversation.
 */
class Conversation {
  int numRounds;
  ArrayList<String> transcript = new ArrayList<>(); // typesafe array of strings to store user prompts and bot responses
  String[] defResponses={"Tell me more.","Sounds thrilling!", "Interesting.", "Why do you say that?"}; // predefined set of responses to user prompts

  public Conversation() {
    System.out.println("How many rounds?");
    numRounds = new Scanner(System.in).nextInt();
    System.out.println("Hi there! What's on your mind?");
    for(int i = 0; i < numRounds; i++) {
      Scanner in = new Scanner(System.in);
      String prompt = in.nextLine();
      transcript.add(prompt); // adds user input to the transcript string array
      if(prompt.equalsIgnoreCase("me")||prompt.equalsIgnoreCase("I'm")||prompt.equalsIgnoreCase("I am")) { // if there's any first-person pronouns in the user input
        System.out.println("There is a first-person pronoun");
        // try to replace first-person pronouns with second-person pronouns
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
  public void printTranscript(){
    System.out.println("TRANSCRIPT:");
      for (String s : transcript) { // iterating through the whole transcript
          System.out.println(s);
      }
  }

  public static void main(String[] arguments) {
    Conversation c = new Conversation(); // runs the conversation
    c.printTranscript();
  }
}
