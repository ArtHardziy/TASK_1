package com.epam.jwd.Hardziyevich.model;

import com.epam.jwd.Hardziyevich.services.ServicesPoint;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Scanner;

public class LineFactory implements AbstractFigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(LineFactory.class);
    private static LineFactory instance;

    private LineFactory() {

    }

    public static LineFactory getInstance() {
        if (instance == null) {
            instance = new LineFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure() {
        Point[] p = ServicesPoint.enterPoints(2);
        Figure line = new Line(p[0], p[1]);
        LOGGER.info(" Line was created by LineFactory ");
        return line;
    }

}
