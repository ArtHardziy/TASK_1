package com.epam.jwd.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Square implements Figure {
    private static final Logger LOGGER = LogManager.getLogger(Square.class);

    private final Point[] P = new Point[4];
    private final Line[] SIDE = new Line[4];
    private final Line[] DIAGONAL = new Line[2];

    public Line[] getSIDE() {
        return SIDE;
    }

    public Square(Point p1, Point p2, Point p3, Point p4){
        this.P[0] = p1;
        this.P[1] = p2;
        this.P[2] = p3;
        this.P[3] = p4;

        SIDE[0] = new Line(p1, p2);
        SIDE[1] = new Line(p2, p3);
        SIDE[2] = new Line(p3, p4);
        SIDE[3] = new Line(p4, p1);

        DIAGONAL[0] = new Line(p1, p3);
        DIAGONAL[1] = new Line(p2, p4);
    }

    public Point getP(int i) {
        while( i > 3 || i < 0 ){
            LOGGER.error("You entered an invalid number");
        }
        return P[i];
    }

    public  int getNumberOfSide() {
        return this.SIDE.length;
    }

    @Override
    public String toString() {
        return "Square" + P[0].toString() + P[1].toString() + P[2].toString() + P[3].toString();
    }

    @Override
    public boolean isItAFigure() {
        if((SIDE[0].getLenght() == SIDE[1].getLenght())
                && (SIDE[2].getLenght() == SIDE[3].getLenght())
                && (DIAGONAL[0].getLenght() == DIAGONAL[1].getLenght())
                && (SIDE[0].getLenght() == SIDE[2].getLenght())) {
            return true;
        }
    return false;
    }

    @Override
    public double getLengthSide(int i) {
        return this.SIDE[i].getLenght();
    }

    @Override
    public int getNumberOfVertices() {
        return P.length;
    }

    @Override
    public Point[] getPOINT() {
        return P;
    }
}
