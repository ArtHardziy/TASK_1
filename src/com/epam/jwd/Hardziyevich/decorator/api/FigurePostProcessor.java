package com.epam.jwd.Hardziyevich.decorator.api;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.factory.api.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}
