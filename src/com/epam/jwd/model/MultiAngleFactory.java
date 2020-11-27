package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MultiAngleFactory implements AbstractFigureFactory{
    private static final Logger LOGGER = LogManager.getLogger(MultiAngleFactory.class);
    @Override
    public Figure createFigure(Point[] points) {
        Figure multiAngleFigure = new MultiAngleFigure(points);
        LOGGER.info(" MultiAngleFigure was created by MultiAngleFactory ");
        return multiAngleFigure;
    }
}