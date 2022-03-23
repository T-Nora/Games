package tictactoeapplication;

import java.util.Scanner;

public class TicTacToeApplication {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        //Allows for continues games
        boolean doYouWantToPlay = true;
        while(doYouWantToPlay){
            System.out.println("Welcome to Tic Tac Toe!\n\nYou are about to go against the master of Tic Tac Toe.\n" +
                    "Are you ready? I hope so!\nBut first, you must pick what character you want to be and which caharter I will be.\n");
            System.out.println();
            System.out.println("Enter a charcter that will represent you on the board!");

            char playerToken = scanner.next().charAt(0);
            System.out.println("Enter a single character that will represent your opponent on the board!");
            char opponentToken = scanner.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);

            AI ai = new AI();

            //Set up the game
            System.out.println();
            System.out.println("Now we can start the game.\nTo play, enter a number and your token shall be put in its place.\n" +
                    "The numbers go from 1-9, left to right.");
            TicTacToe.printIndexBoard();
            System.out.println();

            while(game.gameOver().equals("Not over!")){
                if(game.currentMarker == game.userMarker){
                    System.out.println("It's your turn! Enter a spot for your token.");
                    int spot = scanner.nextInt();
                    while(!game.playTurn(spot)){
                        System.out.println("Try again. " +spot+ " is invalid. This spot is already taken or it is out of range." );
                        spot = scanner.nextInt();
                    }
                    System.out.println("You picked "+spot+"!");
                }else{
                    System.out.println("It's my turn!");
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked " +aiSpot+ "!");
                }
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            System.out.println("Do you want to play again? Enter 'Y' if you do, enter anything else if not.");
            char response = scanner.next().toUpperCase().charAt(0);
            doYouWantToPlay= response == 'Y';
            System.out.println();
            System.out.println();
        }

    }
}
