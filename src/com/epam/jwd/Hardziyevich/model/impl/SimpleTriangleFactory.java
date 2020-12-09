package com.epam.jwd.Hardziyevich.model.impl;

import com.epam.jwd.Hardziyevich.decorator.api.FigureFactory;
import com.epam.jwd.Hardziyevich.model.api.Figure;

import com.epam.jwd.Hardziyevich.model.api.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleTriangleFactory implements FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(SimpleSquareFactory.class);
    private static SimpleTriangleFactory instance;

    private SimpleTriangleFactory(){

    }

    public static SimpleTriangleFactory getInstance(){
        if(instance == null){
            instance = new SimpleTriangleFactory();
        } return instance;
    }

    @Override
    public Figure createFigure(Point[] point){
        return new Triangle(point[0], point[1], point[2]);
    }
}
