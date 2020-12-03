package com.epam.jwd.Hardziyevich.strategy;

import com.epam.jwd.Hardziyevich.model.Figure;

public enum Area implements CharacteristicOfTheFigure {
    INSTANCE;

    /**
     *The area of a polygon is calculated using the Gaussian area formula
     * (surveyor's formula or lacing formula or lacing algorithm)
     */
    @Override
    public double counIt(Figure figure) {
        int[][] matrix = new int[figure.getNumberOfVertices()][2];
        for(int i = 0; i < figure.getPoint().length; i++){
            matrix[i][0] = figure.getPoint()[i].getX();
            matrix[i][1] = figure.getPoint()[i].getY();
        }
        int sum1 = 0;
        for(int i = 0; i < figure.getPoint().length - 1; i++){
            sum1 = matrix[i][0] * matrix[i+1][1];
        }
        int sum2 = 0;
        for(int i = 0; i < figure.getPoint().length - 1; i++){
            sum2 = matrix[i][1] * matrix[i+1][0];
        }
        return Math.abs((sum2-sum1)/2);
    }
}
