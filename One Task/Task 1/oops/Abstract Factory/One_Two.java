abstract class AbstractFactory {
    public void ProductA();
    public void ProductB();
}

class ConcreteFactory1 extends AbstractFactory {
    public void ProductA() {

    }
    public void ProductB() {
        
    }
}
class ConcreteFactory2 extends AbstractFactory {
    public void ProductA() {

    }
    public void ProductB() {
        
    }
}

public class One {
    public static void main(String args[]) {
        ConcreteFactory1 cf1 = new ConcreteFactory1();
        ConcreteFactory2 cf2 = new ConcreteFactory2();
    }
}