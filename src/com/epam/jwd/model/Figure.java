package com.epam.jwd.model;

public interface Figure {
    boolean isItAFigure();
    int getNumberOfSide();
    double getLengthSide(int i);
    int getNumberOfVertices();
    public Point getP(int i);
    Point[] getPoint();
    String toString();

}
