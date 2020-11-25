package com.epam.jwd.task1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Line {
    private static final Logger LOGGER = LogManager.getLogger(Line.class);
    private final Point[] POINT = new Point[2];
    //private double lenght;

    public Line(Point p1, Point p2){
        this.POINT[0] = p1;
        this.POINT[1] = p2;

    }

    public Point getP(int i) {
        while( i > 1 || i < 0 ){
            LOGGER.error("You entered an invalid number");
        }
        return POINT[i];
    }

    public double getLenght(){
      return Math.sqrt(Math.pow((POINT[1].getX() - POINT[0].getX()),2) - Math.pow((POINT[1].getY() - POINT[0].getY()),2));
    };

    public boolean isItAFigure() {
        return false;
        //LOGGER.info("It's not a figure. It's a line!");
    }

    @Override
    public String toString() {
  //      LOGGER.info("Line with point's: " + p1.toString() + p2.toString() + ";" );
        return "Line" + POINT[0].toString() + POINT[1].toString();
    }

    public int getNumberOfSide() {
        return 0;
    }
}
