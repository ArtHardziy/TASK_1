package com.epam.jwd.task1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Point {
    private static final Logger LOGGER = LogManager.getLogger(Figure.class);
    private final int X;
    private final int Y;

    public Point(int value1, int value2){
        this.X = value1;
        this.Y = value2;
    }

    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
   /* public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }*/

    /*public boolean isItAFigure() {
        return false;
    };*/

    @Override
    public String toString() {
   //     LOGGER.info("Point with coordinates (" + this.x + "; " + this.y + ");" +" was created!" );
        return " Point(" + this.X + "; " + this.Y + ") ";
    }

    /*public int getNumberOfSide(){
        return 0;
    }*/
}
