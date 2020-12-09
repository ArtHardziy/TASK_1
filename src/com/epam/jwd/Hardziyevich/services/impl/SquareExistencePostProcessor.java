package com.epam.jwd.Hardziyevich.services.impl;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.model.api.Figure;
import com.epam.jwd.Hardziyevich.decorator.api.FigurePostProcessor;

public class SquareExistencePostProcessor implements FigurePostProcessor {
    private static SquareExistencePostProcessor instance;

    private SquareExistencePostProcessor(){

    }

    public static SquareExistencePostProcessor getInstance(){
        if(instance == null){
            instance = new SquareExistencePostProcessor();
        }
        return instance;
    }

    @Override
    public Figure process(Figure figure) throws FigureException {
        if(figure.getNumberOfVertices() != 4){
            throw new FigureException("It's not a square!!!");
        }
        for (int i = 0; i < figure.getPoint().length - 1; i++) {
            for (int j = i; j < figure.getPoint().length; j++) {
                if (figure.getP(i).equals(figure.getP(j))) {
                    throw new FigureException("The points can't be the same");
                }
            }
        }
        for (int i = 0; i < figure.getPoint().length - 2; i++) {
            if (((figure.getP(i).getX() - figure.getP(i + 1).getX()) / (figure.getP(i).getY() - figure.getP(i + 1).getY()))
                    == (figure.getP(i).getX() - figure.getP(i + 2).getX()) / (figure.getP(i).getY() - figure.getP(i + 2).getY())) {
                throw new FigureException("Points cannot lie on the same straight line!!!");
            }
        }
        return figure;
    }
}
