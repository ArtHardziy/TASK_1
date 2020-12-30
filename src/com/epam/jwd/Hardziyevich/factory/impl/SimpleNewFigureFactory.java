package com.epam.jwd.Hardziyevich.factory.impl;


import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class SimpleNewFigureFactory implements FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(SimpleNewFigureFactory.class);
    private static SimpleNewFigureFactory instance;
    private FigureFactory figureFactory;

    private SimpleNewFigureFactory() {

    }

    public static SimpleNewFigureFactory getInstance() {
        if (instance == null) {
            instance = new SimpleNewFigureFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(FigureType type, ArrayList<Point> points) {
        return figureFactory.createFigure(type, points);
    }

    public void chooseAbstractFigureFactory(FigureFactory factory) {
        this.figureFactory = factory;
    }

}
