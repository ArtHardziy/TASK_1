package com.epam.jwd.Hardziyevich.decorator.api;

import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import com.epam.jwd.Hardziyevich.factory.impl.FigureType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public abstract class BaseFigureDecorator implements FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(BaseFigureDecorator.class);

    @Override
    public Figure createFigure(FigureType type, ArrayList<Point> point){
        //todo: switch with figureCreation

        LOGGER.info("Figure is created !!!");
        return null;
    }


}
