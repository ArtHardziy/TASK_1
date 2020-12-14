package com.epam.jwd.Hardziyevich.decorator.impl;

import com.epam.jwd.Hardziyevich.decorator.api.ApplicationContext;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import com.epam.jwd.Hardziyevich.factory.impl.SimpleNewFigureFactory;
import com.epam.jwd.Hardziyevich.services.impl.ServicesPoint;
import com.epam.jwd.Hardziyevich.services.impl.ChooseTypeFigureFactory;

public class ConcreteApplicationContext implements ApplicationContext {
    private static ConcreteApplicationContext instance;
    private ConcreteApplicationContext(){

    }
    public static ConcreteApplicationContext getInstance(){
        if(instance == null){
            instance = new ConcreteApplicationContext();
        } return instance;
    }
    @Override
    public Figure createFigureFactory() {
        SimpleNewFigureFactory newFigureFactory = SimpleNewFigureFactory.getInstance();
        newFigureFactory.chooseAbstractFigureFactory(new PostProcessingDecorator(new PreProcessingDecorator(ChooseTypeFigureFactory.enterTypeOfFigure())));
        Point[] points = ServicesPoint.enterPoints(2);
        return newFigureFactory.creation(points);
    }
}
