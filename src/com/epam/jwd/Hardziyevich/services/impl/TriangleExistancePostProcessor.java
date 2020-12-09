package com.epam.jwd.Hardziyevich.services.impl;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.model.api.Figure;
import com.epam.jwd.Hardziyevich.decorator.api.FigurePostProcessor;

public class TriangleExistancePostProcessor implements FigurePostProcessor {
    private static TriangleExistancePostProcessor instance;

    private TriangleExistancePostProcessor(){

    }

    public static TriangleExistancePostProcessor getInstance(){
        if(instance == null){
            instance = new TriangleExistancePostProcessor();
        }
        return instance;
    }
    @Override
    public Figure process(Figure figure) throws FigureException {
        if(figure.getNumberOfVertices() != 3){
            throw new FigureException("It's not a triangle!!!");
        }

        if(figure.getP(0).equals(figure.getP(1))
                || figure.getP(1).equals(figure.getP(2))
                || figure.getP(0).equals(figure.getP(2))) {
            throw new FigureException("The points can't be the same!!!");
        } else if(figure.getSide(0).getLenght() >= figure.getSide(1).getLenght() + figure.getSide(2).getLenght()
                || figure.getSide(1).getLenght() >= figure.getSide(0).getLenght() + figure.getSide(2).getLenght()
                || figure.getSide(2).getLenght() >= figure.getSide(0).getLenght() + figure.getSide(1).getLenght()){
            throw new FigureException("Points cannot lie on the same straight line!!!");
        }else return figure;
    }
}
