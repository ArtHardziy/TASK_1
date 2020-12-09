package com.epam.jwd.Hardziyevich.strategy;

import com.epam.jwd.Hardziyevich.model.api.Figure;

public class CalculateValue {
    private CharacteristicOfTheFigure characteristicOfTheFigure;

    public void setCharacteristicOfTheFigure(CharacteristicOfTheFigure characteristicOfTheFigure){
        this.characteristicOfTheFigure = characteristicOfTheFigure;
    }

    public double executeCharacteristicOfTheFigure(Figure figure){
        return characteristicOfTheFigure.counIt(figure);
    }
}
