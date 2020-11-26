package com.epam.jwd.model;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class NewFigure {
    private static final Logger LOGGER = LogManager.getLogger(NewFigure.class);
    private AbstractFigureFactory abstractFigureFactory;

    public Figure creation(Point[] points){
        Figure figure = abstractFigureFactory.createFigure(points);
        LOGGER.info("Create " + figure.toString() + " shape... ");
        return figure;
    }
    public void chooseAbstractFigureFactory(AbstractFigureFactory factory){
        abstractFigureFactory = factory;
    }

}
