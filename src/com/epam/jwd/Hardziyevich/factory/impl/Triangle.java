package com.epam.jwd.Hardziyevich.factory.impl;

import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import com.epam.jwd.Hardziyevich.services.figureStorage.FigureStorage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Triangle implements Figure {
    private static final Logger LOGGER = LogManager.getLogger(Triangle.class);
    private final ArrayList<Point> point = new ArrayList<>(3);
    private final ArrayList<Line> side = new ArrayList<>(3);
    private static final FigureType FIGURE_TYPE = FigureType.TRIANGLE;
    private long id;

    public FigureType getFigureType(){
        return FIGURE_TYPE;
    }

    public ArrayList<Line> getSide() {
        return side;
    }

    Triangle(Point p1, Point p2, Point p3){
        point.add(0,p1);
        point.add(1,p2);
        point.add(2,p3);

        side.add(0, new Line(p1, p2));
        side.add(1, new Line(p2, p3));
        side.add(2, new Line(p3, p1));
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(int newId) {
        id = newId;
    }

    @Override
    public ArrayList<Point> getPoint(){
        return this.point;
    }

    @Override
    public Point getP(int i) {
        while( i > 2 || i < 0 ){
            LOGGER.error("You entered an invalid number");
        }
        return point.get(i);
    }

    public int getNumberOfSide() {
        return getSide().size();
    }

    @Override
    public String toString() {
        return "Triangle " + point.get(0).toString() + point.get(1).toString() + point.get(2).toString();
    }

    @Override
    public boolean isItAFigure() {
        if(side.get(0).getLenght() > side.get(1).getLenght() + side.get(2).getLenght()) {
            return false;
        } else if(side.get(1).getLenght() > side.get(0).getLenght() + side.get(2).getLenght()){
            return false;
        } else return !(side.get(2).getLenght() > side.get(0).getLenght() + side.get(1).getLenght());
    }

    @Override
    public Line getSide(int i) {
        return side.get(i);
    }

    @Override
    public int getNumberOfVertices() {
        return point.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return id == triangle.id && point.equals(triangle.point) && side.equals(triangle.side);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, side, id);
    }
}
