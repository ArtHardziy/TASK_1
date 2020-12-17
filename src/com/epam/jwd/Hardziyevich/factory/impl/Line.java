package com.epam.jwd.Hardziyevich.factory.impl;

import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Line implements Figure {
    private static final Logger LOGGER = LogManager.getLogger(Line.class);
    private final ArrayList<Point> point = new ArrayList<>(2);
    private static final FigureType FIGURE_TYPE = FigureType.LINE;
    private long id = 0;

    public FigureType getFigureType(){
        return FIGURE_TYPE;
    }

    Line(Point p1, Point p2){
        this.point.add(0,p1);
        this.point.add(1,p2);
    }
    @Override
    public Point getP(int i) {
        while( i > 1 || i < 0 ){
            LOGGER.error("You entered an invalid number");
        }
        return point.get(i);
    }

    public double getLenght(){
      return Math.sqrt(Math.abs(Math.pow((point.get(1).getX() - point.get(0).getX()),2) - Math.pow((point.get(1).getY() - point.get(0).getY()),2)));
    }

    public boolean isItAFigure() {
        return false;
    }

    @Override
    public String toString() {
        return "Line" + point.get(0).toString() + point.get(1).toString();
    }

    public int getNumberOfSide() {
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return id == line.id && point.equals(line.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, id);
    }

    @Override
    public Line getSide(int i) {
        return new Line(point.get(0),point.get(1));
    }

    @Override
    public int getNumberOfVertices() {
        return 2;
    }

    @Override
    public ArrayList<Point> getPoint() {
        return point;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(int newId) {
        this.id = newId;
    }
}
