package com.epam.jwd.task1;

import com.epam.jwd.strategy.Area;
import com.epam.jwd.strategy.CalculateValue;
import com.epam.jwd.strategy.Perimetr;
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
        enterTheValueOfFigure(points, lines, triangles, squares);
        outputResult(points, lines, triangles, squares);
    }

    private static void outputResult(Point[] points, Line[] lines, Triangle[] triangles, Square[] squares) {
        outputResultOfPoint(points);
        outputResultOfLine(lines);
        outputResultOfTriangle(triangles);
        outputResultOfSquare(squares);
        strategy(triangles, squares);
    }

    private static void strategy(Triangle[] triangles, Square[] squares) {
        CalculateValue calc = new CalculateValue();
        perimetr(triangles, squares, calc);
        area(triangles, squares, calc);
    }

    private static void area(Triangle[] triangles, Square[] squares, CalculateValue calc) {
        int num = 0;
        for(Triangle i : triangles) {
            calc.setCharacteristicOfTheFigure(new Area());
            LOGGER.info("Area triangle: " + (++num) +": "+ calc.executeCharacteristicOfTheFigure(i) );
        }
        num = 0;
        for(Square i : squares) {
            calc.setCharacteristicOfTheFigure(new Area());
            LOGGER.info("Area squares: " +( ++num ) + ": " + calc.executeCharacteristicOfTheFigure(i) );
        }
    }

    private static void perimetr(Triangle[] triangles, Square[] squares, CalculateValue calc) {
        int num = 0;
        for(Triangle i : triangles) {
            calc.setCharacteristicOfTheFigure(new Perimetr());
            LOGGER.info("Perimetr triangle: " +(++num)+": "+ calc.executeCharacteristicOfTheFigure(i) );
        }
        num = 0;
        for(Square i : squares){
            calc.setCharacteristicOfTheFigure((new Perimetr()));
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

    private static void outputResultOfLine(Line[] lines) {
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

    private static void enterTheValueOfFigure(Point[] points, Line[] lines, Triangle[] triangles, Square[] squares) {
        Scanner sc = new Scanner(System.in);
        enterTheValueOfPoint(points, sc);
        enterValueOfLines(lines, sc);
        enterValueOfTriangle(triangles, sc);
        enterValueOfSquare(squares, sc);
        sc.close();
    }

    private static void enterValueOfSquare(Square[] squares, Scanner sc) {
        System.out.println("Enter the point's for square(4)");
        for(int i = 0; i < squares.length; i++){
            squares[i] = new Square(new Point(sc.nextInt(), sc.nextInt()),
                    new Point(sc.nextInt(), sc.nextInt()),
                    new Point(sc.nextInt(), sc.nextInt()),
                    new Point(sc.nextInt(), sc.nextInt()));
        }
        for(int i = 0; i < squares.length; i++){
            if(squares[i].getP(0).equals(squares[i].getP(1))
                    || squares[i].getP(1).equals(squares[i].getP(2))
                    || squares[i].getP(2).equals(squares[i].getP(3))
                    || squares[i].getP(3).equals(squares[i].getP(0))){
                LOGGER.error("The object " + squares[i].toString() + " is not exist !!!");
            }
        }
        System.out.println("successfully");
    }

    private static void enterValueOfTriangle(Triangle[] triangles, Scanner sc) {
        System.out.println("Enter the point's for triangles(3)");
        for(int i = 0; i < triangles.length; i++){
            triangles[i] = new Triangle(new Point(sc.nextInt(), sc.nextInt()),
                    new Point(sc.nextInt(), sc.nextInt()),
                    new Point(sc.nextInt(), sc.nextInt()));
        }
        for(int i = 0; i < triangles.length; i++){
            if(triangles[i].getP(0).equals(triangles[i].getP(1))
                    || triangles[i].getP(1).equals(triangles[i].getP(2))
                    || triangles[i].getP(0).equals(triangles[i].getP(2))){
                LOGGER.error("The object " + triangles[i].toString() + " is not exist !!!");
            }
        }
        System.out.println("Successfully, construction completed!");
    }

    private static void enterValueOfLines(Line[] lines, Scanner sc) {
        System.out.println("Enter the point's for lines(2)");
        for(int i = 0; i < lines.length; i++){
            lines[i] = new Line(new Point(sc.nextInt(), sc.nextInt()), new Point(sc.nextInt(), sc.nextInt()));
        }
        for(int i = 0; i < lines.length; i++){
            if(lines[i].getP(0).equals(lines[i].getP(1))){
                LOGGER.error("The object " + lines[i].toString() + " is not exist !!!");
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
