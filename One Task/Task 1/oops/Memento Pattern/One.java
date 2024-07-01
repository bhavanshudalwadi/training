class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void restoreStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

class Caretaker {
    private Memento memento;

    public void saveState(Memento memento) {
        this.memento = memento;
    }

    public Memento retrieveState() {
        return memento;
    }
}

public class One {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // Save state
        originator.setState("State 1");
        caretaker.saveState(originator.saveStateToMemento());

        // Change state
        originator.setState("State 2");

        // Restore state
        originator.restoreStateFromMemento(caretaker.retrieveState());
        
        // Display current state
        System.out.println("Current State: " + originator.getState());
    }
}
