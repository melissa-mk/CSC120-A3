import java.util.ArrayList;
import java.util.Scanner;

/***
 * This Conversation class creates a chatbot that asks the user how many rounds the want (how many prompts they will provide) and responds to each of them. At the end of the conversation, the chatbot prints a transcript of the whole conversation.
 */
class Conversation {
  int numRounds;
  ArrayList<String> transcript = new ArrayList<>(); // array of strings to store user prompts and bot responses

  public Conversation() {
    System.out.println("How many rounds?");
    numRounds = new Scanner(System.in).nextInt();
    System.out.println("Hi there! What's on your mind?");
    for(int i = 0; i < numRounds; i++) {
      Scanner in = new Scanner(System.in);
      String prompt = in.nextLine();
      transcript.add(prompt); // adds user input to the transcript string array
      if(prompt.contains("me")||prompt.contains("I'm")||prompt.contains("I am")) {
        // try to replace first-person pronouns with second-person pronouns
      }
    }
    System.out.println("Mmm-hm, see ya!");
  }
  public void printTranscript(){
    System.out.println("TRANSCRIPT:");
    for(int i = 0; i < numRounds; i++) { // iterating through the whole ArrayList
      System.out.println(transcript.get(i));
    }
  }

  public static void main(String[] arguments) {
    Conversation c = new Conversation(); // runs the conversation
    c.printTranscript();
  }
}
