package com.epam.jwd.Hardziyevich.factory.api;

import com.epam.jwd.Hardziyevich.factory.impl.FigureType;

import java.util.ArrayList;

public interface FigureFactory {
    Figure createFigure (FigureType type, ArrayList<Point> point);
}
