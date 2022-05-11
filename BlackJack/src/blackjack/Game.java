package blackjack;

import java.util.Random;

public class Game {
    private Player[] players = new Player[4];
    private Card[] deck = new Card[52];
    private int highscore; // variable keeps tracking the high score of the game

    Game(int highscore, Player[] players, Card[] deck) // constructor to set the values
    {
        this.highscore = highscore;
        this.deck = deck;
        this.players = players;
    }

    public Game() {
    }

    // getter for the attribute(highscore)
    public int gethighscore() {
        return highscore;
    }

    public void setPlayers(Player[] p) {
        this.players = p;
    }

    public Player[] getplayers() {
        return players;
    }

    public Card[] getdeck() {
        return deck;
    }

    // setters for the attribute(highscore)
    public void setGame(int highscore, Player[] players, Card[] deck) {
        this.highscore = highscore;
        this.deck = deck;
        this.players = players;
    }

    public void cardgenerator() // function that generates the deck of cards
    {
        int counter = 0;
        int value;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {

                if (j >= 10) // j means rank
                {
                    value = 10;
                } else {
                    value = j + 1;
                }
                Card card = new Card(i, j, value);

                deck[counter] = card; // putting all my cards in all
                                      // the positions of the counter
                counter++;
            }System.out.println(deck);
                
        }
    }

    // Randomchoice variable returns integer so we must but it in the index
    // of the array of cards to draw a real card !!.

    public Card drawingcard() // function that draw a random card to the player
    {
        Card card1 = new Card();
        while (true) {
            Random rand = new Random();
            int Randomchoice = rand.nextInt(52);
            card1 = deck[Randomchoice];
            // int index = Randomchoice;
            // card1 = deck[index];
            if (card1 != null) {
                deck[Randomchoice] = null;
                return card1;

            } else {
                continue;
            }

        }

    }

    Player playersinfo(String s, int count) {

        Card card1 = drawingcard();
        Card card2 = drawingcard();
        Card[] cards = new Card[] { card1, card2 };
        int score = cards[0].getValue() + cards[1].getValue();
        Player player = new Player(s,score, cards);
        players[count] = player;

        return player;

    }

    public int maxscoreupdate() // function to update the game maximum score of all the players after withdawing  a card from any player.          
    {
        if (players[0].getscore() >= players[1].getscore()) {
            highscore = players[0].getscore();

        } else {
            highscore = players[1].getscore();
        }
        if (players[1].getscore() >= players[2].getscore()) {
            highscore = players[1].getscore();

        } else {
            highscore = players[2].getscore();
        }
        if (players[2].getscore() >= players[3].getscore()) {
            highscore = players[2].getscore();

        } else {
            highscore = players[3].getscore();
        }
        return highscore;

    }

}
