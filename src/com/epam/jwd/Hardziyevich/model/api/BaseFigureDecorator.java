package com.epam.jwd.Hardziyevich.model.api;

import com.epam.jwd.Hardziyevich.decorator.api.FigureFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseFigureDecorator implements FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(BaseFigureDecorator.class);

    @Override
    public Figure createFigure(Point[] point){
        //todo: switch with figureCreation

        LOGGER.info("Figure is created !!!");
        return null;
    }


}
