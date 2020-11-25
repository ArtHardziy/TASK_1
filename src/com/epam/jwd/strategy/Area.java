package com.epam.jwd.strategy;

import com.epam.jwd.task1.Figure;

public class Area implements CharacteristicOfTheFigure {

    @Override
    public double counIt(Figure figure) {
        int[][] matrix = new int[figure.getNumberOfVertices()][2];
        for(int i = 0; i < figure.getPOINT().length; i++){
            matrix[i][0] = figure.getPOINT()[i].getX();
            matrix[i][1] = figure.getPOINT()[i].getY();
        }
        int sum1 = 0;
        for(int i = 0; i < figure.getPOINT().length - 1; i++){
            sum1 = matrix[i][0] * matrix[i+1][1];
        }
        int sum2 = 0;
        for(int i = 0; i < figure.getPOINT().length - 1; i++){
            sum2 = matrix[i][1] * matrix[i+1][0];
        }
        return Math.abs((sum2-sum1)/2);
    }
}
