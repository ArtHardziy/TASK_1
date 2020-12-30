package com.epam.jwd.Hardziyevich.services.api;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import com.epam.jwd.Hardziyevich.factory.impl.FigureType;
import com.epam.jwd.Hardziyevich.services.impl.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FigureCrud {
    Figure createFigure(FigureType type, ArrayList<Point> points) throws FigureException;

    List<Figure> multiCreateFigure(Map<FigureType, List<ArrayList<Point>>> figureCreateInfo) throws FigureException;

    void deleteFigure(Figure figure) throws FigureException;

    Figure findFigure(Figure figure) throws FigureException;

    void updateFigure(Figure oldFigure, Figure newFigure) throws FigureException;

    Figure findFigureById(long id) throws FigureException;

    ArrayList<Figure> findByCriteria(Specification specification) throws FigureException;


}
