package com.epam.jwd.Hardziyevich.model.impl;

import com.epam.jwd.Hardziyevich.decorator.api.FigureFactory;
import com.epam.jwd.Hardziyevich.model.api.Figure;
import com.epam.jwd.Hardziyevich.model.api.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleMultiAngleFactory implements FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(SimpleMultiAngleFactory.class);
    private static SimpleMultiAngleFactory instance;

    private SimpleMultiAngleFactory() {

    }

    public static SimpleMultiAngleFactory getInstance() {
        if (instance == null) {
            instance = new SimpleMultiAngleFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(Point[] point) {
        Figure multiAngleFigure = new MultiAngleFigure(point);
        LOGGER.info("MultiAgleFigure was created by MultiAngleFactory !!!");
        return multiAngleFigure;
    }
}
