package com.epam.jwd.Hardziyevich.model;

import com.epam.jwd.Hardziyevich.exception.FigureNotExistException;

public interface AbstractFigureFactory {
    Figure createFigure () throws FigureNotExistException;
}
