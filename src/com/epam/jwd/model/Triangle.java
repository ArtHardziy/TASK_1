package com.epam.jwd.model;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Arrays;

public class Triangle implements Figure {
    private static final Logger LOGGER = LogManager.getLogger(Triangle.class);
    private final Point[] point = new Point[3];
    private final Line[] side = new Line[3];
    //private int[] length;

    public Line[] getSide() {
        return side;
    }

    protected Triangle(Point p1, Point p2, Point p3){
        this.point[0] = p1;
        this.point[1] = p2;
        this.point[2] = p3;

        this.side[0] = new Line(p1,p2);
        this.side[1] = new Line(p1,p3);
        this.side[2] = new Line(p2,p3);
    }
    @Override
    public Point[] getPoint(){
        return this.point;
    }

    @Override
    public Point getP(int i) {
        while( i > 2 || i < 0 ){
            LOGGER.error("You entered an invalid number");
        }
        return point[i];
    }

    public int getNumberOfSide() {
        return getSide().length;
    }

    @Override
    public String toString() {
        return "Triangle " + point[0].toString() + point[1].toString() + point[2].toString();
    }

    @Override
    public boolean isItAFigure() {
        if(side[0].getLenght() > side[1].getLenght() + side[2].getLenght()) {
            return false;
        } else if(side[1].getLenght() > side[0].getLenght() + side[2].getLenght()){
            return false;
        } else if(side[2].getLenght() > side[0].getLenght() + side[1].getLenght()){
            return false;
        }
        return true;
    }

    @Override
    public double getLengthSide(int i) {
        return side[i].getLenght();
    }

    @Override
    public int getNumberOfVertices() {
        return point.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(point, triangle.point) &&
                Arrays.equals(side, triangle.side);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(point);
        result = 31 * result + Arrays.hashCode(side);
        return result;
    }
}
