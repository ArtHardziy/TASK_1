package com.epam.jwd.Hardziyevich.services.figureStorage;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.exception.FigureNotExistException;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.impl.FigureType;
import com.epam.jwd.Hardziyevich.factory.impl.Line;
import com.epam.jwd.Hardziyevich.factory.impl.MultiAngleFigure;
import com.epam.jwd.Hardziyevich.factory.impl.Square;
import com.epam.jwd.Hardziyevich.factory.impl.Triangle;
import com.epam.jwd.Hardziyevich.services.api.FigureStorageService;

public class FigureCacheStorageService implements FigureStorageService {
    private static FigureCacheStorageService instance;
    private static final FigureStorage FIGURE_LIST = FigureStorage.getInstance();
    private FigureCacheStorageService(){

    }

    public static FigureCacheStorageService getInstance(){
        if(instance == null){
            instance = new FigureCacheStorageService();
        } return instance;
    }


    @Override
    public Figure fetchFigureFromStorage(Figure figure) throws FigureException {
        switch (figure.getFigureType()) {
            case LINE:
                figure = FIGURE_LIST.fetchLineFromStorage((Line) figure);
                break;
            case TRIANGLE:
                figure = FIGURE_LIST.fetchTriangleFromStorage((Triangle) figure);
                break;
            case SQUARE:
                figure = FIGURE_LIST.fetchSquareFromStorage((Square) figure);
                break;
            case MULTI_ANGLE:
                figure = FIGURE_LIST.fetchMultiAngleFigureFromStorage((MultiAngleFigure) figure);
                break;
            default:
                throw new FigureNotExistException("Your figure not exist");
        }
        return figure;
    }

    @Override
    public void addFigureToStorage(Figure figure) throws FigureException {
        switch(figure.getFigureType()){
            case LINE:
                FIGURE_LIST.addLineToStorage((Line) figure);
                break;
            case TRIANGLE:
                FIGURE_LIST.addTriangleToStorage((Triangle) figure);
                break;
            case SQUARE:
                FIGURE_LIST.addSquareToStorage((Square) figure);
                break;
            case MULTI_ANGLE:
                FIGURE_LIST.addMultiAngleFigureToStorage((MultiAngleFigure) figure);
                break;
        }

    }

    @Override
    public void removeFigureFromStorage(Figure figure) throws FigureException {
        switch(figure.getFigureType()) {
            case LINE:
                FIGURE_LIST.removeLineFromStorage((Line) figure);
                break;
            case TRIANGLE:
                FIGURE_LIST.removeTriangleFromStorage((Triangle) figure);
                break;
            case SQUARE:
                FIGURE_LIST.removeSquareFromStorage((Square) figure);
                break;
            case MULTI_ANGLE:
                FIGURE_LIST.removeMultiAngleFigureFromStorage((MultiAngleFigure) figure);
                break;
        }

    }

    @Override
    public Figure fetchFigureByIdFromStorage(FigureType type, long id) throws FigureException {
        Figure figure;
        switch (type) {
            case LINE:
                figure = FIGURE_LIST.fetchLineFromStorageById(id);
                break;
            case TRIANGLE:
                figure = FIGURE_LIST.fetchTriangleFromStorageById(id);
                break;
            case SQUARE:
                figure = FIGURE_LIST.fetchSquareFromStorageById(id);
                break;
            case MULTI_ANGLE:
                figure = FIGURE_LIST.fetchMultiAngleFigureFromStorageById(id);
                break;
            default:
                throw new FigureNotExistException("Your figure with this id: " + id + " not exist");
        }
        return figure;
    }

}
