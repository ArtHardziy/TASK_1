package com.epam.jwd.Hardziyevich.services.impl;

import com.epam.jwd.Hardziyevich.factory.api.FigureFactory;
import com.epam.jwd.Hardziyevich.factory.impl.SimpleLineFactory;

import java.util.Scanner;

import com.epam.jwd.Hardziyevich.factory.impl.SimpleMultiAngleFactory;
import com.epam.jwd.Hardziyevich.factory.impl.SimpleSquareFactory;
import com.epam.jwd.Hardziyevich.factory.impl.SimpleTriangleFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ChooseTypeFigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(ChooseTypeFigureFactory.class);
    private static final String[] TYPES = {"Line", "Triangle", "Square", "MultiAngleFigure"};
    private static String typeOfFigure;

    public static FigureFactory enterTypeOfFigure() {
        try (Scanner sc = new Scanner(System.in)) {
            LOGGER.info("Enter type of Figure: Line/Triangle/Square/MultiAngleFigure");
            String type = sc.nextLine();
            while (true) {
                for (String figure : TYPES) {
                    if (type.equals(figure)) {
                        typeOfFigure = type;
                        return getTypeOfFigure();
                    }
                }
            }
        }
    }

    private static FigureFactory getTypeOfFigure() {
        switch (typeOfFigure) {
            case ("Line"):
                return SimpleLineFactory.getInstance();
            case ("Triangle"):
                return SimpleTriangleFactory.getInstance();
            case ("Square"):
                return SimpleSquareFactory.getInstance();
            case ("MultiAngleFigure"):
                return SimpleMultiAngleFactory.getInstance();
            default:
                throw new IllegalArgumentException("The wrong name of the factory");
        }
    }
}
