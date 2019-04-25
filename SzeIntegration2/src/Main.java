import java.util.Scanner;

// Louis Sze
// This is the main class, self explanatory; where everything happens.
public class Main {
  // This is a header
  // public is an access modifier
  // void is a return type, meaning this method does not return anything
  // method names should be in lowerCamelCase and be named with a verb
  public static void main(String[] args) {
    // Special meaning, starting point of a program
    // Introduction Message
    Introduction myIntro = new Introduction();
    myIntro.intro();

    // creating Playing Deck
    Deck playingDeck = new Deck();
    playingDeck.createFullDeck();
    playingDeck.shuffle();
    // shuffles the deck of cards
    // System.out.println(playingDeck); checking if cards is shuffled
    // Create a deck for the player
    Deck playerDeck = new Deck();
    // Create a deck for Dealer
    Deck dealerDeck = new Deck();
    // Amount of money starting stored as a double

    // double playerMoney = 500.00;

    Scanner userInput = new Scanner(System.in);

    System.out.println("How much do you want to Buy in?");
    System.out.println("Minimum Buy in is $100.00");

    double playerMoney = 0;
    if (userInput.hasNextDouble()) {
      playerMoney = userInput.nextDouble();
    } else {
      System.out.println("Wrong Input");

    }


    // a while loop for the game to start
    while (playerMoney > 0) {
      // While loop if player money is greater than 0 the Game starts or continues.
      // Game Starts
      // Starts the message of how much money you have and how much the player wants to bet.
      System.out
          .println("You currently have $" + playerMoney + ", how much would you like to bet?");
      double playerBet = userInput.nextDouble();
      // if statement if you bet more than you have then it is game over.
      if (playerBet > playerMoney) {
        System.out.println("You cannot bet more than what you have, Default Loss");
        break;
      }

      boolean endRound = false;
      // boolean variable

      // Starts Dealing
      // Player draws two cards from player deck
      playerDeck.draw(playingDeck);
      playerDeck.draw(playingDeck);

      // dealer draws two cards as well from the deck
      dealerDeck.draw(playingDeck);
      dealerDeck.draw(playingDeck);

      while (true) {
        System.out.print("Your Hand:");
        System.out.println(playerDeck.toString());
        System.out.println("Your Hand Value: " + playerDeck.cardsValue() + "\n");

        // Display Dealer Hand, The [Hidden] is the face down card.
        System.out.println(
            "Dealer Hand: \n " + dealerDeck.getCard(0).toString() + " and [Hidden Card]\n");

        // What do player want to do?
        // Enter 1 to hit or 2 to stand.
        System.out.println("Please input [1]To Hit or [2]To Stand?");
        int response = userInput.nextInt();

        // They hit
        if (response == 1) {
          playerDeck.draw(playingDeck);
          System.out
              .println("You draw a " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
          // Bust if greater than 21
          // subtracts money when bust
          if (playerDeck.cardsValue() > 21) {
            System.out.println("Current Hand Value : " + playerDeck.cardsValue());
            System.out.println("Bust!");
            System.out.println("");
            playerMoney -= playerBet;// Takes the players money and use the math operator to
                                     // subtract from bet but also make it equal to the amount
            endRound = true;
            break;
          }
        }
        if (response == 2) {
          break;
        }
      }
      // Reveal dealer cards
      System.out.println("Dealer's Hand: " + dealerDeck.toString());
      // see if dealer has more points than player
      if (dealerDeck.cardsValue() > playerDeck.cardsValue() && endRound == false) {
        System.out.println("Dealer Wins!");
        playerMoney -= playerBet;
        endRound = true;
      }
      // Dealer draws at 16 stand at 17
      while ((dealerDeck.cardsValue() < 17) && endRound == false) {
        dealerDeck.draw(playingDeck);
        System.out
            .println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
      }
      // Display Total Value for Dealer
      System.out.println("Dealer's Hand is valued at: " + dealerDeck.cardsValue());
      // Determine if dealer busted
      if ((dealerDeck.cardsValue() > 21) && endRound == false) {
        System.out.println("Dealer busts! You Win!");
        playerMoney += playerBet;
        endRound = true;
      }
      // Determine if push also means tie
      if ((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
        System.out.println("Push, Player's money is returned.");
        endRound = true;
      }
      if ((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
        // if statement if your card is higher than dealer then you win
        System.out.println("You Win!");
        playerMoney += playerBet;// if you win then your money doubles the amount you bet
        endRound = true;
      } else if (endRound == false) {
        // else if statement when you lose the money gets subtracted from amount betted.
        System.out.println("You Lose!.");
        playerMoney -= playerBet;
        endRound = true;
      }
      // Moves the cards back into the deck after play
      playerDeck.moveAllToDeck(playingDeck);
      dealerDeck.moveAllToDeck(playingDeck);
      System.out.println("End of Round.");
      // Prints out when the round is over
      System.out.println("");
    }
    System.out.println("Game over! You are out of money.");

  }
  // Going to number from string clears out buffer
}
