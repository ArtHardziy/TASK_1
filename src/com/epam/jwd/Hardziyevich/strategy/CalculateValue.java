package com.epam.jwd.Hardziyevich.strategy;

import com.epam.jwd.Hardziyevich.factory.api.Figure;

public class CalculateValue {
    private CharacteristicOfTheFigure characteristicOfTheFigure;

    public void setCharacteristicOfTheFigure(CharacteristicOfTheFigure characteristicOfTheFigure){
        this.characteristicOfTheFigure = characteristicOfTheFigure;
    }

    public double executeCharacteristicOfTheFigure(Figure figure){
        return characteristicOfTheFigure.counIt(figure);
    }
}
