package com.epam.jwd.Hardziyevich.decorator.api;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.factory.api.Point;

public interface FigurePreProcessor {
    void preProcess(Point[] points) throws FigureException;
}
