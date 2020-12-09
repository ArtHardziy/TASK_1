package com.epam.jwd.Hardziyevich.decorator.impl;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.model.api.Figure;
import com.epam.jwd.Hardziyevich.decorator.api.FigureFactory;
import com.epam.jwd.Hardziyevich.decorator.api.FigurePreProcessor;
import com.epam.jwd.Hardziyevich.model.api.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class PreProcessingDecorator implements FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(PreProcessingDecorator.class);

    private final FigurePreProcessor[] preProcessors = new FigurePreProcessor[] {new DuplicatePointsPreProcessor()};

    private final FigureFactory figureFactory;

    public PreProcessingDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(Point[] points) {
        LOGGER.info("Running PreProcessors");
        for (FigurePreProcessor preProcessor : preProcessors) {
            try {
                preProcessor.preProcess(points);
            }catch (FigureException e){
                LOGGER.error(e.getMessage() + Arrays.toString(e.getStackTrace()));
            }
        }
        return figureFactory.createFigure(points);
    }

}
