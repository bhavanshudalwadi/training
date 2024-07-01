abstract class Color {
    String colorCode;

    public void fill();

    public void showColor() {
        System.out.println("Your color is: "+colorCode);
    }
}

class Red implements Color{
    public void fill() {
        super.colorCode = "#FF0000";
    }
}

class Blue implements Color {
    public void fill() {
        super.colorCode = "#0000FF";
    }
}

// abstract class Shape implements Color {
//     public void fill();
// }

// class Circle extends Shape {
//     void fill() {
//         System.out.println("Circle with color");
//     }
// }

class One {
    public static void main(String args[]) {
        Color c = new Blue();
        c.fill();
        c.showColor();
    }
}