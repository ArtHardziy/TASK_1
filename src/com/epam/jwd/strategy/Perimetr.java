package com.epam.jwd.strategy;


import com.epam.jwd.task1.Figure;

public class Perimetr implements CharacteristicOfTheFigure {
    @Override
    public double counIt(Figure figure) {
        double perimetr = 0;
        int i = 0;
        while(i < figure.getNumberOfSide()){
            perimetr += figure.getLengthSide(i);
            i++;
        }
        return perimetr;
    }
}
