package com.epam.jwd.Hardziyevich.decorator.api;

import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;

public interface ApplicationContext {
    FigureFactory createFigureFactory();
}
