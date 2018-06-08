package model;

/**
 * Created by taddeigilles on 07/06/2018.
 */
public class Player {
    private String name;
    private Points points;

    public Player(String name){
        this.name = name;
        points = Points.Love;
    }

    public boolean winPoint(){
        points = points.next();
        return (points == null); //if null, victory !
    }

    public Points getScore(){
        return points;
    }

    public String toString(){
        return name;
    }

    public boolean loseAdvantage() {
        points = points.previous();
        return false;
    }
}
