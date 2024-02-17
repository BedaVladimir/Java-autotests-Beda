package ru.beda.java.lessons;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(this.sideA, triangle.sideA) == 0 && Double.compare(this.sideB, triangle.sideB) == 0
                && Double.compare(this.sideC, triangle.sideC) == 0)
                || (Double.compare(this.sideB, triangle.sideA) == 0 && Double.compare(this.sideC, triangle.sideB) == 0
                && Double.compare(this.sideA, triangle.sideC) == 0)
                || (Double.compare(this.sideC, triangle.sideA) == 0 && Double.compare(this.sideA, triangle.sideB) == 0
                && Double.compare(this.sideB, triangle.sideC) == 0)
                || (Double.compare(this.sideA, triangle.sideA) == 0 && Double.compare(this.sideC, triangle.sideB) == 0
                && Double.compare(this.sideB, triangle.sideC) == 0)
                || (Double.compare(this.sideC, triangle.sideA) == 0 && Double.compare(this.sideB, triangle.sideB) == 0
                && Double.compare(this.sideA, triangle.sideC) == 0)
                || (Double.compare(this.sideB, triangle.sideA) == 0 && Double.compare(this.sideA, triangle.sideB) == 0
                && Double.compare(this.sideC, triangle.sideC) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}