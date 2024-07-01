class Rectangle extends Shape {
    double l, b;

    Rectangle(double l, double b) {
        this.l = l;
        this.b = b;
    }
    
    double area() {
        return this.l*this.b;
    }

    double perimeter() {
        return 2*(this.l+this.b);
    }
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }
    
    double area() {
        return 2*3.141519*this.r*this.r;
    }

    double perimeter() {
        return 2*3.141519*this.r;
    }
}

public class Two {
    public static void main(String args[]) {
        Rectangle rect = new Rectangle(8.67, 4.89);
        System.out.println("Area of Rectangle: "+rect.area());
        System.out.println("Perimeter of Rectangle: "+rect.perimeter());

        Circle c = new Circle(6.56);
        System.out.println("Area of Circle: "+c.area());
        System.out.println("Perimeter of Circle: "+c.perimeter());
    }
}