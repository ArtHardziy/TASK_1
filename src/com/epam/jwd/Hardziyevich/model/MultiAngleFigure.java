package com.epam.jwd.Hardziyevich.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;


public class MultiAngleFigure implements Figure {
    private static final Logger LOGGER = LogManager.getLogger(MultiAngleFigure.class);
    private final Point[] points;
    private final Line[] side;


    protected MultiAngleFigure(Point[] points){
        this.points = points;
        this.side = new Line[points.length];
        for(int i = 0; i < points.length - 1; i++){
            side[i] = new Line(points[i], points[i+1]);
        }
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
        for(int i = 0; i < points.length - 1; i++){
            if(this.points[i].equals(this.points[i+1])){
                LOGGER.error(" This MultiAngleFigure is not exist !!! ");
                return false;
            }
        }
        return true;
    }

    @Override
    public int getNumberOfSide() {
        return side.length;
    }

    @Override
    public Line getSide(int i) {
        return side[i];
    }

    @Override
    public int getNumberOfVertices() {
        return points.length;
    }

    @Override
    public Point getP(int i) {
        return points[i];
    }

    @Override
    public Point[] getPoint() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigure that = (MultiAngleFigure) o;
        return Arrays.equals(points, that.points) &&
                Arrays.equals(side, that.side);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(points);
        result = 31 * result + Arrays.hashCode(side);
        return result;
    }
}