package com.epam.jwd.task1;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Line;
import com.epam.jwd.model.LineFactory;
import com.epam.jwd.model.MultiAngleFactory;
import com.epam.jwd.model.MultiAngleFigure;
import com.epam.jwd.model.NewFigure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;
import com.epam.jwd.model.SquareFactory;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.model.TriangleFactory;
import com.epam.jwd.strategy.Area;
import com.epam.jwd.strategy.CalculateValue;
import com.epam.jwd.strategy.Perimeter;
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
        Scanner sc = new Scanner(System.in);
        NewFigure newFigure = new NewFigure();
        enterTheValueOfPoint(points, sc);
        enterValueOfLines(lines, sc, newFigure);
        enterValueOfTriangle(triangles, sc, newFigure);
        enterValueOfSquare(squares, sc, newFigure);
        enterValueOfPoligon(poligon, sc, newFigure);
    }

    private static void enterValueOfPoligon(MultiAngleFigure[] poligon, Scanner sc, NewFigure newFigure) {
        newFigure.chooseAbstractFigureFactory(new MultiAngleFactory());
        for(int i = 0; i < poligon.length; i++){
            System.out.println(" Now you start enter points for poligon");
            System.out.println("Enter number of angle:");
            int angle = sc.nextInt();
            Point[] p = new Point[angle];
            for(int j = 0; j < angle; j++){
                p[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            poligon[i] = (MultiAngleFigure) newFigure.creation(p);
            System.out.println("successfully");
        }
        sc.close();
    }

    private static void enterValueOfSquare(Square[] squares, Scanner sc, NewFigure newFigure) {
        System.out.println("Enter the point's for square(4)");
        newFigure.chooseAbstractFigureFactory(new SquareFactory());
        for(int i = 0; i < squares.length; i++){
            Point[] points = new Point[4];
            points[0] = new Point(sc.nextInt(), sc.nextInt());
            points[1] = new Point(sc.nextInt(), sc.nextInt());
            points[2] = new Point(sc.nextInt(), sc.nextInt());
            points[3] = new Point(sc.nextInt(), sc.nextInt());
            squares[i] = (Square) newFigure.creation(points);
        }
        for (Square square : squares) {
            if (square.getP(0).equals(square.getP(1))
                    || square.getP(1).equals(square.getP(2))
                    || square.getP(2).equals(square.getP(3))
                    || square.getP(3).equals(square.getP(0))) {
                LOGGER.error("The object " + square.toString() + " is not exist !!!");
            }
        }
        System.out.println("successfully");
    }

    private static void enterValueOfTriangle(Triangle[] triangles, Scanner sc, NewFigure newFigure) {
        System.out.println("Enter the point's for triangles(3)");
        newFigure.chooseAbstractFigureFactory(new TriangleFactory());
        for(int i = 0; i < triangles.length; i++){
            Point[] points = new Point[3];
            points[0] = new Point(sc.nextInt(), sc.nextInt());
            points[1] = new Point(sc.nextInt(), sc.nextInt());
            points[2] = new Point(sc.nextInt(), sc.nextInt());
            triangles[i] = (Triangle) newFigure.creation(points);
        }
        for (Triangle triangle : triangles) {
            if (triangle.getP(0).equals(triangle.getP(1))
                    || triangle.getP(1).equals(triangle.getP(2))
                    || triangle.getP(0).equals(triangle.getP(2))) {
                LOGGER.error("The object " + triangle.toString() + " is not exist !!!");
            }
        }
        System.out.println("Successfully, construction completed!");
    }

    private static void enterValueOfLines(Line[] lines, Scanner sc, NewFigure newfigure) {
        System.out.println("Enter the point's for lines(2)");
        newfigure.chooseAbstractFigureFactory(new LineFactory());
        for(int i = 0; i < lines.length; i++){
            Point[] point = new Point[2];
            point[0] = new Point(sc.nextInt(), sc.nextInt());
            point[1] = new Point(sc.nextInt(), sc.nextInt());
            lines[i] = (Line) newfigure.creation(point);
        }
        for (Figure line : lines) {
            if (line.getP(0).equals(line.getP(1))) {
                LOGGER.error("The object " + line.toString() + " is not exist !!!");
            }
        }
        System.out.println("Successfully, construction completed!!!");
    }

    private static void enterTheValueOfPoint(Point[] points, Scanner sc) {
        System.out.println("Enter the point's");
        for(int i = 0; i < points.length; i++){
           points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        System.out.println("Successfully, construction completed!!!");
    }
}
