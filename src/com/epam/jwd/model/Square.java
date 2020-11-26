package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Square implements Figure {
    private static final Logger LOGGER = LogManager.getLogger(Square.class);

    private final Point[] points = new Point[4];
    private final Line[] side = new Line[4];
    private final Line[] diagonal = new Line[2];

    public Line[] getSide() {
        return side;
    }

    protected Square(Point p1, Point p2, Point p3, Point p4){
        this.points[0] = p1;
        this.points[1] = p2;
        this.points[2] = p3;
        this.points[3] = p4;

        side[0] = new Line(p1, p2);
        side[1] = new Line(p2, p3);
        side[2] = new Line(p3, p4);
        side[3] = new Line(p4, p1);

        diagonal[0] = new Line(p1, p3);
        diagonal[1] = new Line(p2, p4);
    }
    @Override
    public Point getP(int i) {
        while( i > 3 || i < 0 ){
            LOGGER.error("You entered an invalid number");
        }
        return points[i];
    }

    public  int getNumberOfSide() {
        return this.side.length;
    }

    @Override
    public String toString() {
        return "Square" + points[0].toString() + points[1].toString() + points[2].toString() + points[3].toString();
    }

    @Override
    public boolean isItAFigure() {
        if((side[0].getLenght() == side[1].getLenght())
                && (side[2].getLenght() == side[3].getLenght())
                && (diagonal[0].getLenght() == diagonal[1].getLenght())
                && (side[0].getLenght() == side[2].getLenght())) {
            return true;
        }
    return false;
    }

    @Override
    public double getLengthSide(int i) {
        return this.side[i].getLenght();
    }

    @Override
    public int getNumberOfVertices() {
        return points.length;
    }

    @Override
    public Point[] getPoint() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Arrays.equals(points, square.points) &&
                Arrays.equals(side, square.side) &&
                Arrays.equals(diagonal, square.diagonal);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(points);
        result = 31 * result + Arrays.hashCode(side);
        result = 31 * result + Arrays.hashCode(diagonal);
        return result;
    }
}
