package CompositePattern;

import java.util.ArrayList;
import java.util.List;

// Component: FileComponent
interface FileComponent {
    void display();
}

// Leaf: File
class File implements FileComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}

// Composite: Directory
class Directory implements FileComponent {
    private String name;
    private List<FileComponent> files = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addFile(FileComponent file) {
        files.add(file);
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        for (FileComponent file : files) {
            file.display();
        }
    }
}

// Client code
public class CompositePatternExampletwo {
    public static void main(String[] args) {
        FileComponent file1 = new File("file1.txt");
        FileComponent file2 = new File("file2.txt");
        FileComponent file3 = new File("file3.txt");

        Directory directory1 = new Directory("Folder1");
        directory1.addFile(file1);
        directory1.addFile(file2);

        Directory directory2 = new Directory("Folder2");
        directory2.addFile(file3);

        Directory mainDirectory = new Directory("Main Folder");
        mainDirectory.addFile(directory1);
        mainDirectory.addFile(directory2);

        mainDirectory.display();
    }
}
