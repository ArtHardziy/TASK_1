package com.epam.jwd.Hardziyevich.services.impl;

import com.epam.jwd.Hardziyevich.decorator.api.ApplicationContext;
import com.epam.jwd.Hardziyevich.decorator.impl.ConcreteApplicationContext;
import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import com.epam.jwd.Hardziyevich.factory.impl.FigureType;
import com.epam.jwd.Hardziyevich.factory.impl.SimpleNewFigureFactory;
import com.epam.jwd.Hardziyevich.services.api.FigureCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FigureCrudImpl implements FigureCrud{

    private static final ApplicationContext APPLICATION_CONTEXT = ConcreteApplicationContext.getInstance();


    @Override
    public Figure createFigure(FigureType type, ArrayList<Point> points) throws FigureException {
        return null;
    }

    @Override
    public List<Figure> multiCreateFigure(Map<FigureType, List<ArrayList<Point>>> figureCreateInfo) throws FigureException {
        return null;
    }

    @Override
    public void deleteFigure(Figure figure) throws FigureException {

    }

    @Override
    public Figure findFigure(Figure figure) throws FigureException {
        return null;
    }

    @Override
    public void updateFigure(Figure oldFigure, Figure newFigure) throws FigureException {

    }

    @Override
    public Figure findFigureById(long id) throws FigureException {
        return null;
    }
}
