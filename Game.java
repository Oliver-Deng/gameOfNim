
import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private boolean playAgain = true;

    public Game() {
        player1 = new Player();
        player2 = new Player();
    }


    // convert string input into a boolean
    public Boolean evalBoolean(String input) {
        switch (input.toLowerCase()) {
            case "yes":
            case "y":
            case "true":
                return true;
            case "no":
            case "n":
            case "false":
                return false;
            default:
                return null;
        }
    }

    public void play() {
        Scanner sc = new Scanner(System.in);

        //prompts for player input , checks the input is valid, and changes the number of pieces
        while (playAgain) {
            Board.populate();
            //decides randomly who goes first
            Player currentPlayer;
            int startingPlayer = (int) (Math.random());
            int currentPlayerInt = startingPlayer;

            if (startingPlayer == 0) currentPlayer = player1;
            else currentPlayer = player2;

            System.out.println(currentPlayer.getName() + ", you are first!");
            //loops until the game ends
            while (Board.getNumPieces() > 1) {
                System.out.println("There are " + Board.getNumPieces() + " pieces.");
                int num = 0;
                //checks if the user input is a valid input
                while (num < 1 || num > Board.getNumPieces() / 2) {
                    System.out.println(currentPlayer.getName() + ", how many pieces would you like to remove?");
                    num = sc.nextInt();
                }

                //removes the pieces
                Board.removePieces(num);

                //switch players
                currentPlayerInt = 1 - currentPlayerInt;
                if (currentPlayerInt == 0) currentPlayer = player1;
                else currentPlayer = player2;
            }
            //game ends

            //determines the winner and prints
            Player loser = currentPlayer;
            Player winner;
            if (currentPlayerInt == 0) winner = player2;
            else winner = player1;
            //print who wins
            winner.incrScore();
            System.out.println(winner.getName() + " has won! Score: " + winner.getScore() + "-" + loser.getScore());

            //ask if they want to play again
            System.out.println("Would you like to play again? (Y or N)");
            Boolean playAgainInput;
            while ((playAgainInput = evalBoolean(sc.next())) == null) {
                System.out.println("Would you like to play again? (Y or N)");
            }
            playAgain = playAgainInput;
        }
    }
}