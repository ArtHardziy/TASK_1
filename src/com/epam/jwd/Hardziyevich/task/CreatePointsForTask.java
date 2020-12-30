package com.epam.jwd.Hardziyevich.task;

import com.epam.jwd.Hardziyevich.factory.api.Point;

import java.util.ArrayList;

public class CreatePointsForTask {
    public ArrayList<Point> pointsInit() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 2));
        points.add(new Point(3, 2));
        points.add(new Point(0, 3));
        points.add(new Point(1, 1));
        return points;
    }
}
