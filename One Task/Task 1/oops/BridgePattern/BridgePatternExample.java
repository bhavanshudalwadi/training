package BridgePattern;

// Bridge: DrawingAPI
interface DrawingAPI {
    void drawCircle(double x, double y, double radius);
}

// Concrete Implementor 1: DrawingAPI1
class DrawingAPI1 implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API1 - Drawing Circle at (%.2f, %.2f) with radius %.2f%n", x, y, radius);
    }
}

// Concrete Implementor 2: DrawingAPI2
class DrawingAPI2 implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API2 - Drawing Circle at (%.2f, %.2f) with radius %.2f%n", x, y, radius);
    }
}

// Abstraction: Shape
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    abstract void draw();
}

// Refined Abstraction: Circle
class Circle extends Shape {
    private double x, y, radius;

    public Circle(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}

// Client code
public class BridgePatternExample {
    public static void main(String[] args) {
        DrawingAPI api1 = new DrawingAPI1();
        DrawingAPI api2 = new DrawingAPI2();

        Shape circle1 = new Circle(1.0, 2.0, 3.0, api1);
        Shape circle2 = new Circle(5.0, 7.0, 10.0, api2);

        circle1.draw(); // Output: API1 - Drawing Circle at (1.00, 2.00) with radius 3.00
        circle2.draw(); // Output: API2 - Drawing Circle at (5.00, 7.00) with radius 10.00
    }
}
