package com.epam.jwd.Hardziyevich.services.figureStorage;

import com.epam.jwd.Hardziyevich.decorator.api.ApplicationContext;
import com.epam.jwd.Hardziyevich.decorator.impl.ConcreteApplicationContext;
import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import com.epam.jwd.Hardziyevich.factory.impl.FigureType;
import com.epam.jwd.Hardziyevich.factory.impl.Line;
import com.epam.jwd.Hardziyevich.services.api.FigureCrud;
import com.epam.jwd.Hardziyevich.services.api.FigureStorageService;
import com.epam.jwd.Hardziyevich.services.impl.Specification;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FigureCrudImpl implements FigureCrud {

    private static final ApplicationContext APPLICATION_CONTEXT = ConcreteApplicationContext.getInstance();
    private static final FigureFactory FIGURE_FACTORY = APPLICATION_CONTEXT.createFigureFactory();
    private static final FigureStorageService FIGURE_STORAGE_SERVICE = FigureCacheStorageService.getInstance();


    @Override
    public ArrayList<Figure> findByCriteria(Specification specification) throws FigureException {
        List<Figure> figures = new ArrayList<>();
        if (specification.getTypeOfTheRequiredFigure() != null) {
            switch (specification.getTypeOfTheRequiredFigure()) {
                case LINE:
                    figures = FigureStorage.getLinesList().stream().filter(p -> p.getFigureType() == FigureType.LINE).collect(Collectors.toList());
                    break;
                case TRIANGLE:
                    figures = FigureStorage.getTrianglesList().stream().filter(p -> p.getFigureType() == FigureType.TRIANGLE).collect(Collectors.toList());
                    break;
                case SQUARE:
                    figures = FigureStorage.getSquareList().stream().filter(p -> p.getFigureType() == FigureType.SQUARE).collect(Collectors.toList());
                    break;
                case MULTI_ANGLE:
                    figures = FigureStorage.getMultiAngleFiguresList().stream().filter(p -> p.getFigureType() == FigureType.MULTI_ANGLE).collect(Collectors.toList());
                    break;
            }
        }
        if (specification.getStartOfTheRange() - specification.getEndOfTheRange() != 0) {
            long count = specification.getStartOfTheRange();
            while (specification.getStartOfTheRange() <= specification.getEndOfTheRange()) {
                figures.add(findFigureById(count));
                count++;
            }


        }

        return (ArrayList<Figure>) figures;
    }

    @Override
    public Figure createFigure(FigureType type, ArrayList<Point> points) throws FigureException {
        return FIGURE_FACTORY.createFigure(type, points);
    }

    @Override
    public List<Figure> multiCreateFigure(Map<FigureType, List<ArrayList<Point>>> figureCreateInfo) throws FigureException {
        List<Figure> figuresList = new ArrayList<>();
        for (FigureType figureType : figureCreateInfo.keySet()) {
            for (ArrayList<Point> points : figureCreateInfo.get(figureType)) {
                figuresList.add(FIGURE_FACTORY.createFigure(figureType, points));
            }
        }

        return figuresList;
    }

    @Override
    public void deleteFigure(Figure figure) throws FigureException {
        FigureCacheStorageService figureCacheStorageService = FigureCacheStorageService.getInstance();
        figureCacheStorageService.removeFigureFromStorage(figure);

    }

    @Override
    public Figure findFigure(Figure figure) throws FigureException {
        return FIGURE_STORAGE_SERVICE.fetchFigureFromStorage(figure);
    }

    @Override
    public void updateFigure(Figure oldFigure, Figure newFigure) throws FigureException {
        FIGURE_STORAGE_SERVICE.removeFigureFromStorage(oldFigure);
        FIGURE_STORAGE_SERVICE.addFigureToStorage(newFigure);
    }

    @Override
    public Figure findFigureById(long id) throws FigureException {
        Set<FigureType> figureTypes = EnumSet.allOf(FigureType.class);
        Iterator<FigureType> iterator = figureTypes.iterator();
        Figure figure = null;
        while (iterator.hasNext() && figure == null) {
            figure = FIGURE_STORAGE_SERVICE.fetchFigureByIdFromStorage(iterator.next(), id);
        }
        return figure;
    }
}
