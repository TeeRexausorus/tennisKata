package tests.model;

import model.Player;
import model.Points;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by taddeigilles on 07/06/2018.
 */
class PlayerTest {

    @Test
    void should_get_score(){
        Player p = new Player("p1");
        Points score = p.getScore();
        assertEquals(Points.Love, score);
    }

    @Test
    void should_win_point(){
        Player p = new Player("p1");
        p.winPoint();
        Points score = p.getScore();
        Points expected = Points.Fifteen;
        assertEquals(expected, score);
    }
    @Test
    void should_win_2_points(){
        Player p = new Player("p1");
        p.winPoint();
        p.winPoint();
        Points score = p.getScore();
        Points expected = Points.Thirty;
        assertEquals(expected, score);
    }

    @Test
    void should_win_game_deuce(){
        Player p = new Player("p1");
        p.winPoint();//15
        p.winPoint();//30
        p.winPoint();//40
        p.winPoint();//Deuce
        boolean winPoint = p.winPoint();//WIN
        assertEquals(true, winPoint);
    }
}