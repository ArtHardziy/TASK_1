package com.epam.jwd.Hardziyevich.task;

import com.epam.jwd.Hardziyevich.decorator.impl.ConcreteApplicationContext;
import com.epam.jwd.Hardziyevich.factory.api.Figure;
import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;
import com.epam.jwd.Hardziyevich.factory.api.Point;
import com.epam.jwd.Hardziyevich.factory.impl.FigureType;
import com.epam.jwd.Hardziyevich.strategy.Area;
import com.epam.jwd.Hardziyevich.strategy.CalculateValue;
import com.epam.jwd.Hardziyevich.strategy.Perimeter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CreatePointsForTask taskPoints = new CreatePointsForTask();
        ArrayList<Point> points = taskPoints.pointsInit();
        ArrayList<Point> pointsForTriangle = new ArrayList<>();
        pointsForTriangle.set(0, points.get(0));
        pointsForTriangle.set(1, points.get(1));
        pointsForTriangle.set(2, points.get(2));
        FigureFactory figureFactory = ConcreteApplicationContext.getFigureFactory();
        Figure figure = figureFactory.createFigure(FigureType.TRIANGLE, pointsForTriangle);
        CalculateValue calc = new CalculateValue();
        calc.setCharacteristicOfTheFigure(Perimeter.getInstance());
        double perimeter = calc.executeCharacteristicOfTheFigure(figure);
        calc.setCharacteristicOfTheFigure(Area.INSTANCE);
        double area = calc.executeCharacteristicOfTheFigure(figure);
        LOGGER.info("Figure {}. Area of the figure: {}. Perimeter of the figure: {}.", figure, area, perimeter);
    }
}
