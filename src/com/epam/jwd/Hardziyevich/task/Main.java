package com.epam.jwd.Hardziyevich.task;

import com.epam.jwd.Hardziyevich.decorator.impl.ConcreteApplicationContext;

import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;

public class Main {
    public static void main(String[] args){
        ConcreteApplicationContext factory = ConcreteApplicationContext.getInstance();
        FigureFactory figure = factory.createFigureFactory();
    }
}
