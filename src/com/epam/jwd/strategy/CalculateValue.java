package com.epam.jwd.strategy;

import com.epam.jwd.task1.Figure;

public class CalculateValue {
    public CharacteristicOfTheFigure characteristicOfTheFigure;

    public void setCharacteristicOfTheFigure(CharacteristicOfTheFigure characteristicOfTheFigure){
        this.characteristicOfTheFigure = characteristicOfTheFigure;
    }

    public double executeCharacteristicOfTheFigure(Figure figure){
        return characteristicOfTheFigure.counIt(figure);
    }
}
