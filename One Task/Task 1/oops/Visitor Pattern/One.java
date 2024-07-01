interface Visitor {
    void visitElementA(ElementA elementA);
    void visitElementB(ElementB elementB);
}

interface Element {
    void accept(Visitor visitor);
}

class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }

    void operationA() {
        System.out.println("Performing operation A on ElementA");
    }
}

class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }

    void operationB() {
        System.out.println("Performing operation B on ElementB");
    }
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visitElementA(ElementA elementA) {
        System.out.println("ConcreteVisitor is visiting ElementA");
        elementA.operationA();
    }

    @Override
    public void visitElementB(ElementB elementB) {
        System.out.println("ConcreteVisitor is visiting ElementB");
        elementB.operationB();
    }
}

public class One {
    public static void main(String[] args) {
        ElementA elementA = new ElementA();
        ElementB elementB = new ElementB();

        Visitor visitor = new ConcreteVisitor();

        elementA.accept(visitor);
        elementB.accept(visitor);
    }
}
