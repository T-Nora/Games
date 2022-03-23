package hangman;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class HangmanApplication {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to hangman!\n\nI will pick a word and you will try to guess it character by character" +
                ". \nIf you guess wrong 6 times" + ", then I win. \n" +
                "If you can guess it before then, you win. \n\nAre you ready? \n\nI have picked my word. Below is a picture,\n" +
                "and below that is your current guess, which starts off as nothing.\n" +
                "Every time cou guess incorrectly I add a body part \n" +
                "to the picture. When there is a full person, you lose.");

        //Allows for multiple game
        boolean doYouWantToPlay= true;
        while(doYouWantToPlay){
            //Setting up the game
            System.out.println("All right! Let's play!");
            Hangman game = new Hangman();
            do{
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
              //  System.out.println(game.mysteryWord);
                System.out.println();
                //Get the guess
                System.out.println("Enter a character that you think is in the word!");
                char guess = (scanner.next().toLowerCase()).charAt(0);
                System.out.println();

                //Check if the character is guessed already
                while(game.isGuessedAlready(guess)){
                    System.out.println("Try again! You've already guessed that character.");
                    guess= (scanner.next().toLowerCase()).charAt(0);
                }

                //Play the guess
                if(game.playGuess(guess)){
                    System.out.println("Great guess! That character is in the word!");
                }else{
                    System.out.println("Unfortunately that character is not in the word!");
                }
            }
            while(!game.gameOver());


            System.out.println();
            System.out.println("Do you want to play another game? Enter 'Y' if you do.");
            Character response = scanner.next().toUpperCase().charAt(0);
            doYouWantToPlay= response == 'Y';
        }
    }
}
