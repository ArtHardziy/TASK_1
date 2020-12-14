package com.epam.jwd.Hardziyevich.factory.impl;

import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleSquareFactory implements FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(SimpleSquareFactory.class);
    private static SimpleSquareFactory instance;

    private SimpleSquareFactory(){

    }

    public static SimpleSquareFactory getInstance(){
        if(instance == null){
            instance = new SimpleSquareFactory();
        } return instance;
    }

    @Override
    public Figure createFigure(Point[] point) {
        Figure square = new Square(point[0], point[1], point[2], point[3]);
        LOGGER.info("Square was created by SquareFactory !!!");
        return square;
    }
}
