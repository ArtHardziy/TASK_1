package com.epam.jwd.Hardziyevich.decorator.impl;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.decorator.api.FigurePreProcessor;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DuplicatePointsPreProcessor implements FigurePreProcessor {
    private static final Logger LOGGER = LogManager.getLogger(DuplicatePointsPreProcessor.class);

    @Override
    public void preProcess(Point[] points) throws FigureException {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = points.length - 1; j >= i + 1; j--) {
                if (points[i].equals(points[j])) {
                    throw new FigureException("The points can't be the same");
                }

            }
        }
    }
}
