class Engine {
    Engine() {
        System.out.println("Engine Class");
    }
}

class Car {
    Engine en = new Engine();

    Car() {
        System.out.println("Car Class");
    }
}

public class One {
    public static void main(String args[]) {
        Car c = new Car();
    }
}