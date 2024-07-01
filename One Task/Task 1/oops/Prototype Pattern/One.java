interface Prototype {  
    public Prototype getClone();    
}

class Note implements Prototype{  
    private int id;  
    private String name, description;
      
    Note(int id, String name, String description) {   
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Prototype getClone() {
        return new Note(id, name, description);
    }

    void printNote() {
        System.out.println(id+" "+name+" "+description);
    }
}

abstract class Animal implements Prototype {
    public abstract Prototype getClone();  
    public abstract void printAnimal();
}

class Dog extends Animal {
    int lags;
    String color;

    Dog(int l, String c) {
        lags = l;
        color = c;
    }

    public Prototype getClone(){
        return new Dog(lags, color);
    }

    public void printAnimal() {
        System.out.println(lags+" "+color);
    }
}

class Bird extends Animal {
    int lags;
    String color;

    Bird(int l, String c) {
        lags = l;
        color = c;
    }

    public Prototype getClone() {
        return new Bird(lags, color);
    }

    public void printAnimal() {
        System.out.println(lags+" "+color);
    }
}

class One {
    public static void main(String args[]) {
        Note n = new Note(1, "Hello", "Description");
        n.printNote();
        Note n2 = (Note) n.getClone();
        n2.printNote();

        Dog d = new Dog(4, "white");
        d.printAnimal();
        Dog d2 = (Dog) d.getClone();
        d2.printAnimal();
        
        Bird b = new Bird(2, "black");
        b.printAnimal();
        Bird b2 = (Bird) b.getClone();
        b2.printAnimal();
    }
}