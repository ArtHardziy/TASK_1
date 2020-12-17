package com.epam.jwd.Hardziyevich.factory.impl;

import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class MultiAngleFigure implements Figure {
    private static final Logger LOGGER = LogManager.getLogger(MultiAngleFigure.class);
    private final ArrayList<Point> points;
    private final ArrayList<Line> side;
    static final FigureType FIGURE_TYPE = FigureType.MULTI_ANGLE;
    private long id = 0;

    public FigureType getFigureType() {
        return FIGURE_TYPE;
    }


    MultiAngleFigure(ArrayList<Point> points) {
        this.points = points;
        this.side = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            side.add(new Line(points.get(i), points.get(i + 1)));
        }
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
    public String toString() {
        StringBuilder info = new StringBuilder(" MultiAngleFigure ");
        for (Point point : points) {
            info.append(point.toString());
        }
        return info.toString();
    }

    @Override
    public boolean isItAFigure() {
        for (int i = 0; i < points.size() - 1; i++) {
            if (this.points.get(i).equals(this.points.get(i + 1))) {
                LOGGER.error(" This MultiAngleFigure is not exist !!! ");
                return false;
            }
        }
        return true;
    }

    @Override
    public int getNumberOfSide() {
        return side.size();
    }

    @Override
    public Line getSide(int i) {
        return side.get(i);
    }

    @Override
    public int getNumberOfVertices() {
        return points.size();
    }

    @Override
    public Point getP(int i) {
        return points.get(i);
    }

    @Override
    public ArrayList<Point> getPoint() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigure that = (MultiAngleFigure) o;
        return id == that.id && points.equals(that.points) && side.equals(that.side);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, side, id);
    }
}