package com.epam.jwd.Hardziyevich.decorator.impl;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.decorator.api.FigurePreProcessor;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class DuplicatePointsPreProcessor implements FigurePreProcessor {
    private static final Logger LOGGER = LogManager.getLogger(DuplicatePointsPreProcessor.class);

    @Override
    public void preProcess(ArrayList<Point> points) throws FigureException {
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = points.size()- 1; j >= i + 1; j--) {
                if (points.get(i).equals(points.get(j))) {
                    throw new FigureException("The points can't be the same");
                }

            }
        }
    }
}
