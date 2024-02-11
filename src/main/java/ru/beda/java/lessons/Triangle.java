package ru.beda.java.lessons;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle {
    double sideA;
    double sideB;
    double sideC;

    public Triangle(double a, double b, double c) {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public double getPerimeterTriangle() {
        return this.sideA + this.sideB + this.sideC;
    }

    public double getGeronFormula() {
        double p = getPerimeterTriangle() / 2;
        System.out.println(p);
        return Math.floor(Math.sqrt((p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC))));
    }
}