package com.epam.jwd.Hardziyevich.decorator.api;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.factory.api.Point;

import java.util.ArrayList;

public interface FigurePreProcessor {
    void preProcess(ArrayList<Point> points) throws FigureException;
}
