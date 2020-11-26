package com.epam.jwd.model;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Objects;

public class Point {
    private static final Logger LOGGER = LogManager.getLogger(Figure.class);
    private final int x;
    private final int y;

    public Point(int value1, int value2){
        this.x = value1;
        this.y = value2;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    /*public boolean isItAFigure() {
        return false;
    };*/

    @Override
    public String toString() {
   //     LOGGER.info("Point with coordinates (" + this.x + "; " + this.y + ");" +" was created!" );
        return " Point(" + this.x + "; " + this.y + ") ";
    }

    /*public int getNumberOfSide(){
        return 0;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
