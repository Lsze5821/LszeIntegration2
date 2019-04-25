// Louis Sze
public class Card {

  private Suits suit;// private variables that cannot be accessed unless set and get
  private Values value;// private variable for values that can only be access in same class with
                       // setters and getters.

  // card Constructor
  public Card(Suits suit, Values value) {
    this.value = value;// setting value to equal to value with the this.value
    this.suit = suit;
  }

  public String toString() {
    return "[" + this.suit.toString() + "]-[" + this.value.toString() + "]";
    //toString is used when a string is needed to representation of an object.
  }

  public Values getValue() {
    return this.value;
  }
}
