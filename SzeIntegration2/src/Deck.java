import java.util.ArrayList;
import java.util.Random;

// Louis Sze
// This class is the deck class where the suit and values are set for each card,
// that card is getting added and removed from a deck and shuffled
public class Deck {

  private ArrayList<Card> cards;
  // private array list for the cards to be stored in

  // constructor
  public Deck() {
    // setting variable to array list
    this.cards = new ArrayList<Card>();
  }

  public void createFullDeck() {
    // Generate Cards
    // the two for loops creates a deck of 52 cards in the array.
    for (Suits cardSuits : Suits.values()) {
      for (Values cardValues : Values.values()) {
        // Add a new card to the Deck
        this.cards.add(new Card(cardSuits, cardValues));
      }
    }
  }

  public void shuffle() {
    // pulls out cards and puts it back into the deck from the array list

    ArrayList<Card> tempDeck = new ArrayList<Card>(); // array
    // Use Random
    Random random = new Random();
    int randomCardIndex = 0;
    int startSize = this.cards.size();
    for (int i = 0; i < startSize; i++) {
      // random index Syntax random.nextInt ((max - min)+1)+min;
      randomCardIndex = random.nextInt((this.cards.size() - 1) + 1);
      tempDeck.add(this.cards.get(randomCardIndex));
      // remove from starting Deck
      this.cards.remove(randomCardIndex);
    }
    this.cards = tempDeck;// puts the cards back into the deck
  }


  public String toString() {
    // an override
    String cardListOutput = "";
    for (Card aCard : this.cards) {
      cardListOutput += "\n" + aCard.toString();

    }
    return cardListOutput;
  }

  // remove an index from arraylist of cards
  public void removeCard(int i) {
    this.cards.remove(i);
  }

  // Getter to get a card
  public Card getCard(int i) {
    return this.cards.get(i);
  }

  // This adds cards to the deck
  public void addCard(Card addCard) {
    this.cards.add(addCard);
  }

  // Draw cards from the deck
  public void draw(Deck recievingFrom) {
    this.cards.add(recievingFrom.getCard(0));
    recievingFrom.removeCard(0);
  }

  public int deckSize() {
    return this.cards.size();
  }

  // Return total value of cards in deck
  public int cardsValue() {
    int totalValue = 0;
    int aces = 0;

    for (Card aCard : this.cards) {
      // switch statement that sets the values of the cards
      switch (aCard.getValue()) {
        case ACE:
          aces += 1;
          break;
        case TWO:
          totalValue += 2;
          break;
        case THREE:
          totalValue += 3;
          break;
        case FOUR:
          totalValue += 4;
          break;
        case FIVE:
          totalValue += 5;
          break;
        case SIX:
          totalValue += 6;
          break;
        case SEVEN:
          totalValue += 7;
          break;
        case EIGHT:
          totalValue += 8;
          break;
        case NINE:
          totalValue += 9;
          break;
        case TEN:
          totalValue += 10;
          break;
        case JACK:
          totalValue += 10;
          break;
        case QUEEN:
          totalValue += 10;
          break;
        case KING:
          totalValue += 10;
          break;
      }
    }
    // for loop for aces value to be set depending on the total value.
    for (int i = 0; i < aces; i++) {
      if (totalValue > 10) {
        totalValue += 1;
      } else {
        totalValue += 11;
      }
    }
    return totalValue;
  }

  public void moveAllToDeck(Deck moveTo) {
    int thisDeckSize = this.cards.size();
    // puts cards into moveTo deck
    for (int i = 0; i < thisDeckSize; i++) {
      moveTo.addCard(this.getCard(i));
    }
    for (int i = 0; i < thisDeckSize; i++) {
      this.removeCard(0);
    }
  }
}
