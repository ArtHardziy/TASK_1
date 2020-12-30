package com.epam.jwd.Hardziyevich.decorator.impl;

import com.epam.jwd.Hardziyevich.decorator.api.ApplicationContext;
import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;
import com.epam.jwd.Hardziyevich.factory.impl.SimpleNewFigureFactory;


public class ConcreteApplicationContext implements ApplicationContext {
    private static ConcreteApplicationContext instance;
    private static FigureFactory figureFactory = getInstance().createFigureFactory();

    private ConcreteApplicationContext() {

    }

    public static ConcreteApplicationContext getInstance() {
        if (instance == null) {
            instance = new ConcreteApplicationContext();
        }
        return instance;
    }

    public static FigureFactory getFigureFactory() {
        return figureFactory;
    }

    @Override
    public FigureFactory createFigureFactory() {
        if (figureFactory == null) {
            figureFactory = new PostProcessingDecorator(new PreProcessingDecorator(SimpleNewFigureFactory.getInstance()));
        }
        return figureFactory;
    }
}
