abstract class Animal {
    abstract void makeSound();
    abstract void eat();
}

class Dog extends Animal {

    @Override
    void makeSound() {}

    @Override
    void eat() {}
    
}

class Cat extends Animal {

    @Override
    void makeSound() {}

    @Override
    void eat() {}
    
}

public class P3 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
        d.eat();
        
        Cat c = new Cat();
        c.makeSound();
        c.eat();
    }
}
