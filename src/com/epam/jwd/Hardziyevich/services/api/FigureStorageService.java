package com.epam.jwd.Hardziyevich.services.api;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.impl.FigureType;

public interface FigureStorageService {
    Figure fetchFigureFromStorage(Figure figure) throws FigureException;
    void addFigureToStorage(Figure figure) throws FigureException;
    void removeFigureFromStorage(Figure figure) throws FigureException;
    Figure fetchFigureByIdFromStorage(FigureType type, long id) throws FigureException;
}
