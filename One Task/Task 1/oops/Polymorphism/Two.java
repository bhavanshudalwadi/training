class Rectangle implements Shape {
    double l, b;

    Rectangle(double l, double b) {
        this.l = l;
        this.b = b;
    }
    
    public double calculateArea() {
        return this.l*this.b;
    }
}

class Circle implements Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }
    
    public double calculateArea() {
        return 2*3.141519*this.r*this.r;
    }
}

public class Two {
    public static void main(String args[]) {
        Rectangle rect = new Rectangle(8.67, 4.89);
        System.out.println("Area of Rectangle: "+rect.calculateArea());

        Circle c = new Circle(6.56);
        System.out.println("Area of Circle: "+c.calculateArea());
    }
}