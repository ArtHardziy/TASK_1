package com.epam.jwd.Hardziyevich.model;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.services.FigurePostProcessor;
import com.epam.jwd.Hardziyevich.services.ServicesPoint;
import com.epam.jwd.Hardziyevich.services.impl.FigureExistencePostProcessor;
import com.epam.jwd.Hardziyevich.services.impl.SquareExistencePostProcessor;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Scanner;

public class SquareFactory implements AbstractFigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(SquareFactory.class);
    private static SquareFactory instance;

    private SquareFactory() {

    }

    public static SquareFactory getInstance() {
        if (instance == null) {
            instance = new SquareFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure() {
        Point[] p = ServicesPoint.enterPoints(4);
        Figure square = new Square(p[0], p[1], p[2], p[3]);
        LOGGER.info(" Square was created by SquareFactory ");
        try {
            FigureExistencePostProcessor postProcessor = new FigureExistencePostProcessor();
            postProcessor.setFigurePostProcessor(SquareExistencePostProcessor.getInstance());
            postProcessor.executeFigureExistencePostProcessor(square);
        } catch (FigureException e) {
            LOGGER.error(e.getMessage() + e.getStackTrace());
        }
        return square;
    }
}
