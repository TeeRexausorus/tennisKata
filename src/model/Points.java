package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taddeigilles on 07/06/2018.
 */
public enum Points {
    Love,
    Fifteen,
    Thirty,
    Fourty ,
    Advantage {
        @Override
        public Points next(){
            return null;
        };
    };

    public Points next(){
        return values()[ordinal() + 1];
    }
    public Points previous(){
        if(ordinal() <= Points.values().length-2){//point before deuce
            int length = Points.values().length;
            return values()[length-2];//-1 for the length, -2 again for the value before deuce1
        }
        return values()[ordinal() - 1];
    }

}
