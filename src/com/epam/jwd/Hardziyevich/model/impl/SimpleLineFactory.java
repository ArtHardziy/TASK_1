package com.epam.jwd.Hardziyevich.model.impl;

import com.epam.jwd.Hardziyevich.model.api.Figure;
import com.epam.jwd.Hardziyevich.model.api.Point;
import com.epam.jwd.Hardziyevich.decorator.api.FigureFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleLineFactory implements FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(SimpleLineFactory.class);
    private static SimpleLineFactory instance;

    private SimpleLineFactory() {

    }

    public static SimpleLineFactory getSingleton() {
        if (instance == null) {
            instance = new SimpleLineFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(Point[] point) {
        Figure line = new Line(point[0], point[1]);
        LOGGER.info(" Line was created by LineFactory ");
        return line;
    }
}
