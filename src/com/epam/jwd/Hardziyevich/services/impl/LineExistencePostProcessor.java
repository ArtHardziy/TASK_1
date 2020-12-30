package com.epam.jwd.Hardziyevich.services.impl;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.decorator.api.FigurePostProcessor;

public class LineExistencePostProcessor implements FigurePostProcessor {
    private static LineExistencePostProcessor instance;

    private LineExistencePostProcessor() {
    }

    public static LineExistencePostProcessor getInstance() {
        if (instance == null) {
            instance = new LineExistencePostProcessor();
        }
        return instance;
    }

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure.getNumberOfVertices() != 2) {
            throw new FigureException("It's not a Line!!!");
        } else if (figure.getP(0).equals(figure.getP(1))) {
            throw new FigureException("Points cannot lie on the same straight line");
        } else {
            return figure;
        }
    }
}
