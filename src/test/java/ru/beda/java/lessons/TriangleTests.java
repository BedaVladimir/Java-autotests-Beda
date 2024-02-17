package ru.beda.java.lessons;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeter() {
        Triangle result = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertEquals(12, result.getPerimeterTriangle());
        Triangle result1 = new Triangle(5.0, 5.0, 5.0);
        Assertions.assertEquals(15, result1.getPerimeterTriangle());
    }

    @Test
    void canCalculateGeron() {
        Triangle result = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertEquals(6, result.getGeronFormula());
        Triangle result1 = new Triangle(5.0, 5.0, 5.0);
        Assertions.assertEquals(10, result1.getGeronFormula());
    }

    @Test
    void cannotCreateTriangleWithNegativeSideA() {
        try {
            new Triangle(-3.0, 4.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    void cannotCreateTriangleWithNegativeSideB() {
        try {
            new Triangle(3.0, -4.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    void cannotCreateTriangleWithNegativeSideC() {
        try {
            new Triangle(3.0, 4.0, -5.0);
            Assertions.fail();
        } catch (IllegalArgumentException ex) {
        }
    }
    @Test
    void checkTriangleInequalitySideA() {
        try {
            new Triangle(10.0, 4.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException ex) {
        }
    }
    @Test
    void checkTriangleInequalitySideB() {
        try {
            new Triangle(3.0, 10.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException ex) {
        }
    }
    @Test
    void checkTriangleInequalitySideC() {
        try {
            new Triangle(3.0, 4.0, 10.0);
            Assertions.fail();
        } catch (IllegalArgumentException ex) {
        }
    }
}
