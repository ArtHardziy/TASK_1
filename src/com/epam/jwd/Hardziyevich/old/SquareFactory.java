package com.epam.jwd.Hardziyevich.old;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.model.api.FigureFactory;
import com.epam.jwd.Hardziyevich.model.api.FigureType;
import com.epam.jwd.Hardziyevich.model.api.Point;
import com.epam.jwd.Hardziyevich.model.impl.Square;
import com.epam.jwd.Hardziyevich.services.ServicesPoint;
import com.epam.jwd.Hardziyevich.services.impl.FigureExistencePostProcessor;
import com.epam.jwd.Hardziyevich.services.impl.SquareExistencePostProcessor;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SquareFactory implements FigureFactory {
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
    public FigureType createFigure() {
        Point[] p = ServicesPoint.enterPoints(4);
        FigureType square = new Square(p[0], p[1], p[2], p[3]);
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
