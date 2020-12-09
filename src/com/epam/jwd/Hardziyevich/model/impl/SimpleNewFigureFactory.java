package com.epam.jwd.Hardziyevich.model.impl;


import com.epam.jwd.Hardziyevich.decorator.api.FigureFactory;
import com.epam.jwd.Hardziyevich.model.api.Figure;
import com.epam.jwd.Hardziyevich.model.api.Point;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SimpleNewFigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(SimpleNewFigureFactory.class);
    private FigureFactory figureFactory;

    public Figure creation(Point[] points) {
        while (true) {
            return figureFactory.createFigure(points);
        }
    }
    public void chooseAbstractFigureFactory(FigureFactory factory) {
        this.figureFactory = factory;
    }
}
