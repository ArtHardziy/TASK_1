package com.epam.jwd.model;


public class NewFigure {
    private AbstractFigureFactory abstractFigureFactory;

    public Figure creation(Point[] points){
        return abstractFigureFactory.createFigure(points);
    }
    public void chooseAbstractFigureFactory(AbstractFigureFactory factory){
        abstractFigureFactory = factory;
    }

}
