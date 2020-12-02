package com.epam.jwd.model;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

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
    public Figure createFigure(Point[] points) {
        Figure line = new Line(points[0], points[1]);
        LOGGER.info(" Line was created by LineFactory ");
        return line;
    }

}
