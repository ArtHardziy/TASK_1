package com.epam.jwd.Hardziyevich.services.impl;

import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Scanner;

public class ServicesPoint {
    private static final Logger LOGGER = LogManager.getLogger(ServicesPoint.class);
    public static Point[] enterPoints(int numberOfPoints)
    {
        Point[] points = new Point[numberOfPoints];
        LOGGER.info("Let's start entering points");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < points.length; i++){
            System.out.print("Point " + (i+1) +": ");
            points[i] = new Point(sc.nextInt(), sc.nextInt());
            LOGGER.info("Point " + (i+1) +": " + points[i]);
        }
        sc.close();
        return points;
    }
}
