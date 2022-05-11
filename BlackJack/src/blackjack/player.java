package blackjack;

class Player {
    private String Name;
    private int Score;                                       // score of the cards in player's hand
    private Card[] cards = new Card[11];                    // array of cards of the player
    boolean gotblackjack;                                  // boolean value indicates he got black jack or not
    static boolean loseornot;                                    // boolean value indicates whether he already lost or not

    // normal constructor
    Player(String playername, int score, Card[] cards) {
        this.Name = playername;
        this.Score = score;
        this.cards = cards;
    }

    // getters for the attributes
    public String getplayername() {
        return Name;
    }

    public int getscore() {
        return Score;
    }

    public Card[] getcards() {
        return cards;
    }

    // setters for the attributes
    public void setplayer(String playername, int score, Card[] cards) {
        this.Name = playername;
        this.Score = score;
        this.cards = cards;
    }

    Player(String s, Card[] cards) {
        this.Name = s;
        this.cards = cards;

    }
    void setScore(int s){
        this.Score = s;
    }
    

}
