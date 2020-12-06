package com.epam.jwd.Hardziyevich.model;


import com.epam.jwd.Hardziyevich.exception.FigureNotExistException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class NewFigure {
    private static final Logger LOGGER = LogManager.getLogger(NewFigure.class);
    private AbstractFigureFactory abstractFigureFactory;

    public Figure creation() {
        while(true) {
            try {
                return abstractFigureFactory.createFigure();
            } catch (FigureNotExistException e) {
                LOGGER.error(e.getStackTrace());
                LOGGER.info("Enter the points again");
            }
        }
    }

    public void chooseAbstractFigureFactory(AbstractFigureFactory factory) {
        abstractFigureFactory = factory;
    }

}
