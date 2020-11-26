package com.epam.jwd.model;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Arrays;

public class Line implements Figure {
    private static final Logger LOGGER = LogManager.getLogger(Line.class);
    private final Point[] point = new Point[2];

    protected Line(Point p1, Point p2){
        this.point[0] = p1;
        this.point[1] = p2;
    }
    @Override
    public Point getP(int i) {
        while( i > 1 || i < 0 ){
            LOGGER.error("You entered an invalid number");
        }
        return point[i];
    }

    public double getLenght(){
      return Math.sqrt(Math.pow((point[1].getX() - point[0].getX()),2) - Math.pow((point[1].getY() - point[0].getY()),2));
    };

    public boolean isItAFigure() {
        return false;
        //LOGGER.info("It's not a figure. It's a line!");
    }

    @Override
    public String toString() {
  //      LOGGER.info("Line with point's: " + p1.toString() + p2.toString() + ";" );
        return "Line" + point[0].toString() + point[1].toString();
    }

    public int getNumberOfSide() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Arrays.equals(point, line.point);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(point);
    }

    @Override
    public double getLengthSide(int i) {
        return getLenght();
    }

    @Override
    public int getNumberOfVertices() {
        return 2;
    }

    @Override
    public Point[] getPoint() {
        return point;
    }
}
