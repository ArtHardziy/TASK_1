package com.epam.jwd.Hardziyevich.services.impl;

import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.Scanner;

public class ServicesPoint {
    private static final Logger LOGGER = LogManager.getLogger(ServicesPoint.class);

    public static ArrayList<Point> enterPoints(int numberOfPoints) {
        ArrayList<Point> points = new ArrayList<>();
        LOGGER.info("Let's start entering points");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numberOfPoints; i++) {
            System.out.print("Point " + (i + 1) + ": ");
            points.add(new Point(sc.nextInt(), sc.nextInt()));
            LOGGER.info("Point " + (i + 1) + ": " + points.get(i));
        }
        sc.close();
        return points;
    }
}
