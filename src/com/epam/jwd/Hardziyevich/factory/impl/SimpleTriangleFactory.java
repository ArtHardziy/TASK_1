package com.epam.jwd.Hardziyevich.factory.impl;

import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;
import com.epam.jwd.Hardziyevich.factory.api.Figure;

import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class SimpleTriangleFactory implements FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(SimpleSquareFactory.class);
    private static SimpleTriangleFactory instance;

    private SimpleTriangleFactory() {

    }

    public static SimpleTriangleFactory getInstance() {
        if (instance == null) {
            instance = new SimpleTriangleFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(FigureType type, ArrayList<Point> point) {
        return new Triangle(point.get(0), point.get(1), point.get(2));
    }
}
