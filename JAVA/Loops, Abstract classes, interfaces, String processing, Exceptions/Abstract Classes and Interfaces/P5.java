interface College {
    void show();
}

interface School {
    void display();
}

class Teacher implements College, School {

    @Override
    public void show() {}

    @Override
    public void display() {}
    
}

public class P5 {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.show();
        t.display();
    }
}
