class Dog extends Animal {
    void eat() {
        System.out.println("Dog is eating...");
    }

    void sound() {
        System.out.println("Dog making sound...");
    }
}

class Cat extends Animal {
    void eat() {
        System.out.println("Cat is eating...");
    }

    void sound() {
        System.out.println("Cat making sound...");
    }
}

public class Two {
    public static void main(String args[]) {
        Dog d = new Dog();
        d.eat();
        d.sound();
        Cat c = new Cat();
        c.eat();
        c.sound();
    }
}