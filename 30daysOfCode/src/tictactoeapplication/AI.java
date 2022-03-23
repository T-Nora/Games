package tictactoeapplication;

import java.util.ArrayList;
import java.util.Random;

public class AI {
    public int pickSpot(TicTacToe game){
        ArrayList<Integer> choice = new ArrayList<>();
        for(int i =0; i< 9; i++){
            //If the slot is not taken, add it as choice

            if(game.board[i] =='-'){
                choice.add(i+1);
            }
        }
        Random random = new Random();
        int choices = choice.get(Math.abs(random.nextInt()%choice.size()));
        return choices;
    }
}
