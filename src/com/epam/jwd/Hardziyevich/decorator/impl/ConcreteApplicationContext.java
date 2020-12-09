package com.epam.jwd.Hardziyevich.decorator.impl;

import com.epam.jwd.Hardziyevich.decorator.api.ApplicationContext;
import com.epam.jwd.Hardziyevich.model.api.Figure;
import com.epam.jwd.Hardziyevich.model.api.Point;
import com.epam.jwd.Hardziyevich.model.impl.SimpleLineFactory;
import com.epam.jwd.Hardziyevich.model.impl.SimpleNewFigureFactory;
import com.epam.jwd.Hardziyevich.services.ServicesPoint;

public class ConcreteApplicationContext implements ApplicationContext {
    @Override
    public Figure createFigureFactory() {
        SimpleNewFigureFactory newFigure = new SimpleNewFigureFactory();
        newFigure.chooseAbstractFigureFactory(new PostProcessingDecorator(new PreProcessingDecorator(SimpleLineFactory.getSingleton())));
        Point[] points = ServicesPoint.enterPoints(2);
        return newFigure.creation(points);
    }
}
