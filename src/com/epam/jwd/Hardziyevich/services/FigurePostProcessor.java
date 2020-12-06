package com.epam.jwd.Hardziyevich.services;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.model.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}
