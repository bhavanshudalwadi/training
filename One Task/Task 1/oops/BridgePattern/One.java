package BridgePattern;

// Interface for colors
interface Color {
    void fill();
}

// Concrete colors
class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Filling with red color");
    }
}

class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Filling with blue color");
    }
}

// Abstract shape class
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Concrete shapes
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing circle with ");
        color.fill();
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing square with ");
        color.fill();
    }
}

// Client code
public class One {
    public static void main(String[] args) {
        // Creating colors
        Color red = new Red();
        Color blue = new Blue();

        // Creating shapes with different colors
        Shape redCircle = new Circle(red);
        Shape blueSquare = new Square(blue);

        // Drawing shapes
        redCircle.draw(); // Output: Drawing circle with Filling with red color
        blueSquare.draw(); // Output: Drawing square with Filling with blue color
    }
}
