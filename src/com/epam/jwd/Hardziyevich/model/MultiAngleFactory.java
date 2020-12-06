package com.epam.jwd.Hardziyevich.model;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.services.ServicesPoint;
import com.epam.jwd.Hardziyevich.services.impl.FigureExistencePostProcessor;
import com.epam.jwd.Hardziyevich.services.impl.MultiAngleFigureExistencePostProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class MultiAngleFactory implements AbstractFigureFactory {
    private static final Logger LOGGER = LogManager.getLogger(MultiAngleFactory.class);
    private static MultiAngleFactory instance;

    private MultiAngleFactory() {

    }

    public static MultiAngleFactory getInstance() {
        if (instance == null) {
            instance = new MultiAngleFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure() {
        Scanner sc = new Scanner(System.in);
            LOGGER.info("Enter the number of angel: ");
            int numberOfAngel = sc.nextInt();
            sc.close();
            Point[] p = ServicesPoint.enterPoints(numberOfAngel);
            Figure multiAngleFigure = new MultiAngleFigure(p);
        LOGGER.info(" MultiAngleFigure was created by MultiAngleFactory ");
        try{
            FigureExistencePostProcessor postProcessor = new FigureExistencePostProcessor();
            postProcessor.setFigurePostProcessor(MultiAngleFigureExistencePostProcessor.getInstance());
            postProcessor.executeFigureExistencePostProcessor(multiAngleFigure);
        }catch (FigureException e){
            LOGGER.error(e.getMessage() + e.getStackTrace());
        }
        return multiAngleFigure;
    }
}