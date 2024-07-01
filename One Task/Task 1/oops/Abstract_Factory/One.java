package Abstract_Factory;

// Abstract Product A
interface Button {
    void display();
}

// Concrete Product A1
class DesktopButton implements Button {
    @Override
    public void display() {
        System.out.println("Desktop button displayed");
    }
}

// Concrete Product A2
class MobileButton implements Button {
    @Override
    public void display() {
        System.out.println("Mobile button displayed");
    }
}

// Abstract Product B
interface TextField {
    void display();
}

// Concrete Product B1
class DesktopTextField implements TextField {
    @Override
    public void display() {
        System.out.println("Desktop text field displayed");
    }
}

// Concrete Product B2
class MobileTextField implements TextField {
    @Override
    public void display() {
        System.out.println("Mobile text field displayed");
    }
}

// Abstract Factory
interface UIFactory {
    Button createButton();

    TextField createTextField();
}

// Concrete Factory 1
class DesktopUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new DesktopButton();
    }

    @Override
    public TextField createTextField() {
        return new DesktopTextField();
    }
}

// Concrete Factory 2
class MobileUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MobileButton();
    }

    @Override
    public TextField createTextField() {
        return new MobileTextField();
    }
}

// Client code
public class One {
    public static void main(String[] args) {
        // Create desktop UI components
        UIFactory desktopFactory = new DesktopUIFactory();
        Button desktopButton = desktopFactory.createButton();
        TextField desktopTextField = desktopFactory.createTextField();

        desktopButton.display(); // Output: Desktop button displayed
        desktopTextField.display(); // Output: Desktop text field displayed

        // Create mobile UI components
        UIFactory mobileFactory = new MobileUIFactory();
        Button mobileButton = mobileFactory.createButton();
        TextField mobileTextField = mobileFactory.createTextField();

        mobileButton.display(); // Output: Mobile button displayed
        mobileTextField.display(); // Output: Mobile text field displayed
    }
}
