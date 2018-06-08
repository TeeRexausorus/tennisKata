package tests.model;

import controller.Game;
import jdk.nashorn.internal.ir.annotations.Ignore;
import model.Points;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by taddeigilles on 07/06/2018.
 */
class GameTest {
    @Test
    void has_winner() {
        Game g = new Game("nadal", "djoko");
        boolean ret = false;
        g.pointToPlayer1();//15
        g.pointToPlayer1();//30
        g.pointToPlayer1();//40
        g.pointToPlayer1();//Deuce
        ret = g.pointToPlayer1();//WIN
        assertEquals(true, ret);
    }

    @Test
    void should_get_player1_score(){
        Game g = new Game("nadal","djoko");
        Points player1Score = g.getPlayer1Score();

        Assertions.assertEquals(Points.Love, player1Score);
    }

    @Test
    void should_get_player2_score(){
        Game g = new Game("nadal","djoko");
        g.pointToPlayer2();
        Points player2Score = g.getPlayer2Score();

        Assertions.assertEquals(Points.Fifteen, player2Score);
    }

    @Test
    void nadal_should_win_as_usual(){
        Game g = new Game("Nadal","Tsonga");
        g.pointToPlayer1();//15
        g.pointToPlayer1();//30
        g.pointToPlayer1();//40
        g.pointToPlayer1();//Deuce
        String result = g.has_winner();
        assertEquals("Nadal wins", result);
    }

    @Test
    void nadal_should_win_as_usual2(){
        Game g = new Game("Nadal","Djoko");
        g.pointToPlayer2();//15
        g.pointToPlayer2();//30
        g.pointToPlayer2();//40

        g.pointToPlayer1();//15
        g.pointToPlayer1();//30
        g.pointToPlayer1();//40
        g.pointToPlayer1();//Advantage
        g.pointToPlayer1();//Deuce twice to show who's the boss

        String result = g.has_winner();
        assertEquals("Nadal wins", result);
    }
}