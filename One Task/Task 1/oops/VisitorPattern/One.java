package VisitorPattern;

// Visitor Interface
interface Visitor {
    void visitElementA(ElementA elementA);

    void visitElementB(ElementB elementB);
}

// Element Interface
interface Element {
    void accept(Visitor visitor);
}

// Concrete Elements
class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }
}

class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }
}

// Concrete Visitor
class ConcreteVisitor implements Visitor {
    @Override
    public void visitElementA(ElementA elementA) {
        System.out.println("Visitor is visiting ElementA");
    }

    @Override
    public void visitElementB(ElementB elementB) {
        System.out.println("Visitor is visiting ElementB");
    }
}

// Client code
public class One {
    public static void main(String[] args) {
        // Creating elements
        Element elementA = new ElementA();
        Element elementB = new ElementB();

        // Creating visitor
        Visitor visitor = new ConcreteVisitor();

        // Accepting visitors by elements
        elementA.accept(visitor); // Output: Visitor is visiting ElementA
        elementB.accept(visitor); // Output: Visitor is visiting ElementB
    }
}
