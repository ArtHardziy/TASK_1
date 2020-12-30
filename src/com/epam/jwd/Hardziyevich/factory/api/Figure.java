package com.epam.jwd.Hardziyevich.factory.api;

import com.epam.jwd.Hardziyevich.factory.impl.FigureType;
import com.epam.jwd.Hardziyevich.factory.impl.Line;

import java.util.ArrayList;

public interface Figure {
    boolean isItAFigure();

    int getNumberOfSide();

    Line getSide(int i);

    int getNumberOfVertices();

    Point getP(int i);

    ArrayList<Point> getPoint();

    String toString();

    FigureType getFigureType();

    long getId();

    void setId(int newId);

}
