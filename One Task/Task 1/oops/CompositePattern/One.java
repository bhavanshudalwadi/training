package CompositePattern;

import java.util.ArrayList;
import java.util.List;

// Component Interface
interface Component {
    void display();
}

// Leaf
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Leaf: " + name);
    }
}

// Composite
class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void display() {
        System.out.println("Composite:");

        for (Component component : components) {
            component.display();
        }
    }
}

// Client code
public class One {
    public static void main(String[] args) {
        // Creating leaf components
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");

        // Creating composite components
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        // Adding leaf components to composites
        composite1.addComponent(leaf1);
        composite2.addComponent(leaf2);

        // Adding composite components to another composite
        Composite mainComposite = new Composite();
        mainComposite.addComponent(composite1);
        mainComposite.addComponent(composite2);

        // Displaying the structure
        mainComposite.display();
    }
}
