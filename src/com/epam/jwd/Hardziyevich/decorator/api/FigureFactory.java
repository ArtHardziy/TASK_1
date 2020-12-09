package com.epam.jwd.Hardziyevich.decorator.api;

import com.epam.jwd.Hardziyevich.exception.FigureNotExistException;
import com.epam.jwd.Hardziyevich.model.api.Figure;
import com.epam.jwd.Hardziyevich.model.api.Point;

public interface FigureFactory {
    Figure createFigure (Point[] point);
}
