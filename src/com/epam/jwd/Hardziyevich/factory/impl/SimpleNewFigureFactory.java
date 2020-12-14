package com.epam.jwd.Hardziyevich.factory.impl;


import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SimpleNewFigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(SimpleNewFigureFactory.class);
    private static SimpleNewFigureFactory instance;

    private SimpleNewFigureFactory() {

    }

    public static SimpleNewFigureFactory getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new SimpleNewFigureFactory();
        return instance;
    }

    private FigureFactory figureFactory;

    public Figure creation(Point[] points) {
        return figureFactory.createFigure(points);
    }

    public void chooseAbstractFigureFactory(FigureFactory factory) {
        this.figureFactory = factory;
    }
}
