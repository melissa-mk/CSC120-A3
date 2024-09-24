import java.util.ArrayList;
import java.util.Scanner;

class Conversation {
  int numRounds;
  ArrayList<String> userInputs = new ArrayList<>();

  public Conversation() {
    System.out.println("How many rounds?");
    numRounds = new Scanner(System.in).nextInt();
    System.out.println("Hi there! What's on your mind?");
    for(int i = 0; i < numRounds; i++) {
      Scanner in = new Scanner(System.in);
      String prompt = in.nextLine();
      userInputs.add(prompt);
      if(prompt.contains("me")||prompt.contains("I'm")||prompt.contains("I am")) {
        // replace first-person pronouns with second-person pronouns
      }
    }
    System.out.println("Mhmm, see ya!");
  }
  public void printTranscript(){
    System.out.println("TRANSCRIPT:");
    for(int i = 0; i < numRounds; i++) {
      System.out.println(userInputs.get(i));
    }
  }

  public static void main(String[] arguments) {
    Conversation c = new Conversation();
    c.printTranscript();
  }
}
