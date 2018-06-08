package controller;

import model.Player;
import model.Points;

import static model.Points.Advantage;
import static model.Points.Fourty;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by taddeigilles on 07/06/2018.
 */
public class Game {
    private Player player1;
    private Player player2;

    public Game(String namePlayer1, String namePlayer2){
        player1 = new Player(namePlayer1);
        player2 = new Player(namePlayer2);
    }

    public boolean toss(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 200);

        return (randomNum % 2) == 0; //true = player2, false = player1
    }

    public Points getPlayer1Score() {
        return player1.getScore();
    }

    public Points getPlayer2Score() {
        return player2.getScore();
    }

    public String has_winner(){ // called in case of "basic" win (2 points separate
        Points player1Score = getPlayer1Score();
        Points player2Score = getPlayer2Score();
        if (player1Score == null || (player1Score == Advantage && player1Score.ordinal() >= player2Score.ordinal() + 2)){
            return (player1 + " wins");
        }
        else if(player2Score == null || (player2Score == Advantage && player2Score.ordinal() >= player1Score.ordinal() + 2)){
            return (player2 + " wins");
        }
        return "keep playing (unless it's raining)";
    }

    public boolean pointToPlayer1(){
        if(player2.getScore() == Advantage){
            return player2.loseAdvantage();
        }
        return player1.winPoint();
    }

    public boolean pointToPlayer2(){
        if(player1.getScore() == Advantage){
            return player1.loseAdvantage();
        }
        return player2.winPoint();
    }
}
