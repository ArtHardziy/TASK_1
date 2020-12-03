package com.epam.jwd.Hardziyevich.task1;

import com.epam.jwd.Hardziyevich.model.Figure;
import com.epam.jwd.Hardziyevich.model.Line;
import com.epam.jwd.Hardziyevich.model.LineFactory;
import com.epam.jwd.Hardziyevich.model.MultiAngleFactory;
import com.epam.jwd.Hardziyevich.model.MultiAngleFigure;
import com.epam.jwd.Hardziyevich.model.NewFigure;
import com.epam.jwd.Hardziyevich.model.Point;
import com.epam.jwd.Hardziyevich.model.Square;
import com.epam.jwd.Hardziyevich.model.SquareFactory;
import com.epam.jwd.Hardziyevich.model.Triangle;
import com.epam.jwd.Hardziyevich.model.TriangleFactory;
import com.epam.jwd.Hardziyevich.strategy.Area;
import com.epam.jwd.Hardziyevich.strategy.CalculateValue;
import com.epam.jwd.Hardziyevich.strategy.Perimeter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.info("Application is started!");
        Point[] points = new Point[4];
        Line[] lines = new Line[2];
        Triangle[] triangles = new Triangle[2];
        Square[] squares= new Square[1];
        MultiAngleFigure[] poligon = new MultiAngleFigure[1];
        enterTheValueOfFigure(points, lines, triangles, squares, poligon);
        outputResult(points, lines, triangles, squares, poligon);
    }

    private static void outputResult(Point[] points, Line[] lines, Triangle[] triangles, Square[] squares, MultiAngleFigure[] poligon) {
        outputResultOfPoint(points);
        outputResultOfLine(lines);
        outputResultOfTriangle(triangles);
        outputResultOfSquare(squares);
        strategy(triangles, squares);
        for(int i = 0; i < poligon.length; i++){
            StringBuilder info = new StringBuilder(" Poligon ");
            for(int j = 0; j < poligon.length; j++){
                info.append(poligon.toString());
            }
            LOGGER.info(info.toString());
        }
    }

    private static void strategy(Triangle[] triangles, Square[] squares) {
        CalculateValue calc = new CalculateValue();
        perimetr(triangles, squares, calc);
        area(triangles, squares, calc);
    }

    private static void area(Triangle[] triangles, Square[] squares, CalculateValue calc) {
        int num = 0;
        for(Triangle i : triangles) {
            calc.setCharacteristicOfTheFigure(Area.INSTANCE);
            LOGGER.info("Area triangle: " + (++num) +": "+ calc.executeCharacteristicOfTheFigure(i) );
        }
        num = 0;
        for(Square i : squares) {
            calc.setCharacteristicOfTheFigure(Area.INSTANCE);
            LOGGER.info("Area squares: " +( ++num ) + ": " + calc.executeCharacteristicOfTheFigure(i) );
        }
    }

    private static void perimetr(Triangle[] triangles, Square[] squares, CalculateValue calc) {
        int num = 0;
        for(Triangle i : triangles) {
            calc.setCharacteristicOfTheFigure(Perimeter.getInstance());
            LOGGER.info("Perimetr triangle: " +(++num)+": "+ calc.executeCharacteristicOfTheFigure(i) );
        }
        num = 0;
        for(Square i : squares){
            calc.setCharacteristicOfTheFigure(Perimeter.getInstance());
            LOGGER.info("Perimetr squares: " +(++num)+": "+ calc.executeCharacteristicOfTheFigure(i) );
        }
    }

    private static void outputResultOfSquare(Square[] squares) {
        for(int i = 0; i < squares.length; i++){
            if(squares[i].isItAFigure()){
                LOGGER.info("Array squares " + ( i + 1 ) + squares[i].toString());
            } else{
                LOGGER.error("The square " + (i + 1) + "is not exist");
            }
        }
    }

    private static void outputResultOfTriangle(Triangle[] triangles) {
        for(int i = 0; i < triangles.length; i++){
            if(triangles[i].isItAFigure()){
                LOGGER.info("Array triangles " + (i + 1) + triangles[i].toString());
            } else {
                LOGGER.error("The triangle"+ ( i + 1)  +"is not exist");
            }
        }
    }

    private static void outputResultOfLine(Figure[] lines) {
        for(int i = 0; i < lines.length; i++){
            LOGGER.info("Array lines " + (i + 1) + lines[i] .toString());
        }
    }

    private static void outputResultOfPoint(Point[] points) {
        int j = 0;
        do{
            LOGGER.info("Array points " + (j + 1) + points[j].toString() );
            j++;
        }while(j < points.length);
    }

    private static void enterTheValueOfFigure(Point[] points, Line[] lines, Triangle[] triangles, Square[] squares, MultiAngleFigure[] poligon) {
        NewFigure newFigure = new NewFigure();
        enterTheValueOfPoint(points);
        enterValueOfLines(lines, newFigure);
        enterValueOfTriangle(triangles, newFigure);
        enterValueOfSquare(squares, newFigure);
        enterValueOfPoligon(poligon, newFigure);
    }

    private static void enterValueOfPoligon(MultiAngleFigure[] poligon, NewFigure newFigure) {
        newFigure.chooseAbstractFigureFactory(MultiAngleFactory.getInstance());
        for(int i = 0; i < poligon.length; i++){
            poligon[i] = (MultiAngleFigure) newFigure.creation();
            LOGGER.info("Creation of poligons was ended");
        }
    }

    private static void enterValueOfSquare(Square[] squares, NewFigure newFigure) {
        LOGGER.info("Creation of squares started");
        newFigure.chooseAbstractFigureFactory(SquareFactory.getInstance());
        for(int i = 0; i < squares.length; i++){
            squares[i] = (Square) newFigure.creation();
        }
        LOGGER.info("Creation of square was ended");
        for (Square square : squares) {
            if (square.getP(0).equals(square.getP(1))
                    || square.getP(1).equals(square.getP(2))
                    || square.getP(2).equals(square.getP(3))
                    || square.getP(3).equals(square.getP(0))) {
                LOGGER.error("The object " + square.toString() + " is not exist !!!");
            }
        }
        LOGGER.info("Creation of squares was ended");
    }

    private static void enterValueOfTriangle(Triangle[] triangles, NewFigure newFigure) {
        LOGGER.info("Started creation of tringles");
        newFigure.chooseAbstractFigureFactory(TriangleFactory.getInstance());
        for(int i = 0; i < triangles.length; i++){
            triangles[i] = (Triangle) newFigure.creation();
        }
        LOGGER.info("Creation of triangles was ended");
        for (Triangle triangle : triangles) {
            if (triangle.getP(0).equals(triangle.getP(1))
                    || triangle.getP(1).equals(triangle.getP(2))
                    || triangle.getP(0).equals(triangle.getP(2))) {
                LOGGER.error("The object " + triangle.toString() + " is not exist !!!");
            }
        }
        System.out.println("Successfully, construction completed!");
    }

    private static void enterValueOfLines(Line[] lines, NewFigure newfigure) {
        LOGGER.info("Started creation of lines");
        newfigure.chooseAbstractFigureFactory(LineFactory.getInstance());
        for(int i = 0; i < lines.length; i++){
            lines[i] = (Line) newfigure.creation();
        }
        LOGGER.info("Creation of lines was ended");
        for (Figure line : lines) {
            if (line.getP(0).equals(line.getP(1))) {
                LOGGER.error("The object " + line.toString() + " is not exist !!!");
            }
        }
        System.out.println("Successfully, construction completed!!!");
    }

    private static void enterTheValueOfPoint(Point[] points) {
        LOGGER.info("Creation of points started");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the point's");
        for(int i = 0; i < points.length; i++){
           points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        LOGGER.info("Successfully, creation of point complete");
        System.out.println("Successfully, construction completed!!!");
        sc.close();
    }
}
