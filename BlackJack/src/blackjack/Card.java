package blackjack;

public class Card {
  private int suit;
  private int rank;
  private int value;


  // A normal parameterized constructor
  Card(int suit, int rank, int value) {
    this.suit = suit;
    this.rank = rank;
    this.value = value;
  }

  // copy constructor
  Card(Card c) {
    this.suit = c.suit;
    this.rank = c.rank;
    this.value = c.value;
  }

  public Card() { // this empty constructor is neccessary for line 56 in game class
  }

  // getters for the attributes
  public int getSuit() {
    return suit;
  }

  public int getRank() {
    return rank;
  }

  public int getValue() {
    return value;
  }

  // setters for the attributes
  public void setSuit(int suit) {
    this.suit = suit;
  }
  public void setRank(int Rank) {
    this.rank = Rank;
  }
  public void setValue(int valuue) {
    this.value = valuue;
  }

  

}
