package com.epam.jwd.Hardziyevich.services.figureStorage;

import com.epam.jwd.Hardziyevich.factory.impl.Line;
import com.epam.jwd.Hardziyevich.factory.impl.MultiAngleFigure;
import com.epam.jwd.Hardziyevich.factory.impl.Square;
import com.epam.jwd.Hardziyevich.factory.impl.Triangle;

import java.util.ArrayList;
import java.util.List;

public class FigureStorage {
    private static FigureStorage instance;
    private static final List<Line> LINES_LIST = new ArrayList<>();
    private static final List<Square> SQUARE_LIST = new ArrayList<>();
    private static final List<MultiAngleFigure> MULTI_ANGLE_FIGURES_LIST = new ArrayList<>();
    private static final List<Triangle> TRIANGLES_LIST = new ArrayList<>();


    private FigureStorage(){

    }

    public static FigureStorage getInstance(){
        if(instance == null){
            instance = new FigureStorage();
        } return instance;
    }

    public void addLineToStorage(Line newLine){
        LINES_LIST.add(newLine);
    }

    public void addSquareToStorage(Square newSquare){
        SQUARE_LIST.add(newSquare);
    }

    public void addTriangleToStorage(Triangle newTriangle){
        TRIANGLES_LIST.add(newTriangle);
    }

    public void addMultiAngleFigureToStorage(MultiAngleFigure newMultiAngleFigure){
        MULTI_ANGLE_FIGURES_LIST.add(newMultiAngleFigure);
    }

    public void removeLineFromStorage(Line newline) {
        LINES_LIST.remove(newline);
    }

    public void removeSquareFromStorage(Square newSquare) {
        SQUARE_LIST.remove(newSquare);
    }

    public void removeTriangleFromStorage(Triangle newTriangle) {
        TRIANGLES_LIST.remove(newTriangle);
    }

    public void removeMultiAngleFigureFromStorage(MultiAngleFigure newMultiAngleFigure) {
        MULTI_ANGLE_FIGURES_LIST.remove(newMultiAngleFigure);
    }

    public Triangle fetchTriangleFromStorage(Triangle triangle){
        return TRIANGLES_LIST.stream().filter(triangleFromStorage -> triangleFromStorage.equals(triangle)).findAny().orElse(null);
    }

    public Line fetchLineFromStorage(Line line){
        return LINES_LIST.stream().filter(lineFromStorage -> lineFromStorage.equals(line)).findAny().orElse(null);
    }

    public Square fetchSquareFromStorage(Square square){
        return SQUARE_LIST.stream().filter(squareFromStorage -> squareFromStorage.equals(square)).findAny().orElse(null);
    }

    public MultiAngleFigure fetchMultiAngleFigureFromStorage(MultiAngleFigure multiAngleFigure){
        return MULTI_ANGLE_FIGURES_LIST.stream().filter(multiAngleFigureFromStorage -> multiAngleFigureFromStorage.equals(multiAngleFigure)).findAny().orElse(null);
    }

    public Line fetchLineFromStorageById(long id){
        return LINES_LIST.stream().filter(lineFromStorage -> lineFromStorage.getId() == id).findAny().orElse(null);
    }

    public Triangle fetchTriangleFromStorageById(long id){
        return TRIANGLES_LIST.stream().filter(triangleFromStorage -> triangleFromStorage.getId() == id).findAny().orElse(null);
    }

    public Square fetchSquareFromStorageById(long id){
        return SQUARE_LIST.stream().filter(squareFromStorage -> squareFromStorage.getId() == id).findAny().orElse(null);
    }

    public MultiAngleFigure fetchMultiAngleFigureFromStorageById(long id){
        return MULTI_ANGLE_FIGURES_LIST.stream().filter(multiAngleFigureFromStorage -> multiAngleFigureFromStorage.getId() == id).findAny().orElse(null);
    }


    public static List<Line> getLinesList() {
        return LINES_LIST;
    }

    public static List<Square> getSquareList() {
        return SQUARE_LIST;
    }

    public static List<MultiAngleFigure> getMultiAngleFiguresList() {
        return MULTI_ANGLE_FIGURES_LIST;
    }

    public static List<Triangle> getTrianglesList() {
        return TRIANGLES_LIST;
    }
}
