package com.epam.jwd.Hardziyevich.strategy;


import com.epam.jwd.Hardziyevich.model.api.Figure;

public class Perimeter implements CharacteristicOfTheFigure {
    private static Perimeter instance;
    private Perimeter(){
    }
    public static Perimeter getInstance(){
        if(instance == null){
            instance = new Perimeter();
        }
        return instance;
    }


    @Override
    public double counIt(Figure figure) {
        double perimeter = 0;
        int i = 0;
        while(i < figure.getNumberOfSide()){
            perimeter += figure.getSide(i).getLenght();
            i++;
        }
        return perimeter;
    }
}
