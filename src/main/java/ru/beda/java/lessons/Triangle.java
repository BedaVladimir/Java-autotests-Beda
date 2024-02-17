package ru.beda.java.lessons;


public class Triangle {
    double sideA;
    double sideB;
    double sideC;

    public Triangle(double a, double b, double c) {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
        if (this.sideA < 0 || this.sideB < 0 || this.sideC < 0) {
            throw new IllegalArgumentException("Стороны треугольника не могут иметь отрицательные значения");
        }
        if (!(this.sideA + this.sideB > this.sideC && this.sideB + this.sideC > this.sideA
                && this.sideA + this.sideC > this.sideB)) {
            throw new IllegalArgumentException("В треугольнике 1 из сторон не может быть больше суммы 2 других сторон");
        }
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