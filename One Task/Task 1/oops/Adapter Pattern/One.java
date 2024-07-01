interface Target {
    void request();
}

class Adaptee {
    void specificRequest() {
        System.out.println("Adaptee's specificRequest method");
    }
}

class Adapter implements Target {
    private Adaptee adaptee;

    Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

public class One {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);

        // Using the Target interface to make a request
        adapter.request();
    }
}
