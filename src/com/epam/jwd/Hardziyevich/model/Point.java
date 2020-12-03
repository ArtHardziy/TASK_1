package com.epam.jwd.Hardziyevich.model;

import java.util.Objects;

public class Point {
    private final int x;
    private final int y;

    public Point(int value1, int value2){
        this.x = value1;
        this.y = value2;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return " Point(" + this.x + "; " + this.y + ") ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
