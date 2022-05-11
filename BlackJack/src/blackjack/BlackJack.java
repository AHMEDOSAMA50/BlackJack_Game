package blackjack;

import java.util.Scanner;

public class BlackJack {
  static Game game = new Game();

  public static void main(String[] args) {

    GUI gui = new GUI();
    try (Scanner scanner = new Scanner(System.in)) {
      game.cardgenerator(); // starting the game with generating the deck

      // starting with recieving player's info and intalizing 2 cards for each of them
      // by playerinfo function in game class.
      String PlayerName;

      System.out.print("Enter first player name: ");
      PlayerName = scanner.nextLine();
      game.playersinfo(PlayerName, 0);
      
      System.out.print("Enter second player name: ");
      PlayerName = scanner.nextLine();
      game.playersinfo(PlayerName, 1);
      
      System.out.print("Enter third player name: ");
      PlayerName = scanner.nextLine();
      game.playersinfo(PlayerName, 2);

      System.out.print("Enter fourth player name: ");
      PlayerName = scanner.nextLine();
      game.playersinfo(PlayerName, 3);



      gui.runGUI(game.getdeck(),
      game.getplayers()[0].getcards(),
      game.getplayers()[1].getcards(),
      game.getplayers()[2].getcards(),
      game.getplayers()[3].getcards());

      // starting the game with the first round

      String playeranswer;
      int counter = 0;
      Card c = new Card();
      for (int i = 0; i < 3; i++) {
        if (game.getplayers()[counter].getscore() > 21) {
          System.out.println("player " + (counter+1) + " lost" );
          continue;
        }
        int hitsOrStands = 0;
        System.out.println("player" + (counter + 1) + "'s" + " turn" + "\n");
        while (hitsOrStands < 9) {
          System.out.println("you wanna hit or stand");
          playeranswer = scanner.nextLine();

          if (playeranswer.equals("hit".toLowerCase()) == true) {
            c = game.drawingcard();
            gui.updatePlayerHand(game.drawingcard(), counter);
            game.getplayers()[counter].setScore((game.getplayers()[counter].getscore())+(c.getValue()));
            hitsOrStands++;
            if (game.getplayers()[counter].getscore() > 21) {
              //System.out.println("player " + (counter+1) + " lost" );
              break;
            }
          } else if (playeranswer.equals("stand".toLowerCase()) == true)
            break;
          else {
            System.out.print("please specify your input whether hint or stand");
            continue;
          }
        }
        counter++;
        System.out.println(" ");
      }
      // dealer's turn.
      System.out.println("dealer's turn");
      int rounds = 0;
      while (rounds < 9) {
        System.out.println("you wanna hit or stand");
        playeranswer = scanner.nextLine();

        if (playeranswer.equals("hit".toLowerCase()) == true) {
          game.drawingcard();
          game.getplayers()[3].setScore(game.getplayers()[3].getscore()+c.getValue());
          gui.updateDealerHand(game.drawingcard(), game.getdeck());
          rounds++;
          if(game.getplayers()[3].getscore()>21)
        {System.out.println("dealer lost");
        break;} //important line
        } else if (playeranswer.equals("stand".toLowerCase()) == true)
          break;
        else {
          System.out.print("please specify if it is stand or hit ");
          continue;
        }
      }
    }
    

    //after the game has ended we will decide who has won

    for ( int i = 0; i < 4; i++) 
    {
      if (game.getplayers()[i+3].getscore() > game.getplayers()[i].getscore() || game.getplayers()[i+3].getscore() > game.getplayers()[i+1].getscore()  || game.getplayers()[i+3].getscore() > game.getplayers()[i+2].getscore() || game.getplayers()[3].getscore() <= 21) {
        System.out.println("dealer wins");
      } 
      else if (game.getplayers()[i].getscore()==21 || game.maxscoreupdate()==game.getplayers()[i].getscore()) 
      {
        System.out.println("player" + i + " got black jack and won");
        break;
      } 
      else if ( game.maxscoreupdate()==game.getplayers()[i].getscore()) 
      {
        System.out.println("player" + i + " won");
        break;
      } 
      else if (game.getplayers()[i].getscore()==21 || game.getplayers()[i].getscore()==game.getplayers()[i+1].getscore() ||game.getplayers()[i].getscore()==game.getplayers()[i+2].getscore())
      {
        System.out.println("it's a tie");
        break;
      }
    
      
    }
    
  }
}