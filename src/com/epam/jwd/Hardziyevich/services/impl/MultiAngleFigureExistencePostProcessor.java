package com.epam.jwd.Hardziyevich.services.impl;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.model.Figure;
import com.epam.jwd.Hardziyevich.services.FigurePostProcessor;

public class MultiAngleFigureExistencePostProcessor implements FigurePostProcessor {
    private static MultiAngleFigureExistencePostProcessor instance;

    private MultiAngleFigureExistencePostProcessor() {

    }

    public static MultiAngleFigureExistencePostProcessor getInstance() {
        if (instance == null) {
            instance = new MultiAngleFigureExistencePostProcessor();
        }
        return instance;
    }

    @Override
    public Figure process(Figure figure) throws FigureException {
        for(int i = 0; i < figure.getNumberOfVertices() - 1; i++){
            for(int j = i; j < figure.getNumberOfVertices(); j++){
                if(figure.getP(i).equals(figure.getP(j))){
                    throw new FigureException("The points can't be the same!!!");
                }
            }
        }
        return figure;
    }
}
