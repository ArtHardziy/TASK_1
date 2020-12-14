package com.epam.jwd.Hardziyevich.decorator.impl;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;
import com.epam.jwd.Hardziyevich.decorator.api.FigurePostProcessor;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class PostProcessingDecorator implements FigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(PostProcessingDecorator.class);
    private final FigurePostProcessor[] postProcessors = new FigurePostProcessor[]{new FigureExistencePostProcessor()};
    private final FigureFactory figureFactory;
    public PostProcessingDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(Point[] points) {
        Figure verifiedFigure = figureFactory.createFigure(points);
        LOGGER.info("Running PostProcessorDecorator");
        for (FigurePostProcessor postProcessor : postProcessors) {
            try{
                verifiedFigure = postProcessor.process(verifiedFigure);
            } catch(FigureException e){
                LOGGER.error(e.getMessage() + Arrays.toString(e.getStackTrace()));
            }
        }
        return verifiedFigure;
    }
}
