interface Component {
    void operation();
    void add(Component component);
    void remove(Component component);
}

class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf operation");
    }

    @Override
    public void add(Component component) {}

    @Override
    public void remove(Component component) {}
}

class Composite implements Component {
    private java.util.List<Component> children = new java.util.ArrayList<>();

    @Override
    public void operation() {
        System.out.println("Composite operation");
        for (Component component : children) {
            component.operation();
        }
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }
}

public class CompositePatternDemo {
    public static void main(String[] args) {
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();

        Composite composite1 = new Composite();
        composite1.add(leaf1);
        composite1.add(leaf2);

        Leaf leaf3 = new Leaf();
        Leaf leaf4 = new Leaf();

        Composite composite2 = new Composite();
        composite2.add(leaf3);
        composite2.add(leaf4);

        Composite root = new Composite();
        root.add(composite1);
        root.add(composite2);

        // Calling operation on the entire structure
        root.operation();
    }
}
