package com.epam.jwd.Hardziyevich.factory.impl;

import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Square implements Figure {
    private static final Logger LOGGER = LogManager.getLogger(Square.class);

    private ArrayList<Point> points = new ArrayList<>(4);
    private ArrayList<Line> side = new ArrayList<>(4);
    private ArrayList<Line> diagonal = new ArrayList<>(2);
    private static final FigureType FIGURE_TYPE = FigureType.SQUARE;
    private long id;

    public FigureType getFigureType(){
        return FIGURE_TYPE;
    }

    Square(Point p1, Point p2, Point p3, Point p4){
        points.add(0,p1);
        points.add(1,p2);
        points.add(2,p3);
        points.add(3,p4);

        side.add(0, new Line(p1, p2));
        side.add(1, new Line(p2, p3));
        side.add(2, new Line(p3, p4));
        side.add(3, new Line(p4, p1));

        diagonal.add(0,new Line(p1, p3));
        diagonal.add(1,new Line(p2, p4));
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
    public Point getP(int i) {
        while( i > 3 || i < 0 ){
            LOGGER.error("You entered an invalid number");
        }
        return points.get(i);
    }

    public  int getNumberOfSide() {
        return this.side.size();
    }

    @Override
    public String toString() {
        return "Square" + points.get(0).toString() + points.get(1).toString() + points.get(2).toString() + points.get(3).toString();
    }

    @Override
    public boolean isItAFigure() {
        return (side.get(0).getLenght() == side.get(1).getLenght())
                && (side.get(2).getLenght() == side.get(3).getLenght())
                && (diagonal.get(0).getLenght() == diagonal.get(1).getLenght())
                && (side.get(0).getLenght() == side.get(2).getLenght());
    }

    @Override
    public Line getSide(int i) {
        return this.side.get(i);
    }

    @Override
    public int getNumberOfVertices() {
        return points.size();
    }

    @Override
    public ArrayList<Point> getPoint() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return id == square.id && points.equals(square.points) && side.equals(square.side) && diagonal.equals(square.diagonal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, side, diagonal, id);
    }
}
