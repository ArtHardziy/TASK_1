package com.epam.jwd.task1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Triangle implements Figure {
    private static final Logger LOGGER = LogManager.getLogger(Triangle.class);
    private final Point[] POINT = new Point[3];
    private final Line[] SIDE = new Line[3];
    //private int[] length;

    public Line[] getSIDE() {
        return SIDE;
    }

    public Triangle(Point p1, Point p2, Point p3){
        this.POINT[0] = p1;
        this.POINT[1] = p2;
        this.POINT[2] = p3;

        this.SIDE[0] = new Line(p1,p2);
        this.SIDE[1] = new Line(p1,p3);
        this.SIDE[2] = new Line(p2,p3);
    }
    @Override
    public Point[] getPOINT(){
        return this.POINT;
    }

    public Point getP(int i) {
        while( i > 2 || i < 0 ){
            LOGGER.error("You entered an invalid number");
        }
        return POINT[i];
    }

    public int getNumberOfSide() {
        return getSIDE().length;
    }

    @Override
    public String toString() {
        return "Triangle " + POINT[0].toString() + POINT[1].toString() + POINT[2].toString();
    }

    @Override
    public boolean isItAFigure() {
        if(SIDE[0].getLenght() > SIDE[1].getLenght() + SIDE[2].getLenght()) {
            return false;
        } else if(SIDE[1].getLenght() > SIDE[0].getLenght() + SIDE[2].getLenght()){
            return false;
        } else if(SIDE[2].getLenght() > SIDE[0].getLenght() + SIDE[1].getLenght()){
            return false;
        }
        return true;
    }

    @Override
    public double getLengthSide(int i) {
        return SIDE[i].getLenght();
    }

    @Override
    public int getNumberOfVertices() {
        return POINT.length;
    }
}
