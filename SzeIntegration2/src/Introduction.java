import java.util.Scanner;

// Louis Sze
// This is the Introduction class where my introduction is and rules for the game
public class Introduction {
  public void intro() {
    System.out.print("Welcome to my Integration Project\n");// \n creates a new line this is an
                                                            // escape sequence
    System.out.println("");
    System.out.print("Welcome to a game of BlackJack\n");// Prints out the message
    System.out.println("");

    Scanner input = new Scanner(System.in); // Scanner to allow user input
    System.out.println("Whats your name?");// Asks user for name
    String username = input.nextLine();// Stores the next input variable as a String
    System.out.println("Welcome " + username + "!");// Greets the User

    System.out.println("");

    System.out.println("Would you like to read the rules to the game?");
    System.out.println("Enter [y] for Yes or [n] for No.");
    char Response; // store the next input response from user as a char
    Response = input.next().charAt(0);
    while (true) {
      // While statement to ask for the instructions
      if (Response == 'y' || Response == 'Y') {
        // if statement if you enter y then the rules is displayed.
        System.out.println("Welcome to the game of Black Jack!");
        System.out
            .println("Black jack is a game also called 21, The goal is reach as close as possible "
                + "to 21 points with the cards given from the dealer without going over.\n "
                + "The game begins with the player placing a bet, then receiving two cards face up."
                + " The dealer also receives two cards.\n "
                + "The player wins the amount that was bet if the total "
                + "of his card values were closer to 21 than the dealer's card.\n"
                + " Another way to win is if the dealer goes over 21, while the player does not.\n"
                + " The player loses the bet if his total goes over 21.");
        System.out.println("");
        System.out.println("Let the game Begin!");
        System.out.println("");
        break; // break statement to terminate the loop.
      } else if (Response == 'n' || Response == 'N') {
        // == used to compare equals
        // if entered n then then the game begin without showing the rules.
        System.out.println("Let the Game Being!");
        System.out.println("");
        break; // break statement to terminate the loop.
      } else {
        System.out.println("Would you like to read the rules to the game");
        System.out.println("Must Enter [y] or [n]");
        Response = input.next().charAt(0);
        continue;// continue statement skips over the current iteration of a loop and goes
                 // directly to next iteration.
      }

    }
    // input.close();//closes scanner


  }
}
