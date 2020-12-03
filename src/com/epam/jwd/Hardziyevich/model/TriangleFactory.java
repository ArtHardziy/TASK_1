package com.epam.jwd.Hardziyevich.model;
import com.epam.jwd.Hardziyevich.services.ServicesPoint;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Scanner;

public class TriangleFactory implements AbstractFigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);
    private static TriangleFactory instance;

    private TriangleFactory() {

    }

    public static TriangleFactory getInstance() {
        if (instance == null) {
            instance = new TriangleFactory();
        }
        return instance;
    }
    @Override
    public Figure createFigure() {
        Point[] p = ServicesPoint.enterPoints(3);
        Figure triangle = new Triangle(p[0], p[1], p[2]);
        LOGGER.info(" Triangle was created by TriangleFactory ");
        return triangle;
    }

}
