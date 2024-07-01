package Basics_of_IO;

import java.io.*;

class Dog implements Serializable {
    int i = 10;
    transient final int j = 20;
}

class P10 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog d1 = new Dog();
        
        // Serialization
        FileOutputStream fos = new FileOutputStream("Basics_of_IO\\P10.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d1);

        // Deserialization
        FileInputStream fis = new FileInputStream("Basics_of_IO\\P10.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog d2 = (Dog) ois.readObject();

        System.out.println(d2.i + " " + d2.j);
    }
}
