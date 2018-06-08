package tests.model;

import model.Points;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by taddeigilles on 07/06/2018.
 */

public class PointsTest {

    @Test
    void should_get_next_test() {

        Points expected = Points.Fifteen;
        Points actual = Points.Love;

        actual = actual.next();
        assertEquals(expected,actual);
    }

    @Test
    void should_get_null(){
        Points expected = null;
        Points actual = Points.Advantage;
        actual = actual.next();

        assertEquals(expected,actual);

    }

    @Test
    void should_get_fourty_despite_previous_twice(){
        Points point = Points.Advantage;
        point = point.previous();
        point = point.previous();

        assertEquals(Points.Fourty, point);
    }

}