package com.epam.jwd.Hardziyevich.services.impl;

import com.epam.jwd.Hardziyevich.exception.FigureException;
import com.epam.jwd.Hardziyevich.model.api.Figure;
import com.epam.jwd.Hardziyevich.decorator.api.FigurePostProcessor;

public class ChooseFigureExistencePostProcessor {
     private FigurePostProcessor figurePostProcessor;

     public void setFigurePostProcessor(FigurePostProcessor figurePostProcessor){
         this.figurePostProcessor = figurePostProcessor;
     }
     public Figure executeFigureExistencePostProcessor (Figure figure) throws FigureException {
         return figurePostProcessor.process(figure);
     }




}
