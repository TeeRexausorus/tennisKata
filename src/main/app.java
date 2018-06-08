package main;

import controller.Game;
import model.Points;

import static model.Points.Love;

/**
 * Created by taddeigilles on 07/06/2018.
 */
public class app {
    public static void main(String[] args){
        Game g = new Game("Djokovic","Nadal");
        while(g.has_winner().equals("keep playing (unless it's raining)")){

        }
    }
}
