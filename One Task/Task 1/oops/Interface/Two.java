class Circle implements Drawable {
    public void draw() {
        System.out.println("Circle Drawed");
    }
}

class Rectangle implements Drawable {
    public void draw() {
        System.out.println("Rectangle Drawed");
    }
}

public class Two {
    public static void main(String args[]) {
        new Circle().draw();
        new Rectangle().draw();
    }
}