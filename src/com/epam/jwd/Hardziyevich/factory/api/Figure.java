package com.epam.jwd.Hardziyevich.factory.api;

import com.epam.jwd.Hardziyevich.factory.impl.Line;

public interface Figure {
    boolean isItAFigure();
    int getNumberOfSide();
    Line getSide(int i);
    int getNumberOfVertices();
    Point getP(int i);
    Point[] getPoint();
    String toString();
    static final String FIGURE_TYPE = "Figure";
    String getFigureType();
    long getId();
    void setId(int newId);

}
