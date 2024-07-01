abstract class Shape {
    abstract void calculateArea();

    abstract void calculatePerimeter();
}

class Circle extends Shape {
    @Override
    void calculateArea() {}

    @Override
    void calculatePerimeter() {}
}

class Rectangle extends Shape {
    @Override
    void calculateArea() {}

    @Override
    void calculatePerimeter() {}
}

public class P1 {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.calculateArea();
        c.calculatePerimeter();
        Rectangle r = new Rectangle();
        r.calculateArea();
        r.calculatePerimeter();
    }
}
